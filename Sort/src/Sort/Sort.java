package Sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sort {

	Scanner consoleInput = new Scanner(System.in);
	String input;
	Scanner fileInput;
	int[] inputArray;
	
	public Sort() {
		System.out.println("Enter a number for the input file");
		System.out.println("1:input1.txt 2:input2.txt 3:input3.txt 4: input4.txt");
		input = consoleInput.nextLine();
		if (input.length() != 1 && input.charAt(0) != '1' && input.charAt(0)!= '2' && 
				input.charAt(0) != '3' && input.charAt(0) != '4') {
			System.out.println("Enter 1, 2, 3, or 4");
			while (input.length() != 1 && input.charAt(0) != '1' && input.charAt(0)!= '2' && 
				input.charAt(0) != '3' && input.charAt(0) != '4') {
			input = consoleInput.nextLine();
			}
		}
		try {
		fileInput = new Scanner(new File("input"+ input.charAt(0) + ".txt"));
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
			System.exit(0);
		}
		
		String infile = fileInput.nextLine();
		String[] InputStringArray = infile.split(",");
		inputArray = new int[InputStringArray.length];
		for (int i = 0; i < InputStringArray.length; i++) {
			inputArray[i] = Integer.parseInt(InputStringArray[i]);
			System.out.println(inputArray[i]);
		}
		System.out.println("Enter a number for the sort you wish to use.");
		System.out.println("1:Bubble Sort 2:Selection 3:Table 4:quicksort(dont use yet)");
		input = consoleInput.nextLine();
		if (input.length() != 1 && input.charAt(0) != '1' && input.charAt(0)!= '2' && 
				input.charAt(0) != '3' && input.charAt(0) != '4') {
			System.out.println("Enter 1, 2, 3, or 4");
			while (input.length() != 1 && input.charAt(0) != '1' && input.charAt(0)!= '2' && 
				input.charAt(0) != '3' && input.charAt(0) != '4') {
			input = consoleInput.nextLine();
			}
		}
		if (input.equals("1")) {
			inputArray = bubbleSort(inputArray);
		}
		for (int i = 0; i < InputStringArray.length; i++) {
			System.out.println(inputArray[i]);
		}
		
	}
	//compare each pair of numbers and move the larger to the right.  
	int[] bubbleSort(int[] array) {
		for (int j = 0; j < array.length; j++) {
			
		
			for (int i = 0; i < array.length-1; i++) {
				if(array[i] > array[i+1]) {
					//swap
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		new Sort();
	}
	
}
