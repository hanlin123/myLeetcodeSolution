public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || word ==null){
            return false;
        }

        int index = 0;
        int totalRow = board.length;
        int totalCol = board[0].length;
        boolean[] mark = null;

        // search the beginning of the word
        for(int r=0; r<totalRow; r++){
            for(int c=0; c<totalCol; c++){

                // find the first letter
                if(board[r][c]==word.charAt(index)){
                    mark = new boolean[totalCol * totalRow];
                    mark[r*totalCol+c] = true;
                    boolean result = existHelper(board, word, index+1, r, c, mark);
                    if(result){
                        return true;
                    }
                }
            }
        }

        // cannot find the first letter
        return false;
    }
    private boolean existHelper(char[][] board, String word, int index, int row, int col, boolean[] mark){
        if(index>= word.length()){
            return true;
        }
        int totalRow = board.length;
        int totalCol = board[0].length;
        char c = word.charAt(index);
        // look around
        if(row>0){
            int markIndex = totalCol*(row-1)+col;
            if(!mark[markIndex] && board[row-1][col]==c){
                mark[markIndex] = true;
                boolean result = existHelper(board, word, index+1, row-1, col, mark);
                if(result){
                    return true;
                }else{
                    mark[markIndex] = false;
                }
            }
        }

        if(row<totalRow-1){
            int markIndex = totalCol*(row+1)+col;
            if(!mark[markIndex] && board[row+1][col]==c){
                mark[markIndex] = true;
                boolean result = existHelper(board, word, index+1, row+1, col, mark);
                if(result){
                    return true;
                }else{
                    mark[markIndex] = false;
                }
            }
        }

        if(col>0){
            int markIndex = totalCol*row+col-1;
            if(!mark[markIndex] && board[row][col-1]==c){
                mark[markIndex] = true;
                boolean result = existHelper(board, word, index+1, row, col-1, mark);
                if(result){
                    return true;
                }else{
                    mark[markIndex] = false;
                }
            }
        }

        if(col<totalCol-1){
            int markIndex = totalCol*row+col+1;
            if(!mark[markIndex] && board[row][col+1]==c){
                mark[markIndex] = true;
                boolean result = existHelper(board, word, index+1, row, col+1, mark);
                if(result){
                    return true;
                }else{
                    mark[markIndex] = false;
                }
            }
        }

        return false;
    }
}