package workshop;

import java.util.ArrayList;
import java.util.List;



public class TriviaGame {
    private final List<Player> playerList = new ArrayList<>();
    private final Questions questions = new Questions();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public void add(String playerName) {
        playerList.add(new Player(playerName));

        printMessage(playerName + " was added");
        printMessage("They are player number " + playerList.size());
    }

    public void roll(int roll) {
        printMessage(getPlayer().getName() + " is the current player");
        printMessage("They have rolled a " + roll);

        if (getPlayer().isInPenaltyBox) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                printMessage(getPlayer().getName() + " is getting out of the penalty box");
                movePlayerAndCheck(roll);
                tellThePositionAndAskQuestion();
            } else {
                printMessage(getPlayer().getName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            movePlayerAndCheck(roll);

            tellThePositionAndAskQuestion();
        }


    }

    private void tellThePositionAndAskQuestion() {
        printMessage(getPlayer().getName()
                + "'s new location is "
                + getPlayer().getPlace());
        printMessage("The category is " + questions.currentCategory(getPlayer().getPlace()).getLabel());
        askQuestion();
    }

    private void movePlayerAndCheck(int roll) {
        getPlayer().move(roll);
    }

    private void askQuestion() {
        printMessage(questions.getNextQuestion(getPlayer().getPlace()));
    }

    private Player getPlayer() {
        return playerList.get(currentPlayer);
    }
    public boolean wasCorrectlyAnswered() {
        if (getPlayer().isInPenaltyBox()) {
            if (isGettingOutOfPenaltyBox) {
                return correctlyAnswered();
            } else {
                currentPlayer++;
                if (currentPlayer == playerList.size()) currentPlayer = 0;
                return true;
            }
        } else {
            return correctlyAnswered();
        }
    }

    private boolean correctlyAnswered() {
        printMessage("Answer was correct!!!!");
        getPlayer().increaseCoin();
        printMessage(playerList.get(currentPlayer).getName()
                + " now has "
                + getPlayer().getCoinInPurse()
                + " Gold Coins.");

        boolean winner = didPlayerWin();
        currentPlayer++;
        if (currentPlayer == playerList.size()) currentPlayer = 0;
        return winner;
    }

    public void wrongAnswer() {
        printMessage("Question was incorrectly answered");
        printMessage(playerList.get(currentPlayer).getName() + " was sent to the penalty box");
        getPlayer().setInPenaltyBox(true);

        currentPlayer++;
        if (currentPlayer == playerList.size()) currentPlayer = 0;
    }

    private boolean didPlayerWin() {
        return !(getPlayer().getCoinInPurse() == 6);
    }

    protected void printMessage(Object message) {
        System.out.println(message);
    }
}