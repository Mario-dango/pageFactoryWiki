package egg.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import egg.pages.HomePage;

public class WikipediaSearchTest extends BaseTest { 
    
    public SoftAssert mySoftAssert = new SoftAssert();

    //  Prueba con el botón de buscar
    @Test
    public void searchTest01() {
        HomePage paginaPrincipal = getHomePage();
        paginaPrincipal.getLaBarraDeBusqueda().sendKeys("saraza");
        paginaPrincipal.getElBotonReGrozoDeWiki().click();
        String resultado = paginaPrincipal.getTextElTituloDelResultado();
        mySoftAssert.assertEquals("Saraza", resultado, "Lo buscado no ciuncide con el título");
    }
}
