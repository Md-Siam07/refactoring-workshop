package workshop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Questions {
    List<QuestionPatternMatcher> listOfQuestions = new ArrayList<>();
    QuestionPatternMatcher popQuestions = new PopQuestion();
    QuestionPatternMatcher scienceQuestions = new ScienceQuestion();
    QuestionPatternMatcher sportsQuestions = new SportsQuestion();
    QuestionPatternMatcher rockQuestions = new RockQuestion();

    public Questions() {
        initialize();
    }

    private void initialize()
    {
        for (int i = 0; i < 50; i++) {
            popQuestions.addQuestion("Pop Question " + i);
            scienceQuestions.addQuestion("Science Question " + i);
            sportsQuestions.addQuestion("Sports Question " + i);
            rockQuestions.addQuestion("Rock Question " + i);
        }
        addToList();
    }

    private void addToList(){
        listOfQuestions.add(popQuestions);
        listOfQuestions.add(scienceQuestions);
        listOfQuestions.add(sportsQuestions);
        listOfQuestions.add(rockQuestions);
    }

    public String getNextQuestion(int position) {
        for(QuestionPatternMatcher question: listOfQuestions){
            if(question.match(position)){
                return question.generate();
            }
        }
        return "";
    }


    public QuestionCategory currentCategory(int position) {
        switch (position % 4) {
            case 0:
                return QuestionCategory.POP;
            case 1:
                return QuestionCategory.SCIENCE;
            case 2:
                return QuestionCategory.SPORTS;
            default:
                return QuestionCategory.ROCK;
        }
    }
}
