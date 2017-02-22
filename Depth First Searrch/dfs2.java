import java.util.ArrayList;
import java.util.Stack;
 
 
public class dfs2{
     
    
    public static void dfs_iterative(ArrayList<ArrayList<Integer>> adj, int s){
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> st = new Stack<Integer>();
        st.push(s);
        while(!st.isEmpty()){
             int v = st.pop();
            if(!visited[v]){
                visited[v] = true;
                System.out.print(v + " ");
                
                Stack<Integer> auxStack = new Stack<Integer>();
                for(int w : adj.get(v)){
                    if(!visited[w]){
                        auxStack.push(w);
                    }
                }
                while(!auxStack.isEmpty()){
                    st.push(auxStack.pop());
                }
            }
        }
        System.out.println();
    }
     

    public static void main(String[] args) {
         
       
        ArrayList<ArrayList<Integer>> adjLists = new ArrayList<ArrayList<Integer>>();
        final int n = 6;
         
        
        for(int v=0; v<n; v++){
            adjLists.add(new ArrayList<Integer>());
        }
         
        
        adjLists.get(0).add(1);
         
        adjLists.get(1).add(0);
        adjLists.get(1).add(2);
        adjLists.get(1).add(3);
       
        adjLists.get(2).add(1);
        adjLists.get(2).add(3);
        adjLists.get(3).add(1);
        adjLists.get(3).add(2);
        adjLists.get(3).add(4);
     
        
        adjLists.get(4).add(3);
        adjLists.get(4).add(5);
 
        
        adjLists.get(5).add(4);
         
        
        dfs_iterative(adjLists, 0);
    }
}