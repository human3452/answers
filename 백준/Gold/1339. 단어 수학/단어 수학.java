import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        sc.nextLine();
        int count=9;
        char[][] words=new char[N][8];
        for(int i=0; i<N; i++){
            String a=sc.nextLine();
            for(int j=0; j<a.length(); j++){
                words[i][j+8-a.length()]=a.charAt(j);
            }
        }
        int[] nums=new int[26];
        for(int i=0; i<8; i++){
            for(int j=0; j<N; j++){
                if(words[j][i]!=0){
                    nums[words[j][i]-65]+=Math.pow(10,7-i);
                }
            }
        }
        Arrays.sort(nums);
        int ans=0;
        for(int i=25; i>=16; i--){
            ans+=nums[i]*(i-16);
        }
        System.out.println(ans);
    }
}