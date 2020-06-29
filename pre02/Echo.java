import java.util.Scanner;

public class Echo {

    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);

		System.out.print("What is your age? ");
		int age = in.nextInt();
		System.out.print("What is your name? ");
		in.nextLine();
		
		String name = in.nextLine();
		System.out.printf("Hello %s, age %04f\n", name, age*1.0);
/*
        System.out.print("Type something: ");
        line = in.nextLine();
        System.out.print("You said: " + line);  // proves in doesn't read the line break

        System.out.print("Type something else: ");
        line = in.nextLine();
        System.out.println("You also said: " + line);
*/
    }
}