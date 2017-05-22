package cn.willow.demo.controller;

import cn.willow.demo.framework.Cgi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Willow on 5/22/17.
 */
@RestController
@RequestMapping("/")
public class ConfigurationController {
    @RequestMapping("/jdbc/javavirtual")
    public String getJavaVirtaulDbConfiguration(Cgi cgi) throws IOException {
        String project = cgi.getString("project", "");
        String key = cgi.getString("key", "");
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("/Users/" + project + ".properties");
        properties.load(inputStream);
        String cipher = properties.getProperty("cipher");
        String jdbc = properties.getProperty("jdbc_url");
        String jdbc_user = properties.getProperty("jdbc_user");
        String jdbc_password = properties.getProperty("jdbc_password");
        System.out.println(cipher + "," + jdbc + "," + jdbc_user + "," + jdbc_password);
        inputStream.close();
        return key;
    }
}
