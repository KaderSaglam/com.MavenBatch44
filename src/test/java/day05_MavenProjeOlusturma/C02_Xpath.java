package day05_MavenProjeOlusturma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.navigate().to("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//i[@class='icon-signin']")).click();
        //3. Login alanine  “username” yazdirin
        WebElement userLogin=driver.findElement(By.xpath("//input[@id='user_login']"));
        userLogin.sendKeys("username");
        //4. Password alanine “password” yazdirin
        WebElement passwordLogin=driver.findElement(By.id("user_password"));
        passwordLogin.sendKeys("password");
        //5. Sign in buttonuna tiklayin
        WebElement signInButonu=driver.findElement(By.xpath("//input[@value='Sign in']"));
        signInButonu.click();
        WebElement gelismis=driver.findElement(By.xpath("//button[@id='details-button']"));
        gelismis.click();
        WebElement siteGiris=driver.findElement(By.xpath("(//a[@href='#'])[4]"));
        siteGiris.click();
        //6. Pay Bills sayfasina gidin
        WebElement payBills=driver.findElement(By.xpath("//a[text()='Pay Bills']"));
        payBills.click();
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount=driver.findElement(By.id("sp_amount"));
        amount.sendKeys("10000");
        //8. tarih kismina “2020-09-10” yazdirin
        WebElement sp_Date=driver.findElement(By.id("sp_date"));
        sp_Date.sendKeys("2020-09-10");
        Thread.sleep(3000);
        //9. Pay buttonuna tiklayin
        WebElement payButton=driver.findElement(By.id("pay_saved_payees"));
        payButton.click();
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement sonCikanYazi=driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
        System.out.println(sonCikanYazi.getText());
        if (sonCikanYazi.isDisplayed()) {
            System.out.println("Para Yatirma Islemi PASS");
        } else {
            System.out.println("Para Yatirma Islemi FAILED");
        }
        driver.close();
    }
}
