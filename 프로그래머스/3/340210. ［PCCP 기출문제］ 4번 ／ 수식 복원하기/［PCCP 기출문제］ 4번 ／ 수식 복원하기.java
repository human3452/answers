import java.util.*;
class Solution {
    public String[] solution(String[] expressions) {
        int minradix=2;
        int maxradix=9;
        String[][] parts=new String[expressions.length][5];
        for(int i=0; i<expressions.length; i++){
            parts[i]=expressions[i].split(" ");
        }
        for(int i=0; i<parts.length; i++){
            for(int j=0; j<parts[i][0].length(); j++){
                minradix=Math.max(minradix, parts[i][0].charAt(j)-'0'+1);
            }
            for(int j=0; j<parts[i][2].length(); j++){
                minradix=Math.max(minradix, parts[i][2].charAt(j)-'0'+1);
            }
            if(parts[i][4].charAt(0)!='X'){
                for(int j=0; j<parts[i][4].length(); j++){
                    minradix=Math.max(minradix, parts[i][4].charAt(j)-'0'+1);
                }
            }
        }
        boolean[] isimpossible=new boolean[maxradix-minradix+1];
        int counter=0;
        for(int i=0; i<parts.length; i++){
            if(parts[i][4].charAt(0)!='X'){
                for(int j=minradix; j<=maxradix; j++){
                    if(parts[i][1].charAt(0)=='+'){
                        if(radixtoten(Integer.parseInt(parts[i][0]), j)+radixtoten(Integer.parseInt(parts[i][2]),j)!=radixtoten(Integer.parseInt(parts[i][4]), j)){
                            isimpossible[j-minradix]=true;
                        }
                    }else{
                        if(radixtoten(Integer.parseInt(parts[i][0]), j)-radixtoten(Integer.parseInt(parts[i][2]),j)!=radixtoten(Integer.parseInt(parts[i][4]), j)){
                            isimpossible[j-minradix]=true;
                        }
                    }
                }
            }else counter++;
        }
        ArrayList<Integer> set=new ArrayList<>();
        for(int i=minradix; i<=maxradix; i++) if(!isimpossible[i-minradix]) set.add(i);
        String[] answer=new String[counter];
        counter=0;
        outer:for(int i=0; i<parts.length; i++){
            if(parts[i][4].charAt(0)=='X'){
                int temp=-1;
                if(parts[i][1].charAt(0)=='+'){
                    for(int tmp:set){
                        int tp=radixto(radixtoten(Integer.parseInt(parts[i][0]), tmp)+radixtoten(Integer.parseInt(parts[i][2]), tmp), tmp);
                        if(temp==-1){
                            temp=tp;
                        }else if(temp!=tp){
                            answer[counter++]=expressions[i].substring(0, expressions[i].length()-1)+"?";
                            continue outer;
                        }
                    }
                }else{
                    for(int tmp:set){
                        int tp=radixto(radixtoten(Integer.parseInt(parts[i][0]), tmp)-radixtoten(Integer.parseInt(parts[i][2]), tmp), tmp);
                        if(temp==-1){
                            temp=tp;
                        }else if(temp!=tp){
                            answer[counter++]=expressions[i].substring(0, expressions[i].length()-1)+"?";
                            continue outer;
                        }
                    }
                }
                answer[counter++]=expressions[i].substring(0, expressions[i].length()-1)+temp;
            }
        }
        return answer;
    }
    public int radixto(int target, int radix){
        StringBuilder sb=new StringBuilder();
        while(target>=radix){
            sb.append(target%radix);
            target/=radix;
        }
        sb.append(target);
        return Integer.parseInt(sb.reverse().toString());
    }
    public int radixtoten(int target, int radix){
        int answer=0;
        int p=1;
        while(target>0){
            answer+=(target%10)*p;
            p*=radix;
            target/=10;
        }
        return answer;
    }
}