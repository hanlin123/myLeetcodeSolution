public class Solution {
    public static HashMap<String, Integer> cache = null;
	public static void init(){
		cache = new HashMap<String, Integer>();
	}
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1)    return 1;
        if(cache==null)	init();
        
        String key = Integer.toString(m)+"/"+Integer.toString(n);
        if(cache.containsKey(key))	return cache.get(key);
        
        int result = 0;
        if(m>1) result += uniquePaths(m-1, n);
        if(n>1) result += uniquePaths(m, n-1);
        cache.put(key, result);
        return result;
    }
}