/**
 * 
 * @project Caesar Shift
 * @author Ant
 * @date 09/13/19
 * 
 * PRGRM
 * 1) Prompt user to provide an input to be encrypted
 * 2) honestly imma wing it
 * 
 * 65 - 122 is the alphabet range
 * 
 * PRGRM non-functional :(
 */
import java.util.*;
public class CaesarShift {
  static int[] ascii;
  public static void main(String[] args){   
  Scanner keyboard = new Scanner(System.in);
  System.out.println("Hello! Enter a message to be encrypted!");      //user prompt for message
  String message = keyboard.nextLine();          //assign input to a value
  System.out.println("Enter desired key!");      //user prompt for key
  int shift = keyboard.nextInt();                //assign input to a value
  int numchars = message.length();               //assigns and integer value for length of the message, used later for loops
  char[] chararray = message.toCharArray();      //converts user message into a character array, assigns the array to a variable            
  for(int i = 0; i < numchars; i++){
    ascii[i] = (byte) chararray[i];               //converts each individual character into an ascii value
  }
  for(int i = 0; i < ascii.length; i++){
    chararray[i] = (char) ascii[i];               //converts each ascii value in array back into a character
  }
  for(int i = 0; i < numchars; i++){
    System.out.print(chararray[i]);               //print out each reconverted value
  }
  System.out.println("");                         //line break for formatting
  for(int i = 0; i < ascii.length; i++){
  int num = ascii[i];
  if (num + shift > 122){
  }
  else if (num < 65) {}
  else; {}
  }
  
  
  }                
  
  
  }
