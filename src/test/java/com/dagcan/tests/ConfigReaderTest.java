package com.dagcan.tests;

import com.dagcan.utilities.ConfigReader;
import com.dagcan.utilities.TestBase;
import org.testng.annotations.Test;

public class ConfigReaderTest extends TestBase {
    @Test
    public void googleTitleTest() {
        driver.get(ConfigReader.getProperty("url"));
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }
}
