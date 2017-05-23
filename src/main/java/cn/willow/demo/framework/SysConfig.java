package cn.willow.demo.framework;

/**
 * 系统初始化配置
 * Created by Willow on 16/11/17.
 */
public class SysConfig {
    public static boolean DEV = false;

    static {
        DEV = "dev".equals(System.getProperty("environment"));
    }
}
