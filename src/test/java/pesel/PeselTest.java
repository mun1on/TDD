package pesel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PeselTest {

    @Test
    public void shouldReturnPesel93051503219(){
        // given
        Pesel pesel = new Pesel("93051503219");
        // when
        String result = pesel.getPesel();
        // then
        assertEquals("93051503219", result);
    }

    @Test
    public void shouldReturnManByPesel93051503219(){
        // given
        Pesel pesel = new Pesel("93051503219");
        // when
        String result = pesel.getGenderByPesel();
        // then
        assertEquals("Man", result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"89842883219"})
    public void shouldReturn15051993ByPesel93051503219(String param){
        // given
        Pesel pesel = new Pesel(param);
        // when
        String result = pesel.getDateOfBirth();
        // then
        assertEquals("28.04.1889", result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"93051503219", "01210101011"})
    public void shouldReturnTrueIfValidPesel(String param){
        // given
        Pesel pesel = new Pesel(param);
        // when
        boolean isValid = pesel.isValidPesel(param);
        // then
        assertTrue(isValid);
    }

}