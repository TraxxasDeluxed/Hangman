
public class Player {
    public int playerLife;
    @SuppressWarnings("FieldMayBeFinal")
    private char[] guessedLetters;
    private int guesscount;
 
   public Player(int maxAttempts,int maxGuesses){
    this.playerLife = maxAttempts;
    this.guessedLetters = new char[maxGuesses];
    this.guesscount = 0;
   }
     // Getter for attempts left
     public int getAttemptsLeft() {
        return playerLife;
    }

    // Method to decrease attempts
    public void decreaseAttempts() {
       playerLife--;
    }

    // Method to check if letter is already guessed
    public boolean hasGuessedLetter(char letter){
        for(int i=0;i<guesscount;i++){
            if(guessedLetters[i] == letter){
                return true;
            }
        }
     return false;
    }
    // Method to add guessed letter
    public void addGuessedLetter(char letter){
        if 
        (!hasGuessedLetter(letter) && guesscount < guessedLetters.length) {
            guessedLetters[guesscount] = letter; // Add letter to array
            guesscount++;
        }
    
    }

    // Get guessed letters to print
    public String getGussedLetters(){
        StringBuilder guessed = new StringBuilder();
        for(int i=0;i<guesscount;i++){
            guessed.append(guessedLetters[i]).append(" ");
        }
        return guessed.toString().trim();
    }
}