public class Solution {
    private static HashMap<Integer, Integer> mark;
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	
        int totalRow = obstacleGrid.length;
        int totalCol = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[totalRow-1][totalCol-1]==1){
            return 0;
        }
        
        mark = new HashMap<Integer, Integer>();
        uniquePathsHelper(obstacleGrid, 0, 0);
        return mark.get(0);
    }
    private static int uniquePathsHelper(int[][] grids, int row, int col){
        int totalRow = grids.length;
        int totalCol = grids[0].length;
        int index = row*totalCol+col;
        int numPath = 0;
        
        if(grids[row][col]==1){
            mark.put(index, 0);
            return 0;
        }
        
        if(row==totalRow-1 && col==totalCol-1){
            mark.put(index, 1);
            return 1;
        }
        
        if(row!=totalRow-1){
            int nextIndex = index + totalCol;
            if(mark.containsKey(nextIndex)){
                numPath += mark.get(nextIndex);
            }else{
                numPath += uniquePathsHelper(grids, row+1, col);
            }
        }
        if(col!=totalCol-1){
            int nextIndex = index + 1;
            if(mark.containsKey(nextIndex)){
                numPath += mark.get(nextIndex);
            }else{
            	numPath += uniquePathsHelper(grids, row, col+1);
            }
        }
        
        mark.put(index, numPath);
        return numPath;
    }
}