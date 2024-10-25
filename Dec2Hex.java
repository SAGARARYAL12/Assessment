import java.util.logging.Logger;

class Dec2Hex {
    public static int Arg1;
    private static final Logger logger = Logger.getLogger(Dec2Hex.class.getName());

    public static void main(String args[]) {
        if (args.length == 0) {
            logger.severe("Error: Please enter a Number.");
            return;
        }
        
        if (!isInteger(args[0])) {
            logger.severe("Error: The input provided is not a valid integer. Please enter a valid integer.");
            return;
        }

        Arg1 = Integer.parseInt(args[0]);
        String hexadecimal = convertToHex(Arg1);
        logger.info(String.format("Hexadecimal representation is: %s", hexadecimal));
    }

    public static String convertToHex(int num) {
        char ch[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder hexadecimal = new StringBuilder();

        while (num != 0) {
            int rem = num % 16;
            hexadecimal.insert(0, ch[rem]);
            num = num / 16;
        }

        return hexadecimal.toString();
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
