import java.util.logging.Logger;

class Dec2Hex {
    public static int Arg1;
    private static final Logger logger = Logger.getLogger(Dec2Hex.class.getName());

    public static void main(String args[]) {
        if (args.length == 0) {
            logger.severe("Error: Please enter a Number.");
            return;
        }
        try {
            Arg1 = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            logger.severe("Error: The input provided is not a valid integer. Please enter a valid integer.");
            return;
        }

        char ch[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int rem, num;
        num = Arg1;
        String hexadecimal = "";

        logger.info("Converting the Decimal Value " + num + " to Hex...");

        while (num != 0) {
            rem = num % 16;
            hexadecimal = ch[rem] + hexadecimal;
            num = num / 16;
        }

        logger.info("Hexadecimal representation is: " + hexadecimal);
    }
}
