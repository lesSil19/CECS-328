import java.util.*;

public class Search
{
    static int [] a;
    static int key;
    
    public static void main (String[] Args)
    {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.print("Enter how many numbers will you like to generate.\nn = ");
        int n = in.nextInt();
        a = new int[n];
        
        int stack = 0;
        for(int i = 0; i < n; i++ )//random into array numbers
        {
            a[i] = rand.nextInt(2001) - 1000;
        }
        Arrays.sort(a);
        
        System.out.print("\n\nThe array is now sorted\n");
        
        //random key selection
        key = a[rand.nextInt(a.length)];
        System.out.print("\n\nThe key is: "+key);
        
        // linear search
        boolean keyFound = linearSearch(a, key);
        if(keyFound == true)
            System.out.print("\nKey was found using linear search.");
        else
            System.out.print("\nKey was not found using linear search.");
        
        //binary search
        boolean found = binarySearch(a ,key);
        if (found == true)
            System.out.print("\nKey was found using binary search.");
        else
            System.out.print("\nKey was not found using binary search.");
    
        //linear Search Run Time
        double start = System.nanoTime();
        for(int i = 0; i < 100; i++) 
        {
            key = a[rand.nextInt(a.length)];
            linearSearch(a, key);
        }
        double end = System.nanoTime();
        double totalTime = end - start;
        System.out.printf("\n\nThe average time to run linear search is %.4f nano seconds\n ", (totalTime/100));
        
        //binary Search Run Time
        double start2 = System.nanoTime();
        for(int i = 0; i < 100; i++) 
        {
            key = a[rand.nextInt(a.length)];
            binarySearch(a, key);
        }
        double end2 = System.nanoTime();
        double totalTime2 = end2 - start2;
        System.out.printf("The average time to run binary search is %.4f nano seconds\n", (totalTime2/100));
        
      //linear Search worst case
        double start3 = System.nanoTime();
        linearSearch(a, key);
        double end3 = System.nanoTime();
        System.out.printf("\nThe time to run one linear search is %.4f nano seconds ", (end3-start3));
        double start5 = System.nanoTime();
        linearSearch(a, 5000);
        double end5 = System.nanoTime();
        System.out.printf("\nThe worst-case run time for linear search is %.4f nano seconds\n",(end5-start5));

        //binary Search worst case 
        double start4 = System.nanoTime(); 
        binarySearch(a, key);
        double end4 = System.nanoTime();
        System.out.printf("\nThe time to run one binary search is %.4f nano seconds", (end4-start4));
        double line = (end4-start4) / Math.log(Math.pow(10,5));
        System.out.printf("\nThe run time for one line with binary search is %.4f nano seconds", line);
        
        double worstcase = (line*Math.log(Math.pow(10,15)));
        System.out.printf("\nThe worst-case run time for binary search is %.4f nano seconds ", worstcase);

    }
    static boolean linearSearch(int[] a , int key)
    {
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] == key)
                return true;
        }
        return false;
    }
    static boolean binarySearch(int[] a , int k)
    {
        int first = 0;
        int end = a.length - 1;
        
        while(first<end) 
        {
            int middle = (first + end) / 2;
            if(a[middle] == k) 
            {
                return true;
            }
            if(a[middle] < k) 
            {
                first = middle + 1;
            }
            if(a[middle] > k) 
            {
                end = middle - 1;
            }
        }
        return false;
    }
}

