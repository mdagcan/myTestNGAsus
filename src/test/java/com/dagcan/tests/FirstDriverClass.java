package com.dagcan.tests;

import com.dagcan.utilities.ConfigReader;
import com.dagcan.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstDriverClass {
    @Test
    public void firstDriverTest() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Driver.getDriver().get("https://google.com");
        //Driver.getDriver().getTitle();
        //Assert.assertEquals(Driver.getDriver().getTitle(), "Google");
    }
}
