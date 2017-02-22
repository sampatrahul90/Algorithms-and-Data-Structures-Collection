
import java.util.Scanner;
import java.util.*;

public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInputScanner = new Scanner(System.in);
		System.out.println("Please enter the input size: ");
		int size=userInputScanner.nextInt();//
		double[] userArray=new double[size];
		
		System.out.println("Enter the input numbers: ");
		for(int z=0; z<userArray.length; z++)
		{
		userArray[z]=userInputScanner.nextDouble();
		}
		for(int i=1; i<userArray.length; i++)
		{
		double x=userArray[i];
		int j=i;
		while(j>0 && userArray[j-1]>x)
		{
		userArray[j]=userArray[j-1];
		j=j-1;
		}
		userArray[j]=x;	
		}
		System.out.println("The sorted array is: " + Arrays.toString(userArray));
	}

}
