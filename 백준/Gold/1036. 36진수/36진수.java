import java.io.*;
import java.util.*;
public class Main {
    static HashMap<Character, Integer> toTen=new HashMap<>();
    static char[] toTS={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        long[][] radix=new long[36][50];
        for(int i=0; i<10; i++){
            toTen.put((char) (i+'0'), i);
        }
        for(int i=0; i<26; i++){
            toTen.put((char)(i+'A'), i+10);
        }
        PriorityQueue<String> pq=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()) {
                    for(int i=0; i<o1.length(); i++){
                        if(o1.charAt(i)!= o2.charAt(i)) return o2.charAt(i)-o1.charAt(i);
                    }
                    return 0;
                }
                return o2.length()-o1.length();
            }
        });
        String tmp="0";
        for(int i=0; i<N; i++){
            String temp=br.readLine();
            for(int j=0; j<temp.length(); j++){
                radix[toTen.get(temp.charAt(j))][temp.length()-1-j]++;
            }
            tmp=plus(temp, tmp);
        }
        for(int i=0; i<35; i++){
            String answer="0";
            StringBuilder sb=new StringBuilder();
            sb.append(toTS[35-i]);
            for(int j=0; j<radix[i][0]; j++){
                answer=plus(answer, sb.toString());
            }
            for(int j=1; j<50; j++){
                sb.append('0');
                for(int k=0; k<radix[i][j]; k++){
                    answer=plus(answer, sb.toString());
                }
            }
            pq.add(answer);
        }
        int num= Integer.parseInt(br.readLine());
        pq.add("0");
        for(int i=0; i<num; i++) {
            tmp=plus(tmp, pq.poll());
        }
        System.out.println(tmp);
        bw.flush();
        bw.close();
        br.close();
    }
    static String plus(String A, String B){
        StringBuilder sb=new StringBuilder();
        int Apointer=A.length()-1;
        int Bpointer=B.length()-1;
        boolean upper=false;
        while(Apointer>=0 && Bpointer>=0){
            int number=toTen.get(A.charAt(Apointer))+toTen.get(B.charAt(Bpointer));
            if(upper){
                number++;
            }
            if(number>=36){
                upper=true;
                number-=36;
            }else{
                upper=false;
            }
            sb.append(toTS[number]);
            Apointer--;
            Bpointer--;
        }
        if(Apointer<0 && Bpointer<0){
            if(upper){
                sb.append(1);
            }
        }else if(Apointer>=0){
            if(upper){
                while(Apointer>=0 && A.charAt(Apointer)=='Z'){
                    sb.append(0);
                    Apointer--;
                }
                if(Apointer>=0){
                    sb.append(toTS[toTen.get(A.charAt(Apointer))+1]);
                    Apointer--;
                }else{
                    if(A.charAt(0)=='Z') sb.append(1);
                }
                while(Apointer>=0){
                    sb.append(A.charAt(Apointer));
                    Apointer--;
                }
            }else{
                while(Apointer>=0){
                    sb.append(A.charAt(Apointer));
                    Apointer--;
                }
            }
        }else {
            while (Bpointer >= 0) {
                if (upper) {
                    while (Bpointer >= 0 && B.charAt(Bpointer) == 'Z') {
                        sb.append(0);
                        Bpointer--;
                    }
                    if (Bpointer >= 0) {
                        sb.append(toTS[toTen.get(B.charAt(Bpointer)) + 1]);
                        Bpointer--;
                    }else{
                        if(B.charAt(0)=='Z') sb.append(1);
                    }
                    while (Bpointer >= 0) {
                        sb.append(B.charAt(Bpointer));
                        Bpointer--;
                    }
                } else {
                    while (Bpointer >= 0) {
                        sb.append(B.charAt(Bpointer));
                        Bpointer--;
                    }
                }
            }
        }
        return sb.reverse().toString();
    }
}