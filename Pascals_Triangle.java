public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        recursiveBuild(array, numRows);
        return array;
    }
    private static void recursiveBuild(ArrayList<ArrayList<Integer>> array, int num){
        if(num<1)   return;
        if(array.size()==0){
            ArrayList<Integer> newRow = new ArrayList<Integer>();
            newRow.add(1);
            array.add(newRow);
            recursiveBuild(array, num-1);
            return;
        }
        ArrayList<Integer> last = array.get(array.size()-1);
        ArrayList<Integer> newRow = new ArrayList<Integer>();
        
        int num1 = 0;
        for(int i : last){
            newRow.add(num1+i);
            num1 = i;
        }
        newRow.add(num1);
        array.add(newRow);
        recursiveBuild(array, num-1);
    }
}