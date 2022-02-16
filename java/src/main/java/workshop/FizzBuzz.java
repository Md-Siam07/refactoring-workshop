package workshop;

import java.util.List;

/**
 * Requirements:
 * For factor of three print Fizz instead of the number
 * For factor of five print Buzz instead of the number
 * For numbers which are factors of both three and five print FizzBuzz instead of the number
 */
public class FizzBuzz {

    List<FizzBuzzPatternMatcher> patternMatchers;
    public FizzBuzz(List<FizzBuzzPatternMatcher> patternMatchers){
        this.patternMatchers = patternMatchers;
    }
    public String say(int number) {
        String strReturn = "";
        for(FizzBuzzPatternMatcher fizzBuzzPatternMatcher: patternMatchers){
            if(fizzBuzzPatternMatcher.match(number))
                strReturn += fizzBuzzPatternMatcher.respond();
        }
        if(strReturn.equals(""))
            return String.valueOf(number);
        else
            return strReturn;
    }
}
