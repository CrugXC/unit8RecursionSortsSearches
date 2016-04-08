import java.util.Random;
public class TheBestSort
{
    public static void sort(int[] list)
    {
        int errors = 0;
        int[] random = new int[list.length];
        boolean sorted = false;
        Random r1 = new Random();
        
        while(!sorted)
        {
            for(int i = 0; i < random.length; i++)
            {
                random[i] = r1.nextInt(101);
            }
            
            sorted = isSorted(random);
        }
        
        list = random;
    }
    
    public static boolean isSorted(int[] list)
    {
        int error = 0;
        for(int i = 0; i < list.length - 1; i++)
        {
            for(int j = i + 1; j < list.length; j++)
            {
                if(list[i] > list[j])
                    error++;
            }
        }
        
        return error==0;
    }
}