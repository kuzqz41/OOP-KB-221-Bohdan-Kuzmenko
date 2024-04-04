import java.util.Scanner;
public class task09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть коефіцієнти a, b та c квадратного рівняння ax^2 + bx + c = 0:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0)
        {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
        else if (discriminant == 0)
        {
            double x1 = (-b) / (2 * a);
            System.out.println("x = " + x1);
        }
        else
        {
            System.out.println("Рівняння не має розв'язків");
        }
        scanner.close();
    }
}
