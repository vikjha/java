import java.io.Console;

public class TreeStory {
  public static void main(String[] args){
    Console console = System.console();
    int age = 33;
    if( age < 13){
      console.printf("Sorry too young!\n");
      System.exit(0);
    }

    String name = console.readLine("Enter your name:   ");
    String adjective = console.readLine("Choose an adjective to describe yourself:    ");
    console.printf("%s is very %s\n", name, adjective);
  }
}
