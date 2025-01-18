import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0; i<elements.length; i++) set.add(elements[i]);
        int start=elements.length-1;
        int end=-1;
        int num=elements[start];
        set.add(num);
        for(int i=1; i<elements.length; i++){
            end++;
            num+=elements[end%elements.length];
            for(int j=0; j<elements.length; j++){
                num-=elements[start%elements.length];
                start++;
                end++;
                num+=elements[end%elements.length];
                set.add(num);
            }
        }
        return set.size();
    }
}