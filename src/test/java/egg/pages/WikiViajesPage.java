package egg.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiViajesPage extends BasePage{
    
    private static List<String> listaTitulosDestacados = new ArrayList<String>();

    //      Método constructor
    public WikiViajesPage(WebDriver elDriver) {
        super(elDriver);
    }
    
    // TAG + CLASS_NAME + ATTRIBUTE
    @FindBy(css = "h2.main-box-header")
    private List<WebElement> listaDeTitulosDeLugares;
    
    // GETTERS  //
    public List<String> getListaDeTitulosDeLugares() {
        for (WebElement tituloDestacado : this.listaDeTitulosDeLugares) {
            if(this.esVisibleElElemento(tituloDestacado)){
                listaTitulosDestacados.add(tituloDestacado.getText());
            }
        }
        return this.listaTitulosDestacados;
    }
    
}
