package by.mts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class OnlinePaymentPage {

    private static final String BASE_URL = "https://www.mts.by/";

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cookieButton = By.id("cookie-agree");
    private final By cookiePopup = By.cssSelector(".cookie.show");
    private final By paymentTitle = By.cssSelector(".pay h2");
    private final By paymentLogos = By.cssSelector(".pay img");
    private final By serviceSelectHeader = By.cssSelector(".pay .select__header");
    private final By moreDetailsLink = By.xpath("//div[contains(@class,'pay')]//a[contains(text(),'Подробнее о сервисе')]");
    private final By paymentWidgetIframe = By.cssSelector("iframe.payment-widget-iframe");

    public OnlinePaymentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get(BASE_URL);
        acceptCookiesIfPresent();
    }

    public String getTitleText() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentTitle));
        return title.getText().replace("\n", " ").trim();
    }

    public List<String> getPaymentLogoAlts() {
        List<WebElement> logos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(paymentLogos));
        List<String> logoAlts = new ArrayList<>();

        for (WebElement logo : logos) {
            logoAlts.add(logo.getAttribute("alt"));
        }

        return logoAlts;
    }

    public void openMoreDetailsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(moreDetailsLink)).click();
        wait.until(ExpectedConditions.urlContains("/help/"));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<String> getPlaceholdersForService(String serviceName) {
        selectService(serviceName);

        List<By> fields = getFieldsForService(serviceName);
        List<String> placeholders = new ArrayList<>();

        for (By field : fields) {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(field));
            placeholders.add(input.getAttribute("placeholder"));
        }

        return placeholders;
    }

    public void fillConnectionServiceAndContinue(String phone, String amount) {
        selectService("Услуги связи");

        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-phone")));
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-sum")));
        amountInput.clear();
        amountInput.sendKeys(amount);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#pay-connection button.button__default"))).click();
    }

    public PaymentWidgetPage switchToPaymentWidget() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentWidgetIframe));
        driver.switchTo().frame(iframe);

        return new PaymentWidgetPage(wait);
    }

    private void acceptCookiesIfPresent() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
            shortWait.until(ExpectedConditions.elementToBeClickable(cookieButton)).click();
            shortWait.until(ExpectedConditions.invisibilityOfElementLocated(cookiePopup));
        } catch (TimeoutException ignored) {
        }
    }

    private void selectService(String serviceName) {
        WebElement selectHeader = wait.until(ExpectedConditions.elementToBeClickable(serviceSelectHeader));

        if (selectHeader.getText().trim().equals(serviceName)) {
            return;
        }

        selectHeader.click();
        By serviceItemText = By.xpath("//div[contains(@class,'pay')]//li[contains(@class,'select__item')]/p[normalize-space()='"
                + serviceName + "']");

        wait.until(ExpectedConditions.elementToBeClickable(serviceItemText)).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(serviceSelectHeader, serviceName));
    }

    private List<By> getFieldsForService(String serviceName) {
        List<By> fields = new ArrayList<>();

        if (serviceName.equals("Услуги связи")) {
            fields.add(By.id("connection-phone"));
            fields.add(By.id("connection-sum"));
            fields.add(By.id("connection-email"));
        } else if (serviceName.equals("Домашний интернет")) {
            fields.add(By.id("internet-phone"));
            fields.add(By.id("internet-sum"));
            fields.add(By.id("internet-email"));
        } else if (serviceName.equals("Рассрочка")) {
            fields.add(By.id("score-instalment"));
            fields.add(By.id("instalment-sum"));
            fields.add(By.id("instalment-email"));
        } else if (serviceName.equals("Задолженность")) {
            fields.add(By.id("score-arrears"));
            fields.add(By.id("arrears-sum"));
            fields.add(By.id("arrears-email"));
        }

        return fields;
    }
}
