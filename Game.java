import java.util.Scanner;

public class Game {
    private final String wordToGuess;
    private String displayWord;
    Player player;

    public Game() {
        this.wordToGuess = WordProvider.getWord(); // Get a random word
        this.displayWord = ""; // Initialize displayWord with underscores
        for (int i = 0; i < wordToGuess.length(); i++) {
            this.displayWord += "_";
        }
        this.player = new Player(6, 26); // Initialize player with 6 attempts and space for 26 guesses
    }
    
    
    public boolean isGameWon(){
      return wordToGuess.equals(displayWord);
    }

    public boolean isGameOver(){
        return  player.getAttemptsLeft()==0;
    }
    public String checkGuess(char guess){
        StringBuilder updatedisplay = new StringBuilder(displayWord);
        boolean isCorrect = false;
        for(int i =0;i<wordToGuess.length();i++){
            if(guess == wordToGuess.charAt(i)){
              updatedisplay.setCharAt(i, guess);
              isCorrect = true;
            }
        }
        if(!isCorrect){
            player.decreaseAttempts();
        }
        displayWord=updatedisplay.toString();
        return displayWord;
    }

    public void startGame(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.println("Your word: " + displayWord);

        while (!isGameOver() && !isGameWon()) {
            System.out.print("Enter your guess: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (player.hasGuessedLetter(guess)) {
                System.out.println("You already guessed that letter!");
            }

            player.addGuessedLetter(guess);
            String oldDisplayWord = displayWord;
            checkGuess(guess);

            if (!displayWord.equals(oldDisplayWord)) {
                System.out.println("Correct guess!");
            } else {
                System.out.println("Incorrect guess. Attempts left: " + player.getAttemptsLeft());
            }

            System.out.println("Current word: " + displayWord);
        }

        if (isGameWon()) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Game over! The word was: " + wordToGuess);
        }
        
    }
 

}
