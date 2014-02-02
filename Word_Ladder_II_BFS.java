public class Solution {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
 			if(start==null || end==null || dict==null){
 				return results;
 			} 

 		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
 		LinkedList<String> queue = new LinkedList<String>();
 		queue.offer(start);
 		dict.add(end);

 		while(queue.size()!=0){
 			LinkedList<String> newQueue = new LinkedList<String>();
 			while(queue.size()!=0){
 				String str = queue.poll();

 				if(str.equals(end)){
 					ArrayList<String> path = new ArrayList<String>();
 					path.add(str);
 					findAllResults(str, start, map, path, results);
 					return results;
 				}

 				// search for the next ladder
 				char[] charArray = str.toCharArray();
 				for(int i=0;i<str.length();i++){
    			char oldChar = charArray[i];
    			for(char c='a';c<='z';c++){
    				if(c==oldChar){
    					continue;
    				}
    				charArray[i] = c;
    				String newString = String.valueOf(charArray);
    				if(dict.contains(newString)){
    					if(!map.containsKey(newString)){
    						newQueue.offer(newString);
    						map.put(newString, new ArrayList<String>());
    					}
    					map.get(newString).add(str);
    				}
    			}
    			charArray[i] = oldChar;
    		}
 			}

 			if(newQueue.size()!=0){
 				for(String s : newQueue){
 					dict.remove(s);
 				}
 			}
 			queue = newQueue;
 		}

 		return results;
	}

	private void findAllResults(String str, String start, HashMap<String, ArrayList<String>> map, 
		ArrayList<String> path, ArrayList<ArrayList<String>> results){
		if(str.equals(start)){
			results.add(new ArrayList<String>(path));
			return;
		}

		ArrayList<String> array = map.get(str);
		for(String s : array){
			path.add(0, s);
			findAllResults(s, start, map, path, results);
			path.remove(0);
		}
	}
}