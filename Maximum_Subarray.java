public class Solution {
    public int maxSubArray(int[] A) {
        if(A==null || A.length==0)  return 0;
        
        int max = A[0];
        int localMax = max;
        int index = 1;
        while(index<A.length){
            if(localMax<0 && A[index]>localMax)	{localMax = A[index];max = localMax;}
            else if(localMax>=0){
            	int tmp = localMax + A[index];
            	localMax = tmp>0 ? tmp : localMax;
            	max = localMax>max ? localMax : max;
            	if(tmp<=0)	localMax = 0;
            }
            index++;
        }
        return max;
    }
}