public class Example {
  public static void main(String[] args) {
    System.out.println("We are making a new PEZ Dispenser");
    System.out.printf("Fun Fact: You have the potential to recieve %d tasty treats if you answer your wise teachers questions correctly%n", PezDisp.MAX_PEZ );

    PezDisp Dispenser = new PezDisp("Yoda");

    System.out.printf("My wise teacher, %s, teaches me and gives me candy to boot %n", Dispenser.getWiseTeacher()
      );

    if(Dispenser.isEmpty()){
      System.out.println("Dispenser is Empty");
    }
    System.out.println("Filling the dispenser with delicious treats");
    Dispenser.fill();

    if (!Dispenser.isEmpty()){
      System.out.println("Dispenser has treats!");
    }

    while (Dispenser.dispense()){
      System.out.println("Chomp!!!!");
    }
    if (Dispenser.isEmpty()){
      System.out.println("Ate all openthe tasty treats!!!");
    }
    Dispenser.fill(3);
    Dispenser.fill(2);
    while (Dispenser.dispense()){
      System.out.println("Chomp!!!!");
    }


    try{
      Dispenser.fill(400);
      System.out.println("too many tasty treats!!!");
    } catch(IllegalArgumentException iae){
      System.out.printf("The error was %s %n", iae.getMessage());

    }
  //  String before = Dispenser.swapHead("Darth Vader");

  //  System.out.printf("My wise teacher was %s but now i learn from the great %s %n",
  //  before, Dispenser.getWiseTeacher());
  }
}
