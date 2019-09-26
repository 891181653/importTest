package seleniumTest;
import java.util.Iterator;
import java.util.Set;
import java.util.function.ToDoubleBiFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.sourceforge.htmlunit.corejs.javascript.tools.shell.JSConsole;

public class imooc {

	public void login(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.baidu.com/"); // 获取 网页的 title
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("登录")).click(); // 切换窗口
		// 设置等待时间，知道找到某个事件后才开始往下执行
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"TANGRAM__PSP_10__footerULoginBtn\"]")));
		driver.findElement(By.id("TANGRAM__PSP_10__footerULoginBtn")).click();
		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"TANGRAM__PSP_10__userName\"]")));
		driver.findElement(By.id("TANGRAM__PSP_10__userName")).sendKeys("zxcvbn");
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("zxcvbn");
		driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("vcode-close")));
		driver.findElement(By.className("vcode-close")).click();
		driver.findElement(By.xpath("//*[@id=\"passport-login-pop-dialog\"]/div/div/div/div[3]/a")).click();
	}
	public void register(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//切换窗口
		Set<String> nwindow=driver.getWindowHandles();
	    Iterator aIterator=nwindow.iterator();
	    while(aIterator.hasNext()) {
	    	String window1=(String) aIterator.next();
	    	System.out.println(window1);
	    	driver.switchTo().window(window1);
	    }
		//切换窗口
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"TANGRAM__PSP_4__phone\"]")));
		driver.findElement(By.name("phone")).sendKeys("13437868119");
	    driver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_4__phoneLabel\"]")).click();
	    //处理弹出框alert
	  
	   /* System.out.println("获取警告框文本值："+driver.switchTo().alert().getText());
*/		
	    Thread.sleep(3000);
	    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("TANGRAM__PSP_23__confirm_cancel")));
	   WebElement cancelbutton= driver.findElement(By.id("TANGRAM__PSP_23__confirm_cancel"));
	    js.executeScript("arguments[0].click();", cancelbutton);
	   //TODO:sfsdsggs
	    //TODO:xxxxxx
	    
	}
}
