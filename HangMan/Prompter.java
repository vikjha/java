import java.util.Scanner;

public class Prompter {
  private GameLogic gamelogic;

  public Prompter(GameLogic gamelogic){
    this.gamelogic = gamelogic;
  }
  public boolean promptForGuess(){
    Scanner scanner = new Scanner(System.in);
    boolean isHit = false;
    boolean isAcceptable = false;

    do {
      System.out.print("Enter a letter:     ");
      String guessInput = scanner.nextLine();
      //char guess = guessInput.charAt(0);

      try{
        isHit = gamelogic.applyGuess(guessInput);
        isAcceptable = true;
      }catch (IllegalArgumentException iae){
        System.out.printf("%s. Please try again. %n",
                          iae.getMessage());
      }
  }while(! isAcceptable);
    return isHit;
  }
  public void displayProgress(){
    System.out.printf("You have %d remaining to solve: %s%n",
                        gamelogic.getRemainingTries(),
                        gamelogic.getCurrentProgress());
  }
  public void displayOutcome(){
    if (gamelogic.isWon()){
      System.out.printf("Congratulations!!!!! You've won with %d tries remaining%n",
                          gamelogic.getRemainingTries());
    }else{
      System.out.printf("ohhhh nooooo... the world was %s",
                          gamelogic.getAnswer());
    }
  }
}
