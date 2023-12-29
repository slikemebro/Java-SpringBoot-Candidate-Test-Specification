package com.ua.hlibkorbov.javajuniorleveltechnicaltask.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public final class GetDriver {
//    @Value("${url}")
    private static String url = "https://jobs.techstars.com/jobs";
    private static WebDriver DRIVER;

    private GetDriver() {
    }

    public static WebDriver getConnection() {
        if (DRIVER == null) {
            DRIVER = new ChromeDriver();
            DRIVER.get(url);
        }
        return DRIVER;
    }

    public static void closeConnection() {
        DRIVER.close();
    }
}
