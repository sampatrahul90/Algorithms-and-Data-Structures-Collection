import java.util.Scanner;
public class QuickSort {
		static int partition(int a[],int left,int right){
			int i=left;
			int j=right;
			int x=a[left];
			while(i<j){
				while(i<=right&&a[i]<=x)
					i++;
				while(a[j]>x)
					j--;
				if(i<j){
					int t=a[i];
					a[i]=a[j];
					a[j]=t;
				}
			}
			int t=a[j];
			a[j]=a[left];
			a[left]=t;
			
			return j;
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
