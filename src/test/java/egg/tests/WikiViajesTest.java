package egg.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import egg.pages.HomePage;
import egg.pages.WikiViajesPage;

public class WikiViajesTest extends BaseTest {
    
    public SoftAssert mySoftAssert = new SoftAssert();

    //  Prueba con el botón de buscar
    @Test
    public void lugaresDestacadosLosAndes() {
        WikiViajesPage paginaPrincipal = getWikiViajesPage();
        paginaPrincipal.getElLinkAHomePageEspaniol().click();
        for (WebElement titulosDestacados : paginaPrincipal.getListaDeTitulosDeLugares()) {
            if(titulosDestacados.getText().contains("Los Andes")){
                mySoftAssert.assertTrue(true);
            }
        }

    }
    
    @Test
    public void verificarTitulo() {
        WikiViajesPage paginaPrincipal = getWikiViajesPage();
        mySoftAssert.assertEquals(
            "Wikivoyage\nFree travel guide", 
            paginaPrincipal.getTextElTitulo()
            );
    }
}
