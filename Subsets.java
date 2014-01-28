public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(S==null || S.length==0){
        	return results;
        }
        
        Arrays.sort(S);
        ArrayList<Integer> path = new ArrayList<Integer>();
        results.add(path);
        subsetsHelper(S, 0, path, results);
        return results;
    }
    private void subsetsHelper(int[] S, int index, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> results){
    	if(index==S.length){
    		return;
    	}
    	for(int i=index; i<S.length; i++){
    		path.add(S[i]);
    		results.add(new ArrayList<Integer>(path));
    		subsetsHelper(S, i+1, path, results);
    		path.remove(path.size()-1);
    	}
    	return;
    }
}