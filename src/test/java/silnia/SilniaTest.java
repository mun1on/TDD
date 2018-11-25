package silnia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SilniaTest {

    @Test
    public void shouldReturn1when0(){
        //given
        Silnia silnia = new Silnia();
        //when
        int result = silnia.calculate(0);
        //then
        assertEquals(1, result);
    }

    @Test
    public void shouldReturnSilniaFor2And5And7(){
        //given
        Silnia silnia = new Silnia();
        //when
        int result = silnia.calculate(5);
        //then
        assertEquals(120,result);
    }
}