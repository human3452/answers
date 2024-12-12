class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int time=0;
        int maxhealth=health;
        for(int i=0; i<attacks.length; i++){
            health=Math.min(maxhealth, bandage[2]*((attacks[i][0]-time-1)/bandage[0])+health);
            health=Math.min(maxhealth, (attacks[i][0]-time-1)*bandage[1]+health);
            health-=attacks[i][1];
            if(health<=0){
                return -1;
            }
            time=attacks[i][0];
        }
        answer=health;
        return answer;
    }
}