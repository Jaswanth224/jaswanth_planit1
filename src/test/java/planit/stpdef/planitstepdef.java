package planit.stpdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.print.DocFlavor;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class planitstepdef {
    WebDriver driver;
    int i;
    @Given("user opened the browser and entered the url")
    public void user_opened_the_browser_and_entered_the_url() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://jupiter.cloud.planittesting.com");
        driver.manage().window().maximize();

    }
    @When("from the homepage user click on contact")
    public void from_the_homepage_user_click_on_contact() {
        driver.findElement(By.xpath("//*[@id=\"nav-contact\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @When("user click on submit button")
    public void user_click_on_submit_button() {
        driver.findElement(By.xpath("/html/body/div[2]/div/form/div/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }
    @When("verify the mandatory fields are populating with the error  messages")
    public void verify_the_mandatory_fields_are_populating_with_the_error_messages() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String actforename_errmsg= driver.findElement(By.xpath("//span[@id='forename-err']")).getText();
        String expforename_errmsg="Forename is required";
        Assert.assertEquals(actforename_errmsg,expforename_errmsg);
        System.out.println("forename error message is populating correctly");
        String actforemail_errmsg=  driver.findElement(By.xpath("//span[@id='email-err']")).getText();
        String expforemail_errmsg="Email is required";
        Assert.assertEquals(actforemail_errmsg,expforemail_errmsg);
        System.out.println("email error message is poulating correctly");
        String actmsg_errmsg= driver.findElement(By.xpath("//span[@id='message-err']")).getAttribute("innerHTML");
        String Expmsg_errmsg="Message is required";
        Assert.assertEquals(actmsg_errmsg,Expmsg_errmsg);
        System.out.println("Message textbox error message is populating correctly");

    }
    @Then("verify the error messages are gone with valid data")
    public void verify_the_error_messages_are_gone_with_valid_data() {
        driver.findElement(By.id("forename")).sendKeys("Jaswanth");
        driver.findElement(By.id("email")).sendKeys( "jaswanth@gmail.com");
        driver.findElement(By.id("message")).sendKeys("Hello");
        driver.findElement(By.linkText("Submit")).click();

    }
    @When("give the corresponding valid data and click on submit button")
    public void give_the_corresponding_valid_data_and_click_on_submit_button() throws InterruptedException {
        driver.findElement(By.id("forename")).sendKeys("Jaswanth");
        driver.findElement(By.id("email")).sendKeys("jashwanth@gmail.com");
        driver.findElement(By.id("message")).sendKeys("Hello");
        driver.findElement(By.linkText("Submit")).click();
        Thread.sleep(5000);




    }
    @When("validate the successful submission message")
    public void validate_the_successful_submission_message() {
        String successmsg = driver.findElement(By.xpath("/html/body/div[2]/div/div")).getText();
        System.out.println(successmsg);

    }
    @When("click on Start Shopping button")
    public void click_on_start_shopping_button() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/p[2]/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

    }
    @When("click two times on Stuffed Frog,five times on Fluffy Bunny and three times on valentine Bear")
    public void click_two_times_on_stuffed_frog_five_times_on_fluffy_bunny_and_three_times_on_valentine_bear() {

        WebElement stuffedfrog= driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[2]/div/p/a"));
       stuffedfrog.click();
       stuffedfrog.click();
       String actprice_SF= driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[2]/div/p/span")).getText();
       WebElement fluffybunny=  driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[4]/div/p/a"));
       String actprice_FB=driver.findElement(By.xpath("//*[@id=\"product-4\"]/div/p/span")).getText();
        for(int i=0; i<5; i++)
        {
            fluffybunny.click();
       }
        WebElement valentinebear= driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[7]/div/p/a"));
        String  actprice_VB=driver.findElement(By.xpath("//*[@id=\"product-7\"]/div/p/span")).getText();
        valentinebear.click();
        valentinebear.click();
        valentinebear.click();
    }
    @When("Go to the cart page")
    public void go_to_the_cart_page() {
        driver.findElement(By.id("nav-cart")).click();
    }
    @Then("Verify that total is equal to the sum of subtotals")
    public void verify_that_total_is_equal_to_the_sum_of_subtotals() {
        String sprice_SF = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[1]/td[4]")).getText();
        String sprice_FB = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[2]/td[4]")).getText();
        String sprice_VB = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[3]/td[4]")).getText();

        String dou_sprice_SF = sprice_SF.replaceAll("[^0-9.]", "");
        double x = Double.valueOf(dou_sprice_SF);
        String dou_sprice_FB = sprice_FB.replaceAll("[^0-9.]", "");
        double y = Double.valueOf(dou_sprice_FB);
        String dou_sprice_VB = sprice_VB.replaceAll("[^0-9.]", "");
        double z = Double.valueOf(dou_sprice_VB);

        double Actual_stotal = x + y + z;
        String expec_stotal = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tfoot/tr[1]/td/strong")).getText();
        String dou_ex_total = expec_stotal.replaceAll("[^0-9.]", "");
        double subtotal=Double.valueOf(dou_ex_total);
        Assert.assertEquals(Actual_stotal,subtotal,0.001);
        System.out.println("subtotal is correct");


    }




}






