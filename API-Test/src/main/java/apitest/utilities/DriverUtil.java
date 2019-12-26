
package apitest.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ErrorHandler;

import java.util.concurrent.TimeUnit;

public class DriverUtil
{

    public static long DEFAULT_WAIT = 20;
    protected static WebDriver driver;

    public static WebDriver getDefaultDriver()
    {
        if (driver != null)
        {
            return driver;
        }
        DesiredCapabilities capabilities;
        capabilities = DesiredCapabilities.chrome();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);
        driver = chooseDriver(capabilities);
        if (driver != null)
        {
            driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        return driver;
    }

    private static WebDriver chooseDriver(DesiredCapabilities capabilities)
    {
        String preferredDriver = System.getProperty("browser", "Chrome");
        System.setProperty("webdriver.chrome.driver", APIConstants.WEBDRIVER_PATH);

        if (preferredDriver.toLowerCase().equals("chrome"))
        {
            final ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            ChromeDriver driver = new ChromeDriver();
            ErrorHandler handler = new ErrorHandler();
            handler.setIncludeServerErrors(false);
            driver.setErrorHandler(handler);
            return driver;
        }
        return null;
    }

    public static void closeDriver()
    {
        if (driver != null)
        {
            try
            {
                driver.close();
                driver.quit();
            }
            catch (NoSuchMethodError nsme)
            {
                nsme.printStackTrace();
            }
            driver = null;
        }
    }

}
