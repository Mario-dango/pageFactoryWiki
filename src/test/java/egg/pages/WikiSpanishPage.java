package egg.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiSpanishPage extends BasePage{
    
    private List<String> listaDeCategoriasText = new ArrayList<String>();

    //      Método constructor
    public WikiSpanishPage(WebDriver elDriverParaUsar){
        super(elDriverParaUsar);
    }

    // TAG + CLASS_NAME + ATTRIBUTE
    @FindBy(css = "b> a[title^='Portal']")
    private List<WebElement> listaDeCategorias;
    
    // GETTERS  //
    public List<String> getListaDeTitulosDeLugares() {
        for (WebElement categoria : this.listaDeCategorias) {
            if(this.esVisibleElElemento(categoria)){
                listaDeCategoriasText.add(categoria.getText());
            }
        }
        return this.listaDeCategoriasText;
    }

    public WikiCategoryPage clickEnCategoria(String laCategoriaSeleccionada){
        for (WebElement categoria : this.listaDeCategorias) {
            if ((this.esVisibleElElemento(categoria))&&(this.estaHabilitadoElElemento(categoria))){
                if (categoria.getText().contains(laCategoriaSeleccionada)){
                    categoria.click();
                }
            }
        }
        return new WikiCategoryPage(myWebDriver);
    }
}
