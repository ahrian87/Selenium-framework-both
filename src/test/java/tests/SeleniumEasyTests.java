package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class SeleniumEasyTests extends TestBase {

    @Test
    public void goingToTestsListTest() {
        WebElement startPractisingButton = driver.findElement(By.id("btn_basic_example"));
        startPractisingButton.click();

        WebElement simpleFormDemoButton = driver.findElement(By.xpath("//div[@class='list-group']/a[@href='./basic-first-form-demo.html']"));
        simpleFormDemoButton.click();

        WebElement simpleFormHeader = driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/h3"));
        assertTrue(simpleFormHeader.isDisplayed());
    }

    @Test
    public void radioButtonTest() {
        driver.navigate().to("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='Male'][name='optradio']"));
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='Female'][name='optradio']"));

        maleRadioButton.click();
        assertTrue(maleRadioButton.isSelected());
        assertFalse(femaleRadioButton.isSelected());

        femaleRadioButton.click();
        assertTrue(femaleRadioButton.isSelected());
        assertFalse(maleRadioButton.isSelected());
    }

    @Test
    public void groupRadioButtonsTest() {
        driver.navigate().to("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
        WebElement genderMaleRadioButton = driver.findElement(By.cssSelector("input[value='Male'][name='gender']"));
        WebElement genderFemaleRadioButton = driver.findElement(By.cssSelector("input[value='Female'][name='gender']"));
        WebElement firstGroupAgeButton = driver.findElement(By.cssSelector("input[value='0 - 5']"));
        WebElement getValuesButton = driver.findElement(By.cssSelector("button[class='btn btn-default'][onclick]"));
        WebElement groupRadioValues = driver.findElement(By.cssSelector("p[class='groupradiobutton']"));

        genderMaleRadioButton.click();
        assertTrue(genderMaleRadioButton.isSelected());
        assertFalse(genderFemaleRadioButton.isSelected());

        genderFemaleRadioButton.click();
        firstGroupAgeButton.click();
        getValuesButton.click();
        assertEquals(groupRadioValues.getAttribute("textContent"), "Sex : Female Age group: 0 - 5");
    }

    @Test
    public void selectListTest() {
        driver.navigate().to("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        WebElement selectADay = driver.findElement(By.cssSelector("select[class='form-control']"));
        Select selectADayDropdown = new Select(selectADay);

        List<WebElement> options = selectADayDropdown.getOptions();
        List<String> namesOfOptions = new ArrayList<>();

        for (WebElement option : options) {
            namesOfOptions.add(option.getText());
            System.out.println(option.getText());
        }

        List<String> expectedNamesOfOptions = new ArrayList<>();
        expectedNamesOfOptions.add("Please select");
        expectedNamesOfOptions.add("Sunday");
        expectedNamesOfOptions.add("Monday");
        expectedNamesOfOptions.add("Tuesday");
        expectedNamesOfOptions.add("Wednesday");
        expectedNamesOfOptions.add("Thursday");
        expectedNamesOfOptions.add("Friday");
        expectedNamesOfOptions.add("Saturday");


        assertEquals(namesOfOptions, expectedNamesOfOptions);
    }

    @Test
    public void selectingOptionsFromSelectADayDropdownTest() {
        driver.navigate().to("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        WebElement selectADay = driver.findElement(By.cssSelector("select[class='form-control']"));
        Select selectADayDropdown = new Select(selectADay);

        selectADayDropdown.selectByIndex(1);

        assertEquals(selectADayDropdown.getFirstSelectedOption().getText(), "Sunday");

        selectADayDropdown.selectByValue("Monday");

        assertEquals(selectADayDropdown.getFirstSelectedOption().getText(), "Monday");

        selectADayDropdown.selectByVisibleText("Wednesday");

        assertEquals(selectADayDropdown.getFirstSelectedOption().getText(), "Wednesday");
    }

}