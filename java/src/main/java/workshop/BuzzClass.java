package workshop;

public class BuzzClass implements FizzBuzzPatternMatcher{
    @Override
    public boolean match(int number) {
        return number % 5 == 0;
    }

    @Override
    public String respond() {
        return "Buzz";
    }
}
