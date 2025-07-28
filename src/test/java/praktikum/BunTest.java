package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static model.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты на класс Bun")
public class BunTest {

    private Bun bun;

    @BeforeEach
    public void setUp(){
        bun = new Bun(BUN_NAME, BUN_PRICE);
    }

    @Test
    @DisplayName("Имя булки")
    public void getNameShouldReturnName(){
        String bunName = bun.getName();
        assertEquals(BUN_NAME, bunName);
    }

    @Test
    @DisplayName("Цена булки")
    public void getPriceShouldReturnPrice(){
        float bunPrice = bun.getPrice();
        assertEquals(BUN_PRICE, bunPrice, 0);
    }
}
