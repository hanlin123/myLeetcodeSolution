/* 
 * Given an array of strings, return all groups of strings that are anagrams.
 *
 * Note: All inputs will be in lower-case.
 */

public class Solution {
	public static class Node{
		String str;
		Node next;
		public Node(String _str){
			str = _str;
			next = null;
		}
	}
public ArrayList<String> anagrams(String[] strs) {
    ArrayList<String> results = new ArrayList<String>();
    if(strs==null || strs.length<2)	
    	return results;

    HashMap<String,Node> anagrams = new HashMap<String, Node>();
    for(String s : strs){
    	HashMap<Character, Integer> analyzer = new HashMap<Character, Integer>();
    	for(int i=0;i<s.length();i++){
    		char c = s.charAt(i);
    		if(analyzer.containsKey(c))		analyzer.put(c, analyzer.get(c)+1);
    		else													analyzer.put(c, 1);
    	}
    	Set<Character> keyset = analyzer.keySet();
    	Arrays.sort(keys);
    	Character[] keys = keyset.toArray(new Character[keyset.size()]);
    	StringBuffer strb = new StringBuffer();
    	for(char c : keys){
    		strb.append(c);
    		strb.append(analyzer.get(c));
    	}
    	putStrings(anagrams, strb.toString(), s);
    }

    Set<String> keyset = anagrams.keySet();
    String[] keys = keyset.toArray(new String[keyset.size()]);
    for(String s : keys){
    	Node node = anagrams.get(s);
    	if(node.next!=null){
    		while(node!=null){
    			results.add(node.str);
    			node = node.next;
    		}
    	}
    }
    return results;
}
private static void putStrings(HashMap<String, Node> anagrams, String key, String str){
	if(!anagrams.containsKey(key))	
		anagrams.put(key, new Node(str));
	else{
		Node node = anagrams.get(key);
		while(node.next!=null)	node = node.next;
		node.next = new Node(str);
	}
}
}