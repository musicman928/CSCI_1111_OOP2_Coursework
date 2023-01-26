public class EtcFunctions {
    public static void reverseDisplay(String value) {
        if (value.length() != 1) {
            System.out.print(value.substring(value.length() - 1));
            reverseDisplay(value.substring(0, value.length() - 1));
        }else {
            System.out.print(value);
        }
    }
}
