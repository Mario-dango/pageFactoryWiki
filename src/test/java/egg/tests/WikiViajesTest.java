package egg.tests;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import egg.pages.WikiHomePage;
import egg.pages.WikiViajesPage;

public class WikiViajesTest extends BaseTest {
    
    public SoftAssert mySoftAssert = new SoftAssert();

    //  Prueba con el botón de buscar
    @Test
    public void lugaresDestacadosLosAndes() {
        // WikiHomePage paginaPrincipal = getWikiViajesPage();
        // WikiViajesPage wikiViajesEspanio = paginaPrincipal.clickEnEspaniol();
        // List<String> tituloDeLugares = WikiViajesPage.getListaDeTitulosDeLugares();
        // for (String tituloDestacado : tituloDeLugares) {
        //     if(tituloDestacado.contains("Los Andes")){
        //         mySoftAssert.assertTrue(true);
        //     }
        // }
    }
    
    @Test
    public void verificarTitulo() {
        WikiHomePage paginaPrincipal = getWikiViajesPage();
        mySoftAssert.assertEquals(
            "Wikivoyage\r\n" + //
            "La gu\u00EDa de viajes libre", 
            paginaPrincipal.getTextElTitulo()
            );
    }
}
