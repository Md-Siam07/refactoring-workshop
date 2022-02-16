package workshop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    List<FizzBuzzPatternMatcher> patternMatchers;
    FizzBuzz fizzBuzz;
    public void initialize()
    {
        patternMatchers = new ArrayList<>();
        FizzClass fizzClass = new FizzClass();
        BuzzClass buzzClass = new BuzzClass();
        patternMatchers.add(fizzClass);
        patternMatchers.add(buzzClass);
        fizzBuzz = new FizzBuzz(patternMatchers);
    }

    @Test
    public void returnsANumber() {
        initialize();
        assertEquals("1", fizzBuzz.say(1));
        assertEquals("4", fizzBuzz.say(4));
        assertEquals("7", fizzBuzz.say(7));
    }

    @Test
    public void factorOf3() {
        initialize();
        assertEquals("Fizz", fizzBuzz.say(3));
        assertEquals("Fizz", fizzBuzz.say(6));
        assertEquals("Fizz", fizzBuzz.say(9));
    }

    @Test
    public void factorOf5() {
        initialize();
        assertEquals("Buzz", fizzBuzz.say(5));
        assertEquals("Buzz", fizzBuzz.say(10));
        assertEquals("Buzz", fizzBuzz.say(20));
    }

    @Test
    public void factorOf3And5() {
        initialize();
        assertEquals("FizzBuzz", fizzBuzz.say(15));
        assertEquals("FizzBuzz", fizzBuzz.say(30));
        assertEquals("FizzBuzz", fizzBuzz.say(60));
    }
}