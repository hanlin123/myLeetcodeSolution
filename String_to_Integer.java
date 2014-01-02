public class Solution {
    public int atoi(String str){
        char[] charArray = checkValidation(str);
        if(charArray==null)         return 0;
        
        boolean negativeFlag = false;
        long result = 0;
        
        for(int i=0;i<charArray.length;i++){
            int c = charArray[i];
            if(c==43)   continue;
            if(c==45){
                negativeFlag = true;
                continue;
            }
          
            result *= 10;
            result += c - 48;
            if(result>Integer.MAX_VALUE){
                if(negativeFlag)	return Integer.MIN_VALUE;
                else				return Integer.MAX_VALUE;
            } 
        }

        if(negativeFlag)    result = 0 - result;
        return (int)result;
    }
    
    private static char[] checkValidation(String str){
    	if(str==null || str.equals(""))	return null;
        char[] charArray = str.toCharArray();
        int startPoint = 0;
        int endPoint = 0;
        
        //skip leading space
        while(((int)charArray[startPoint])==32)   startPoint++;
        int c = charArray[startPoint];
        if(c!=43 && c!=45 && (c<48 || c>57))    return null;
        endPoint = startPoint + 1;
        
        // find the last digit
        while(endPoint<charArray.length && (int)charArray[endPoint]>47 && (int)charArray[endPoint]<58)   endPoint++;
        if((endPoint == (startPoint+1)) && ((int)charArray[startPoint]==43 || (int)charArray[startPoint]==45))
            return null;
        int size = endPoint - startPoint;
        char[] result = new char[size];
        System.arraycopy(charArray, startPoint, result, 0, size);
        return result;
    }
}