package by.mts.tests;

import by.mts.pages.OnlinePaymentPage;
import by.mts.pages.PaymentWidgetPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OnlinePaymentBlockTest {

    private static final String TEST_PHONE = "297777777";
    private static final String TEST_AMOUNT = "10";

    private WebDriver driver;
    private OnlinePaymentPage onlinePaymentPage;

    @BeforeAll
    static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void openSite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        onlinePaymentPage = new OnlinePaymentPage(driver, wait);
        onlinePaymentPage.open();
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
        assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ", onlinePaymentPage.getTitleText());
    }

    @Test
    @DisplayName("Логотипы платежных систем отображаются")
    void shouldDisplayPaymentSystemLogos() {
        List<String> logoAlts = onlinePaymentPage.getPaymentLogoAlts();

        assertTrue(logoAlts.contains("Visa"));
        assertTrue(logoAlts.contains("Verified By Visa"));
        assertTrue(logoAlts.contains("MasterCard"));
        assertTrue(logoAlts.contains("MasterCard Secure Code"));
        assertTrue(logoAlts.contains("Белкарт"));
    }

    @Test
    @DisplayName("Ссылка Подробнее о сервисе открывает страницу с описанием оплаты")
    void shouldOpenMoreDetailsPage() {
        onlinePaymentPage.openMoreDetailsPage();

        assertTrue(onlinePaymentPage.getCurrentUrl().contains("poryadok-oplaty"));
    }

    @Test
    @DisplayName("Поля вариантов оплаты содержат правильные подсказки")
    void shouldDisplayPlaceholdersForPaymentServices() {
        assertEquals(List.of("Номер телефона", "Сумма", "E-mail для отправки чека"),
                onlinePaymentPage.getPlaceholdersForService("Услуги связи"));
        assertEquals(List.of("Номер абонента", "Сумма", "E-mail для отправки чека"),
                onlinePaymentPage.getPlaceholdersForService("Домашний интернет"));
        assertEquals(List.of("Номер счета на 44", "Сумма", "E-mail для отправки чека"),
                onlinePaymentPage.getPlaceholdersForService("Рассрочка"));
        assertEquals(List.of("Номер счета на 2073", "Сумма", "E-mail для отправки чека"),
                onlinePaymentPage.getPlaceholdersForService("Задолженность"));
    }

    @Test
    @DisplayName("Виджет оплаты показывает данные платежа и поля карты")
    void shouldDisplayPaymentWidgetDataAndCardFields() {
        onlinePaymentPage.fillConnectionServiceAndContinue(TEST_PHONE, TEST_AMOUNT);

        PaymentWidgetPage paymentWidgetPage = onlinePaymentPage.switchToPaymentWidget();
        String widgetText = paymentWidgetPage.getText();
        List<String> iconSources = paymentWidgetPage.getPaymentIconSources();

        assertTrue(widgetText.contains("10.00 BYN"));
        assertTrue(widgetText.contains("375" + TEST_PHONE));
        assertTrue(paymentWidgetPage.getPaymentButtonText().contains("10.00 BYN"));
        assertTrue(widgetText.contains("Номер карты"));
        assertTrue(widgetText.contains("Срок действия"));
        assertTrue(widgetText.contains("CVC"));
        assertTrue(widgetText.contains("Имя и фамилия на карте"));
        assertTrue(hasIcon(iconSources, "visa-system"));
        assertTrue(hasIcon(iconSources, "mastercard-system"));
        assertTrue(hasIcon(iconSources, "belkart-system"));
        assertTrue(hasIcon(iconSources, "maestro-system"));
        assertTrue(hasIcon(iconSources, "mir-system"));
    }

    private boolean hasIcon(List<String> iconSources, String iconName) {
        for (String iconSource : iconSources) {
            if (iconSource.contains(iconName)) {
                return true;
            }
        }

        return false;
    }
}
