package egg.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiCategoryPage extends BasePage{
    
    private List<String> listaDeCategoriasText = new ArrayList<String>();

    //      Método constructor
    public WikiCategoryPage(WebDriver elDriverParaUsar){
        super(elDriverParaUsar);
    }

    // TAG + CLASS_NAME + ATTRIBUTE
    @FindBy(css = "span[style='white-space:nowrap']")
    private WebElement tituloDeCategoria;
    
    // GETTERS  //
    public String getTextTituloDeCategoria() {
        this.esVisibleElElemento(this.tituloDeCategoria);
        return this.tituloDeCategoria.getText();
    }
}