package cn.willow.demo.controller;

import cn.willow.demo.framework.Cgi;
import cn.willow.demo.framework.SysConfig;
import com.alibaba.fastjson.JSONObject;
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
    private static final String PREFIX = SysConfig.DEV ? "/Users" : "/var/www/cc";

    @RequestMapping("/jdbc")
    public String getPropertiesByProject(Cgi cgi) throws IOException {
        String project = cgi.getString("project", "");
        String cipher = cgi.getString("cipher", "");
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(PREFIX + "/" + project + ".properties");
        properties.load(inputStream);
        if (properties.isEmpty()) {
            return "get properties error";
        }
        String savedCipher = properties.getProperty("cipher");
        if (cipher.isEmpty() || savedCipher.isEmpty() || !cipher.equals(savedCipher)) {
            return "authentication is failed";
        }
        String jdbc_url = properties.getProperty("jdbc_url");
        String jdbc_user = properties.getProperty("jdbc_user");
        String jdbc_password = properties.getProperty("jdbc_password");
        JSONObject propertiesJson = new JSONObject();
        propertiesJson.put("jdbc_url", jdbc_url);
        propertiesJson.put("jdbc_user", jdbc_user);
        propertiesJson.put("jdbc_password", jdbc_password);
        System.out.println(propertiesJson.toString());
        inputStream.close();

        return propertiesJson.toString();
    }
}
