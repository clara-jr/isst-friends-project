package es.upm.dit.isst.amigos.test.RegistroCase;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestcaseRegistroEInicioDeSesion {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://1-dot-amigo-invisible-1264.appspot.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCaseRegistroEInicioDeSesion() throws Exception {
    driver.get(baseUrl + "/index.jsp");
    driver.findElement(By.linkText("Iniciar Sesión")).click();
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("nachoperegrino94@gmail.com");
    driver.findElement(By.id("next")).click();
    driver.findElement(By.id("Passwd")).clear();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.findElement(By.linkText("Cerrar Sesión")).click();
    driver.findElement(By.linkText("Iniciar Sesión")).click(); 
    driver.findElement(By.id("Passwd")).clear();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
