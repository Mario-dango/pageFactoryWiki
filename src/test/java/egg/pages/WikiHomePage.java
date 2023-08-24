package egg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiHomePage extends BasePage{

    
    //      Método constructor
    public WikiHomePage(WebDriver elDriverParaUsar, String LaURL){
        super(elDriverParaUsar);
        this.myWebDriver.get(LaURL);
    }

    //////////////////////!     WIKIPEDIA HOME PAGE ///////////////////////!
    // TAG + CLASS_NAME
    @FindBy(css = "h1.central-textlogo-wrapper")
    private WebElement elTitulo;
    // TAG + CLASS_NAME
    @FindBy(css = "input#searchInput")
    private WebElement laBarraDeBusqueda;
    // TAG + CLASS_NAME + ATTRIBUTE
    @FindBy(css = "button.pure-button-primary-progressive[type='submit']")
    private WebElement elBotonDeBuscar;

    // GETTERS or Interactions between objects  //
    public void sendToLaBarraDeBusqueda(String textoParaEnviar) {
        this.esVisibleElElemento(this.laBarraDeBusqueda);
        if (textoParaEnviar.contains("\n")){
            
        }
        this.laBarraDeBusqueda.sendKeys(textoParaEnviar);
    }

    public WikiSearchResultsPage sendToLaBarraDeBusquedaYEnter(String textoParaEnviar) {
        this.esVisibleElElemento(this.laBarraDeBusqueda);
        if (textoParaEnviar.contains("\n")){
            this.laBarraDeBusqueda.sendKeys(textoParaEnviar);            
        } else {
            this.laBarraDeBusqueda.sendKeys(textoParaEnviar + "\n"); 
        }
        return new WikiSearchResultsPage(myWebDriver);
    }
    
    public String getTextElTitulo() {
        this.esVisibleElElemento(this.elTitulo);
        return this.elTitulo.getText();
    }

    public WikiSearchResultsPage clickEnBuscar() {
        this.elBotonDeBuscar.click();
        return new WikiSearchResultsPage(myWebDriver);
    }
    
    //////////////////////!     WIKIVOYAGE HOME PAGE ///////////////////////!
    //      LOCATORS USING PAGEFACTORY      //
    // ID
    @FindBy(id = "js-link-box-es")
    private WebElement elLinkAHomePageEspaniol;
    
    //      METHODS AND INTERACTIONS BETWEEN OBJECTS        //
    public WikiViajesPage clickEnEspaniol(){
        this.esVisibleElElemento(elBotonDeBuscar);
        this.estaHabilitadoElElemento(elBotonDeBuscar);
        this.elLinkAHomePageEspaniol.click();
        return new WikiViajesPage(myWebDriver);
     }

}
