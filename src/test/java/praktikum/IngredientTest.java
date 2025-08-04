package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

    @ParameterizedTest(name = "{0}")
    @MethodSource("objProvider")
    @DisplayName("Тип ингредиента")
    public void getTypeShouldReturnType(String description,  IngredientType type, String name, float price){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType ingredientType = ingredient.getType();
        assertEquals(type, ingredientType);
    }

    static Stream<Arguments> objProvider(){
        return Stream.of(
                Arguments.of("Соус", SAUCE_TYPE, INGREDIENT_SAUCE_NAME, INGREDIENT_PRICE),
                Arguments.of("Начинка", FILLING_TYPE, INGREDIENT_FILLING_NAME, INGREDIENT_PRICE)
        );
    }
}
