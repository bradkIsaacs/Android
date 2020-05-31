package bradley.codebreakers;

public class History {
    String[] guess;
    int correct;
    int incorrect;

    public History(String[] guess, int correct, int incorrect) {
        this.guess = guess;
        this.correct = correct;
        this.incorrect = incorrect;
    }

    public String[] getGuess() {
        return guess;
    }

    public void setGuess(String[] guess) {
        this.guess = guess;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }
}
