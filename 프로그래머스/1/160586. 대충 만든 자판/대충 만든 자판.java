class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] smallest=new int[26];
        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                if(smallest[keymap[i].charAt(j)-'A']==0){
                    smallest[keymap[i].charAt(j)-'A']=j+1;
                }else{
                    smallest[keymap[i].charAt(j)-'A']=Math.min(j+1, smallest[keymap[i].charAt(j)-'A']);
                }
            }
        }
        for(int i=0; i<targets.length; i++){
            for(int j=0; j<targets[i].length(); j++){
                if(smallest[targets[i].charAt(j)-'A']==0){
                    answer[i]=-1;
                    break;
                }
                answer[i]+=smallest[targets[i].charAt(j)-'A'];
            }
        }
        return answer;
    }
}