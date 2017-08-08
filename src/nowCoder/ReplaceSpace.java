package nowCoder;

public class ReplaceSpace {
	public String replaceSpace(StringBuffer str) {
    	int spaceNum = 0;
        int len = str.length();
        for(int i=0;i<len;i++) {
            if(str.charAt(i)==' ')
                spaceNum++;
        }
        int newLen = len+2*spaceNum;
        int oldIndex = len-1;
        int newIndex = newLen-1;
        str.setLength(newLen);
        while(oldIndex>=0) {
            if(str.charAt(oldIndex)==' ') {
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');//从后往前
            } else {
                str.setCharAt(newIndex--,str.charAt(oldIndex));
            }
            oldIndex--;
        }
        return str.toString();
    }
}
