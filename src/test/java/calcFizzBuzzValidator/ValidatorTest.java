package calcFizzBuzzValidator;

import calcFizzBuzzValidator.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void shouldReturnTrueWhen18(){
        // given
        Validator validator = new Validator();
        // when
        boolean isAdult = validator.isAdult(19);
        // then
        assertTrue(isAdult);
    }

}