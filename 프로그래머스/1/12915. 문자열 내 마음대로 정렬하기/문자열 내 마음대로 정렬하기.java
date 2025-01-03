import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        Arrays.sort(strings, new Comparator<String>(){
            public int compare(String o1, String o2){
                if(o1.charAt(n)==o2.charAt(n)){
                    for(int i=0; i<Math.min(o1.length(), o2.length()); i++){
                        if(o1.charAt(i)!=o2.charAt(i)) return o1.charAt(i)-o2.charAt(i);
                    }
                    return o1.length()-o2.length();
                }else return o1.charAt(n)-o2.charAt(n);
            }
        });
        return strings;
    }
}