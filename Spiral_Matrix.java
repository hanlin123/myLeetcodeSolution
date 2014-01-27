/* 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 * [
 *	[1,2,3]
 * 	[4,5,6]
 *	[7,8,9]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */

 public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0)	return result;

        int rowTotal = matrix.length;
        int colTotal = matrix[0].length;
        int row = 0;
        int col = 0;
        boolean flag = true;
        boolean[] mark = new boolean[rowTotal*colTotal];

        while(flag){
        	flag = false;
        	// go left
        	for(;col<colTotal && (!mark[row*colTotal+col]); col++){
        		flag = true;
        		result.add(matrix[row][col]);
        		mark[row*colTotal+col] = true;
        	}
        	col--;
        	row++;
        	// go down
        	for(;row<rowTotal && (!mark[row*colTotal+col]); row++){
        		flag = true;
        		result.add(matrix[row][col]);
        		mark[row*colTotal+col] = true;
        	}
        	row--;
        	col--;
        	// go left
        	for(;col>=0 && (!mark[row*colTotal+col]); col--){
        		flag = true;
        		result.add(matrix[row][col]);
        		mark[row*colTotal+col] = true;
        	}
        	col++;
        	row--;
        	// go up
        	for(;row>=0 && (!mark[row*colTotal+col]); row--){
        		flag = true;
        		result.add(matrix[row][col]);
        		mark[row*colTotal+col] = true;
        	}
        	row++;
        	col++;
        }
        return result;
    }
}