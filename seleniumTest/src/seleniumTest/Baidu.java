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

public class Baidu {

	public void login(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.baidu.com/"); // ��ȡ ��ҳ�� title
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("��¼")).click(); // �л�����
		// ���õȴ�ʱ�䣬֪���ҵ�ĳ���¼���ſ�ʼ����ִ��
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
		//�л�����
		Set<String> nwindow=driver.getWindowHandles();
	    Iterator aIterator=nwindow.iterator();
	    while(aIterator.hasNext()) {
	    	String window1=(String) aIterator.next();
	    	System.out.println(window1);
	    	driver.switchTo().window(window1);
	    }
		//�л�����
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"TANGRAM__PSP_4__phone\"]")));
		driver.findElement(By.name("phone")).sendKeys("13437868119");
	    driver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_4__phoneLabel\"]")).click();
	    //��������alert
	  
	   /* System.out.println("��ȡ������ı�ֵ��"+driver.switchTo().alert().getText());
*/		
	    Thread.sleep(3000);
	    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("TANGRAM__PSP_23__confirm_cancel")));
	   WebElement cancelbutton= driver.findElement(By.id("TANGRAM__PSP_23__confirm_cancel"));
	    js.executeScript("arguments[0].click();", cancelbutton);
	   //TODO:sfsdsggs
	    //TODO:xxxxxx
	    
	}
}
