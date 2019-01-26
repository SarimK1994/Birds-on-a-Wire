/***************************************************************************************************
 * 																								   * 
 * 		Program Filename:	Khan09C.Java                                                           *
 * 		Author:				Sarim Khan								     		     			   *
 * 		Date Written:		October 9, 2017                                                        *
 * 		Purpose:			To approximate birds on a wire                                         *
 * 		Input From:			Keyboard													   	       *
 * 		Output to:			Screen													        	   *
 * 																							       *
 **************************************************************************************************/

import java.util.Random; 
import java.util.Scanner;  

public class Khan09C
{
   public static void main(String[] args) 
   {
      int n, m, i; 
      int j = 1; 
      Scanner Keyboard = new Scanner(System.in); 
      Random generator = new Random(); 
      double[] wireArray; 
      int[] checkPad; 
      double total; 
      double sum = 0; 
      double totalAverage = 0;
      int count = 0; 
      
      System.out.println("Please enter the number of iterations you would like to perform: "); 
      m = Keyboard.nextInt(); 
      System.out.println("Please enter the number of birds and size of wire you would like: "); 
      n = Keyboard.nextInt();  
      
      while (j <= m) 
      {  
      
         checkPad = new int[n+1]; 
         for (i = 1; i<n; i++);
         {
            checkPad[i] = 0; 
         }
         wireArray = new double[n+1]; 
         double A; 
         
         for(i = 1; i<=n; i++)
         {
            A = n*generator.nextDouble(); 
            wireArray[i] = A; 
         }
         
         QuickSort(wireArray, 1, n); 
         
         total = wireArray[2] - wireArray[1]; 
         total += wireArray[n] - wireArray[n-1]; 
         checkPad[1] = 1;
         
         for(i = 2; i<n; i++)
         {
            if(wireArray[i] - wireArray[i-1] < wireArray[i+1] - wireArray[i] && checkPad[i-1] != 1)
            {
               total += wireArray[i] - wireArray[i-1];  
            }
            else if(wireArray[i+1] - wireArray[i] < wireArray[i] - wireArray[i-1])
            {
               total += wireArray[i+1] - wireArray[i];
               checkPad[i] = 1; 
            }
         }   
         
         sum += total/n; 
         j++;
      }   
         //end for iterations
         
         totalAverage = sum/m;  
         System.out.println(totalAverage); 
   }    
      //end main  

public static void QuickSort(double A[], int Left, int Right)
{
   double v, temp;
   int i, j;

   if (Left >= Right)
      return;
   // end if

   v = A[Right];
   i = Left;
   j = Right-1;

   for (;;)
   {
      while (A[i] < v)
         i++;
      // end while

      while (j > Left && A[j] > v)
         j--;
      // end while

      if (i >= j)
         break;
      // end if

      temp = A[i];
      A[i] = A[j];
      A[j] = temp;
      i++;
      j--;
   }
   // end for

   temp     = A[i];
   A[i]     = A[Right];
   A[Right] = temp;

   if (Left < i-1)
      QuickSort(A, Left, i-1);
   // end if
   if (Right > i+1)
      QuickSort(A, i+1, Right);
   // end if
}
// end method QuickSort
}
// end class QuickSort
