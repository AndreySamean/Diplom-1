package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static model.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты на класс Ingredient")
public class IngredientTest {

    private Ingredient ingredient;

    @BeforeEach
    public void setUp(){
        ingredient = new Ingredient(SAUCE_TYPE, INGREDIENT_SAUCE_NAME, INGREDIENT_PRICE);
    }

    @Test
    @DisplayName("Имя ингредиента")
    public void getNameShouldReturnName(){
        String ingredientName = ingredient.getName();
        assertEquals(INGREDIENT_SAUCE_NAME, ingredientName);
    }

    @Test
    @DisplayName("Цена ингредиента")
    public void getPriceShouldReturnPrice(){
        float ingredientPrice = ingredient.getPrice();
        assertEquals(INGREDIENT_PRICE, ingredientPrice);
    }

    @Test
    @DisplayName("Тип ингредиента")
    public void getTypeShouldReturnType(){
        IngredientType ingredientType = ingredient.getType();
        assertEquals(SAUCE_TYPE, ingredientType);
    }
}
