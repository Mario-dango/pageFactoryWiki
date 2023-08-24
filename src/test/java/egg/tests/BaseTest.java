package egg.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import egg.pages.WikiHomePage;
import egg.pages.WikiViajesPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    
    //      Atributos privado de clase test      //
    private static WebDriver miDriver = null;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup(); // Configurar el controlador de Chrome
    }

    @BeforeEach
    void lalala(){
        miDriver = new FirefoxDriver();
    }

    @AfterEach
    void lololo(){
        miDriver.close();
    }                           

    @AfterAll
    static void afterAllMethods(){
    }                           

    public WikiHomePage getHomePage(){
        return new WikiHomePage(miDriver, "https://www.wikipedia.org/");
    }                    

    public WikiHomePage getWikiViajesPage(){
        return new WikiHomePage(miDriver, "https://www.wikivoyage.org/");
    }

}
