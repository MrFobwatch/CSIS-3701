package exceptionhandler;

import java.io.*;

public class ExceptionHandler {
  public static void main(String[] args) {
    //    //
    //    int num1, num2, num3;
    //
    //    num1 = 10;
    //    num2 = 0;
    //    num3 = 0;
    //
    //      try
    //      {
    //
    //
    //    num3 = num1 / num2;}
    //    catch (Exception e) {
    //      System.out.println(e.getMessage());
    //    }
    //    System.out.println(num3);

    try {
      int a = 30, b = 0;
      int c = a / b;
      System.out.println("Result: " + c);
    } catch (ArithmeticException e) {
      System.out.println("Can't divided a number by 0");
    }

    // Array index out of bounds
    try {
      int a[] = new int[5];
      a[6] = 9;
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Array index is Out of Bounds.");
    }

    // File Not Found Exception
    try {
      File file = new File("E://file.txt");
      FileReader fr = new FileReader(file);
      System.out.println("File opened successfully");
    } catch (FileNotFoundException e) {
      System.out.println("File does not exist.");
    }

    // IO Exception
    FileInputStream f = null;
    try {
      f = new FileInputStream("abc.txt");
      int i;
      while ((i = f.read()) != -1) {
        System.out.println((char) i);
      }
      f.close();
    } catch (IOException e) {
      System.out.println("IO Exception ...");
    }
  }
}
