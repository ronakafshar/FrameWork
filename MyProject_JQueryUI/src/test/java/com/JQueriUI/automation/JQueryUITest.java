package com.JQueriUI.automation;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JQueryUITest {

	public WebDriver driver;

	@BeforeMethod
	public void beforeEachTestStart() {
		// Setting driver path for chromedriver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/browser_drivers/chromedriver.exe");
		// start a browser
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterEachTestEnd() {
		try {
			Thread.sleep(10 * 1000);

			driver.close(); // close the browser
			driver.quit(); // kills/deletes the driver object

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void Testing_JQueryUI() {
		try {
			driver.get("http://jquery.com/");
			String browserTitle = driver.getTitle();
			System.out.println("website title is: '" + browserTitle + "'");
			assertEquals(browserTitle, "jQuery");

			String currentURL = driver.getCurrentUrl();
			System.out.println("url is: [" + currentURL + "]");


		    WebElement JQueryUI = driver.findElement(By.partialLinkText("jQuery UI"));
			JQueryUI.click();
			
			//draggable
			//driver.get("https://jqueryui.com/draggable/");
			WebElement draggable = driver.findElement(By.partialLinkText("Draggable"));
			draggable.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String verticalPixel = null;
			js.executeScript("scroll(0," + verticalPixel + ")");
			String horizontalPixel = null;
			js.executeScript("scroll(" + horizontalPixel + ",0)");
			driver.switchTo().frame(0);
			Actions action = new Actions(driver);
			WebElement drag = driver.findElement(By.id("draggable"));
			WebElement drop = driver.findElement(By.xpath("/html/body"));
			action.dragAndDrop(drag , drop).build().perform();
			action.dragAndDropBy(drop,200,250).build().perform();
			
			
			driver.navigate().back();

			//droppable
			WebElement droppable = driver.findElement(By.partialLinkText("Droppable"));
			droppable.click();
			driver.switchTo().frame(0);
			WebElement drag1 = driver.findElement(By.id("draggable"));
			WebElement drop1 = driver.findElement(By.id("droppable"));
			action.dragAndDrop(drag1 , drop1).build().perform();
			
			driver.navigate().back();

			//resizeable
			WebElement resizeable = driver.findElement(By.partialLinkText("Resizable"));
			resizeable.click();
			driver.switchTo().frame(0);
			WebElement resize1 = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[1]"));
			action.clickAndHold(resize1).moveByOffset(200,0).release(resize1).build().perform();
			
			Thread.sleep(2 * 1000);
			
			
			WebElement resize2 = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[2]"));
			action.clickAndHold(resize2).moveByOffset(0,100).release(resize2).build().perform();
			
			Thread.sleep(2 * 1000);
			
			WebElement resize3 = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
			action.clickAndHold(resize3).moveByOffset(20, 50).release(resize3).build().perform();
			
	
			driver.navigate().back();
			

			//selectable
			WebElement selectable = driver.findElement(By.partialLinkText("Selectable"));
			selectable.click();
			driver.switchTo().frame(0);
			WebElement select1 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[1]"));
			action.clickAndHold(select1).release(select1).build().perform();
			WebElement select2 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[2]"));
			action.clickAndHold(select2).release(select2).build().perform();
			WebElement select3 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[3]"));
			action.clickAndHold(select3).release(select3).build().perform();
			WebElement select4 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[4]"));
			action.clickAndHold(select4).release(select4).build().perform();
			WebElement select5 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[5]"));
			action.clickAndHold(select5).release(select5).build().perform();
			WebElement select6 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[6]"));
			action.clickAndHold(select6).release(select6).build().perform();
			WebElement select7 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[7]"));
			action.clickAndHold(select7).release(select7).build().perform();
			
			driver.navigate().back();
			

			//sortable
			WebElement sortable = driver.findElement(By.partialLinkText("Sortable"));
			sortable.click();
			driver.switchTo().frame(0);
			WebElement drag4 = driver.findElement(By.cssSelector("#sortable > li:nth-child(5)"));
			WebElement drop4 = driver.findElement(By.cssSelector("#sortable > li:nth-child(3)"));
			action.dragAndDrop(drag4 , drop4).build().perform();
			WebElement drag5 = driver.findElement(By.cssSelector("#sortable > li:nth-child(6)"));
			WebElement drop5 = driver.findElement(By.cssSelector("#sortable > li:nth-child(4)"));
			action.dragAndDrop(drag5 , drop5).build().perform();
			Thread.sleep(2 * 1000);
			
		    driver.navigate().back();

		    //accordion
			WebElement accordion = driver.findElement(By.partialLinkText("Accordion"));
			accordion.click();
			driver.switchTo().frame(0);
			WebElement section2 = driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]"));
			action.clickAndHold(section2).release(section2).build().perform();
			WebElement section3 = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]"));
			action.clickAndHold(section3).release(section3).build().perform();
			WebElement section4 = driver.findElement(By.xpath("//*[@id=\"ui-id-7\"]"));
			action.clickAndHold(section4).release(section4).build().perform();
			WebElement section1 = driver.findElement(By.xpath("//*[@id=\"ui-id-1\"]"));
			action.clickAndHold(section1).release(section1).build().perform();

			driver.navigate().back();
			

			//Autocomplete
			WebElement autocomplete = driver.findElement(By.partialLinkText("Autocomplete"));
			autocomplete.click();
			driver.switchTo().frame(0);
			WebElement blank = driver.findElement(By.id("tags"));
			blank.sendKeys("a");
			blank.sendKeys(Keys.ARROW_DOWN);
            blank.sendKeys(Keys.ARROW_DOWN);
            blank.click();
			
			Thread.sleep(2 * 1000);
			
			driver.navigate().back();

			//button
			WebElement button = driver.findElement(By.partialLinkText("Button"));
			button.click();
			driver.switchTo().frame(0);
			WebElement button11 = driver.findElement(By.cssSelector(".ui-button.ui-widget.ui-corner-all"));
			action.moveToElement(button11).click().build().perform();
			Thread.sleep(2 * 1000);
			WebElement button12 = driver.findElement(By.xpath("/html/body/div/input"));
			action.moveToElement(button12).click().build().perform();
			Thread.sleep(2 * 1000);
			WebElement button13 = driver.findElement(By.xpath("/html/body/div/a"));
			action.moveToElement(button13).click().build().perform();
			Thread.sleep(2 * 1000);
			WebElement button21 = driver.findElement(By.xpath("/html/body/button"));
			action.moveToElement(button21).click().build().perform();
			Thread.sleep(2 * 1000);
			WebElement button22 = driver.findElement(By.xpath("/html/body/input"));
			action.moveToElement(button22).click().build().perform();
			Thread.sleep(2 * 1000);
			WebElement button23 = driver.findElement(By.xpath("/html/body/a"));
			action.moveToElement(button23).click().build().perform();
			Thread.sleep(2 * 1000);
		
			driver.navigate().back();

			//checkboxradio
			WebElement checkboxradio = driver.findElement(By.partialLinkText("Checkboxradio"));
			checkboxradio.click();
			driver.switchTo().frame(0);
			WebElement location1 = driver.findElement(By.xpath("/html/body/div/fieldset[1]/label[1]/span[1]"));
			action.clickAndHold(location1).release(location1).build().perform();
			WebElement location2 = driver.findElement(By.xpath("/html/body/div/fieldset[1]/label[2]/span[1]"));
			action.clickAndHold(location2).release(location2).build().perform();
			WebElement location3 = driver.findElement(By.xpath("/html/body/div/fieldset[1]/label[3]/span[1]"));
			action.clickAndHold(location3).release(location3).build().perform();
			
			WebElement hotel2 = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[1]/span[1]"));
			action.clickAndHold(hotel2).release(hotel2).build().perform();
			WebElement hotel3 = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[2]/span[1]"));
			action.clickAndHold(hotel3).release(hotel3).build().perform();
			WebElement hotel4 = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[3]/span[1]"));
			action.clickAndHold(hotel4).release(hotel4).build().perform();
			WebElement hotel5 = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[4]/span[1]"));
			action.clickAndHold(hotel5).release(hotel5).build().perform();
			
			WebElement lab = driver.findElement(By.xpath("/html/body/div/h2[3]"));
			js.executeScript("arguments[0].scrollIntoView();", lab);
			
			WebElement d2 = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[1]/span[1]"));
			action.clickAndHold(d2).release(d2).build().perform();
			WebElement q2 = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[2]/span[1]"));
			action.clickAndHold(q2).release(q2).build().perform();
			WebElement q1 = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[3]/span[1]"));
			action.clickAndHold(q1).release(q1).build().perform();
			WebElement k1 = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[4]/span[1]"));
			action.clickAndHold(k1).release(k1).build().perform();
			
			driver.navigate().back();

			
			WebElement controlgroup = driver.findElement(By.partialLinkText("Controlgroup"));
			js.executeScript("arguments[0].scrollIntoView();", controlgroup);
			
			
			
			WebElement draggable1 = driver.findElement(By.partialLinkText("Draggable"));
			js.executeScript("arguments[0].scrollIntoView();",draggable1);
			
			
			//Controlgroup
			WebElement controlgroup1 = driver.findElement(By.partialLinkText("Controlgroup"));
			controlgroup1.click();
			driver.switchTo().frame(0);
			WebElement carType = driver.findElement(By.xpath("//*[@id=\"car-type-button\"]/span[1]"));
			//action.moveToElement(carType).click().build().perform();
			action.clickAndHold(carType).release(carType).build().perform();
			WebElement suv = driver.findElement(By.id("ui-id-4"));
			action.moveToElement(suv).click().build().perform();
			
			Thread.sleep(2 * 1000);
			
			WebElement standard = driver.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/label[1]/span[1]"));
			//action.clickAndHold(standard).release(standard).build().perform();
			action.moveToElement(standard).click().build().perform();
			WebElement automatic = driver.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/label[2]/span[1]"));
			action.moveToElement(automatic).click().build().perform();
			WebElement insurance = driver.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/label[3]/span[1]"));
			action.moveToElement(insurance).click().build().perform();
			WebElement num = driver.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/span[2]/a[1]/span[1]"));
			for(int i=0;i<=3;i++) {
			action.moveToElement(num).click().build().perform();
			}
			WebElement book = driver.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/button"));
			action.moveToElement(book).click().build().perform();
			
			
			
			js.executeScript("arguments[0].scrollIntoView();",book);
			
			WebElement carType1 = driver.findElement(By.xpath("//*[@id=\"ui-id-8-button\"]/span[2]"));
			action.clickAndHold(carType1).release(carType1).build().perform();
			WebElement suv1 = driver.findElement(By.id("ui-id-12"));
			action.moveToElement(suv1).click().build().perform();
			
			Thread.sleep(2 * 1000);
			
			WebElement standard1 = driver.findElement(By.xpath("/html/body/div[1]/fieldset[2]/div/label[1]/span[1]"));
			action.moveToElement(standard1).click().build().perform();
			WebElement automatic1 = driver.findElement(By.xpath("/html/body/div[1]/fieldset[2]/div/label[2]/span[1]"));
			action.moveToElement(automatic1).click().build().perform();
			WebElement insurance1 = driver.findElement(By.xpath("/html/body/div[1]/fieldset[2]/div/label[3]/span[1]"));
			action.moveToElement(insurance1).click().build().perform();
			WebElement num1 = driver.findElement(By.xpath("/html/body/div[1]/fieldset[2]/div/span[2]/a[1]/span[1]"));
			for(int i=0;i<=2;i++) {
			action.moveToElement(num1).click().build().perform();
			}
			WebElement book1 = driver.findElement(By.id("book"));
			action.moveToElement(book1).click().build().perform();
			
			
			driver.navigate().back();
			
			

			WebElement draggable2 = driver.findElement(By.partialLinkText("Draggable"));
			js.executeScript("arguments[0].scrollIntoView();",draggable2);
			
			
			
            //datepicker
			WebElement datepicker = driver.findElement(By.partialLinkText("Datepicker"));
			datepicker.click();
			driver.switchTo().frame(0);
			/*WebElement blank1 = driver.findElement(By.xpath("//*[@id=\"datepicker\"]"));
			action.moveToElement(blank1).click().build().perform();
			WebElement month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span"));
			for(int i=0;i<=5;i++) {
				action.moveToElement(month).click().build().perform();
				}
			WebElement day = driver.findElement(By.partialLinkText("21"));
			action.moveToElement(day).click().build().perform();*/
			WebElement blank1 = driver.findElement(By.xpath("//*[@id=\"datepicker\"]"));
			blank1.sendKeys("02/02/2020");
			Thread.sleep(4 * 1000);
			
			
			driver.navigate().back();
			
			WebElement draggable3 = driver.findElement(By.partialLinkText("Draggable"));
			js.executeScript("arguments[0].scrollIntoView();",draggable3);
			
			
            //dialog
			WebElement dialog = driver.findElement(By.partialLinkText("Dialog"));
			dialog.click();
			driver.switchTo().frame(0);
			
			WebElement resize4 = driver.findElement(By.cssSelector("body > div > div.ui-resizable-handle.ui-resizable-e"));
			action.clickAndHold(resize4).moveByOffset(100,0).release(resize4).build().perform();
			WebElement resize44 = driver.findElement(By.cssSelector("body > div > div.ui-resizable-handle.ui-resizable-e"));
			action.clickAndHold(resize4).moveByOffset(-100,0).release(resize4).build().perform();
			
			Thread.sleep(2 * 1000);   
			
			WebElement resize5 = driver.findElement(By.cssSelector("body > div > div.ui-resizable-handle.ui-resizable-s"));
			action.clickAndHold(resize5).moveByOffset(0,-100).release(resize5).build().perform();
			WebElement resize55 = driver.findElement(By.cssSelector("body > div > div.ui-resizable-handle.ui-resizable-s"));
			action.clickAndHold(resize5).moveByOffset(0,100).release(resize5).build().perform();
			
			Thread.sleep(2 * 1000);
			
			WebElement resize6 = driver.findElement(By.cssSelector("body > div > div.ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se"));
			action.clickAndHold(resize6).moveByOffset(-20,-50).release(resize6).build().perform();
			WebElement resize66 = driver.findElement(By.cssSelector("body > div > div.ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se"));
			action.clickAndHold(resize6).moveByOffset(20,50).release(resize6).build().perform();
			
			Thread.sleep(2 * 1000);
			
			/*
			WebElement dragbox = driver.findElement(By.cssSelector("body > div > div.ui-dialog-titlebar.ui-corner-all.ui-widget-header.ui-helper-clearfix.ui-draggable-handle"));
			WebElement dropbody = driver.findElement(By.cssSelector("body"));
			action.dragAndDrop(dragbox , dropbody).build().perform();
			action.dragAndDropBy(drop,40,50).build().perform();
			action.dragAndDropBy(drop,-40,-50).build().perform();
			
			*/
			Thread.sleep(2 * 1000);
			
			action.release().build().perform();
			
		    Thread.sleep(2 * 1000);
		
			
			WebElement x = driver.findElement(By.xpath("/html/body/div/div[1]/button/span[1]"));
			//action.moveToElement(x).click(x).build().perform();
			x.click();
			Thread.sleep(5 * 1000);
			
			driver.switchTo().defaultContent();
			 
			 
			driver.navigate().back();

			
			
			WebElement draggable4 = driver.findElement(By.partialLinkText("Draggable"));
			js.executeScript("arguments[0].scrollIntoView();",draggable4);
			
			
			
            //menu
			WebElement menu = driver.findElement(By.partialLinkText("Menu"));
			menu.click();
			driver.switchTo().frame(0);
			WebElement books = driver.findElement(By.id("ui-id-2"));
			action.moveToElement(books).click().build().perform();
			WebElement clothing = driver.findElement(By.id("ui-id-3"));
			action.moveToElement(clothing).click().build().perform();
			WebElement electronics = driver.findElement(By.id("ui-id-4"));
			action.moveToElement(electronics).build().perform();
			
			
			
			WebElement car = driver.findElement(By.id("ui-id-6"));
			car.click();
			action.moveToElement(electronics).build().perform();
			WebElement utilities = driver.findElement(By.id("ui-id-7"));
			utilities.click();
			WebElement movies = driver.findElement(By.id("ui-id-8"));
			action.moveToElement(movies).click().build().perform();
			WebElement music = driver.findElement(By.id("ui-id-9"));
			action.moveToElement(music).click().build().perform();
			WebElement rock = driver.findElement(By.id("ui-id-10"));
			rock.click();
			WebElement alternative = driver.findElement(By.id("ui-id-11"));
			alternative.click();
			action.moveToElement(rock).click().build().perform();
			WebElement classic = driver.findElement(By.id("ui-id-12"));
			classic.click();
			action.moveToElement(music).click().build().perform();
			WebElement jazz = driver.findElement(By.id("ui-id-13"));
			jazz.click();
			WebElement freejazz = driver.findElement(By.id("ui-id-14"));
			freejazz.click();
			action.moveToElement(jazz).click().build().perform();
			WebElement bigBand = driver.findElement(By.id("ui-id-15"));
			bigBand.click();
			action.moveToElement(jazz).click().build().perform();
			WebElement modern = driver.findElement(By.id("ui-id-16"));
			modern.click();
			
			WebElement pop = driver.findElement(By.id("ui-id-17"));
			pop.click();
			
			driver.navigate().back();
			
			WebElement draggable5 = driver.findElement(By.partialLinkText("Draggable"));
			js.executeScript("arguments[0].scrollIntoView();",draggable5);
			
			
            //selectmenu
			WebElement selectmenu = driver.findElement(By.partialLinkText("Selectmenu"));
			selectmenu.click();
			driver.switchTo().frame(0);
			WebElement speed = driver.findElement(By.cssSelector("#speed-button > span.ui-selectmenu-icon.ui-icon.ui-icon-triangle-1-s"));
			action.moveToElement(speed).click().build().perform();
			WebElement fast = driver.findElement(By.id("ui-id-4"));
			action.moveToElement(fast).click().build().perform();
			
			Thread.sleep(3 * 1000);
			
			WebElement file = driver.findElement(By.cssSelector("#files-button > span.ui-selectmenu-icon.ui-icon.ui-icon-triangle-1-s"));
			action.moveToElement(file).click().build().perform();
			WebElement someUnKnownFile = driver.findElement(By.id("ui-id-8"));
			action.moveToElement(someUnKnownFile).click().build().perform();
			WebElement number = driver.findElement(By.cssSelector("#number-button > span.ui-selectmenu-icon.ui-icon.ui-icon-triangle-1-s"));
			action.moveToElement(number).click().build().perform();
			WebElement four = driver.findElement(By.id("ui-id-13"));
			action.moveToElement(four).click().build().perform();
			WebElement title = driver.findElement(By.cssSelector("#salutation-button > span.ui-selectmenu-icon.ui-icon.ui-icon-triangle-1-s"));
			action.moveToElement(title).click().build().perform();
			WebElement mrs = driver.findElement(By.id("ui-id-31"));
			action.moveToElement(mrs).click().build().perform();
			Thread.sleep(5 * 1000);
			driver.navigate().back();

            WebElement draggable6 = driver.findElement(By.partialLinkText("Draggable"));
			js.executeScript("arguments[0].scrollIntoView();",draggable6);
			

            //slider
			WebElement slider = driver.findElement(By.partialLinkText("Slider"));
			slider.click();
			driver.switchTo().frame(0);
			WebElement dragslider = driver.findElement(By.cssSelector("#slider > span"));
			action.clickAndHold(dragslider).moveByOffset(100,0).release(dragslider).build().perform();
			
			
			driver.navigate().back();
			
			WebElement draggable7 = driver.findElement(By.partialLinkText("Draggable"));
			js.executeScript("arguments[0].scrollIntoView();",draggable7);
			


            //tabs
			WebElement tabs = driver.findElement(By.partialLinkText("Tabs"));
			tabs.click();
			driver.switchTo().frame(0);
			WebElement one = driver.findElement(By.partialLinkText("Nunc tincidunt"));
			action.moveToElement(one).click().build().perform();
			WebElement two = driver.findElement(By.partialLinkText("Proin dolor"));
			action.moveToElement(two).click().build().perform();
			WebElement three = driver.findElement(By.partialLinkText("Aenean lacinia"));
			action.moveToElement(three).click().build().perform();
			
			driver.navigate().back();
			
			WebElement draggable8 = driver.findElement(By.partialLinkText("Draggable"));
			js.executeScript("arguments[0].scrollIntoView();",draggable8);
			


            //tooltip
			WebElement tooltip = driver.findElement(By.partialLinkText("Tooltip"));
			tooltip.click();
			driver.switchTo().frame(0);
			WebElement name = driver.findElement(By.id("age"));
			name.sendKeys("36");
			driver.navigate().back();
			Thread.sleep(5 * 1000);

			currentURL = driver.getCurrentUrl();
			System.out.println("url is: [" + currentURL + "]");

			Thread.sleep(2 * 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}