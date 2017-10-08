package minx.m.util;

import java.io.PrintStream;

public class Debug
{
  public Debug() {}
  
  public static String convBinary(int paramInt)
  {
    return Integer.toBinaryString(paramInt).toUpperCase();
  }
  
  public static String convHex(int paramInt)
  {
    return Integer.toHexString(paramInt).toUpperCase();
  }
  
  public static String convOctal(int paramInt)
  {
    return Integer.toOctalString(paramInt).toUpperCase();
  }
  
  public static void printBinary(int paramInt)
  {
    System.out.println(convBinary(paramInt));
  }
  
  public static void printBinary(String paramString)
  {
    for (int i = 0;; i++)
    {
      if (i >= paramString.length()) {
        return;
      }
      System.out.println(Integer.toBinaryString(paramString.getBytes()[i]).toUpperCase());
    }
  }
  
  public static void printHex(int paramInt)
  {
    System.out.println(convHex(paramInt));
  }
  
  public static void printHex(String paramString)
  {
    for (int i = 0;; i++)
    {
      if (i >= paramString.length()) {
        return;
      }
      System.out.println(Integer.toHexString(paramString.getBytes()[i]).toUpperCase());
    }
  }
  
  public static void printOctal(int paramInt)
  {
    System.out.println(convOctal(paramInt));
  }
  
  public static void printOctal(String paramString)
  {
    for (int i = 0;; i++)
    {
      if (i >= paramString.length()) {
        return;
      }
      System.out.println(Integer.toOctalString(paramString.getBytes()[i]).toUpperCase());
    }
  }
}
