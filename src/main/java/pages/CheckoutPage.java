package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;

public class CheckoutPage extends BasePage {
    AndroidDriver driver;

    public String inputIdNome = "Full Name* input field";
    public String inputIdEndereco = "Address Line 1* input field";

    public String inputIdCidade = "City* input field";
    public String inputIdCodigoPostal = "Zip Code* input field";

    public String inputIdPais = "Country* input field";

    public String btnIdIrParaPagamento = "To Payment button";
    public String inputIdNomeNoCartao = "Full Name* input field";
    public String inputIdNumeroCartao = "Card Number* input field";
    public String inputIdDataVencimento = "Expiration Date* input field";
    public String inputIdCodigoDeSeguranca = "Security Code* input field";
    public String btnIdRevisarPedido = "Review Order button";
    public String IdQuantideTotal = "total number";
    public String IdResumoNomeProduto = "product label";

    public String btnIdConfirmarPedido = "Place Order button";


    public CheckoutPage(AndroidDriver driverScenario) {
        super(driverScenario);
        this.driver = driverScenario;
    }

    public void validarNomeProduto(String elemento, String valorEsperado) {
        String valorAtual = driver.findElement(AppiumBy.accessibilityId(elemento)).getText();
        Assert.assertEquals(valorEsperado, valorAtual);
    }

    public void validarQuantidadeProduto(String elemento, String valorEsperado) {
        String valorAtual = driver.findElement(AppiumBy.accessibilityId(elemento)).getText();
        Assert.assertEquals(valorEsperado, valorAtual);
    }
}

