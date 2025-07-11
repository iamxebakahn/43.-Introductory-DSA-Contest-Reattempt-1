/*Maximum Prime Difference
Problem Description

In a kingdom, a mathematician named Arya was given an Array of integers, A of size N. The king challenged her to find the maximum distance between the indices of any two (not necessarily different) prime numbers in the array. If there is no prime number in the given array, return -1.

Help Arya solve this problem to prove her skill.


Problem Constraints
1 <= A.length <= 105
2 <= A[i] <= 100


Input Format
The only argument is an Integer Array, A.


Output Format
Return an Integer, denoting the maximum distance between the indices of any two prime numbers.


Example Input
Input 1:
A = [14, 2, 8, 5, 3]
Input 2:
A = [8, 4, 10, 7, 18]
Input 2:
A = [9, 12, 4]


Example Output
Output 1:
3
Output 2:
0
Input 2:
-1


Example Explanation
For Input 1:
A[1], A[3], and A[4] are prime. 


Choosing A[1] and A[1]  => distance = |1 - 1| = 0
Choosing A[1] and A[3]  => distance = |3 - 1| = 2
Choosing A[1] and A[4]  => distance = |4 - 1| = 3
Choosing A[3] and A[3]  => distance = |3 - 3| = 0
Choosing A[3] and A[4]  => distance = |4 - 3| = 1
Choosing A[4] and A[4]  => distance = |4 - 4| = 0



So the maximum distance is 3.

For Input 2:
There is only 1 prime number at A[3].  


Choosing A[3] and A[3]  => distance = |3 - 3| = 0



So the maximum distance is 3.

For Input 3:

There is no Prime number in the given array.  The answer is -1.


User Code
     */


public class Q4_Introductory_DSA_Contest_Reattempt_1 {
    public int maximumPrimeDifference(int[] A) {
        
        int count_factors=0;
        
        int[] pref_prime=new int[A.length];
        
        for (int i = 0; i < A.length; i++) 
        {
            count_factors = 0;
            
            
            for (int j = 2; j * j <= A[i]; j++) 
            {
                if (A[i] % j == 0) 
                {
                    count_factors++;
                    break; 
                }
            }

            if (A[i] >= 2 && count_factors == 0) 
            {
                pref_prime[i] = 1;
            } 
            else
            {
                pref_prime[i] = 0;
            }
        }
        
        /*
        for(int i=0;i<A.length;i++)
        {
            System.out.print(pref_prime[i]);
        }
        
        */
        int sum=0;
        for(int i=0;i<A.length;i++)
        {
         sum=sum+pref_prime[i];   
        }
        
        if(sum==0)
            return -1;
        
        if(sum==1)
            return 0;
        
        int start=0,end=A.length-1;
        
        for(int i=0;i<A.length;i++)
        {
            if(pref_prime[i]==1)
                {
                    start=i;
                    break;
                }
        }
        
        for(int j=A.length-1;j>=0;j--)
        {
            if(pref_prime[j]==1)
            {
                end=j;
                break;
            }
        }
        
        return end-start;
        
        
    }
}