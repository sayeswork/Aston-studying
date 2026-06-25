package by.mts.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OnlinePaymentBlockTest {

    private static final String BASE_URL = "https://www.mts.by/";
    private static final String TEST_PHONE = "297777777";
    private static final String TEST_AMOUNT = "10";

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void openSite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get(BASE_URL);
        acceptCookiesIfPresent();
    }

    @AfterEach
    void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Заголовок блока онлайн-пополнения отображается")
    void shouldDisplayCorrectPaymentBlockTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pay h2")));

        String actualTitle = title.getText().replace("\n", " ").trim();

        assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ", actualTitle);
    }

    @Test
    @DisplayName("Логотипы платежных систем отображаются")
    void shouldDisplayPaymentSystemLogos() {
        List<WebElement> logos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".pay img")));

        List<String> logoAlts = new ArrayList<>();
        for (WebElement logo : logos) {
            logoAlts.add(logo.getAttribute("alt"));
        }

        assertTrue(logoAlts.contains("Visa"));
        assertTrue(logoAlts.contains("Verified By Visa"));
        assertTrue(logoAlts.contains("MasterCard"));
        assertTrue(logoAlts.contains("MasterCard Secure Code"));
        assertTrue(logoAlts.contains("Белкарт"));
    }

    @Test
    @DisplayName("Ссылка Подробнее о сервисе открывает страницу с описанием оплаты")
    void shouldOpenMoreDetailsPage() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'pay')]//a[contains(text(),'Подробнее о сервисе')]")));

        assertEquals("Подробнее о сервисе", link.getText().trim());
        assertTrue(link.getAttribute("href").contains("/help/"));

        link.click();

        wait.until(ExpectedConditions.urlContains("/help/"));
        assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty"));
    }

    @Test
    @DisplayName("Форма услуг связи открывает платежный виджет")
    void shouldOpenPaymentWidgetForCommunicationService() {
        selectService("Услуги связи");

        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-phone")));
        phoneInput.clear();
        phoneInput.sendKeys(TEST_PHONE);

        WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-sum")));
        amountInput.clear();
        amountInput.sendKeys(TEST_AMOUNT);

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#pay-connection button.button__default")));
        continueButton.click();

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("iframe.payment-widget-iframe")));
        assertTrue(iframe.isDisplayed());
    }

    private void acceptCookiesIfPresent() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            shortWait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree"))).click();
            shortWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cookie.show")));
        } catch (TimeoutException ignored) {
        }
    }

    private void selectService(String serviceName) {
        WebElement selectHeader = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".pay .select__header")));

        if (selectHeader.getText().trim().equals(serviceName)) {
            return;
        }

        selectHeader.click();
        List<WebElement> serviceItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector(".pay .select__item")));

        boolean serviceFound = false;
        for (WebElement serviceItem : serviceItems) {
            if (serviceItem.getText().trim().equals(serviceName)) {
                serviceItem.click();
                serviceFound = true;
                break;
            }
        }

        assertTrue(serviceFound);
    }
}
