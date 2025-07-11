/*Problem Description

You are working on a project to analyze profit for a given set of days. You have been given an array A with profit for N days. You also have Q queries represented by a 2D array B of size Qx2. Each query consists of two integers B[i][0] and B[i][1].

For every query, your task is to find the count of non-negative profit in the range from A[B[i][0]] to A[B[i][1]].


Problem Constraints
|A| = N
|B| = Q
1 <= N, Q <= 105
-109 <= A[i] <= 109
0 <= B[i][0] <= B[i][1] <= N - 1


Input Format
First arguemnt A, is an array
Second argument B, is a matrix


Output Format
Return an array.


Example Input
Input 1:
A = [1, -1, 0]
B = [[0, 2],
    [1, 2]]
Input 2:
A = [-1, -2]
B = [[0, 0],
    [1, 1]]


Example Output
Output 1:
[2, 1]
Output 2:
[0, 0]


Example Explanation
For Input 1:
Consider 0-based indexing:
Number of non-negative elements from [0, 2] is 2.
Number of non-negative elements from [1, 2] is 1.
For Input 2:
Number of non-negative elements from [0, 0] is 0.
Number of non-negative elements from [1, 1] is 0.


User Code */

public class Q3_Introductory_DSA_Contest_Reattempt_1 {
    public int[] solve(int[] A, int[][] B) {
        
        int[] pref_pprof=new int[A.length];
        
        if(A[0]>=0)
            pref_pprof[0]=1;
        else
            pref_pprof[0]=0;
            
        for(int i=1;i<A.length;i++)
        {
            if(A[i]>=0)
                pref_pprof[i]=pref_pprof[i-1]+1;
            else
                pref_pprof[i]=pref_pprof[i-1];
        }
        
        int[] ans=new int[B.length];
        
        for(int i=0;i<B.length;i++)
        {
            int L=B[i][0];
            int R=B[i][1];
            
            if(L==0)
                ans[i]=pref_pprof[R];
                
            else
                ans[i]=pref_pprof[R]-pref_pprof[L-1];
                
        }
        
        return ans;
        
    }
}
 