/*
    File Name: RecursiveMethodProject.java
    Author: Brea Zeller
    Programming Assignment 2
    
    Description: I have wrote a recursive method named printEnglishthat 
    prints out the digits of an integer in English.
    I also rewrote the printEnglish method as toEnglish,
    which returns a String to the calling method.T
    he return String should contain the entire phrase for the number
*/

public class RecursiveMethodProject {

 public static void main(String[] args) {

  int[] testCases = {
   0,
   123,
   98765,
   -2104,
   -1
  };
  String[] testAnswers = {
   "zero",
   "one two three",
   "nine eight seven six five",
   "negative two one zero four",
   "negative one"
  };

  for (int i = 0; i < testCases.length; i++) {
   System.out.println("printEnglish( " + testCases[i] + " )");
   printEnglish(testCases[i]);
   System.out.println();
   System.out.println();
  }

  for (int i = 0; i < testCases.length; i++) {
   System.out.println("toEnglish( " + testCases[i] + " )");
   if (testAnswers[i].equals(toEnglish(testCases[i]))) {
    System.out.println("success for toEnglish( " + testCases[i] + " )");
   } else {
    System.out.println("fail for toEnglish( " + testCases[i] + " )");
    System.out.println("toEnglish( " + testCases[i] + " ) returns:");
    String str = toEnglish(testCases[i]);
    System.out.println("'" + str + "'");
   }
   System.out.println();
   System.out.println();
  }
 }
 public static void printEnglish(int n) {
  if (n < 0) { //if n is negative
   System.out.print("negative "); //print negative
   printEnglish(n * -1); //call print on the positive version of the number
  } else if (n / 10 == 0) { //if single digit left
   System.out.print(digitToEnglish(n)); //print the digit
  } else { //otherwise
   printEnglish(n / 10); //call print on all but the digit in the ones place
   System.out.print(" " + digitToEnglish(n % 10)); //print the english of the digit in the ones places
  }
 }

 public static String toEnglish(int n) {
  if (n < 0) //if n is negative
   return "negative " + toEnglish(n * -1); //return negative and toEnglish of the positive version of the number
  if (n / 10 == 0) //if n is a single digit number
   return digitToEnglish(n); //return the english version of that number
  return toEnglish(n / 10) + " " + digitToEnglish(n % 10); //otherwise return the toEnglish of everything but the ones place and the english of the ones place
 }

 private static String digitToEnglish(int n) {
  n = Math.abs(n);
  if (n > 9) {
   return null;
  } else {
   return new String[] {
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine"
   }[n];
  }
 }
}