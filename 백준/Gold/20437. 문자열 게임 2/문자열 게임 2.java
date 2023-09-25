import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        sc.nextLine();
        for (int tc = 0; tc<T; tc++){
            int min=10001;
            int max=-1;
            String str=sc.nextLine();
            int a=sc.nextInt()-1;
            ArrayList<Integer> list[]=new ArrayList[26];
            for(int i=0; i<26; i++){
                list[i]=new ArrayList<>();
            }
            for(int i=0; i<str.length(); i++){
                int temp=str.charAt(i)-'a';
                list[temp].add(i);
                if(list[temp].size()>a){
                    min=Math.min(i-list[temp].get(list[temp].size()-(a+1)), min);
                    max=Math.max(i-list[temp].get(list[temp].size()-(a+1)), max);
                }
            }
            if(min==10001) System.out.println(-1);
            else System.out.println((min+1)+" "+(max+1));
            sc.nextLine();
        }
    }
}
