import java.util.Scanner;

public class QuickSort2 {
	static int partition(int a[],int left,int right){
		int pivot=a[right];
		int pIndex=left;
		for (int i=left; i<right; i++)
		{
			if(a[i]<=pivot)
			{
				int t=a[i];
				a[i]=a[pIndex];
				a[pIndex]=t;
				pIndex++;
			}
		}
		int v=a[pIndex];
		a[pIndex]=a[right];
		a[right]=v;
		return pIndex;
	}	
	static void quicksort(int a[],int left,int right){
		if(left<right){
			int p=partition(a,left,right);
			quicksort(a,left,p-1);
			quicksort(a,p+1,right);
		}
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("How many elements:");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.print("Enter elements:");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		quicksort(a,0,n-1);
		System.out.print("Sorted array: ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
	}

}
