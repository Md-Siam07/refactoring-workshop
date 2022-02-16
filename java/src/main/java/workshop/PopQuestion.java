package workshop;

public class PopQuestion extends QuestionPatternMatcher{

    @Override
    public boolean match(int number) {
        return number == 0;
    }

}
