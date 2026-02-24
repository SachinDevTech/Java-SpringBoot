public class SwitchCase{
    public static void main(String[] args) {
        int i = 5;
        switch(i%2){
            case 0:
                System.out.println("Even");
                break;
            case 1:
                System.out.println("Odd");
                break;
        }
    }
}