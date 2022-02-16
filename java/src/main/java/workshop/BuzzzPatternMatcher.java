package workshop;

public class BuzzzPatternMatcher implements Matcher, Responder{

    @Override
    public boolean matches(int number) {
        return (number % 3) ==0;
    }

    @Override
    public String generateResponse() {
        return "Fizz";
    }
}
