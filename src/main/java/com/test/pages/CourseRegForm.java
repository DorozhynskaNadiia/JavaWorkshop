package com.test.pages;

/**
 * Created by dorozhynska on 2/13/2017.
 */

import org.apache.xpath.operations.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseRegForm {

    private WebDriver driver;

    @FindBy(css = ".submit-wrap > input")
    private WebElement clearLink;

    @FindBy(css = ".wpcf7-form-control.wpcf7-submit")
    private WebElement submitLink;

    @FindBy(id = "comment")
    private WebElement commentField;

    @FindBy(css = "input[name='text-71']")
    private WebElement yourSkype;

    @FindBy(css = "input[name='your-email']")
    private WebElement yourEmail;

    @FindBy(css = "input[name='text-297']")
    private WebElement yourPhone;

    @FindBy(css = "input[name='text-68']")
    private WebElement yourName;

    @FindBy(css = "input[name='your-name']")
    private WebElement yourSurname;

    @FindBy(css = "select[name='menu-11']")
    private WebElement dropdownList;

    public CourseRegForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private CourseRegForm enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);

        return this;
    }

    public CourseRegForm enterUserName(String name) {
        return enterText(yourName, name);
    }

    public CourseRegForm enterLastName(String lastName) {
        return enterText(yourSurname, lastName);
    }

    public CourseRegForm enterNameAndLastName(String name, String lastName) {
        return enterUserName(name).enterLastName(lastName);
    }

    public void submitForm() {
        submitLink.submit();
    }

    public String getName(){
        return yourName.getAttribute("value");
    }

    public String getLastName(){
        return yourSurname.getAttribute("value");
    }
}

