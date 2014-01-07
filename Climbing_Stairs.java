public class Solution {
    public static HashMap<Integer, Integer> cache = null;
    public static void init(){
        cache = new HashMap<Integer, Integer>();
    }
    public int climbStairs(int n) {
        if(n==0)    return 1;
        if(n<0)     return 0;
        if(cache==null) init();
        
        if(cache.containsKey(n))    return cache.get(n);
        
        int result = 0;
        result += climbStairs(n-1);
        result += climbStairs(n-2);
        cache.put(n, result);
        return result;
    }
}