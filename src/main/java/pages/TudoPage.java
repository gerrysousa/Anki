package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TudoPage extends BasePage {
    @FindBy(id = "f0")
    private WebElement txtFront;

    @FindBy(id = "f1")
    private WebElement txtBack;

    @FindBy(id = "f-1")
    private WebElement txtTag;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement btnSalvar;

    @FindBy(xpath = "//a[text()='Add']")
    private WebElement btnAdd;


    public void escreverFrontCard(String front) {
        escrever(txtFront, front);
    }

    public void escreverBackCard(String back) {
        escrever(txtBack, back);
    }

    public void escreverTagCard(String tag) {
        escrever(txtTag, tag);
    }

    public void clicarBotaoSalvar() {
        clicar(btnSalvar);
    }

    public void clicarBotaoAdd() {
        clicar(btnAdd);
    }
}
