package workshop;

public class SportsQuestion extends QuestionPatternMatcher{

    @Override
    public boolean match(int number) {
        return number == 2;
    }
}
