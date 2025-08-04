package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static model.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Тесты на класс Burger")
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient ingredientSauceMock;

    @Mock
    private Ingredient ingredientFillingMock;

    @BeforeEach
    public void setUp(){
        burger = new Burger();
        burger.ingredients = new ArrayList<>(Arrays.asList(ingredientSauceMock, ingredientFillingMock));
        burger.bun = bunMock;
    }

    @Test
    @DisplayName("Тест метода setBuns")
    public void setBunsShouldSetBun(){
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    @DisplayName("Тест метода addIngredient")
    public void addIngredientShouldIncreaseArrayListSize(){
        int expectedSize = burger.ingredients.size() + 1;
        burger.addIngredient(ingredientSauceMock);
        int actualSize = burger.ingredients.size();
        assertAll(
                () -> assertEquals(expectedSize, actualSize),
                () -> assertEquals(ingredientSauceMock, burger.ingredients.get(actualSize - 1))
        );
    }

    @Test
    @DisplayName("Тест метода removeIngredient")
    public void removeIngredientShouldDecreaseArrayListSize(){
        int expectedSize = burger.ingredients.size() - 1;
        burger.removeIngredient(0);
        int actualSize = burger.ingredients.size();
        assertAll(
                () -> assertEquals(expectedSize, actualSize),
                () -> assertEquals(ingredientFillingMock, burger.ingredients.get(0))
        );
    }

    @Test
    @DisplayName("Тест метода moveIngredient")
    public void moveIngredientShouldMoveIngredientToSpecifiedIndex(){
        burger.moveIngredient(1,0);
        assertAll(
                () -> assertEquals(ingredientFillingMock, burger.ingredients.get(0)),
                () -> assertEquals(ingredientSauceMock, burger.ingredients.get(1))
        );
    }

    @Test
    @DisplayName("Тест метода getPrice")
    public void getPriceReturnSumOfPrices(){
        Mockito.when(bunMock.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredientSauceMock.getPrice()).thenReturn(INGREDIENT_PRICE);
        Mockito.when(ingredientFillingMock.getPrice()).thenReturn(INGREDIENT_PRICE);

        float expectedPrice = BUN_PRICE * 2 + INGREDIENT_PRICE + INGREDIENT_PRICE;
        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    @DisplayName("Тест метода getReceipt")
    public void getReceiptShouldReturnReceipt(){
        Mockito.when(bunMock.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredientSauceMock.getPrice()).thenReturn(INGREDIENT_PRICE);
        Mockito.when(ingredientFillingMock.getPrice()).thenReturn(INGREDIENT_PRICE);
        Mockito.when(bunMock.getName()).thenReturn(BUN_NAME);
        Mockito.when(ingredientSauceMock.getName()).thenReturn(INGREDIENT_SAUCE_NAME);
        Mockito.when(ingredientFillingMock.getName()).thenReturn(INGREDIENT_FILLING_NAME);
        Mockito.when(ingredientSauceMock.getType()).thenReturn(SAUCE_TYPE);
        Mockito.when(ingredientFillingMock.getType()).thenReturn(FILLING_TYPE);

        String receipt = burger.getReceipt();
        assertAll(
                () -> assertTrue(receipt.contains(BUN_NAME)),
                () -> assertTrue(receipt.contains(INGREDIENT_SAUCE_NAME)),
                () -> assertTrue(receipt.contains(INGREDIENT_FILLING_NAME)),
                () -> assertTrue(receipt.contains(SAUCE_TYPE.name().toLowerCase())),
                () -> assertTrue(receipt.contains(FILLING_TYPE.name().toLowerCase())),
                () -> assertTrue(receipt.contains("Price:"))
                );
    }
}
