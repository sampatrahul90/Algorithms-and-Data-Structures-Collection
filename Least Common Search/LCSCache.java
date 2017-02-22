/**
 * 
 */
/**
 * @author {Rahul Sampat}
 * @file LCSCache.java
 * {Algorithm Design and Analysis}
 */
public class LCSCache implements Constants{

	static int cache[][],direction[][];
	static String s1,s2;
	public static void main(String[] args) {
		
		s1 = takeInput();
		s2 = takeInput();
		cache = new int [s1.length()+1][s2.length()+1];
		direction = new int [s1.length()+1][s2.length()+1];
		
		//Initialising the input
		initInput(cache);
		initInput(direction);
		
		for (int p = s1.length()-1; p >= 0; p--) {
            for (int q = s2.length()-1; q >= 0; q--) {
            	LCS(p,q);
           }
		}
		
		for (int p = s1.length()-1; p >= 0; p--) {
            for (int q = s2.length()-1; q >= 0; q--) {
            	printPath(p,q);
           }
		}
		
	}
	
	private static int LCS(int p, int q){
		    	
				if(cache[p][q] == -1) return 0;
            	
				else if (cache[p][q] != -1)
                    return cache[p][q];
                
				//If there is a match increment the value by 1
				else if(s1.charAt(p) == s2.charAt(q)){
						//direction [p][q] = MATCH_CASE;
                		return cache[p][q] = 1 + LCS(p-1,q-1);
				}
				else {
					
					int v1 = LCS (p-1,q);
					int v2 = LCS (p,q-1);
					
					if( v1 > v2){
						direction[p][q] = LCS(p-1,q);
						cache[p][q] = v1;	
						} else { 
							direction[p][q] = LCS(p,q-1);
							cache[p][q] = v2;
					}
				}
				return cache[p][q];
			}
	private static void printPath(int p,int q){
		
		/*if(direction[p][q] == MATCH_CASE){
			printPath(p - 1, q - 1);
			System.out.println(s1.charAt(p));
		}
		else if(direction[p][q] == LCS (p-1,q)){
			printPath(p-1,q);
		}
		else if(direction[p][q] == LCS (p-1,q)){
			printPath(p, q-1);
		}*/
	}
		
	private static void initInput(int input[][]){
		
		//Simply setting inputs to -1
		for (int i = 0; i < input.length ; i++) {
			for (int j = 0; j < input.length; j++) {
				input[i][j] = -1;
			}
		}
		
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
