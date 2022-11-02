package com.group28.laptrinhhuongdoituong.commons;

import com.group28.laptrinhhuongdoituong.LaptrinhhuongdoituongApplication;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class I18n {
    private static Properties prop = new Properties();

    private I18n() {
    }

    public static void load() throws Exception {
        InputStream in = LaptrinhhuongdoituongApplication.class.getResourceAsStream("/langs/i18n.properties");
        prop.load(new InputStreamReader(in, Charset.forName("UTF-8")));
    }

    public static String get(String key) {
        return prop.getOrDefault(key, "{" + key + "}").toString();
    }
}
