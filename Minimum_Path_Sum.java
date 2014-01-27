public class Solution {
    private static HashMap<Integer, Integer> record;
    
    public int minPathSum(int[][] grid) {
        record = new HashMap<Integer, Integer>();
        return minPathHelper(grid, 0, 0);
    }
    private int minPathHelper(int[][] grid, int row, int col){
        int totalRow = grid.length;
        int totalCol = grid[0].length;
        int index = row*totalCol + col;
        
        if(row==totalRow-1 && col==totalCol-1){
            record.put(index, grid[row][col]);
            return grid[row][col];
        }
        
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(row!=totalRow-1){
            int nextIndex = index + totalCol;
            if(record.containsKey(nextIndex)){
                down = record.get(nextIndex);
            }else{
                down = minPathHelper(grid, row+1, col);
            }
        }
        if(col!=totalCol-1){
            int nextIndex = index+1;
            if(record.containsKey(nextIndex)){
                right = record.get(nextIndex);
            }else{
                right = minPathHelper(grid, row, col+1);
            }
        }
        int min = grid[row][col] + Math.min(down, right);
        record.put(index, min);
        return min;
    }
}