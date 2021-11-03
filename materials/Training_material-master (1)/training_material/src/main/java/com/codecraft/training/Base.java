package com.codecraft.training;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Base {

    public AppiumDriver  driver;

    public Base(AppiumDriver driver){
        this.driver = driver;
    }

    public void tapGesture(MobileElement element){
        new TouchAction<>(driver).tap(TapOptions.tapOptions().withPosition(PointOption.point(element.getCenter().x+element.getSize().width/2,element.getCenter().y)).withTapsCount(2)).perform();
    }

}
