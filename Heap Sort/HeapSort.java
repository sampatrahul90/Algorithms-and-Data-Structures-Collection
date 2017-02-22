import java.util.Scanner;

public class HeapSort {
	static void adjust(int a[], int i, int n){
		int j=i*2;
		int x=a[i];
		while(j<=n){
			if(j<n&&a[j]<a[j+1])
				j=j+1;
			if(x>a[j])
				break;
			a[j/2]=a[j];
			j=j*2;
		}
		a[j/2]=x;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("How many elements:");
		int n = sc.nextInt();
		int a[] = new int[n+1];
		System.out.print("Enter elements:");
		for(int i=1;i<=n;i++)
			a[i]=sc.nextInt();
		
		for(int i=n/2;i>=1;i--)
			adjust(a,i,n);
				
		for(int i=n;i>=2;i--){
			int t=a[i];
			a[i]=a[1];
			a[1]=t;
			adjust(a,1,i-1);
		}
		
		System.out.print("Sorted array: ");
		for(int i=1;i<=n;i++)
			System.out.print(a[i]+" ");
	}
}
