import java.io.Console;

public class Intro {
  public static void main(String[] args){
    Console console = System.console();
    String firstName = console.readLine("What is your name?   ");//use camel case for variables
    console.printf("hellooooo, my name is %s\n", firstName);
    console.printf("the name %s is reserverd for awesome people!!!", firstName);
  }
}

