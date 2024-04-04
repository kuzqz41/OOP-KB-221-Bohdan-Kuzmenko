import java.util.Scanner;
public class task07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число (0 для завершення): ");
        int val = scanner.nextInt();
        int max = val;
        while (val !=0)
        {
            System.out.print("Введіть число (0 для завершення): ");
            val = scanner.nextInt();
            if (val > max)
            {
                max = val;
            }
        }
        System.out.println("Максимальне число: " + max);
        scanner.close();
    }
}
