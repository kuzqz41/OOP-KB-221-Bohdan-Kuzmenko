public class task11
{
    public static void main(String[] args)
    {
        int[] array = {10, 5, 7, 2, 15, 9};
        int sumOfEven = sumdbl(array);
        System.out.println("Сума парних чисел масиву: " + sumOfEven);
    }
    public static int sumdbl(int[] arr)
    {
        int sum = 0;
        for (int x : arr)
        {
            if (x % 2 == 0)
            {
                sum += x;
            }
        }
        return sum;
    }
}