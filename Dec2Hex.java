import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class Dec2Hex {
    public static int Arg1;
    private static final Logger logger = Logger.getLogger(Dec2Hex.class.getName());

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class Dec2Hex {
    public static int Arg1;
    private static final Logger logger = Logger.getLogger(Dec2Hex.class.getName());

    public static void main(String args[]) {
        try {
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

            char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            int rem;
            int num = Arg1;
            StringBuilder hexadecimal = new StringBuilder();

            if (logger.isLoggable(java.util.logging.Level.INFO)) {
                logger.info(String.format("Converting the Decimal Value %d to Hex...", num));
            }

            while (num != 0) {
                rem = num % 16;
                hexadecimal.insert(0, ch[rem]); // Use StringBuilder's insert method
                num = num / 16;
            }

            if (hexadecimal.length() == 0) { // Handling the case where input is 0
                hexadecimal.append("0");
            }

            if (logger.isLoggable(java.util.logging.Level.INFO)) {
                logger.info(String.format("Hexadecimal representation is: %s", hexadecimal.toString()));
            }

        } catch (Exception e) {
            logger.severe("An unexpected error occurred: " + e.getMessage());
        }
    }

    // Inner class for unit tests
    public static class Dec2HexTest {

        @Test
        public void testValidInput() {
            // Redirecting logger output for testing
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            String[] args = {"255"};
            Dec2Hex.main(args);

            String expectedOutput = "Hexadecimal representation is: FF";
            assertTrue(outContent.toString().contains(expectedOutput));
        }

        @Test
        public void testNoInput() {
            // Redirecting logger output for testing
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            String[] args = {};
            Dec2Hex.main(args);

            String expectedOutput = "Error: Please enter a Number.";
            assertTrue(outContent.toString().contains(expectedOutput));
        }

        @Test
        public void testInvalidInput() {
            // Redirecting logger output for testing
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            String[] args = {"invalid"};
            Dec2Hex.main(args);

            String expectedOutput = "Error: The input provided is not a valid integer.";
            assertTrue(outContent.toString().contains(expectedOutput));
        }

        @Test
        public void testInputZero() {
            // Redirecting logger output for testing
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            String[] args = {"0"};
            Dec2Hex.main(args);

            String expectedOutput = "Hexadecimal representation is: 0";
            assertTrue(outContent.toString().contains(expectedOutput));
        }
    }
}
