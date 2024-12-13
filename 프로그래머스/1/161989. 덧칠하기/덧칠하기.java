class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int pointer=0;
        outer:while(pointer<section.length){
            int find=section[pointer]+m-1;
            if(find>=section[section.length-1]){
                answer++;
                break;
            }
            int start=pointer+1;
            int end=section.length;
            while(start<=end){
                int middle=(start+end)/2;
                if(find==section[middle]){
                    answer++;
                    pointer=middle+1;
                    continue outer;
                }else if(find>section[middle]){
                    start=middle+1;
                }else{
                    end=middle-1;
                }
            }
            pointer=start;
            answer++;
            
        }
        
        return answer;
    }
}