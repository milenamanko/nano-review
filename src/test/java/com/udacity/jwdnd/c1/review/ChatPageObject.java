package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPageObject {

    @FindBy(id = "messageText")
    private WebElement messageText;

    @FindBy(id = "submitMsgButton")
    private WebElement submitMsgButton;

    @FindBy(className = "messageUsername")
    private WebElement firstMessageUsername;

    @FindBy(className = "messageSent")
    private WebElement firstMessageText;

    public ChatPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public ChatMessage getDisplayedMessage() {

        ChatMessage msg = new ChatMessage();
        msg.setMessage(firstMessageText.getText());
        msg.setUsername(firstMessageUsername.getText());

        return msg;
    }

    public void addMessage(String msgText) {

        messageText.sendKeys(msgText);
    }

    public void submitMessage() {
        submitMsgButton.click();
    }
}
