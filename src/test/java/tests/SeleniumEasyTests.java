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

public class SeleniumEasyTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.seleniumeasy.com/");
    }

    @Test
    public void goingToTestsListTest() {
        WebElement startPractisingButton = driver.findElement(By.id("btn_basic_example"));
        startPractisingButton.click();
        sleep();

        WebElement simpleFormDemoButton = driver.findElement(By.xpath("//div[@class='list-group']/a[@href='./basic-first-form-demo.html']"));
        simpleFormDemoButton.click();
        sleep();

        WebElement simpleFormHeader = driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/h3"));
        assertTrue(simpleFormHeader.isDisplayed());
    }



    @Test
    public void radioButtonTest() {
        driver.navigate().to("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='Male'][name='optradio']"));
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='Female'][name='optradio']"));

        sleep();
        maleRadioButton.click();
        sleep();
        assertTrue(maleRadioButton.isSelected());
        assertFalse(femaleRadioButton.isSelected());

        femaleRadioButton.click();
        sleep();
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

        sleep();
        genderMaleRadioButton.click();
        sleep();
        assertTrue(genderMaleRadioButton.isSelected());
        assertFalse(genderFemaleRadioButton.isSelected());

        sleep();
        genderFemaleRadioButton.click();
        sleep();
        firstGroupAgeButton.click();
        sleep();
        getValuesButton.click();
        sleep();
        assertEquals(groupRadioValues.getAttribute("textContent"), "Sex : Female Age group: 0 - 5");
        sleep();
    }

    @Test
    public void singleCheckboxTest() {
        driver.navigate().to("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
        WebElement firstCheckbox = driver.findElement(By.cssSelector("input[type='checkbox'][id='isAgeSelected']"));
        WebElement successMessageBlock = driver.findElement(By.cssSelector("div[id='txtAge']"));

        sleep();
        firstCheckbox.click();
        sleep();
        assertTrue(firstCheckbox.isSelected());
        assertTrue(successMessageBlock.isDisplayed());
        assertEquals(successMessageBlock.getAttribute("textContent"), "Success - Check box is checked");
        sleep();
        firstCheckbox.click();
        sleep();
        assertFalse(firstCheckbox.isSelected());
        assertFalse(successMessageBlock.isDisplayed());
        sleep();
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

        sleep();

        assertEquals(namesOfOptions, expectedNamesOfOptions);
    }

    @Test
    public void selectingOptionsFromSelectADayDropdownTest() {
        driver.navigate().to("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        WebElement selectADay = driver.findElement(By.cssSelector("select[class='form-control']"));
        Select selectADayDropdown = new Select(selectADay);
        sleep();

        selectADayDropdown.selectByIndex(1);
        sleep();

        assertEquals(selectADayDropdown.getFirstSelectedOption().getText(), "Sunday");
        sleep();

        selectADayDropdown.selectByValue("Monday");
        sleep();

        assertEquals(selectADayDropdown.getFirstSelectedOption().getText(), "Monday");
        sleep();

        selectADayDropdown.selectByVisibleText("Wednesday");
        sleep();

        assertEquals(selectADayDropdown.getFirstSelectedOption().getText(), "Wednesday");
    }

    private void sleep() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}