package egg.pages;

import java.util.ArrayList;
import java.util.List;

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
    // TAG + CLASS_NAME
    @FindBy(css = "a.suggestion-link")
    private List<WebElement> listaDeResultados;


    // GETTERS or Interactions between objects  //
    public void sendToLaBarraDeBusqueda(String textoParaEnviar) {
        this.esVisibleElElemento(this.laBarraDeBusqueda);
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
        this.esVisibleElElemento(elBotonDeBuscar);
        this.estaHabilitadoElElemento(elBotonDeBuscar);
        this.elBotonDeBuscar.click();
        return new WikiSearchResultsPage(myWebDriver);
    }
    

    public List<String> getListaDeResultados() {
        List<String> listaDeResultadosText = new ArrayList<String>();
        for (WebElement resultadoVisible : this.listaDeResultados) {
            if(this.esVisibleElElemento(resultadoVisible)){
                listaDeResultadosText.add(resultadoVisible.getText());
            }
        }
        return listaDeResultadosText;
    }

    //////////////////////!     WIKIVOYAGE HOME PAGE ///////////////////////!
    //      LOCATORS USING PAGEFACTORY      //
    // ID
    @FindBy(id = "js-link-box-es")
    private WebElement elLinkAHomePageEspaniol;
    
    //      METHODS AND INTERACTIONS BETWEEN OBJECTS        //
    public WikiSpanishPage clickEnEspaniol(){
        this.esVisibleElElemento(elBotonDeBuscar);
        this.estaHabilitadoElElemento(elBotonDeBuscar);
        this.elLinkAHomePageEspaniol.click();
        return new WikiSpanishPage(myWebDriver);
     }

}
