package egg.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import egg.pages.WikiHomePage;
import egg.pages.WikiSearchResultsPage;

public class WikipediaSearchTest extends BaseTest { 
    
    public SoftAssert mySoftAssert = new SoftAssert();

    //  Prueba con el botón de buscar
    @Test
    @Tag("SmokeTest")   // se agrega tag para ser corrido solamente este método y no todos los Test
    // invocación:mvn test -Dgroups=SmokeTest
    public void searchTest01() {
        WikiHomePage paginaPrincipal = getHomePage();
        paginaPrincipal.sendToLaBarraDeBusqueda("saraza");
        WikiSearchResultsPage paginaResultadoDeBusqueda = paginaPrincipal.clickEnBuscar();
        String resultado = paginaResultadoDeBusqueda.getTextElTituloDelResultado();
        mySoftAssert.assertEquals("Saraza", resultado, "Lo buscado no ciuncide con el título");
    }
    
}
