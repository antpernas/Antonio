/* @author Ant
 * @date 1/25/2020
 * @proj Dinner with Emma
 */
import java.util.*;
import java.io.*;

public class dinnerWithEmma{
  public static void main(String[] args)throws IOException{
    
    int[][] city = cityGenerator();    //Generate a matrix to represent the citys avenues and streets.
    
    PrintWriter outputFile = new PrintWriter("City Matrix"); //Create a text file to print out the matrix.                            
    outputFile.println(city.length + ", " + city[0].length); //Print out the dimensions of the matrix at the top of the text file.
    
      for(int i = 0; i < city.length; i++){ //Print out the generated matrix in the text file.
      for(int y = 0; y < city[i].length; y++){
        outputFile.print(city[i][y] + ", ");
      }
     outputFile.println("");  
    } 
    
    int emma = emmaChoose(city);   //Call the method for Emma to choose a street.
    
    int jack = jackChoose(city[emma]);  //Call the method for Jack to choose an avenue based off of Emma's street selection.
    
    int price = city[emma][jack]; //Record the price of the restaurant at Jack and Emma's intersection.
    
    outputFile.println("Emma chose street #" + (emma+1) + "\nJack chose avenue #" + (jack+1) + "\nThe price of dinner is " + price + "."); 
    //Print out both individual's selections, as well as the price of the location, at the bottom of the text file.
    
              
    outputFile.close(); //Close the text file.
    
    
    
  
    
    
  }
  public static int[][] cityGenerator(){ //Matrix generator method.
    Random rand = new Random();
    int m = rand.nextInt(100) + 1; //Randomly generate the number of rows in the matrix, representing the number of "streets" in the city.
    int n = rand.nextInt(100) + 1; //Randomly generate the number of columns in the matrix, representing the number of "avenues" in the city.
    int[][] a = new int[m][n]; //Create the matrix using the previous two values.
    for(int x = 0; x < a.length; x++){ //Loop to assign an element (random integer) to each array index.
      for(int y = 0; y < a[x].length; y++){
        a[x][y] = rand.nextInt(1000000000) + 1;
      }
    }
    return a; //Return the created matrix.
    
  }
  public static int emmaChoose(int[][] city){ //Emma selection method, given that Emma selects first.
    int smallest; //Since Emma must choose optimally, she will first only take into consideration the smallest value in each row, or "street."
                  //This is because Emma knows Jack will always choose the smallest value available to him in the street.
    int[] smallestValues = new int[city.length]; //Emma will then record the smallest value of each street in an array.
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
    for(int i = 0; i < smallestValues.length; i++){ //Emma then compares all the values in the array she created, recording the largest of the smallest values.
      if(smallestValues[i] > biggest){
        biggest = smallestValues[i];
        biggestIndex = i;
      }
    }
    return biggestIndex; //Emma returns the index value of the 1-D array, or "street," containing the largest of the smallest values.
}
  public static int jackChoose(int[] street){ //Jack now selects from the street Emma has provided.
    int smallest = 101;
    int smallestIndex = 0;
      for(int x = 0; x < street.length; x++){ //Jack simply loops through to find the smallest value in the street.
        if(street[x] < smallest){
          smallest = street[x];
          smallestIndex = x;
        }
    }
    return smallestIndex; //Jack returns the index value of the smallest element, or the "cheapest restaraunt."
  }
}