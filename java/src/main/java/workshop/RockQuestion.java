package workshop;

public class RockQuestion extends QuestionPatternMatcher{
    @Override
    public boolean match(int number) {
        return number == 3;
    }
}
