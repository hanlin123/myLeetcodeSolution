public class Solution {
    public String simplifyPath(String path) {
        if(path==null){
            return null;
        }
        
        String[] elements = path.split("/");
        String[] newPath = new String[elements.length];
        int index = 0;

        for(int i=0;i<elements.length;i++){
        	if(elements[i].equals("") || elements[i].equals(".")){
        		continue;
        	}

        	if(elements[i].equals("..")){
        		index = Math.max(0, index-1);
        	}
        	else{
        		newPath[index] = elements[i];
        		index++;
        	}
        }

        if(index==0){
        	return "/";
        }

        StringBuffer strb = new StringBuffer();
        for(int i=0; i<index; i++){
        	strb.append("/"+newPath[i]);
        }
        return strb.toString();
    }
}