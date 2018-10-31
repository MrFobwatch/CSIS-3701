package exceptionhandler;

public class ExceptionHandler {
  public static void main(String[] args) {
    //
    int num1, num2, num3;

    num1 = 10;
    num2 = 0;
    num3 = 0;

      try
      {


    num3 = num1 / num2;}
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.println(num3);
  }
}
