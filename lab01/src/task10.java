public class task10
{
    public static void main(String[] args)
    {
        int[] array = {10, 5, 7, 2, 15, 9};

        int maxValue = max(array);
        System.out.println("Максимальне значення масиву: " + maxValue);
    }
    public static int max(int[] arr)
    {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }
}