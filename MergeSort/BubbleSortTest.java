public class BubbleSortTest
{
    public static void main(String[] args)
    {
        int[] list = {22, 45, 12, 74, 34, 13, 65, 23, 56};
        BubbleSort.sort(list);
        for(int i: list)
        {
            System.out.println(i);
        }
    }
}