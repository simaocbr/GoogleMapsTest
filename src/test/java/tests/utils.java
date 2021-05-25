package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class utils {

    static void ButtonClick(WebDriver driver,String selector){
        WebElement button = driver.findElement(By.xpath(selector));
        button.click();
    }

    static void SendKeys(WebDriver driver,String selector,String text){
        WebElement input = driver.findElement(By.xpath(selector));
        input.sendKeys(text);
    }

    static void CheckElementText(WebDriver driver,String selector,String text){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
        String value = element.getText();
        assertEquals("Can't find "+ text +" in the search area", value, text);
    }

    static void CheckInputText(WebDriver driver,String selector,String text){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
        String value = element.getAttribute("aria-label");
        assertTrue("Can't find "+ text +" in the text",value.contains(text));
    }
}
