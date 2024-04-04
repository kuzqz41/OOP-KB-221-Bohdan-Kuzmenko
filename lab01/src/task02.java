import java.util.Scanner;
public class task02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Будь ласка, введіть рядок:");
        int time = scanner.nextInt();
        scanner.close();
        int hours = time / 3600;
        int minutes = (time % 3600) / 60;
        int seconds = time % 60;
        System.out.printf("%d:%d:%d", hours, minutes, seconds);
    }
}