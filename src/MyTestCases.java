import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Random;

public class MyTestCases {
	  WebDriver driver = new ChromeDriver();
    
    Random random = new Random();
    String Url = "file:///C:/Users/LENOVO/Desktop/Fainl%20Task/Responsive-Form/index.html";
    String[] firstNames = {"Ayoub", "Heba", "Ali", "Omar", "Assel"};
    String[] lastNames = {"Smadi", "Obedat", "Smadi", "Ayoub", "Sss"};
    String[] phones = {"0793214567" , "0786321548","0797166460"};
    String[] dobs = {"02/27/2001", "01/03/2002", "06/06/2006", "03/03/2003", "09/09/2009"};
    String[] addresses = {"Amman", "Ajloun", "Jarash", "Irbid", "Zarqa"};
    String[] genders = {"Male", "Female"};
    
  

    @BeforeTest
    public void setUp() {
    
        driver.get(Url);
        driver.manage().window().maximize();
    }

    @Test(invocationCount = 6)
    public void testFormSubmission() throws InterruptedException {
    	  String firstName = firstNames[random.nextInt(firstNames.length)];
    	    String lastName = lastNames[random.nextInt(lastNames.length)];
    	    String email = firstName + lastName + random.nextInt(1000) + "@gmail.com";
    	    String phone = phones[random.nextInt(phones.length)];
    	    String dob = dobs[random.nextInt(dobs.length)];
    	    String gender = genders[random.nextInt(genders.length)];
    	    String address = addresses[random.nextInt(addresses.length)];
    

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        firstNameField.sendKeys(firstName);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys(lastName);

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);

        WebElement phoneField = driver.findElement(By.id("phone"));
        phoneField.sendKeys(phone);

        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys(dob);

        WebElement genderField = driver.findElement(By.id("gender"));
        genderField.sendKeys(gender);

        WebElement addressField = driver.findElement(By.id("address"));
        addressField.sendKeys(address);

        WebElement submitButton = driver.findElement(By.className("btn-primary"));
        Thread.sleep(3000);
        submitButton.click();
        WebElement Resltmessg=driver.findElement(By.className("card"));
        Assert.assertEquals(Resltmessg.getText(), "Display Results:");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
