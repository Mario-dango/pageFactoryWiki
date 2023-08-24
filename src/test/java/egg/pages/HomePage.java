package egg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    
    //      Método constructor
    public HomePage(WebDriver elDriverParaUsar, String LaURL){
        super(elDriverParaUsar);
        this.myWebDriver.get(LaURL);
    }

    // TAG + CLASS_NAME
    @FindBy(css = "h1.central-textlogo-wrapper")
    private WebElement elTitulo;
    // TAG + CLASS_NAME
    @FindBy(css = "input#searchInput")
    private WebElement laBarraDeBusqueda;
    // TAG + CLASS_NAME + ATTRIBUTE
    @FindBy(css = "button.pure-button-primary-progressive[type='submit']")
    private WebElement elBotonReGrozoDeWiki;
    // TAG + ID
    @FindBy(css = "h1#firstHeading")
    private WebElement elTituloDelResultado;

    // GETTERS  //
    public WebElement getLaBarraDeBusqueda() {
        return this.laBarraDeBusqueda;
    }
    
    public String getTextElTitulo() {
        return this.elTitulo.getText();
    }

    public WebElement getElBotonReGrozoDeWiki() {
        return this.elBotonReGrozoDeWiki;
    }
    public String getTextElTituloDelResultado() {
        return this.elTituloDelResultado.getText();
    }

}
