package id.ac.ui.cs.advprog.eshop.functional;

import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import io.github.bonigarcia.seljup.SeleniumJupiter;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {

    @LocalServerPort
    private int port;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d%s", testBaseUrl, port, "/product/create");
    }

    @Test
    void pageTitle_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        String pageTitle = driver.getTitle();

        assertEquals("Create New Product", pageTitle);
    }

    @Test
    void createProductPage_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        String createProductPage = driver.findElement(By.tagName("h3")).getText();

        assertEquals("Create New Product", createProductPage);
    }
    
    @Test
    void createProductForm(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("nameInput")).sendKeys("Product 1");
        driver.findElement(By.id("quantityInput")).sendKeys("100");
        driver.findElement(By.tagName("button")).click();

        String productListPage = driver.findElement(By.tagName("h2")).getText();
        assertEquals("Product List", productListPage);

        assertTrue(driver.findElement(By.tagName("table")).getText().contains("Product 1"));
        assertTrue(driver.findElement(By.tagName("table")).getText().contains("100"));
    }
    
}
