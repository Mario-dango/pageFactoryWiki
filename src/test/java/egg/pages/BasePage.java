package egg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    
    WebDriver myWebDriver;

    public BasePage(WebDriver elDriverParaUsar){
        this.myWebDriver = elDriverParaUsar;
        PageFactory.initElements(this.myWebDriver, this);
    }

        //      Mis Métodos de espera       //
    protected boolean esVisibleElElemento(WebElement elementoParaPreguntar){
        WebDriverWait myWait = new WebDriverWait(myWebDriver, 8);
        myWait.until(ExpectedConditions.visibilityOf(elementoParaPreguntar));
        return elementoParaPreguntar.isDisplayed();
    }
    
    protected boolean estaHabilitadoElElemento(WebElement elementoParaPreguntar){
        WebDriverWait myWait = new WebDriverWait(myWebDriver, 8);
        myWait.until(ExpectedConditions.visibilityOf(elementoParaPreguntar));
        return elementoParaPreguntar.isEnabled();
    }
}
