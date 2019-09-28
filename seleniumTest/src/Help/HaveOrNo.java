package Help;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HaveOrNo {
	public Boolean check(WebDriver driver,By seletor) {
		try {
			driver.findElement(seletor);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
