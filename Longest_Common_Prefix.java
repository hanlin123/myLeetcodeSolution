public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int size = strs.length;
        
        if(strs==null || size==0)    return result;
        if(size==1)                  return strs[0];
        
        Arrays.sort(strs);
        String benchmark = strs[size-1];
        
        for(int i=benchmark.length();i>0;i--){
            String prefix = benchmark.substring(0,i);
            boolean find = true;
            for(int j=0; j<size; j++){
                if(!strs[j].startsWith(prefix)){
                    find = false;
                    break;
                }
            }
            if(find){
                result = prefix;
                break;
            }
        }
        return result;
    }
}