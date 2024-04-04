import java.util.Scanner;
public class task08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        int i = 0;
        System.out.print("Введіть число (0 для завершення): ");
        int current = scanner.nextInt();
        while (current !=0)
        {
            sum += current;
            System.out.print("Введіть число (0 для завершення): ");
            current = scanner.nextInt();
            i++;
        }
        System.out.println("Середнє число = : " + (sum/i));
        scanner.close();
    }
}
