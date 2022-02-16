package workshop;

public class FizzClass implements FizzBuzzPatternMatcher{
    @Override
    public boolean match(int number) {
        return number % 3 == 0;
    }

    @Override
    public String respond() {
        return "Fizz";
    }
}
