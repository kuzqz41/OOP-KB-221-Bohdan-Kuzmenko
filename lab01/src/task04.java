import java.util.Scanner;
public class task04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int numberOfStrangers = 0;
        while (numberOfStrangers <= 0)
        {
            System.out.println("Введіть кількість незнайомців більшу за 0:");
            numberOfStrangers = scanner.nextInt();
        }
        scanner.nextLine();
        System.out.println("Введіть імена незнайомців:");
        for (int i = 0; i < numberOfStrangers; i++)
        {
            String name = scanner.nextLine();
            System.out.println("Hello, " + name);
        }
        scanner.close();
    }
}