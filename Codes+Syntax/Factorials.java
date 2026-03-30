
import java.util.*;

public class Factorials {
    public static int fact(int num){
        if(num < 0){
            return -1;
        }
        int ans = 1;
        for(int i = num; i > 0; i--){
            ans *= i;
        }
        return ans;
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        System.out.println("The factorial of " + value + " is " + fact(value));
        sc.close();
    }
}
