package com.codecraft.training.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public static PropertyReader getinstance(){
        return new PropertyReader();
    }

    public Properties readProperty(String fileName) throws IOException {
        FileInputStream property = new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/resources/"+fileName));
        Properties prop = new  Properties();
        prop.load(property);
        return prop;
    }
}
