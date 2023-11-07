public class Main {
    public static void main(String[] args) throws MyException {
        Reader reader = new Reader("Words.txt");
        Game game = new Game();

        game.WordToGuess();
        game.Run();
    }
}
