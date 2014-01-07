public class Solution {
    public int searchInsert(int[] A, int target) {
        return recursiveSearch(A, 0, A.length-1, target);
    }
    private int recursiveSearch(int[] A, int start, int end, int target){
        if(start > end)     return start;
        int middle = (start + end)/2;
        
        if(A[middle]==target)   return middle;
        if(A[middle]<target)
            return recursiveSearch(A, middle+1, end, target);
        else
            return recursiveSearch(A, start, middle-1, target);
    }
}  