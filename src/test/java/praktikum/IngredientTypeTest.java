package praktikum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static model.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты на enum IngredientType")
public class IngredientTypeTest {

@ParameterizedTest
@MethodSource("dataProvider")
@DisplayName("Enum IngredientType содержит ожидаемые значения и длину")
void shouldHaveCorrectEnumValues(IngredientType type, String expected) {
    IngredientType[] values = IngredientType.values();

    assertAll(
            () -> assertEquals(2, values.length),
            () -> assertEquals(expected, type.name())
    );
}

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(SAUCE_TYPE, "SAUCE"),
                Arguments.of(FILLING_TYPE, "FILLING")
        );
    }
}
