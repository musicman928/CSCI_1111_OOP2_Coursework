import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        File testy = new File("testy.txt");
        PrintWriter out = new PrintWriter(new FileOutputStream(testy, true));
        FileInputStream in = new FileInputStream(testy);

        for (int i = 0; i < 100; i++) {
            Random randy = new Random();

            out.append(Integer.toString(randy.nextInt()));
            out.append(" ");

            System.out.println((char) in.read());
        }

        out.close();
        in.close();



    }
}
