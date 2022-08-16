import java.util.Arrays;

class WorstCountingSort {  
  
int getMax(int[] a, int n) 
{  
  int max = a[0];  
  for(int i = 1; i<n; i++) 
  {  
      if(a[i] > max)  
         max = a[i]; 
      
  }  
  return max; 
}  
  
void countSort(int[] a, int n)
{  
   int[] output = new int [n+1];  
   int max = getMax(a, n);  
   System.out.print("The Maximum Element in the Array: " + max);
   int[] count = new int [max+1];
  
  for (int i = 0; i <= max; ++i)   
  {  
    count[i] = 0;
  }  
  System.out.println("");
  System.out.println("\nSet the Values of the Array to Zero: ");
 
  Arrays.stream(count).forEach(e->System.out.print(e + "\t"));
  System.out.println("");
  for (int i = 0; i < n; i++) 
  {  
    count[a[i]]++; 
    
  }

  System.out.println("");
  System.out.println("Count of each element at their "
  					+ "respective index in Count Array: ");
  Arrays.stream(count).forEach(e->System.out.print(e + "\t"));
  System.out.println("");
   for(int i = 1; i<=max; i++)   
      count[i] += count[i-1];
   System.out.println("");
   System.out.println("Store Cumulative Sum of the Elements of the Count Array: ");
   Arrays.stream(count).forEach(e->System.out.print(e + "\t"));
  
  System.out.println("");
  for (int i = n - 1; i >= 0; i--) 
  {  
    output[count[a[i]] - 1] = a[i];  
    count[a[i]]--; 
    
    System.out.println("\nPlace Element Value: " + a[i] + " at Index: " + count[a[i]]);
    Arrays.stream(output).forEach(e->System.out.print(e + "\t"));
    System.out.println("");
    
  }  
  
   for(int i = 0; i<n; i++) 
   {  
      a[i] = output[i];
   }  
}  
   
void printArray(int a[], int n)  
{  
    int i;  
    for (i = 0; i < n; i++)  
        System.out.print(a[i] + "\t");  
    	System.out.println("");
}  
  
public static void main(String args[])  
{  
    int a[] = {6,5,2,3,1,10};  
    int n = a.length;  
    WorstCountingSort wcs = new WorstCountingSort();  
    System.out.println("Before Counting Sort: "); 
    wcs.printArray(a, n); 
    System.out.println("");
    wcs.countSort(a,n);  
    System.out.println("\nAfter Counting Sort: ");  
    wcs.printArray(a, n);  
    System.out.println();  
}  
}  