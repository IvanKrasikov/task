import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String str1 = args[0];
        String str2 = args[1];

        FileReader fr1 = new FileReader( str1 );
        Scanner scan1 = new Scanner(fr1);
        String[] xy = scan1.nextLine().split(" ");
        float x = Float.parseFloat(xy[0]);
        float y = Float.parseFloat(xy[1]);
        float r = Float.parseFloat(scan1.nextLine().split(" ")[0]);
        fr1.close();

        FileReader fr2 = new FileReader( str2 );
        Scanner scan2 = new Scanner(fr2);
        while (scan2.hasNextLine()){
            String[] ab = scan2.nextLine().split(" ");
            float a = Float.parseFloat(ab[0]);
            float b = Float.parseFloat(ab[1]);
            float v = (x-a) * (x-a) + (y-b) * (y-b);

            if( v  < r*r ) System.out.println(1);
            if( v == r*r ) System.out.println(0);
            if( v  > r*r ) System.out.println(2);
        }
        fr2.close();
    }
}