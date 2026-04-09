import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo {
    private WebDriver cd;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\AdithMR\\MY_MEGA\\SEM4\\ST\\PROJECT_REQ\\Drivers\\edgedriver_win64\\msedgedriver.exe");
        cd = new ChromeDriver();
    }

    @Test
    public void tc1() {
        cd.manage().window().maximize();
        cd.get("https://www.google.com");
    }

    @Test
    public void tc2() {
        WebElement searchBox = cd.findElement(By.name("q"));
        searchBox.sendKeys("reddit");
        searchBox.submit();
    }

    @Test
    public void tc3() throws InterruptedException {
        WebElement link = cd.findElement(By.partialLinkText("Reddit"));
        link.click();
        Thread.sleep(3000);
    }

    @Test
    public void tc4() throws InterruptedException {
        WebElement signInButton = cd.findElement(By.xpath("//span[.='Log In']"));
        signInButton.click();
        Thread.sleep(3000);
    }

    @Test
    public void tc5() throws InterruptedException {
        WebElement emailField = cd.findElement(By.id("login-username"));
        emailField.sendKeys("Jan_Man69");
        WebElement passwordField = cd.findElement(By.id("login-password"));
        passwordField.sendKeys("Password123");
        JavascriptExecutor js = (JavascriptExecutor) cd;
        js.executeScript(
                "document.querySelector(\"body > shreddit-app > shreddit-overlay-display\").shadowRoot.querySelector(\"shreddit-signup-drawer\").shadowRoot.querySelector(\"shreddit-drawer > div > shreddit-async-loader > div > shreddit-slotter\").shadowRoot.querySelector(\"#login > auth-flow-modal > div.w-100 > faceplate-tracker > button > span > span\").click();");
        Thread.sleep(7000);
    }

    @Test
    public void tc6() throws InterruptedException {
        WebElement chat = cd.findElement(By.id("header-action-item-chat-button"));
        chat.click();
        Thread.sleep(5000);
    }

    @Test
    public void tc7() throws InterruptedException {
        WebElement create = cd.findElement(By.cssSelector("#create-post"));
        create.click();
        Thread.sleep(7000);
        cd.navigate().back();
    }

    @Test
    public void tc8() throws InterruptedException {
        WebElement notify = cd.findElement(
                By.cssSelector("#mini-inbox-tooltip > span > faceplate-tracker > faceplate-tooltip > button"));
        notify.click();
        Thread.sleep(7000);
    }

    @Test
    public void tc9() throws InterruptedException {
        WebElement dropdown = cd.findElement(By.cssSelector(
                "#main-content > div > shreddit-async-loader > div > shreddit-layout-event-setter > shreddit-sort-dropdown"));
        dropdown.click();
        Thread.sleep(7000);
    }

    @AfterClass
    public void tearDown() {
        cd.quit();
    }
}
