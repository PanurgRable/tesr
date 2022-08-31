import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {



    static String calc(String input) throws IOException {
        String InputOperators[] = input.split(" ");
        if (InputOperators.length < 3) {
            throw  new ArrayIndexOutOfBoundsException("throws Exception // stroka ne yavlyatsa matematicheskoi operaciei");
        }
        if (InputOperators.length > 3) {
            throw  new ArrayIndexOutOfBoundsException("throws Exception // format matematicheskoi operacii ne udovletvoriaet zadaniu - " +
                    " dva operanda i odin operator (+,-,/,*");
        }

        String arrayToString2 = Arrays.toString(InputOperators);
        // System.out.println(arrayToString2);
        String arabOperand[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String romanOperand[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int numberA1 = 0;
        int numberA2 = 0;
        int ans = 0;
        int numberR2 = 0;
        int numberR1 = 0;



        // check if firstNumber is arabic
        for (int i = 0; i < arabOperand.length; i++) {
            if (arabOperand[i].equals(InputOperators[0])) {
                numberA1 = i + 1;
                //   System.out.println(numberA1 + "A1");
            }
        }
        for (int i = 0; i < arabOperand.length; i++) {
            if (arabOperand[i].equals(InputOperators[2])) {
                numberA2 = i + 1;
                //  System.out.println(numberA2 + "A2");



            }
        }


        if (numberA2 != 0 && numberA1 != 0) {
            if (InputOperators[1].equals("-")) {
                ans = numberA1 - numberA2;
                //  System.out.println(ans + "answer");
            } else if (InputOperators[1].equals("*")) {
                ans = numberA1 * numberA2;
                // System.out.println(ans + "answer");
            } else if (InputOperators[1].equals("/")) {
                ans = numberA1 / numberA2;
                // System.out.println(ans + "answer");
            } else if (InputOperators[1].equals("+")) {
                ans = numberA1 + numberA2;
                //  System.out.println(ans + "answer");
            }

        }
        // check if firstNumber is roman
        if (numberA2 == 0 || numberA1 == 0) {
            for (int i = 0; i < romanOperand.length; i++) {
                if (romanOperand[i].equals(InputOperators[0])) {
                    numberR1 = i + 1;
                    //   System.out.println(numberR1 + "R1");
                }
            }
        }
        if (numberA2 == 0 || numberA1 == 0) {
            for (int i = 0; i < romanOperand.length; i++) {
                if (romanOperand[i].equals(InputOperators[2])) {
                    numberR2 = i + 1;
                    // System.out.println(numberR2 + "R2");
                }
            }
        }
        if ((numberA2 != 0 || numberA1 != 0) && (numberR2 != 0 || numberR1 != 0)) {

            throw new IOException ("throws Exception // raznie sistemi ichisenii");

        }

        if (numberR2 != 0 && numberR1 != 0) {
            if (InputOperators[1].equals("-")) {
                ans = numberR1 - numberR2;
                if (ans < 1) {

                    throw new IOException("throws Exception // v rimskoi sisteme ischisenii net otricatelnih chisel ");

                }

                //  System.out.println(ans + "answer");
            } else if (InputOperators[1].equals("*")) {
                ans = numberR1 * numberR2;
                // System.out.println(ans + "answer");
            } else if (InputOperators[1].equals("/")) {
                ans = numberR1 / numberR2;
                // System.out.println(ans + "answer");
            } else if (InputOperators[1].equals("+")) {
                ans = numberR1 + numberR2;
                //  System.out.println(ans + "answer");


            }
            for (Roman status : Roman.values()) {
                // System.out.println(Roman.valueOf(String.valueOf(status)) + "bbb");
                // System.out.println(status.getConvert() + "bbb");
                if (Objects.equals(status.getConvert(), ans)) {
                    // System.out.println(status);
                    return status.toString();
                }
            }

        }




        return String.valueOf(ans);


    }

    public static void main(String args[]) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write  an expression");
        String input = scanner.nextLine();
        System.out.println(calc(input));
        // calc(input);

    }
    //   for (Roman status : Roman.values()) {
    // System.out.println(Roman.valueOf(String.valueOf(status)) + "bbb");
    // System.out.println(status.getConvert() + "bbb");
    //       if (Objects.equals(status.getConvert(), 3)) {
    //         System.out.println(status);
    //      }
    //}


}

