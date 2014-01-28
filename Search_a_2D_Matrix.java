public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null){
        	return false;
        }

        int totalRow = matrix.length;
        int totalCol = matrix[0].length;
        if(target<matrix[0][0] || target>matrix[totalRow-1][totalCol-1]){
        	return false;
        }

        int row = findRow(matrix, target, 0, totalRow-1);
        return findTarget(matrix[row], target, 0, totalCol-1);
    }
    private int findRow(int[][] matrix, int target, int start, int end){
    	if(start>end){
    		return end<0 ? start : end;
    	}
    	int mid = (start+end)/2;
    	if(target==matrix[mid][0]){
    		return mid;
    	}
    	else if(target>matrix[mid][0]){
    		return findRow(matrix, target, mid+1, end);
    	}
    	else{
    		return findRow(matrix, target, start, mid-1);
    	}
    }

    private boolean findTarget(int[] array, int target, int start, int end){
    	if(start>end){
    		return false;
    	}
    	int mid = (start+end)/2;
    	if(target==array[mid]){
    		return true;
    	}
    	else if(target>array[mid]){
    		return findTarget(array, target, mid+1, end);
    	}
    	else{
    		return findTarget(array, target, start, mid-1);
    	}
    }
}