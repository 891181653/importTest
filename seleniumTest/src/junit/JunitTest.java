package junit;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class JunitTest {

	@Test
	void test() {
		//fail("ипн╢й╣ож");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.imooc.com");
	}

}
  