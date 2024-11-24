import java.io.*;
import java.util.*;
public class Main {
    static HashMap<Character, Integer> toTen=new HashMap<>();
    static char[] toTS={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        String B=st.nextToken();
        int N= Integer.parseInt(st.nextToken());
        int answer=0;
        for(int i=0; i<10; i++){
            toTen.put((char) (i+'0'), i);
        }
        for(int i=0; i<26; i++){
            toTen.put((char)(i+'A'), i+10);
        }
        for(int i=0; i<B.length(); i++){
            answer+=(toTen.get(B.charAt(i)))*(int)Math.pow(N, B.length()-1-i);
        }
        System.out.println(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}