import java.util.ArrayList;
//import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //int m = sc.nextInt();
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        ArrayList<Integer> a = new ArrayList();
        for(int i = 0; i < n; i++) a.add(i+1);

        int x = 0;
        ArrayList<Integer> z = new ArrayList();
        do{
            z.add(a.get(0));
            for(int i = 0; i < m-1; i++) a.remove(0);
            while(a.size()<m){
                x++;
                a.add(x);
                if(x==n) x = 0;
            }
        }while (!( a.get(a.size()-1) == 1));
        z.add(a.get(0));
        System.out.println(z);
    }
}