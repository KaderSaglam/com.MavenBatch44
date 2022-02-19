package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class LocatorsIntro {
    public static void main(String[] args) {
        //1. Bir class oluşturun: LocatorsIntro
     //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        // b. Sign in butonuna basin
        driver.findElement(By.xpath("//a[@id='sign-in']")).click();
       // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailTextbox=driver.findElement(By.xpath("//input[@id='session_email']"));
        WebElement passwordTextbox=driver.findElement(By.xpath("//input[@id='session_password']"));
        WebElement signinButton=driver.findElement(By.xpath("//input[@value='Sign in']"));
           // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
            // i. Username : testtechproed@gmail.com
           // ii.Password : Test1234!
        emailTextbox.sendKeys("testtechproed@gmail.com");
        emailTextbox.click();
        passwordTextbox.sendKeys("Test1234!");
        passwordTextbox.click();
        signinButton.click();
   // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
       WebElement userId=driver.findElement(By.xpath("//h1[text()='Welcome to Address Book']"));
        System.out.println(userId.getText());
        if (userId.isDisplayed()) {
            System.out.println("Id Girisi PASS");
        } else System.out.println("Id Girisi FAILED");
        // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement addresses=driver.findElement(By.xpath("//a[text()='Addresses']"));
        if (addresses.isDisplayed()) {
            System.out.println("Adress girisi PASS");

        }else System.out.println("Adress girisi FAİLED");
        WebElement signOut=driver.findElement(By.xpath("//a[text()='Sign out']"));
        if (signOut.isDisplayed()) {
            System.out.println("SignOut girisi PASS");

        }else System.out.println("SignOut girisi FAİLED");
      //3. Sayfada kac tane link oldugunu bulun.
       List<WebElement> link=driver.findElements(By.tagName("a"));

          //4.Linklerin yazisini nasil yazdirabiliriz
        System.out.println("linklerin sayisi = "+ link.size());
        //5. driver i kapatin
        driver.close();
    }
}
