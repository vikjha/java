class PezDisp {
  public static final int MAX_PEZ = 12;//"static": class level variables can be accessed from the class but not the instance-- gives the ability to provide variables and methods off the class instead of off the instance
  final private String wiseTeacher;//final blocks changing the variable
//String.contains public boolean
  private int pezCount; //best practice to always start with private and switch to public when you have the need

public PezDisp(String wiseTeacher){
  this.wiseTeacher = wiseTeacher;
  pezCount = 0;
}
public void fill(){//void is used when a method doesnt return anything
  //using void encapsulates, keeps private, the method from consumer

  //pezCount = MAX_PEZ; instead of using this we will method overload below
  //multiple methods with the same name is called overloading
  fill(MAX_PEZ); //now fill will always be equal to the other fill method

  //"abstraction" abstracted away the need for consumers of the code to know how the fill method works
  //return "blah blah"; void is blocking this

  }
  public boolean dispense(){
    boolean wasDispensed = false;
    if(!isEmpty()){
      pezCount--;
      wasDispensed = true;
    }
    return wasDispensed;
  }

  public boolean isEmpty(){
    return pezCount == 0;

  }
  public String getWiseTeacher(){
    return wiseTeacher;
  }
  public void fill(int pezAmount){
    int newAmount = pezCount + pezAmount;
    if (newAmount> MAX_PEZ){
      throw new IllegalArgumentException("Too many tasty treats!!!!");
    }
    pezCount = newAmount;
  }
//  public String swapHead(String wiseTeacher){
//    String originalWiseTeacher= this.wiseTeacher;
//    this.wiseTeacher = wiseTeacher;
//    return originalWiseTeacher;
//  }
}


