package com.slyak.controller;

import com.slyak.core.hibernate.HibernateContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/6/15
 */
@Controller
public class AdminCtl {

    @ResponseBody
    public String schema(boolean run) throws IOException {
        String schemaScript = "";
        if (run) {
            SchemaUpdate schemaUpdator = new SchemaUpdate(HibernateContext.getConfiguration());
            schemaUpdator.setDelimiter(";");
            File outputFile = new File(FileUtils.getTempDirectoryPath() + File.separator + "schema-update.ddl");
            schemaUpdator.setOutputFile(outputFile.getAbsolutePath());
            schemaUpdator.execute(true, false);
            if (outputFile.exists()) {
                FileInputStream is = new FileInputStream(outputFile);
                schemaScript = IOUtils.toString(is, Charset.defaultCharset());
                IOUtils.closeQuietly(is);
            }
        }
        return schemaScript;
    }
}
