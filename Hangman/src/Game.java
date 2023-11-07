import java.util.Scanner;

public class Game {
    Reader reader = new Reader("Words.txt");
    Random random = new Random();
    StringBuilder sb = new StringBuilder("");
    Scanner scanner = new Scanner(System.in);
    public String mainWord = null;


    //a function that generates a random number based on which it selects a word from the list and creates a hidden word
    public String WordToGuess(){
        int number = random.RandomNumber(0, reader.wordsList.size() - 1);
        mainWord = reader.wordsList.get(number);
        for(int i = 0; i<mainWord.length(); i++){
            sb.append("_");
        }
        return mainWord;
    }

    public void CheckingPositionOfLetters(String mainWord, char letter) {
        for(int i = 0; i < mainWord.length(); i++){
            if(mainWord.charAt(i) == letter) {
                sb.setCharAt(i, letter);
            }
        }
    }

    //displays the hangman
    public void HangMan(int i){
        String[] hangman = new String[6];
        hangman[0] = "  _";
        hangman[1] = "  |";
        hangman[2] = "  |";
        hangman[3] = "  O";
        hangman[4] = " /|\\";
        hangman[5] = " / \\";

        System.out.println("\n---------------------");
        for(int j = 0; j <= i; j++){
            System.out.println(hangman[j]);
        }
        System.out.println("---------------------\n");

    }

    // contains the rules of the game
    public void Run() throws MyException {
        String letter = "";
        int badAnswer = 0;
        System.out.println("The game has started");
        while (!mainWord.equals(sb.toString())) {
            System.out.println("Your word:\n" + sb);
            letter = scanner.nextLine();
            try {
                if (letter.length() == 1) {
                    char temp = letter.charAt(0);
                    if(mainWord.contains(letter)){
                        CheckingPositionOfLetters(mainWord, temp);
                    }
                    else{
                        HangMan(badAnswer);
                        badAnswer++;
                        if(badAnswer == 6){
                            System.out.println("You lost!\nTry again!");
                            System.out.println("Your word was: " + mainWord);
                            break;
                        }
                    }
                }

                else if (letter.length() == mainWord.length()) {
                    if(letter.equals(mainWord)){
                        break;
                    }
                    else {
                        HangMan(badAnswer);
                        badAnswer++;
                        if(badAnswer == 6) {
                            System.out.println("You lost!\nTry again!");
                            System.out.println("Your word was: " + mainWord);
                            break;
                        }
                    }
                }

                else {
                        throw new MyException("Enter only 1 letter or full word");
                }
            } catch (MyException e) {
                System.out.println(e);
            }
        }
        if(badAnswer != 6) {
            System.out.println("You won!");
        }
    }



}
