import com.microsoft.playwright.*;
import com.redbus.selewright.PlaywrightImplementation;
import com.redbus.selewright.SeleniumImplementation;
import com.redbus.selewright.Selewright;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
    public static void main(String[] args) {
        Selewright selewright = null;

        try {
            selewright = setupSelewright("selenium");
            boolean result = runSampleTest(selewright);
            System.out.println("Test Verification: " + result);
        } finally {
            if (selewright != null) {
                selewright.closeBrowser();
            }
        }
    }

    private static Selewright setupSelewright(String automationTool) {
        if ("selenium".equalsIgnoreCase(automationTool.trim())) {
            WebDriver driver = new ChromeDriver();
            return new SeleniumImplementation(driver);
        } else if ("playwright".equalsIgnoreCase(automationTool.trim())) {
            Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            return new PlaywrightImplementation(page);
        }
        throw new IllegalArgumentException("Invalid tool: " + automationTool);
    }

    private static boolean runSampleTest(Selewright selewright) {
        selewright.openUrl("https://github.com/Krishna-D-Hegde?tab=repositories");
        selewright.enterText("//input[@id='your-repos-filter']", "selewright");
        selewright.click("//a[@href='/Krishna-D-Hegde/selewright']");
        return selewright.isDisplayed("(//a[@href='/Krishna-D-Hegde/selewright/blob/main/README.md'])[last()]");
    }
}
