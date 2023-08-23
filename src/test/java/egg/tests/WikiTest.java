package egg.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import egg.pages.HomePage;

class WikiTest extends BaseTest {
    
    public SoftAssert mySoftAssert = new SoftAssert();

    @Test
    public void verificarTitulo() {
        HomePage paginaPrincipal = getHomePage();
        assertEquals(
            "Wikipedia\nThe Free Encyclopedia", 
            paginaPrincipal.getTextElTitulo()
            );
    }

}
