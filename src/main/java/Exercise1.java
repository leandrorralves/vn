import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1 {

    private static String VISUAL = "Visual";
    private static String NUTS = "Nuts";

    public static void printVisualNuts(int maxNumber) throws Exception {

        if (maxNumber < 1){
            throw new Exception("The parameter must be greater then 0 (zero)!");
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= maxNumber; i++) {
            if (i%3 == 0){
                sb.append(VISUAL);
            }
            if (i%5 == 0){
                if (sb.length() > 0)
                    sb.append(" ");
                sb.append(NUTS);
            }
            if (sb.length() == 0)
                sb.append(i);

            if (i != maxNumber)
                sb.append('\n');

            System.out.print(sb);
            sb.setLength(0);
        }
    }

    public static void main (String[] args){
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number : ");
        try {
            printVisualNuts(Integer.parseInt(reader.readLine()));
        } catch (NumberFormatException  e) {
            System.out.print("The parameter must be a number!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
