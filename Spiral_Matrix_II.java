/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * For example,
 * Given n = 3,
 *
 * You should return the following matrix:
 * [
 *	[1,2,3],
 *	[8,9,4],
 *	[7,6,5]
 * ]
 */

 public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if(n==0)	return result;

        boolean[] mark = new boolean[n*n];
        int row = 0;
        int col = 0;
        int val = 1;
        boolean flag = true;

        while(flag){
        	flag = false;
        	for(;col<n && (!mark[n*row+col]); col++){
        		flag = true;
        		result[row][col] = val++;
        		mark[n*row+col] = true;
        	}
        	col--; row++;

        	for(;row<n && (!mark[n*row+col]); row++){
        		flag = true;
        		result[row][col] = val++;
        		mark[n*row+col] = true;
        	}
        	row--; col--;

        	for(;col>=0 && (!mark[n*row+col]); col--){
        		flag = true;
        		result[row][col] = val++;
        		mark[n*row+col] = true;
        	}
        	col++;row--;

        	for(;row>=0 && (!mark[n*row+col]); row--){
        		flag = true;
        		result[row][col] = val++;
        		mark[n*row+col] = true;
        	}
        	row++; col++;
        }

        return result;
    }
}
