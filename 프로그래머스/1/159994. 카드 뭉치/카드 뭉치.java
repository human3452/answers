class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int p1=0, p2=0, counter=0;
        while(p1<cards1.length && p2<cards2.length && counter<goal.length){
            if(cards1[p1].equals(goal[counter])){
                p1++;
                counter++;
            }else if(cards2[p2].equals(goal[counter])){
                p2++;
                counter++;
            }else{
                return "No";
            }
        }
        if(counter==goal.length){
            return "Yes";
        }else{
            if(p1<cards1.length){
                while(counter<goal.length){
                    if(cards1[p1].equals(goal[counter])){
                        p1++;
                        counter++;
                    }else{
                        return "No";
                    }
                }
            }else{
               while(counter<goal.length){
                    if(cards2[p2].equals(goal[counter])){
                        p2++;
                        counter++;
                    }else{
                        return "No";
                    }
                } 
            }
        }
        return "Yes";
    }
}