package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTestingApplicationTests {

    private static WebDriver driver;

    private ChatPageObject chatPageObject;

    private LoginPageObject loginPageObject;

    private SignupPageObject signupPageObject;

    @LocalServerPort
    public int port;

    public String baseURL;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @BeforeEach
    public void beforeEach() {
        baseURL = "http://localhost:" + port;
    }

    @Test
    public void testSignupLoginSubmit() {

        String firstName = "milena";
        String lastName = "manko";
        String username = "milenia";
        String password = "abc123";
        String messageText = "HEheHE";

        driver.get(baseURL + "/signup");

        signupPageObject = new SignupPageObject(driver);

        signupPageObject.addData(firstName, lastName, username, password);
        signupPageObject.submitSignup();

        driver.get(baseURL + "/login");

        loginPageObject = new LoginPageObject(driver);

        loginPageObject.addData(username, password);
        loginPageObject.submitLogin();

        driver.get(baseURL + "/chat");

        chatPageObject = new ChatPageObject(driver);

        chatPageObject.addMessage(messageText);
        chatPageObject.submitMessage();

        ChatMessage sentMessage = chatPageObject.getDisplayedMessage();

        Assertions.assertEquals(username, sentMessage.getUsername());
        Assertions.assertEquals(messageText, sentMessage.getMessage());

    }

//    @Test
//    public void testLogin() {
//
//        driver.get(baseURL + "/login");
//
//        loginPageObject = new LoginPageObject(driver);
//
//        loginPageObject.addData("milkaczka", "abcde");
//        loginPageObject.submitLogin();
//    }
//
//    @Test
//    public void testChatMessage() {
//        chatPageObject.addMessage("hehehehe");
//        chatPageObject.submitMessage();
//    }


}
