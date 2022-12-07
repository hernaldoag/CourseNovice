package guidebook;

public class StringReverse {
    public static void main(String args[]) {

        String str = "Hernald0";

        String reverse = new StringBuffer(str).reverse().toString();

        System.out.printf("Actual Word: %s, Word after reversing %s", str, reverse);

        String reversed = str;

        System.out.println("Using the function " + reverse(reversed));

    }

    public static String reverse(String source) {

        if (source == null || source.isEmpty()) {

            return source;

        }

        String reverse = "";

        for (int i = source.length() - 1; i >= 0; i--) {

            reverse = reverse + source.charAt(i);

        }

        return reverse;

    }
}
