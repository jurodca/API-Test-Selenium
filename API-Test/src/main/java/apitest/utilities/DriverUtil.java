package apitest.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ErrorHandler;

import java.util.ArrayList;
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
        capabilities = DesiredCapabilities.phantomjs();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);
        driver = chooseDriver(capabilities, "phantomjs");
        if (driver != null)
        {
            driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        return driver;
    }

    private static WebDriver chooseDriver(DesiredCapabilities capabilities, String driver)
    {
        String preferredDriver = driver;
        System.setProperty("webdriver.chrome.driver", APIConstants.WEBDRIVER_PATH);

        switch (preferredDriver)
        {
            case "chrome":
                final ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                ChromeDriver chromeDriver = new ChromeDriver();
                ErrorHandler handler = new ErrorHandler();
                handler.setIncludeServerErrors(false);
                chromeDriver.setErrorHandler(handler);
                return chromeDriver;
            case "phantomjs":
                capabilities.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                APIConstants.PHANTOM_PATH);
                capabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
                capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
                capabilities.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
                capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
                capabilities.setJavascriptEnabled(true);

                ArrayList<String> cliArgs = new ArrayList<String>();
                cliArgs.add("--web-security=true");
                cliArgs.add("--ignore-ssl-errors=true");
                capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgs);
                final PhantomJSDriver phantom = new PhantomJSDriver(capabilities);
                return phantom;
            default:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-headless", "-safe-mode");
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
                final FirefoxDriver firefox = new FirefoxDriver();
                return firefox;
        }
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
