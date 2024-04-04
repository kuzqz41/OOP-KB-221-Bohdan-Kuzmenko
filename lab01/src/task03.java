import java.util.Scanner;
public class task03
{
    private static final int password = 12345;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть пароль:");
        int userInput = scanner.nextInt();
        if (userInput == password)
        {
            System.out.println("Hello, Agent");
        }
        else
        {
            System.out.println("Access denied");
        }
        scanner.close();
    }
}
