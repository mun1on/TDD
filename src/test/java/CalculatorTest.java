import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void shouldReturn15WhenAdd5And10(){
        // given
        Calculator calculator = new Calculator();
        // when
        String result = Calculator.add("5", "10");
        // then
        assertEquals("15",result);
    }

    @Test
    public void shouldThrowExceptionForInvalidNumber(){
        // given
        Calculator calculator = new Calculator();
        // when
        assertThrows(NumberFormatException.class,
                () -> calculator.add("12test", "13"));
        // then

    }
}