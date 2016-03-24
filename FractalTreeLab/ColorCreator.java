import java.awt.Color;

public class ColorCreator
{
    public static Color generateColor(String color1, String color2, double c1, double c2)
    {
        int red1 = 0;
        int blue1 = 0;
        int green1 = 0;
    
        int red2 = 0;
        int blue2 = 0;
        int green2 = 0;
        switch(color1){
            case "Red":
            red1 = (int)(255 * (((c1/1920)>1 || (c1/1920)<0)?1:(c1/1920)));
            break;
            
            case "Blue":
            blue1 = (int)(255 * (((c1/1920)>1 || (c1/1920)<0)?1:(c1/1920)));
            break;
            
            case "Green":
            green1 = (int)(255 * (((c1/1920)>1 || (c1/1920)<0)?1:(c1/1920)));
            break;
        }
        
        switch(color2){
            case "Red":
            red2 = (int)(255 * (((c2/1080)>1 || (c2/1080)<0)?1:(c2/1080)));
            break;
            
            case "Blue":
            blue2 = (int)(255 * (((c2/1080)>1 || (c2/1080)<0)?1:(c2/1080)));
            break;
            
            case "Green":
            green2 = (int)(255 * (((c2/1080)>1 || (c2/1080)<0)?1:(c2/1080)));
            break;
        }
        
        return new Color((red1 > 0)?red1:red2, (green1 > 0)?green1:green2, (blue1 > 0)?blue1:blue2);
    }
}
