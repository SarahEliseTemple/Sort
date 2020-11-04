package Sort;
/*Name:Sarah Temple
 * Date: November 4th 2020
 * Comments: THis will sort a users numbers from a file and can use different ways to sort. I got help with Ryan B for the Quick sort and here is the
 * link I used. https://www.youtube.com/watch?v=MZaf_9IZCrc There is more information below. 
 * 
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sort {

	Scanner consoleInput = new Scanner(System.in);
	String input;
	Scanner fileInput;
	int[] inputArray;
	long startTime;
	
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
		startTime=System.currentTimeMillis();
		if (input.equals("1")) {
			inputArray = bubbleSort(inputArray);
		}
		if (input.equals("2")) {
			inputArray = selectionSort(inputArray);
		}
		if (input.equals("3")) {
			inputArray = tableSort(inputArray);
		}
		if (input.equals("4")) {
			inputArray = quickSort(inputArray);
		}
		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Total time:" + totalTime);
		try {
		PrintWriter pw = new PrintWriter(new FileWriter(new File("output.txt")));
		String output = "";
		for (int i = 0; i < InputStringArray.length; i++) {
			
			output += inputArray[i] + ", ";
		} 
		output+="\nTotal time:" + totalTime;
		pw.write(output);
		pw.close();
		}catch (IOException ex) {
			ex.printStackTrace();
			System.exit(0);
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
	int[] selectionSort(int[] array) {
		
		for (int j = 0; j < array.length; j++) {
			int smallestNumber = array[j];
			int smallestIndex = j;
			for (int i = j; i < array.length; i++) {
				if(array[i] <smallestNumber) {
					smallestNumber = array[i];
					smallestIndex = i;
				}
			}
			int temp = array[smallestIndex];
			array[smallestIndex] = array[j];
			array[j] = temp;
		}
		
		
		return array;
	}
	//Tally how often you see each number. Print out that number of times
	int[] tableSort(int[] array) {
		int[] tally = new int[1001];
		for (int i = 0; i < array.length; i++) {
			tally[array[i]]++;	
		}
		int count = 0;
		//i keeps track of the actual number
		for (int i = 0; i < tally.length; i++) {
			//j keeps track of how many times we've seen that number
			for (int j = 0; j < tally[i]; j++) {
				array[count] = i;
				count++;
			}
		}
		
		return array;
	}
	

// This is the link where someone explained how to do quicksort
// his skills are legendary and I understand it well now.
//https://www.youtube.com/watch?v=MZaf_9IZCrc
//Ryan B.  and I worked together to figure this out. 
	int[] quickSort(int[] array) {
		
		for (int k = 0; k < array.length-1; k++) {
			int pivot = array.length-1;
			int i = -1; // i is the thing thats going to be switched
			for (int j = 0; j < array.length-1; j++) {
				if (array[j]<array[pivot]) { // j is the thing being compared to the pivot
					i++;
					int temp =array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
			int temp = array[pivot];
			array[pivot] = array[i+1];
			array[i+1] = temp;
		}
		return array;
	}
	
	public static void main(String[] args) {
		new Sort();
	}
	
}
