package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import runner.RunCucumber;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class cadastro extends RunCucumber {

    @Dado("que estou na tela de cadastro de usuário")
    public void que_estou_na_tela_de_cadastro_de_usuário() {
        driver.get("https://automationpratice.com.br/register");

    }

    @Quando("preencho o campo nome {string} com um nome válido")
    public void preencho_o_campo_com_um_nome_válido(String nome) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tempo máximo de espera de 10 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));
        driver.findElement(By.id("user")).sendKeys(nome);


    }

    @E("preencho o campo {string} com um e-mail válido")
    public void preencho_o_campo_com_um_e_mail_válido(String email) {

        driver.findElement(By.id("email")).sendKeys(email);

    }

    @E("preencho o campo senha {string} com uma senha válida")
    public void preencho_o_campo_com_uma_senha_válida(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @E("clico no botão Cadastrar")
    public void clico_no_botão() {
        driver.findElement(By.id("btnRegister")).click();

    }


    @Então("sou redirecionado para a página inicial do sistema")
    public void sou_redirecionado_para_a_página_inicial_do_sistema() {
        String cadastroSucesso = driver.findElement(By.id("swal2-title")).getText();
        Assert.assertEquals(cadastroSucesso, "Cadastro realizado!");
        driver.findElement(By.cssSelector(".swal2-confirm")).click();

    }

    @Quando("clico no botão Cadastrar sem preencher os campos")
    public void clico_no_botão_sem_preencher_os_campos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tempo máximo de espera de 10 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnRegister")));
        driver.findElement(By.id("btnRegister")).click();

    }

    @Então("vejo mensagem de erro indicando que nome deve ser preenchido")
    public void vejo_mensagem_de_erro_indicando_que_o_nome_deve_ser_preenchido() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tempo máximo de espera de 10 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessageFirstName")));
        String erro = driver.findElement(By.id("errorMessageFirstName")).getText();
        Assert.assertEquals(erro, "O campo nome deve ser prenchido");


    }

    @Dado("preencho o campo email {string} com um formato inválido")
    public void preencho_o_campo_email_com_um_formato_inválido(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }
    @Quando("tento prosseguir com o cadastro")
    public void tento_prosseguir_com_o_cadastro() {
        driver.findElement(By.id("btnRegister")).click();
    }
    @Então("vejo uma mensagem de erro")
    public void vejo_uma_mensagem_de_erro_indicando_que() {
       driver.findElement(By.id("errorMessageFirstName")).getText();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tempo máximo de espera de 10 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.errorLabel#errorMessageFirstName")));
       String msgErro = driver.findElement(By.cssSelector("span.errorLabel#errorMessageFirstName")).getText();
       Assert.assertEquals(msgErro, "O campo e-mail deve ser prenchido corretamente");
    }

    @Dado("preencho o campo senha {string} com uma senha muito curta")
    public void preencho_o_campo_senha_com_uma_senha_muito_curta(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Então("vejo uma mensagem de erro indicando que o campo senha de ter pelo menos 6 dígitos")
    public void vejo_uma_mensagem_de_erro_indicando_o_campo_senha_deve_ter_pelo_menos_dígitos() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tempo máximo de espera de 10 segundos
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessageFirstName")));
     String msgErro = driver.findElement(By.id("errorMessageFirstName")).getText();
     assertThat(msgErro,containsString("O campo senha deve ter pelo menos 6 "));

    }


}