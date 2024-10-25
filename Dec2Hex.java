import java.util.Scanner; 
class Dec2Hex {

    public static int Arg1;

    public static void main(String args[]) {
	//if there is no input
        if (args.length == 0) {
            System.out.println("Error: Please enter a Number.");
            return;
        }
		//if the input isnt a  valid number
        try {
            Arg1 = Integer.parseInt(args[0]);

        }
	//catch the error and display a message
		 catch (NumberFormatException e) {
            System.out.println("Error: The input provided isn't a valid number, Please enter a valid Number.");
            return;
        }

        char ch[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int rem, num;
        num = Arg1;
        String hexadecimal = "";

        System.out.println("Converting the Decimal Value " + num + " to Hex...");

        while (num != 0) {
            rem = num % 16;
            hexadecimal = ch[rem] + hexadecimal;
            num = num / 16;
        }

        System.out.println("Hexadecimal representation is: " + hexadecimal);
    }
}

 

