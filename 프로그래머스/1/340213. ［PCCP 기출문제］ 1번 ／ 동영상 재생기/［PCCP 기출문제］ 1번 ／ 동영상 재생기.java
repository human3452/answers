class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int o_start=Integer.parseInt(op_start.substring(0, 2))*60+Integer.parseInt(op_start.substring(3, 5));
        int o_end=Integer.parseInt(op_end.substring(0, 2))*60+Integer.parseInt(op_end.substring(3, 5));
        int poss=Integer.parseInt(pos.substring(0, 2))*60+Integer.parseInt(pos.substring(3, 5));
        int vid=Integer.parseInt(video_len.substring(0, 2))*60+Integer.parseInt(video_len.substring(3, 5));
        for(int i=0; i<commands.length; i++){
            if(poss>=o_start && poss<=o_end){
                poss=o_end;
            }
            switch(commands[i]){
                case "prev":
                    poss=Math.max(0, poss-10);
                    break;
                case "next":
                    poss=Math.min(vid, poss+10);
                    break;
            }
        }
        if(poss>=o_start && poss<=o_end){
            poss=o_end;
        }
        String ans_min=String.format("%02d",poss/60);
        String ans_sec=String.format("%02d",poss%60);
        return ans_min+":"+ans_sec;
    }
}