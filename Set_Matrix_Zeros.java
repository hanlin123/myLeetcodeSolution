public class Solution {
    private static boolean[] zerosCol;
		private static boolean[] zerosRow;
    public void setZeroes(int[][] matrix) {
        if(matrix==null){
        	return;
        }

        int totalRow = matrix.length;
        int totalCol = matrix[0].length;
        zerosCol = new boolean[totalCol];
        zerosRow = new boolean[totalRow];

        for(int r=0; r<totalRow; r++){
        	for(int c=0; c<totalCol; c++){
        		if(matrix[r][c]==0){
        			//set the row to zero
        			if(!zerosRow[r]){
        				for(int i=0; i<c; i++){
        					matrix[r][i] = 0;
        				}
        				zerosRow[r] = true;
        			}

        			//set the elements in the column before the element to zero
        			if(!zerosCol[c]){
        				for(int i=0; i<r; i++){
        					matrix[i][c] = 0;
        				}
        				zerosCol[c] = true;
        			}
        		}else{
        			if(zerosCol[c] || zerosRow[r]){
        				matrix[r][c] = 0;
        			}
        		}
        	}
        }

    }
}