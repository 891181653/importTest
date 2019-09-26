package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class job {

	public void login(WebDriver driver) {
		
		

		// 普通Login-51job.com----------------------------------------------------------------
		driver.get("https://login.51job.com/login.php?lang=c");
		System.out.println(driver.getTitle());
//		driver.findElement(By.linkText("首页")).click();
		driver.findElement(By.partialLinkText("首页")).click();
		// 设置浏览器 大小---------------------
		/*
		 * maximize() 设置浏览器最大化 setSize() 设置浏览器宽高
		 */
		driver.manage().window().maximize();// 设置浏览器最大化
	//	driver.manage().window().
		// driver.manage().window().setSize(new Dimension(480, 800));设置浏览器大小
		// driver.findElement(By.linkText("登录")).click();

		// 浏览器返回，向前，刷新--------------
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();
		// Login 功能 多种定位方式------------
		// driver.findElement(By.linkText("登录")).click();连接文本方式
		// driver.findElement(By.partialLinkText("首页")).click(); 模糊连接文本方式
		// driver.findElement(By.id("loginname")).click();id方式
		// driver.findElement(By.className("ef")).click();class方式
		// driver.findElement(By.name("loginname")).click();name方式
		// driver.findElement(By.tagName("input")).sendKeys("13437868119");tag
		// driver.findElement(By.xpath("//*[@id=\"loginname\"]")).sendKeys("13437868119");Xpath
		// 定位
		driver.findElement(By.cssSelector("#loginname")).sendKeys("13437868119");
		// driver.findElement(By.id("loginname")).sendKeys("13437868119");
		driver.findElement(By.id("password")).sendKeys("zxcvbnm123");
		driver.findElement(By.className("p_but")).click();
		String txtString = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[3]/ul/li[1]/a")).getText()
				.toString();
		System.out.println("-----------------" + txtString);
		if (txtString.equals("欢迎您")) {
			System.out.println("欢迎登陆，登录成功！");
		} else {
			System.out.println("对不起，登录失败");
		}
		// 普通Login

		// 普通Login-51job.com----------------------------------------------------------------

		// 打开隐藏的div 直接用JavascriptExecutor执行就好
		/*
		 * Actions action=new Actions(driver); WebElement
		 * welcome=driver.findElement(By.xpath(
		 * "/html/body/div[1]/div[1]/div/div[3]/ul/li[1]/a"));
		 * action.moveToElement(welcome).perform();
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement changePage = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[3]/ul/li[3]/a"));
		js.executeScript("arguments[0].click();", changePage);
		String nString = driver.findElement(By.xpath("/html/body/div[2]/div[1]/a[2]")).getAttribute("class");
		if (nString.equals("on")) {
			System.out.println("成功从隐藏界面点击连接跳转");
		} else {
			System.out.println("隐藏界面跳转失败");
		}
		WebElement LoginOut = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[3]/ul/li[6]/a"));
		js.executeScript("arguments[0].click();", LoginOut);

		// 打开隐藏的div 直接用JavascriptExecutor执行就好

		// 隐藏div式登录
		driver.get("https://www.51job.com/");
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div[3]/span[1]")).click();
		WebElement lowdown = driver.findElement(By.xpath("//*[@id=\"login_form\"]/p[2]/span"));

		js.executeScript("arguments[0].click();", lowdown);
		// 显示面板，不显示的话会报 element not interactable 不能交互的错误
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div[3]/span[1]")).click();

		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// 对于input的属性改变后再进行操作
		String inputName = "document.getElementById('loginname').setAttribute('value', 'text')";
		js.executeScript(inputName);
		// driver.findElement(By.id("loginname")).sendKeys("13437868119");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		String inputpassword = "document.getElementById('password').setAttribute('type', 'text')";
		js.executeScript(inputpassword);
		driver.findElement(By.id("password")).sendKeys("zxcvbnm123");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// 单个复选框操作
		driver.findElement(By.id("isread")).click();
		/*
		 * String checkoutoLogin = "document.getElementById('isread').click()";
		 * js.executeScript(checkoutoLogin);
		 */
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// button或连接的操作
		driver.findElement(By.id("login_btn")).click();
		// js操作复选框
		/*
		 * WebElement webbutton=driver.findElement(By.id("login_btn"));
		 * js.executeScript("arguments[0].click();", webbutton);
		 */

		// driver.quit();

	}
}
