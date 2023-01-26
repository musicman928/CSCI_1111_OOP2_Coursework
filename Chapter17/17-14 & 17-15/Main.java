import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Source file path: ");
        String sourceFilePath = scanner.nextLine();
        File sourceFile = new File(sourceFilePath);

        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist");
            System.exit(1);
        }

        System.out.print("Destination file path: ");
        String destFilePath = scanner.nextLine();
        File destFile = new File(destFilePath);

        if (destFile.exists()) {
            System.out.println("File already exists");
            System.exit(2);
        }

        System.out.print("(1 = encrypt, 2 = decrypt: ");
        switch (scanner.nextInt()) {
            case 1: encrypt(sourceFile, destFile);
            case 2: decrypt(sourceFile, destFile);
        }
    }

    public static void encrypt(File in, File out) throws IOException {
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(in));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(out));

        int data;

        while ((data = input.read()) != -1) {
            output.write(data + 5);
        }
    }

    public static void decrypt(File in, File out) throws IOException {
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(in));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(out));

        int data;

        while ((data = input.read()) != -1) {
            output.write(data - 5);
        }
    }
}
