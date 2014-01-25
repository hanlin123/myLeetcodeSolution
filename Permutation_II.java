/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
      ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
     	if(num==null || num.length==0)	return results;

     	Arrays.sort(num);
     	boolean[] mark = new boolean[num.length];
     	ArrayList<Integer> array = new ArrayList<Integer>();
     	recursiveBuild(num, mark, array, results);
     	return results; 
    }
    private static void recursiveBuild(int[] num, boolean[] mark, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> results){
    	boolean allMarked = true;
    	for(int i=0;i<mark.length;i++){
    		if(mark[i]==false){
    			if(i!=0 && num[i]==num[i-1] && mark[i]==mark[i-1])	continue;
    			allMarked = false;
    			ArrayList<Integer> copy = arrayCopy(array);
    			copy.add(num[i]);
    			mark[i] = true;
    			recursiveBuild(num, mark, copy, results);
    			mark[i] = false;
    		}
    	}
    	if(allMarked){
    		results.add(array);
    	}
    }
    private static ArrayList<Integer> arrayCopy(ArrayList<Integer> src){
    	ArrayList<Integer> copy = new ArrayList<Integer>();
    	for(int i : src)	copy.add(i);
    	return copy;
    }
}