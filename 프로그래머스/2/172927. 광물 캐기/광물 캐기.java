class Solution {
    static int[] pick2;
    static String[] compressed;
    static int min=Integer.MAX_VALUE, count=0;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        pick2=picks.clone();
        for(int i=0; i<3; i++) count+=picks[i];
        compressed=new String[minerals.length/5+(minerals.length%5==0 ? 0 : 1)];
        int tasd=-1;
        for(int i=0; i<minerals.length; i+=5){
            int temp=0;
            tasd++;
            for(int j=i; j<Math.min(minerals.length, i+5); j++){
                switch(minerals[j].charAt(0)){
                    case 'd':
                        temp+=100;
                        break;
                    case 'i':
                        temp+=10;
                        break;
                    case 's':
                        temp++;
                        break;
                }
            }
            compressed[tasd]=String.format("%03d", temp);
        }
        dp(0, 0);
        return min;
    }
    public void dp(int depth, int score){
        if(depth==Math.min(compressed.length, count)){
            min=Math.min(score, min);
        }else{
            for(int i=0; i<3; i++){
                if(pick2[i]!=0){
                    int temp=calc(compressed[depth], i);
                    pick2[i]--;
                    dp(depth+1, temp+score);
                    pick2[i]++;
                }
            }   
        }
    }
    public int calc(String A, int pick){
        int answer=0;
        switch(pick){
            case 0:
                answer+=(A.charAt(0)-'0');
                answer+=(A.charAt(1)-'0');
                answer+=(A.charAt(2)-'0');
                break;
            case 1:
                answer+=(A.charAt(0)-'0')*5;
                answer+=(A.charAt(1)-'0');
                answer+=(A.charAt(2)-'0');
                break;
            case 2:
                answer+=(A.charAt(0)-'0')*25;
                answer+=(A.charAt(1)-'0')*5;
                answer+=(A.charAt(2)-'0');
                break;
        }
        return answer;
    }
}