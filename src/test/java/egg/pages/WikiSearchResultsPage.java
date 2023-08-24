package egg.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiSearchResultsPage extends BasePage {
    
    //      Método constructor
    public WikiSearchResultsPage(WebDriver elDriver) {
        super(elDriver);
    }
    
    // TAG + ID
    @FindBy(css = "h1#firstHeading")
    private WebElement tituloDelResultado;

    // GETTERS  //
    public String getTextElTituloDelResultado() {
        this.esVisibleElElemento(tituloDelResultado);
        return this.tituloDelResultado.getText();
    }
}

