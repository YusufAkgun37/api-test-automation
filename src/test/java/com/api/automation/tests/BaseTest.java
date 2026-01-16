package com.api.automation.tests;

import com.api.automation.utils.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = ConfigReader.getProperty("base.url");
    }
}
