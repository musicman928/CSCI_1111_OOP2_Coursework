import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("Exercise17_03.dat");
        DataOutputStream out = new DataOutputStream(new FileOutputStream(file, true));
        Random randy = new Random();
        for (int i = 0; i < 100; i++) {
            out.writeInt(randy.nextInt(100));
            out.writeChars(" ");
        }

        DataInputStream in = new DataInputStream(new FileInputStream(file));
        try {
            do {
                System.out.println(in.readInt());
            } while (in.readChar() == ' ');
        } catch (Exception ignored) {}

    }
}
