package workshop;

import java.util.ArrayList;
import java.util.List;

abstract public class QuestionPatternMatcher {
    List<String> questions = new ArrayList<>();
    abstract public boolean match(int number);
    public String generate() {
        return questions.remove(0);
    }
    public void addQuestion(String question){
        questions.add(question);
    }
}
