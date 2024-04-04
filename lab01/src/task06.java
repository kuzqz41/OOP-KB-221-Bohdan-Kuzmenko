import java.util.Scanner;
public class task06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double totalBill = 0;
        while (totalBill <= 0)
        {
            System.out.println("Введіть суму рахунку більшу за нуль:");
            totalBill = scanner.nextDouble();
        }
        int numOfFriends = 0;
        while (numOfFriends <= 0)
        {
            System.out.println("Введіть кількість друзів більшу за 0:");
            numOfFriends = scanner.nextInt();
        }
        double paymentPerFriend = (totalBill * 1.1) / numOfFriends;
        System.out.println("Кожен друг повинен заплатити: " + paymentPerFriend);
        scanner.close();
    }
}
