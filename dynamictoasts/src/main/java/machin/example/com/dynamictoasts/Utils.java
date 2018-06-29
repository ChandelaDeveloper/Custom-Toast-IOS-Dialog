package machin.example.com.dynamictoasts;

public class Utils {

    public static int toastTime(String str){
        if (str.length() <= 10){
            return 2000;
        } else {
            int roundedCount = 0;
            int mod = str.length() % 10;
            if (mod >= 5){
                roundedCount = str.length() + 10 - mod;
                return roundedCount*65;
            }
            else{
                roundedCount = str.length() - mod;
                return roundedCount*65;
            }
        }
    }
}
