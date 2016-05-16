package es.upm.dit.isst.amigos.test.SorteoCase;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SorteoBasicoTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://1-dot-isst-grupo17-amigos.appspot.com/";
    // baseUrl = "http://1-dot-amigo-invisible-1264.appspot.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSorteoBasico() throws Exception {
    driver.get(baseUrl + "/index.jsp");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.id("exampleInputName1")).clear();
    driver.findElement(By.id("exampleInputName1")).sendKeys("Edu");
    driver.findElement(By.id("exampleInputName2")).clear();
    driver.findElement(By.id("exampleInputName2")).sendKeys("Edu2");
    driver.findElement(By.id("exampleInputName3")).clear();
    driver.findElement(By.id("exampleInputName3")).sendKeys("Test");
    driver.findElement(By.id("exampleInputEmail1")).clear();
    driver.findElement(By.id("exampleInputEmail1")).sendKeys("skyle94@gmail.com");
    driver.findElement(By.id("exampleInputEmail2")).clear();
    driver.findElement(By.id("exampleInputEmail2")).sendKeys("erodvarg@gmail.com");
    driver.findElement(By.id("exampleInputEmail3")).clear();
    driver.findElement(By.id("exampleInputEmail3")).sendKeys("test@example.com");
    driver.findElement(By.id("exampleInput1")).clear();
    driver.findElement(By.id("exampleInput1")).sendKeys("3");
    driver.findElement(By.cssSelector("div.col-md-6 > button.btn.btn-default")).click();
    driver.findElement(By.id("exampleInputName")).clear();
    driver.findElement(By.id("exampleInputName")).sendKeys("Edu");
    driver.findElement(By.id("exampleInputMoney")).clear();
    driver.findElement(By.id("exampleInputMoney")).sendKeys("100");
    driver.findElement(By.id("exampleInputDate")).clear();
    driver.findElement(By.id("exampleInputDate")).sendKeys("12-10");
    driver.findElement(By.id("exampleInputMessage")).clear();
    driver.findElement(By.id("exampleInputMessage")).sendKeys("Hola!");
    driver.findElement(By.cssSelector("div.col-md-6 > button.btn.btn-default")).click();
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
