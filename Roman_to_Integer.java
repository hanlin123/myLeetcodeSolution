public class Solution {
    private static HashMap<Character, Integer> map = null;
    private static void init(){
        map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
    }
    public int romanToInt(String s) {
        if(s==null || s.equals(""))     return 0;
        if(map==null)   init();
        
        int result = 0;
        int index = 0;
        int size = s.length();
        while(index<size){
            if(index==(size-1))
                result += map.get(s.charAt(index));
            else{
                int thisVal = map.get(s.charAt(index));
                int nextVal = map.get(s.charAt(index+1));
                if(thisVal<nextVal)     result -= thisVal;
                else                    result += thisVal;
            }
            index++;
        }
        return result;
    }
}