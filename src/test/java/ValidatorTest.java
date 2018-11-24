import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    public void shouldReturnTrueWhen18(){
        // given
        Validator validator = new Validator();
        // when
        boolean isAdult = validator.isAdult(18);
        // then
        assertEquals(true, isAdult);
    }

}