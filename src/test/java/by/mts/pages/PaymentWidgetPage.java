package by.mts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PaymentWidgetPage {

    private final WebDriverWait wait;

    private final By body = By.tagName("body");
    private final By paymentButton = By.xpath("//button[contains(., 'Оплатить')]");
    private final By paymentIcons = By.cssSelector("img[src*='payment-icons']");

    public PaymentWidgetPage(WebDriverWait wait) {
        this.wait = wait;
    }

    public String getText() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(body, "BYN"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(body, "Номер карты"));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(body)).getText();
    }

    public String getPaymentButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentButton)).getText();
    }

    public List<String> getPaymentIconSources() {
        List<WebElement> icons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(paymentIcons));
        List<String> sources = new ArrayList<>();

        for (WebElement icon : icons) {
            sources.add(icon.getAttribute("src"));
        }

        return sources;
    }
}
