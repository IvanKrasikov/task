package org.example;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        String str = args[0];//"text.txt";
        FileReader fr = new FileReader( str );
        Scanner scan = new Scanner(fr);
        ArrayList<Integer> arr = new ArrayList<>();

        while (scan.hasNextLine())
            arr.add(Integer.parseInt(scan.nextLine()));

        int[] ar = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++)
            ar[i]=arr.get(i);

        double round =  Arrays.stream(ar).sum()/ar.length;
        int z = Integer.parseInt(String.format("%.0f",round));
        int sum = 0;
        for (int i = 0; i < ar.length; i++){
            sum += Math.abs(ar[i]-z);
        }
        System.out.println(sum);
    }
}