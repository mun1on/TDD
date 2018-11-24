import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FizzBuzz {


    public static String generateSingleSeq(int number) {
        if (number == 0)
            return null;
        if (number %3 == 0 && number %5 == 0)
            return "Fizz Buzz";
        else if (number %3 == 0)
            return "Fizz";
        else if (number %5 == 0)
            return "Buzz";
        else
            return number+"";
    }

    public static String generateChain(int number){
        return IntStream.rangeClosed(1, number)
                .mapToObj(FizzBuzz::generateSingleSeq)
                .collect(Collectors.joining(", ")
                );
    }
}
