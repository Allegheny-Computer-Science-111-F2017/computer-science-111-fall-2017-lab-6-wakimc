package labsix;
/** This is the File that will allow for chosenDna Manipulaton
 * This will Randomize, insert, certain varibles 
 * into chosenDna strings.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class ManipulateDna {

  /** This is the main entry point for ManipulatechosenDna.java
   *  This program will Manipulate User Imput chosenDna
   *  In a Random Fasion 
   **/ 
  public static void main(String[] args) {
    // display the name of the programmer and the date
    System.out.println("Christopher N. Wakim " + new Date());
    // declare the starting file and scanner
    File dnaInputsFile = null;
    Scanner scanner = null;
    // connect the scanner to the input file
    try {
      dnaInputsFile = new File("input/dna_inputs.txt");
      scanner = new Scanner(dnaInputsFile);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate file");
    }
    // Step One: Read in and display the chosen chosenDna string
    String dna = scanner.nextLine();
    String chosenDna = dna.toUpperCase();
    System.out.println("Please Enter a chosenDna String using A, T, C, and G " + chosenDna);

    // Step Two: Compute the complement of the chosenDna String
    chosenDna = chosenDna.replace('A','t');
    chosenDna = chosenDna.replace('T','a');
    chosenDna = chosenDna.replace('C','g');
    chosenDna = chosenDna.replace('G','c');
    chosenDna = chosenDna.toUpperCase();
    System.out.println("Complement of " + dna.toUpperCase() + " is " + chosenDna);
    // Step Three: Insert a randomly chosen chosenDna letter into the chosenDna String
    Random generator = new Random();
    dna = dna.toUpperCase();
    int randIndex = generator.nextInt(4);
    char randChar = "ACTG".charAt(randIndex);
    int randInsert = generator.nextInt(dna.length());
    //randChar =  randChar.toUpperCase();
    String newInsert = dna.substring(0, randInsert) + randChar + dna.substring(randInsert);
    System.out.println("Insert " + randChar + " at position " + randIndex + " gives " + newInsert);
    // Step Four: Delete a Dna letter from a randomly chosen position in the Dna string
    int randdltLetter = generator.nextInt(dna.length());
    String dltLetter = dna.substring(0, randdltLetter) + dna.substring(randdltLetter + 1);
    System.out.println("Deleting from Position " + randdltLetter + " gives " + dltLetter);

    // Step Five: Change a random position in the Dna String to a randomly chosen Dna letter
    int randSelect = generator.nextInt(dna.length());
    char randomchoose = "ACTG".charAt(generator.nextInt(4));
    String swap = dna.substring(0, randSelect) + randomchoose + dna.substring(randSelect + 1);  
    System.out.println("Changing position " + randSelect + " gives " + swap);
    // Step Six: Display a final thankyou message
    System.out.println("Thank you for using my program to manipulate chosenDna");

  }

}
