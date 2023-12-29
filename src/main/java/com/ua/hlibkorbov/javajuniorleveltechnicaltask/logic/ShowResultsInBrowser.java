package com.ua.hlibkorbov.javajuniorleveltechnicaltask.logic;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Component
@Log4j2
public class ShowResultsInBrowser {

    private static final ChromeOptions options = new ChromeOptions();
    private static WebDriver DRIVER;

    private static final String CLASS_NAME_OF_JOB_FUNCTION = "cktMLM";
    private static JavascriptExecutor jsExecutor;
    private static final String MESSAGE_FOR_SCRAPING = "Scraping... {}";
    private static WebDriverWait wait;


    public static void showResult(String accountingAndFinance) {
        log.info(MESSAGE_FOR_SCRAPING, accountingAndFinance);
        log.info("showResult");
        getConnection();
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.className(CLASS_NAME_OF_JOB_FUNCTION)));
        element.click();
        WebElement childElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(".//button[contains(text(), '" + accountingAndFinance + "')]")));

        scrollToElement(childElement);

        childElement.click();
        scrollBack();
    }

    private static void scrollToElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private static void scrollBack() {
        jsExecutor.executeScript("window.scrollTo(0, 0);");
    }

    public static void closeConnection() {
        DRIVER.close();
    }
    public static void getConnection() {
        DRIVER = GetDriver.getConnection();
        if (jsExecutor == null) {
            jsExecutor = (JavascriptExecutor) DRIVER;
        }
        if (wait == null) {
            wait = new WebDriverWait(DRIVER, Duration.ofSeconds(20));
        }
    }

    public static void clearAllFilters() {
        log.info("Clearing all filters...");
        getConnection();
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.className("dVWFYR")));

        elements.forEach(e -> {
            scrollToElement(e);
            e.click();
        });
        scrollBack();
    }
}
