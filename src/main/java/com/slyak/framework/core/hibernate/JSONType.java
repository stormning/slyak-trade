/*
 * Project:  slyak-trade
 * Module:   slyak-trade
 * File:     JSONType.java
 * Modifier: stormning
 * Modified: 2014-11-19 17:39
 * Copyright (c) 2014 Slyak All Rights Reserved.
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent
 * or the registration of a utility model, design or code.
 */

package com.slyak.framework.core.hibernate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Objects;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.internal.CoreMessageLogger;
import org.hibernate.internal.util.ReflectHelper;
import org.hibernate.internal.util.SerializationHelper;
import org.hibernate.usertype.DynamicParameterizedType;
import org.hibernate.usertype.UserType;
import org.jboss.logging.Logger;
import org.springframework.util.ReflectionUtils;

import javax.persistence.Column;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;


public class JSONType implements UserType, DynamicParameterizedType, Serializable {
    private static final long serialVersionUID = 352044032843534075L;
    private static final CoreMessageLogger LOG = Logger.getMessageLogger(CoreMessageLogger.class, JSONType.class.getName());
    public static final String TYPE = "com.slyak.framework.core.hibernate.JSONType";
    public static final String CLASS_NAME = "class";
    private int sqlType = Types.VARCHAR;
    private Class clazz = Object.class;
    private Type type = clazz;

    @Override
    public int[] sqlTypes() {
        return new int[]{sqlType};
    }

    @Override
    public Class returnedClass() {
        return clazz;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equal(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        Object object = rs.getObject(names[0]);
        if (rs.wasNull()) {
            if (LOG.isTraceEnabled())
                LOG.tracev("Returning null as column {0}", names[0]);
            return null;
        } else {
            return JSON.parseObject((String) object, type);
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        if (value == null) {
            if (LOG.isTraceEnabled()) {
                LOG.tracev("Binding null to parameter: {0}", index);
            }
            st.setNull(index, sqlType);
        } else {
            st.setObject(index, JSON.toJSONString(value), sqlType);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        if (value instanceof JSONObject) {
            return ((JSONObject) value).clone();
        } else if (value instanceof Cloneable) {
            return ObjectUtils.clone(value);
        } else if (value instanceof Serializable) {
            return SerializationHelper.clone((Serializable) value);
        } else {
            return value;
        }
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }

    @SuppressWarnings("unchecked")
    public void setParameterValues(Properties parameters) {
        try {
            clazz = ReflectHelper.classForName(parameters.getProperty(DynamicParameterizedType.ENTITY));
            Field field = ReflectionUtils.findField(clazz, parameters.getProperty(DynamicParameterizedType.PROPERTY));
            type = field.getGenericType();
            parseSqlType(field.getAnnotations());
            return;
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        final ParameterType reader = (ParameterType) parameters.get(DynamicParameterizedType.PARAMETER_TYPE);
        if (reader != null) {
            clazz = reader.getReturnedClass();
            parseSqlType(reader.getAnnotationsMethod());
        } else {
            try {
                clazz = ReflectHelper.classForName((String) parameters.get(CLASS_NAME));
                if (type instanceof Class) {
                    Class tClass = (Class) type;
                    if (tClass.isInterface() || Modifier.isAbstract(tClass.getModifiers())) {
                        type = clazz;
                    }
                }
            } catch (ClassNotFoundException exception) {
                throw new HibernateException("class not found", exception);
            }
        }
    }

    private void parseSqlType(Annotation[] anns) {
        for (Annotation an : anns) {
            if (an instanceof Column) {
                int length = ((Column) an).length();
                if (length > 4000) {
                    sqlType = Types.CLOB;
                }
                break;
            }
        }
    }
}
