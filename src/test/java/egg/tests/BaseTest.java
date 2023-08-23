package egg.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import egg.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    
    //      Atributos privado de clase test      //
    private static WebDriver miDriver = null;
    // private static HomePage 
    private static String url;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup(); // Configurar el controlador de Chrome
        miDriver = new FirefoxDriver();
        url = "https://www.wikipedia.org/";
    }

    @BeforeEach
    void lalala(){
    }

    @AfterEach
    void lololo(){
        miDriver.quit();
    }                           

    public HomePage getHomePage(){
        return new HomePage(miDriver, url);
    }

}
