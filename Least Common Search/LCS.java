/**
 * 
 */
/**
 * @author {Rahul Sampat}
 * @file LCS.java
 * {Algorithm Design and Analysis}
 */
public class LCS implements Constants {

    public static void main(String[] args) {
    	
    	String x = takeInput();
        String y = takeInput();
        
        //Stores the optimum cost of the the whole input
        int[][] opt = new int[x.length()+1][y.length()+1];

        //This is the memorization step
        //First each row is scanned in a columnar manner
        for (int i = x.length()-1; i >= 0; i--) {
            for (int j = y.length()-1; j >= 0; j--) {
            	
            	//If there is a match increment the value by 1
                if (x.charAt(i) == y.charAt(j))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else 
                	//Take the maximum of whatever is the max
                    opt[i][j] = findMax(opt[i+1][j], opt[i][j+1]);
            }
        }

        //Just track back
        int i = 0, j = 0;
        String cS="";
        while(i < x.length() && j < y.length()) {
        	
        	//if equal proceed and take the next value
            if (x.charAt(i) == y.charAt(j)) {
                //cS=cS + System.out.print(x.charAt(i));
            	cS=cS + x.charAt(i);
                i++;
                j++;
            }
            
            //else keep looking
            else if (opt[i+1][j] >= opt[i][j+1]){
            	i++;
            }
            else{
            	j++;
            }
        }
        System.out.println("The longest common subsequence is " + cS + " of length " + cS.length());
    }
    
    private static String takeInput(){
    	
    	//Simply use to take the input
    	System.out.println("Please input the LCS input string");
    	String temp = sc.nextLine();
    	
    	return temp;
    }
    
    private static int findMax(int number1, int number2){
    	
    	//Use to find max using the ternary operator
    	return (number1 > number2)? number1 : number2;
    	
    }

}