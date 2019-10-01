package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class CaseTest {
	 private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  
	  
	   @Before
	  public void setUp() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  
	  @After
	  public void tearDown() {
	   // driver.quit();
	  }
	  public String waitForWindow(int timeout) {
		    try {
		      Thread.sleep(timeout);
		    } catch (InterruptedException e) {
		      e.printStackTrace();
		    }
		    Set<String> whNow = driver.getWindowHandles();
		    Set<String> whThen = (Set<String>) vars.get("window_handles");
		    if (whNow.size() > whThen.size()) {
		      whNow.removeAll(whThen);
		    }
		    return whNow.iterator().next();
		  }
		  
	@Test
	void test() {
	//	fail("尚未实现");
		System.out.println("------------------------------------");
		 driver.get("https://www.baidu.com");
		  /*  driver.manage().window().setSize(new Dimension(1103, 687));
		    vars.put("window_handles", driver.getWindowHandles());
		    driver.findElement(By.linkText("百度首页")).click();
		    vars.put("win6467", waitForWindow(2000));
		    driver.switchTo().window(vars.get("win6467").toString());*/
	}

}
