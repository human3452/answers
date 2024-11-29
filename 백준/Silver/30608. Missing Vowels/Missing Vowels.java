import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s=br.readLine();
        HashSet<Character> vowel=new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');
        vowel.add('y');
        vowel.add('Y');
        String l=br.readLine();
        int pointerA=0;
        int pointerB=0;
        boolean flag=true;
        while(pointerA<s.length() && pointerB<l.length()){
            int A, B;
            A=num(s, pointerA);
            B=num(l, pointerB);
            if(A==B){
                pointerA++;
                pointerB++;
            }else{
                if(vowel.contains(l.charAt(pointerB))){
                    pointerB++;
                }else{
                    flag=false;
                    break;
                }
            }
        }
        if(pointerA!=s.length()) flag=false;
        while(pointerB<l.length()){
            if(!vowel.contains(l.charAt(pointerB))){
                flag=false;
                break;
            }
            pointerB++;
        }
        if(flag){
            bw.write("Same");
        }else{
            bw.write("Different");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int num(String A, int ch){
        if(A.charAt(ch)-'A'>=0 && A.charAt(ch)-'A'<26){
            return A.charAt(ch)-'A';
        }else if(A.charAt(ch)-'a'>=0 && A.charAt(ch)-'a'<26){
            return A.charAt(ch)-'a';
        }else{
            return A.charAt(ch);
        }
    }
}
