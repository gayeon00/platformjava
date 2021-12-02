import java.util.Scanner;
enum StringCommand {ADD, REMOVE, CLEAN, QUIT, INVALID};
public class StringSetManager {
    static int index=0;
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] stringSet = new String[100];

        while (true){
            final StringCommand command = getCommand(scanner);
            if (command == StringCommand.QUIT){
                System.out.println("BYE!"); break;
            }
            switch (command){
                case ADD: {
                    final String str = getString(scanner);
                    add(stringSet, str);
                    break;
                }
                case REMOVE: {
                    final String str = getString(scanner);
                    remove(stringSet, str);
                    break;
                }
                case CLEAN:{
                    clear(stringSet);
                    break;
                }
                default:
                    System.out.println("Unknown Command!");
                    break;
            }
            print(stringSet);
        }
    }

    private static void print(String[] stringSet) {
        System.out.printf("Element Size: %d, Values = [",index);
        for (int i=0;i<index;++i) {
            System.out.printf("%s, ",stringSet[i]);
        }
        System.out.println("]");
    }

    private static void clear(String[] stringSet) {
        stringSet = new String[];
        index = 0;

    }



    private static void remove(String[] stringSet, String str) {
        int idx = 0;
        int i;
        for (i = 0; i < index; i++) {
            if (stringSet[i].equals(str)){
                idx = i;
                break;
            }
        }
        if (i==index)  return;

        String[] tmp = new String[index];
        System.arraycopy(stringSet, 0, tmp, 0, idx+1);
        System.arraycopy(stringSet, idx + 1, tmp, idx, index - idx);
        System.arraycopy(tmp,0,stringSet,0,tmp.length);
        index--;
    }

    private static void add(String[] stringSet, String str) {
        for (int i = 0; i < index; i++) {
            if (stringSet[i].equals(str)) return;
        }
        stringSet[index++] = str;
    }

    private static String getString(Scanner scanner) {
        return scanner.next();
    }

    private static StringCommand getCommand(Scanner scanner) {
        String str = scanner.next();
        str = str.toUpperCase();

        StringCommand stringCommand = StringCommand.INVALID;
        try {
            stringCommand = StringCommand.valueOf(str);
        } catch (IllegalArgumentException e) {}
        return stringCommand;
    }
}
