package com.binupjewelry.base;

import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(DriverContext.driver,this);
    }
}