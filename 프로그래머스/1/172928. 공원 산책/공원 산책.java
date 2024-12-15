class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int[] position={0, 0};
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                if(park[i].charAt(j)=='S'){
                    position[0]=i;
                    position[1]=j;
                    break;
                }
            }
        }
        outer:for(int i=0; i<routes.length; i++){
            char direction=routes[i].charAt(0);
            int moves=routes[i].charAt(2)-'0';
            switch(direction){
                case 'N':
                    for(int j=1; j<=moves; j++){
                        if(!(position[0]-j>=0 && park[position[0]-j].charAt(position[1])!='X')){
                            continue outer;
                        }
                    }
                    position[0]-=moves;
                    break;
                case 'S':
                    for(int j=1; j<=moves; j++){
                        if(!(position[0]+j<park.length && park[position[0]+j].charAt(position[1])!='X')){
                            continue outer;
                        }
                    }
                    position[0]+=moves;
                    break;
                case 'E':
                    for(int j=1; j<=moves; j++){
                        if(!(position[1]+j<park[0].length() && park[position[0]].charAt(position[1]+j)!='X')){
                            continue outer;
                        }
                    }
                    position[1]+=moves;
                    break;
                default:
                    for(int j=1; j<=moves; j++){
                        if(!(position[1]-j>=0 && park[position[0]].charAt(position[1]-j)!='X')){
                            continue outer;
                        }
                    }
                    position[1]-=moves;
                    break;
            }
        }
        return position;
    }
}