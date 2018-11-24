import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void shouldReturnCorrectFizzBuzz() {
        // given
        FizzBuzz fizzbuzz = new FizzBuzz();
        // when
        String result = FizzBuzz.generateChain(50);
        // then
        assertEquals("1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, Fizz Buzz, 16, 17, Fizz, 19, Buzz, Fizz, 22, 23, Fizz, " +
                "Buzz, 26, Fizz, 28, 29, Fizz Buzz, 31, 32, Fizz, 34, Buzz, Fizz, 37, 38, Fizz, Buzz, 41, Fizz, 43, 44, Fizz Buzz, 46, 47, Fizz, 49, Buzz", result);
    }
}