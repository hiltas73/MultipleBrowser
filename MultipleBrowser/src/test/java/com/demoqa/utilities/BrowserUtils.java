package com.demoqa.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BrowserUtils {


 public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void sleep(double second){
     second*=1000;
     long wait=(long) second;
     try {
         Thread.sleep(wait);
     }catch (Exception e){

     }
    }
}
