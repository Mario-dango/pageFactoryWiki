package egg.tests;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import egg.pages.WikiCategoryPage;
import egg.pages.WikiHomePage;
import egg.pages.WikiSearchResultsPage;
import egg.pages.WikiSpanishPage;

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
        mySoftAssert.assertEquals("Saraza", resultado, "Lo buscado no ciuncide con el título.");
    }
    
    //  Prueba con el botón de buscar
    @Test
    @Tag("Enter")   // se agrega tag para ser corrido solamente este método y no todos los Test
    // invocación:mvn test -Dgroups=SmokeTest
    public void searchTest02() {
        WikiHomePage paginaPrincipal = getHomePage();
        WikiSearchResultsPage paginaResultadoDeBusqueda = paginaPrincipal.sendToLaBarraDeBusquedaYEnter("ecuaciones de maxwell\n\r");
        String resultado = paginaResultadoDeBusqueda.getTextElTituloDelResultado();
        mySoftAssert.assertEquals("ecuaciones de maxwell", resultado, "Lo buscado no ciuncide con el título.");
    }
    
    //  Prueba con el botón de buscar
    @Test
    @Tag("Lista")   // se agrega tag para ser corrido solamente este método y no todos los Test
    // invocación:mvn test -Dgroups=SmokeTest
    public void searchTest03() {
        WikiHomePage paginaPrincipal = getHomePage();
        paginaPrincipal.sendToLaBarraDeBusqueda("ecuaciones");
        List<String> listaString = paginaPrincipal.getListaDeResultados();
        for (String resultado : listaString) {
            if (resultado.contains("ecuaciones de maxwell")){
                mySoftAssert.assertTrue(true);
            }
        }
    }

    //  Prueba con el botón de buscar
    @Test
    @Tag("Categorias")   // se agrega tag para ser corrido solamente este método y no todos los Test
    // invocación:mvn test -Dgroups=SmokeTest
    public void searchTest04() {
        WikiHomePage paginaPrincipal = getHomePage();
        WikiSpanishPage paginaEnEspaniol = paginaPrincipal.clickEnEspaniol();
        WikiCategoryPage paginaDeCategoria = paginaEnEspaniol.clickEnCategoria("Tecnologías");
        mySoftAssert.assertEquals("Portal Tecnología", paginaDeCategoria.getTextTituloDeCategoria(),"no coincide el titulo.");
    }
}
