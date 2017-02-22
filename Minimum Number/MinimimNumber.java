
import java.util.Scanner;

public class MinimimNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
			double[] userArray=new double[5];
			Scanner userInputScanner = new Scanner(System.in);
			System.out.println("Enter the 5 numbers: ");
			for(int i=0; i<userArray.length; i++)
			{
			userArray[i]=userInputScanner.nextDouble();
			}
			double minNumber=userArray[0];
			for(int j=1; j<userArray.length; j++)
			{
			if(minNumber>userArray[j])
			minNumber=userArray[j];
			}
			System.out.println("Minimum Number is: " + minNumber);
			}

	}

}
