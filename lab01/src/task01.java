import java.util.Scanner;
public class task01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Будь ласка, введіть рядок:");
        String input = scanner.nextLine();
        scanner.close();
        System.out.println("Привіт, " + input);
    }
}
