/* @author Ant
 * @date 1/25/2020
 * @proj Dinner with Emma
 */


// Please run the program and read the text file before reading the code!

import java.io.*;

public class dinnerWithEmmaEXTRACREDIT{
  public static void main(String[] args)throws IOException{
    
    int[][] city = {{1, 2, 3}, {2, 3, 1}, {3, 1, 2}};
    
    PrintWriter outputFile = new PrintWriter("Extra Credit Proof");                            
    outputFile.println(city.length + ", " + city[0].length); 
    
      for(int i = 0; i < city.length; i++){ 
      for(int y = 0; y < city[i].length; y++){
        outputFile.print(city[i][y] + ", ");
      }
     outputFile.println("");  
    } 
    
    int emma1 = emmaFirst(city);  
    
    int jack2 = jackSecond(city[emma1]);  
    
    int price1 = city[emma1][jack2]; 
    
    outputFile.println("Emma chose street #" + (emma1+1) + " first.\nJack chose avenue #" + (jack2+1) + " second.\nThe price of dinner if Emma chooses first is " + price1 + ".");
    
    
    int jack1 = jackFirst(city);  
    
    int emma2 = emmaSecond(city[jack1]);  
    
    int price2 = city[emma2][jack1]; 
    
    outputFile.println("Jack chose avenue #" + (jack2+1) + " first.\nEmma chose street #" + (emma2+1) + " second.\nThe price of dinner if Jack chooses first is " + price2 + ".");
    
    /* Please run the file and read "reasoning" from the text file :D It will be much easier.*/
    outputFile.println("\n\n\nREASONING:\n" + "If Emma chooses first, the biggest of the\nsmallest values in each row is always 1. Since Jack\nwill choose the smallest number available to him,\nthe price will end as 1." + "\nHowever, if Jack chooses first, the smallest of the\nbiggest values in each column is always 3. Since Emma \nwill choose the smallest number available to her,\nthe price will end as 3." + "\nSo, the only time the order of the choices impacts the final price is if\nFor Jack: the smallest of the biggest values in every column is the same.\nFor Emma: the biggest of the smallest values in every row is the same.\n(These are different phrasings for the same concept.)");
                         

              
    outputFile.close(); 
    
    
    
    
  }
  
  public static int emmaFirst(int[][] city){
    int smallest;
    int[] smallestValues = new int[city.length];
    for(int x = 0; x < city.length; x++){
     smallest = city[x][0];
      for(int y = 0; y < city[x].length; y++){
        if(city[x][y] < smallest){ 
          smallest = city[x][y];
      }
    }
      smallestValues[x] = smallest;
  }
    int biggest = 0;
    int biggestIndex = 0;
    for(int i = 0; i < smallestValues.length; i++){
      if(smallestValues[i] > biggest){
        biggest = smallestValues[i];
        biggestIndex = i;
      }
    }
    return biggestIndex;
}
   public static int jackFirst(int[][] city){ 
    int biggest; 
    int[] biggestValues = new int[city.length];
    for(int x = 0; x < city[0].length; x++){
     biggest = city[0][x];
      for(int y = 0; y < city.length; y++){
        if(city[y][x] > biggest){ 
          biggest = city[y][x];
      }
    }
      biggestValues[x] = biggest;
  }
    int smallest = 101;
    int smallestIndex = 0;
    for(int i = 0; i < biggestValues.length; i++){ 
      if(biggestValues[i] < smallest){
        smallest = biggestValues[i];
        smallestIndex = i;
      }
    }
    return smallestIndex;
}
  public static int emmaSecond(int[] avenue){
    int biggest = 0;
    int biggestIndex = 0;
      for(int x = 0; x < avenue.length; x++){ 
        if(avenue[x] > biggest){
          biggest = avenue[x];
          biggestIndex = x;
        }
    }
    return biggestIndex; 
  }
  
  public static int jackSecond(int[] street){
    int smallest = 101;
    int smallestIndex = 0;
      for(int x = 0; x < street.length; x++){ 
        if(street[x] < smallest){
          smallest = street[x];
          smallestIndex = x;
        }
    }
    return smallestIndex; 
  }
}