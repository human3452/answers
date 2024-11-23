import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int max=-1;
        String maxt = "";
        outer:while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                String temp=st.nextToken();
                if(temp.equals("E-N-D")) break outer;
                StringBuilder sb=new StringBuilder();
                for(int i=0; i<temp.length(); i++){
                    char t=temp.charAt(i);
                    if((t-'a'>=0 && t-'a'<26) || t=='-'){
                        sb.append(t);
                    }else if((t-'A'>=0 && t-'A'<26)){
                        sb.append((char)(t-'A'+'a'));
                    }
                }
                String answer=sb.toString();
                if(answer.length()>max){
                    maxt=answer;
                    max=answer.length();
                }
            }
        }
        bw.write(maxt+"");
        bw.flush();
        bw.close();
        br.close();
    }
}