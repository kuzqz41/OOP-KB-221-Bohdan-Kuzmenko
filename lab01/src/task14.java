public class task14
{
    public static void main(String[] args)
    {
        int[] array = {1, 3, 2, 7, 4};
        cycleSwap(array);
        System.out.println("Масив після зсуву на 1 позицію: ");
        for (int value : array)
        {
            System.out.print(value + " ");
        }
        cycleSwap(array, 3);
        System.out.println("\nМасив після зсуву на 3 позиції: ");
        for (int value : array)
        {
            System.out.print(value + " ");
        }
    }
    public static void cycleSwap(int[] array)
    {
        int last = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--)
        {
            array[i] = array[i - 1];
        }
        array[0] = last;
    }
    public static void cycleSwap(int[] array, int x)
    {
        for (int j = 0; j < x; j++)
        {
            int last = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--)
            {
                array[i] = array[i - 1];
            }
            array[0] = last;
        }
    }
}
