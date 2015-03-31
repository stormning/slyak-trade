/*
 * Project:  slyak-web
 * Module:   slyak-web
 * File:     Test.java
 * Modifier: nzhou
 * Modified: 2015-03-31 10:50
 * Copyright (c) 2014 Wisorg All Rights Reserved.
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent
 * or the registration of a utility model, design or code.
 */

package com.slyak.test;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/3/31
 */
public class Test {

    public static void main(String[] args) throws IOException {
        int min = 5;
        String result = IOUtils.toString(new FileInputStream(new File("D:\\project\\msc-service\\server\\msc-server\\pub\\css\\web.css")));
        Pattern pattern = Pattern.compile("([0-9]+).px");
        Matcher matcher = pattern.matcher(result);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String g = matcher.group();
            String gIntStr = StringUtils.trim(matcher.group().replaceAll("px", ""));
            int gInt = NumberUtils.toInt(gIntStr);
            String replace;
            if (gInt > min) {
                replace = gInt * 0.8 + "px";
            } else {
                replace = g;
            }
            matcher.appendReplacement(sb, replace);
        }
        matcher.appendTail(sb);
        result = sb.toString();

        IOUtils.write(result, new FileOutputStream(new File("D:\\output\\web.css")));
    }
}
