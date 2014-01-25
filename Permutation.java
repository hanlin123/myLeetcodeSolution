/*
 * Given a collection of numbers, return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
     	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
     	if(num==null || num.length==0)	return results;

     	boolean[] mark = new boolean[num.length];
     	ArrayList<Integer> array = new ArrayList<Integer>();
     	recursiveBuild(num, mark, array, results);
     	return results;
    }
    private static void recursiveBuild(int[] num, boolean[] mark, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> results){
    	boolean allMarked = true;
    	for(int i=0;i<mark.length;i++){
    		if(mark[i]==false){
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