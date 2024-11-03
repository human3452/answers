import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String temp=br.readLine();
        int[] answer= new int[26];
        for(int i=0; i<26; i++) answer[i]--;
        for(int i=0; i<temp.length(); i++){
            if(answer[temp.charAt(i)-'a']==-1){
                answer[temp.charAt(i)-'a']=i;
            }
        }
        for(int i=0; i<26; i++) bw.write(answer[i]+" ");
        bw.flush();
        bw.close();
        br.close();
    }
}