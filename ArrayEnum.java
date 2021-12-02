import java.util.Locale;
import java.util.Scanner;

enum Command {ADD, LIST, SUM, MAX, MIN, QUIT,INVALID}
public class ArrayEnum {
    public static void main(String[] args) {
        int[] values = new int[100];
        int index=0;
        final Scanner scanner = new Scanner(System.in);

        while (true){
            final Command command = getCommand(scanner);
            if (command == Command.QUIT){
                System.out.println("Bye!");
                break;
            }


            switch (command){
                case ADD:
                    final int newValue = getValue(scanner);
                    values[index] = newValue;
                    index++;
                    break;
                case LIST:
                    printList(values,index);
                    break;
                case SUM:
                    System.out.println(getSum(values,index));
                    break;
                case MAX:
                    System.out.println(getMax(values,index));
                    break;
                case MIN:
                    System.out.println(getMin(values,index));
                    break;
                case INVALID:
                    break;
            }

        }
        scanner.close();
    }

    private static int getMin(int[] values, int index) {
        int min = 10000;
        for (int i=0;i<index;++i){
            if(min>values[i]) min = values[i];
        }
        return min;
    }

    private static int getMax(int[] values, int index) {
        int max = 0;
        for (int i=0;i<index;++i){
            if(max<values[i]) max = values[i];
        }
        return max;
    }

    private static int getSum(int[] values, int index) {
        int sum=0;

        for (int i=0;i<index;++i){
            sum+= values[i];
        }
        return sum;
    }

    private static void printList(int[] values, int index) {
        for (int i=0;i<index;++i){
            System.out.printf("%d ",values[i]);
        }
        System.out.println();
    }

    private static int getValue(Scanner scanner) {
        return scanner.nextInt();
    }

    private static Command getCommand(Scanner scanner) {
        final String commandName = scanner.next();

        Command command = Command.INVALID;
        try {
            command = Command.valueOf(commandName.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Command");
        }

        return command;
    }
}
