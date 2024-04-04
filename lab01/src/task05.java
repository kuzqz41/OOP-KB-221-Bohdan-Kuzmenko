import java.util.Scanner;
public class task05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int h = scanner.nextInt();
        scanner.close();
        if (a <= b)
        {
            System.out.println("Impossible");
        }
        else
        {
            System.out.println((h - b) / (a - b));
        }
    }
}
