package egg.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiViajesPage extends BasePage{
    
    //      Método constructor
    public WikiViajesPage(WebDriver elDriver, String wikiVisitaURL) {
        super(elDriver);
        this.myWebDriver.get(wikiVisitaURL);
    }
    
    // TAG + CLASS_NAME + ATTRIBUTE
    @FindBy(css = "h2.main-box-header")
    private List<WebElement> listaDeTitulosDeLugares;
    // TAG + CLASS_NAME
    @FindBy(css = "h1.central-textlogo-wrapper")
    private WebElement elTitulo;
    // ID
    @FindBy(id = "js-link-box-es")
    private WebElement elLinkAHomePageEspaniol;
    
    
    // GETTERS  //
    public List<WebElement> getListaDeTitulosDeLugares() {
        return this.listaDeTitulosDeLugares;
    }
    
    public String getTextElTitulo() {
        this.esVisibleElElemento(this.elTitulo);
        return this.elTitulo.getText();
    }

    public WebElement getElLinkAHomePageEspaniol(){
       return this.elLinkAHomePageEspaniol;
    }


}
