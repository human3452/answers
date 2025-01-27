import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        ArrayList<Character> list=new ArrayList<>();
        for(int i=0; i<new_id.length(); i++) {
            char A=new_id.charAt(i);
            if(A-'A'>=0 && A-'A'<26){
                list.add((char)(A-'A'+'a'));
            }else list.add(A);
        }
        //2단계
        HashSet<Character> set=new HashSet<>();
        set.add('~');
        set.add('!');
        set.add('@');
        set.add('#');
        set.add('$');
        set.add('%');
        set.add('^');
        set.add('&');
        set.add('*');
        set.add('(');
        set.add('=');
        set.add('+');
        set.add(')');
        set.add('[');
        set.add('{');
        set.add('}');
        set.add(']');
        set.add(':');
        set.add('?');
        set.add(',');
        set.add('<');
        set.add('>');
        set.add('/');
        for(int i=0; i<list.size(); i++){
            if(set.contains(list.get(i))){
                list.remove(i);
                i--;
            }
        }
        //3단계
        boolean flag=false;
        for(int i=0; i<list.size(); i++){
            if(list.get(i)=='.'){
                if(!flag) flag=true;
                else{
                    list.remove(i);
                    i--;
                }
            }else flag=false;
        }
        //4단계
        while(list.size()>0){
            if(list.get(0)=='.') {
                list.remove(0);
                continue;
            }
            if(list.get(list.size()-1)=='.') {
                list.remove(list.size()-1);
                continue;
            }
            break;
        }
        //5단계
        if(list.size()==0) list.add('a');
        //6단계
        while(list.size()>15){
            list.remove(list.size()-1);
        }
        while(list.size()>0){
            if(list.get(list.size()-1)=='.') {
                list.remove(list.size()-1);
                continue;
            }
            break;
        }
        //7단계
        while(list.size()<3){
            list.add(list.get(list.size()-1));
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<list.size(); i++) sb.append(list.get(i));
        return sb.toString();
    }
}