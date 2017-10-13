public class HangMan {//passing this class makes java look for the "public" method named "main", because it is a class method and not an instance method its marked with "static", the method doesn't return anything so its return type is "void" this leads it to take multiple arguments passed to it with spaces--it then takes an array of strings and passes that as an argument in the method which can be accessed by "args" 
  public static void main(String[] args) {
    if (args.length ==0){
      System.out.println("Usage: java HangMan <answer>");
      System.err.println("Answer is required!!!");
      System.exit(1);
    }
    GameLogic gamelogic = new GameLogic(args[0]);
    Prompter prompter = new Prompter(gamelogic);

    while (gamelogic.getRemainingTries() > 0 && !gamelogic.isWon()){
      prompter.displayProgress();
      prompter.promptForGuess();
    }

    prompter.displayOutcome();

      //boolean isHit = prompter.promptForGuess();
      //if (isHit){
      //  Syste
      System.out.println("we got a hit");
      //} else{
    //    System.out.println("no hits; miss!");
    //  }
      //prompter.displayProgress();
  }
}
