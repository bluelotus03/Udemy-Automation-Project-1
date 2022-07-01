package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
           webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;

        switch(getBrowserType()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                System.out.println("✅ Opened Chrome");
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                System.out.println("✅ Opened Firefox");
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
    private static String getBrowserType() {
        String browserType = null;

        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
            properties.load(file);
            browserType = properties.getProperty("browser").toLowerCase().trim();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return browserType;
    }

    public static void cleanupDriver() {
//        webDriver.get().quit();
//        System.out.println("✅ Closed " + getBrowserType() + " browser");
        webDriver.remove();
        System.out.println("✅ Removed driver");
    }
}
