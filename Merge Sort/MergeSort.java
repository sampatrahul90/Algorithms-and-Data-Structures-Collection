import java.io.*;
import java.util.*;

public class MergeSort {
	
	
	public static int [] mergeSort(int [] k)
	{
	  if (k.length<=1)
	  {
		  return k;
	  }
	  int mid = k.length/2;
	  int left [] = new int[mid];
	  int right [];
	  if(k.length%2==0)
	  {
	      right = new int[mid];
	  }
	  else
	  {
	      right = new int[mid+1];
	  } 
	  
	  int result [] = new int [k.length];
	  
	  for (int i=0;i<mid;i++)
	  {
		  left[i]=k[i];
	  }
	  int x=0;
	  for (int j=mid;j<k.length;j++)
	  {   if(x<right.length)
	        {
		      right[x]=k[j];
		      x++;
	        }
	  }
	  
	  left = mergeSort(left);
	  right = mergeSort(right);
	  
	  result= merge(left,right);
	  
	  
	  return result;
	  }
	
	
	public static int [] merge(int [] mleft, int [] mright)
	{
		int resultlength = mleft.length + mright.length;
		int result [] = new int [resultlength];
		int indexL=0,indexR=0,indexResult=0;
		while (indexL<mleft.length || indexR<mright.length)
		{
			if(indexL<mleft.length && indexR<mright.length)
			{
			    if(mleft[indexL]<=mright[indexR])
			    {
			    	result[indexResult]=mleft[indexL];
			    	indexL++;
			    	indexResult++;
			    	
			    }
			    else
			    {
			    	result[indexResult]=mright[indexR];
				    indexR++;
				    indexResult++;
				}
		    }
			else if(indexL<mleft.length)
			     {
				   result[indexResult]=mleft[indexL];
				   indexL++;
				   indexResult++;
	             }
			
			else if(indexR<mright.length)
		         {
				   result[indexResult]=mright[indexR];
			       indexR++;
			       indexResult++;
			     }
		}
		return result;
		
	}
	
	public static void main(String[] args)
	{
	 int a[]= {33,5,6,12,1,7,9};
	 System.out.println("Array before sorting : " +Arrays.toString(a));
	 a = mergeSort(a);
	 System.out.println("Array after sorting : " +Arrays.toString(a));
    }
	
}