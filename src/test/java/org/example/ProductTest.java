package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ProductTest {

    AndroidDriver driver;
    HomePage homePage;
    CartPage carrinhoPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;

    @Before
    public void before() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformVersion("13.0");
        options.setAutomationName("UIAutomator2");
        options.setDeviceName("emulator-5554");
        options.setAppPackage("com.saucelabs.mydemoapp.rn");
        options.setAppActivity(".MainActivity");
        options.setApp("D:\\workflow\\mydemoapp-mobile-test\\mydemoapp-mobile-test\\src\\test\\resources\\Android-MyDemoAppRN.1.3.0.build-244.apk");
        options.setNoReset(false);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new HomePage(driver);
        carrinhoPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        checkoutPage = new CheckoutPage(driver);

    }

    @Test
    public void testeComprarProdutoAplicativo() {
        homePage.clicarPorXpath(homePage.produto);
        homePage.clicarPorAccId(homePage.idAddCarrinho);
        homePage.clicarPorXpath(homePage.btnCarrinho);
        carrinhoPage.alterarAquantidadeParaTres();
        carrinhoPage.clicarPorAccId(carrinhoPage.idAddIrParaCheckout);
        loginPage.preencherCampoTextoPorAccId(loginPage.inputIdUsername, "bob@example.com");
        loginPage.preencherCampoTextoPorAccId(loginPage.inputIdPassword, "10203040");
        loginPage.clicarPorAccId(loginPage.btnIdLogin);
        checkoutPage.preencherCampoTextoPorAccId(checkoutPage.inputIdNome, "Rebecca Winter");
        checkoutPage.preencherCampoTextoPorAccId(checkoutPage.inputIdEndereco, "Av Paulista, 509");
        checkoutPage.preencherCampoTextoPorAccId(checkoutPage.inputIdCidade, "Sao Paulo");
        checkoutPage.preencherCampoTextoPorAccId(checkoutPage.inputIdCodigoPostal, "89750");
        checkoutPage.preencherCampoTextoPorAccId(checkoutPage.inputIdPais, "United Kingdom");
        checkoutPage.clicarPorAccId(checkoutPage.btnIdIrParaPagamento);
        checkoutPage.preencherCampoTextoPorAccId(checkoutPage.inputIdNomeNoCartao, "Rebecca Winter");
        checkoutPage.preencherCampoTextoPorAccId(checkoutPage.inputIdNumeroCartao, "5445 6899 2339 7519");
        checkoutPage.preencherCampoTextoPorAccId(checkoutPage.inputIdDataVencimento, "07/25");
        checkoutPage.preencherCampoTextoPorAccId(checkoutPage.inputIdCodigoDeSeguranca, "689");
        checkoutPage.clicarPorAccId(checkoutPage.btnIdRevisarPedido);
        checkoutPage.validarQuantidadeProduto(checkoutPage.IdQuantideTotal, "3 items");
        checkoutPage.validarNomeProduto(checkoutPage.IdResumoNomeProduto, "Sauce Labs Backpack");
        checkoutPage.clicarPorAccId(checkoutPage.btnIdConfirmarPedido);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
