package seleniumTest;

import javax.imageio.ImageIO;


import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.server.HttpChannelState.Action;

import Help.HaveOrNo;
import Help.yanzheng.Captcha;
import Help.yanzheng.DamaUtil;

import org.openqa.selenium.By.ByName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

public class Imooc {
	WebDriver driver;
	WebDriverWait wait;
	HaveOrNo checkElement = new HaveOrNo();

	public void initDriver(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 3000);
	}

//Login
	public void login() throws IOException {
		driver.get("https://www.imooc.com");
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("��¼")));
		driver.findElement(By.linkText("��¼")).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("js-loginWrap")));
		driver.findElement(By.name("email")).sendKeys("13437868119");
		driver.findElement(By.name("password")).sendKeys("zxcfghuiop321");

		// test��֤��

		try {

			By seletor = new By.ByXPath("//*[@id=\"signup-form\"]/div[3]/input");
			driver.manage().window().maximize();
			if (checkElement.check(driver, seletor)) {
				WebElement ele = driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[3]/a[1]/img"));

				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				BufferedImage fullImg = ImageIO.read(screenshot);

				// Get the location of element on the page
				Point point = ele.getLocation();

				// Get width and height of the element
				int eleWidth = ele.getSize().getWidth();
				int eleHeight = ele.getSize().getHeight();

				// Crop the entire page screenshot to get only element screenshot
				BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
				ImageIO.write(eleScreenshot, "png", screenshot);

				// Copy the element screenshot to disk
				File screenshotLocation = new File("C:\\images\\GoogleLogo_screenshot.png");
				FileUtils.copyFile(screenshot, screenshotLocation);

				// -

				DamaUtil util = new DamaUtil();
				System.out.println("===================");
				String code = ""; // ��֤��
				Captcha captcha = new Captcha();
				captcha.setFilePath("test.png");
				code = DamaUtil.getCaptchaResult(captcha);
				System.out.println("���봦���������֤����" + code);
				WebElement elementsumbit = driver.findElement(By.id("seccodeInput"));
				// ����ؼ���
				elementsumbit.sendKeys(code);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

				System.out.println("����Ҫ��֤��");
			}

		} catch (Exception e) {
			System.out.println("��֤���������");

		}

		// end ��֤��

		driver.findElement(By.className("xa-login")).click();

	}

//�༭������Ϣ
	public void editImformation() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"header-avator\"]/img")));
		driver.findElement(By.xpath("//*[@id=\"header-avator\"]/img")).click();
		driver.findElement(By.className("set-btn")).click();
		wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/ul/li[2]/a")));
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/ul/li[2]/a")).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("js-edit-info")));
		driver.findElement(By.className("js-edit-info")).click();
		// edit����༭div

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("job")));
		WebElement form1 = driver.findElement(By.id("profile"));
		WebElement job = form1.findElement(By.id("job"));
		// WebElement job=driver.findElement(By.id("job"));

		// ѡ��ְҵ
		job.click();
		Thread.sleep(3000);
		Select jobs = new Select(job);
		jobs.selectByValue("9");
		job.click();
		// ��д�ǳ�
		WebElement nName = form1.findElement(By.id("nick"));
		nName.click();
		nName.clear();
		nName.sendKeys("kkkkkkkkkkkkkkkkk");
		// ѡ��ʡ��
		WebElement province = form1.findElement(By.id("province-select"));
		province.click();
		Select pro = new Select(province);
		pro.selectByValue("19");
		province.click();
		// ѡ�����
		Thread.sleep(2000);
		WebElement city = form1.findElement(By.id("city-select"));
		city.click();
		Thread.sleep(2000);
		Select ci = new Select(city);
		ci.selectByValue("204");
		city.click();
		// ѡ����
		Thread.sleep(2000);
		WebElement area = form1.findElement(By.id("area-select"));
		area.click();
		Select areas = new Select(area);
		areas.selectByValue("1765");
		area.click();
		// ѡ���Ա�
		List<WebElement> sex = form1.findElements(By.name("sex"));
		sex.get(1).click();
		// ��д���ڸ��˱�ע
		form1.findElement(By.id("aboutme")).sendKeys("ttttttt");
		form1.findElement(By.id("profile-submit")).click();

		// �ж���û����erroά��div
		Thread.sleep(2000);
		HaveOrNo aHaveOrNo = new HaveOrNo();
		By seletor = new By.ByClassName("js-modal-info");

		if (aHaveOrNo.check(driver, seletor)) {
			WebElement errorInfo = driver.findElement(By.className("js-modal-info"));
			driver.findElement(By.xpath("/html/body/div[11]/div/div/div/div/a/span")).click();
			System.out.println("right");
		} else {
			System.out.println("error");
		}
		// ���ȡ�����ر�div
		driver.findElement(By.xpath("//*[@id=\"profile\"]/div[6]/div/a[2]")).click();

	}

//�ϴ�ͷ��
	public void uploadPicture() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.className("avator-img"));
		actions.moveToElement(target);
		Thread.sleep(1000);
		driver.findElement(By.className("update-avator")).click();
		// driver.findElement(By.linkText("�ϴ�ͷ��")).click();
		driver.findElement(By.id("upload")).sendKeys("C:\\images\\picture2.png");
		// driver.findElement(By.linkText("ȷ��")).click();ϵͳά�����޸Ĳ���
		Thread.sleep(3000);
		driver.close();
	}

	public void editPosition() throws InterruptedException {
		String newPosition = "�������";
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"header-avator\"]/img")));
		driver.findElement(By.xpath("//*[@id=\"header-avator\"]/img")).click();
		driver.findElement(By.className("set-btn")).click();
		driver.findElement(By.linkText("�ռ���ַ")).click();
		Thread.sleep(3000);
		By sele = new By.ByXPath("//*[@id=\"main\"]/div/div[2]/div/div/div[3]/div/ul/li[1]/div/p[1]");

		if (!(checkElement.check(driver, sele))) {
			System.out.println("��ַ�����������������");
		} else {

			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div[3]/div/ul/li[1]/div/p[1]")).click();

			Thread.sleep(1000);
			WebElement contentBox = driver.findElement(By.className("contentBox"));
			WebElement listul = contentBox.findElement(By.className("list-box"));
			List<WebElement> targetF = listul.findElements(By.tagName("li"));
			String allName = newPosition.toString() + targetF.size();
			driver.findElement(By.id("name")).sendKeys(allName);
			driver.findElement(By.id("phone")).sendKeys("13452654556");
			WebElement prov = driver.findElement(By.id("province-select"));
			prov.click();
			Thread.sleep(1000);
			Select pro1 = new Select(prov);
			pro1.selectByVisibleText("�㶫");
			prov.click();

			Thread.sleep(1000);
			WebElement city = driver.findElement(By.id("city-select"));
			city.click();
			Thread.sleep(1000);
			Select city1 = new Select(city);
			city1.selectByVisibleText("տ����");
			city.click();

			Thread.sleep(1000);
			WebElement area = driver.findElement(By.id("area-select"));
			area.click();
			Thread.sleep(1000);
			Select area1 = new Select(area);
			area1.selectByVisibleText("������");
			area.click();

			driver.findElement(By.id("addrdetail"))
					.sendKeys("����������d80a294506b4c9d18015e755cee48f953ddc3f2f-refs/branch-heads/380f��Ҫ20����");
			driver.findElement(By.id("zipcode")).sendKeys("510000");

			driver.findElement(By.id("submit")).click();
			Thread.sleep(4000);
			// ��֤�Ƿ��ύ�ɹ�
			contentBox = driver.findElement(By.className("contentBox"));
			listul = contentBox.findElement(By.className("list-box"));
			By sele1 = new By.ByXPath("//*[@id=\"main\"]/div/div[2]/div/div/div[3]/div/ul/li[1]/div/p[1]");
			List<WebElement> target = listul.findElements(By.tagName("li"));
			System.out.println();
			WebElement newOne;
			if (checkElement.check(driver, sele1)) {
				System.out.println(target.size()+"--------------------");
				newOne = target.get(1);

			} else {
				System.out.println(target.size()+"--------------------");
				newOne = target.get(0);
			}

			WebElement nameIn = newOne.findElement(By.className("name"));
			if (nameIn.getText().equals(allName)) {
				System.out.println("¼��ɹ�");
				// �޸�Ĭ��
				Actions actions = new Actions(driver);
				actions.moveToElement(newOne).perform();
				Thread.sleep(2000);
				
				if(target.size()==2) {
					System.out.println("����Ҫ�޸�Ĭ�ϵĵ�ַ");
				}
				else
				{
					newOne.findElement(By.className("js-normal-btn")).click();
					Thread.sleep(2000);

					String statues = newOne.findElement(By.className("normal-icon")).getAttribute("style");
					System.out.println(statues + "----------------------");
					if (statues.equals("display: block;")) {
						System.out.println("SUCCESS");
					} else {
						System.out.println("ERROR");
					}
				}
			
				// end�޸�Ĭ��
			} else {
				System.out.println("¼��ʧ��");
			}
		}

	}

}
