public class Solution {
    public boolean isValid(String s) {
        if(s==null || s.equals("")) return true;
        
        LinkedList<Character> stack = new LinkedList<Character>();
        int index = 0;
        int size = s.length();
        
        while(index<size){
            char c = s.charAt(index);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else{
                if(stack.size()==0)         return false;
                char paren = stack.pop();
                if(paren=='(' && c!=')')    return false;
                if(paren=='[' && c!=']')    return false;
                if(paren=='{' && c!='}')    return false;
            }
            index++;
        }
        if(stack.size()!=0)     return false;
        return true;
    }
}