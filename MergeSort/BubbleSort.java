public class BubbleSort
{
    public static void sort(int list[])
    {
        boolean sorted = false;
        int a;
        int b;
        int count = 0;
        while(!sorted)
        {
            for(int i = 0; i < list.length - 1; i++)
            {
                a = list[i];
                b = list[i + 1];
                
                if(a > b)
                {
                    list[i] = b;
                    list[i+1] = a;
                    count++;
                }
            }
            
            if(count == 0)
                sorted = true;
            count = 0;
        }
    }
}