package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class Login extends RunCucumber {

    @Dado("que estou na tela de login")
    public void que_estou_na_tela_de_login() {
       driver.get("https://automationpratice.com.br/login#!");
    }
    @Quando("preencho o campo de email com {string} com um e-mail válido")
    public void preencho_o_campo_de_email_com_com_um_e_mail_válido(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tempo máximo de espera de 10 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).sendKeys(email);

    }
    @E("preencho o campo de senha com {string} com uma senha válida")
    public void preencho_o_campo_de_senha_com_com_uma_senha_válida(String password) {
        driver.findElement(By.id("password")).sendKeys(password);

    }
    @E("clico no botão Login")
    public void clico_no_botão_login() {
        driver.findElement(By.id("btnLogin")).click();

    }
    @Então("a messagem Login Realizado aparece")
    public void a_messagem_login_realizado_aparece() {
        String login = driver.findElement(By.id("swal2-title")).getText();
        assertThat(login,is(equalTo("Login realizado")));


    }

    @Quando("não preencho os campos obrigatórios")
    public void não_preencho_os_campos_obrigatórios() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tempo máximo de espera de 10 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("password")).click();

    }

    @Então("vejo uma mensagem de erro email inválido e senha inválida")
    public void vejo_uma_mensagem_de_erro_email_inválido_e_senha_inválida() {
    driver.findElement(By.id("btnLogin")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tempo máximo de espera de 10 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='invalid_input' and normalize-space()='E-mail inválido.']")));

        String msgErroEmail = driver.findElement(By.xpath("//span[@class='invalid_input' and normalize-space()='E-mail inválido.']")).getText();

        assertThat(msgErroEmail, is(equalTo("E-mail inválido.")));
    }

    @Quando("clico no link Ainda não tem conta")
    public void clico_no_link_inda_não_tem_conta() {
    driver.findElement(By.linkText("Ainda não tem conta?")).click();

    }

    @Então("sou redirecionado para a página de cadastro")
    public void sou_redirecionado_para_a_página_de_cadastro() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Cadastro de usuário']")));
    String validacaoTexto = driver.findElement(By.xpath("//h3[text()='Cadastro de usuário']")).getText();
    assertThat(validacaoTexto, is(equalTo("Cadastro de usuário")));

    }

}
