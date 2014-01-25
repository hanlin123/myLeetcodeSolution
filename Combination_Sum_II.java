/*
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1,7]
 * [1,2,5]
 * [2,6]
 * [1,1,6]
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length==0)	return results;

        ArrayList<Integer> array = new ArrayList<Integer>();
        Arrays.sort(num);
        recursiveCheck(num, target, 0,array, results);
        return results;
    }
    private static void recursiveCheck(int[] candidates, int target, int pos, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> results){
    	for(int i=pos;i<candidates.length;i++){
    		int sub = target - candidates[i];
    		if(sub==0){
    			ArrayList<Integer> copy = arrayCopy(array);
    			copy.add(candidates[i]);
    			copy = sortArray(copy);
    			if(!results.contains(copy))
    				results.add(copy);
    		}else if(sub<0){
    			break;
    		}else{
    			ArrayList<Integer> copy = arrayCopy(array);
    			copy.add(candidates[i]);
    			recursiveCheck(candidates, sub, i+1,copy, results);
    		}
    	}
    }
    private static ArrayList<Integer> arrayCopy(ArrayList<Integer> src){
    	ArrayList<Integer> copy = new ArrayList<Integer>();
    	for(int i : src)	copy.add(i);
    	return copy;
    }
    private static ArrayList<Integer> sortArray(ArrayList<Integer> src){
    	Integer[] array = src.toArray(new Integer[src.size()]);
    	Arrays.sort(array);
    	ArrayList<Integer> newArray = new ArrayList<Integer>();
    	for(int i : array)	newArray.add(i);
    	return newArray;
    }
}