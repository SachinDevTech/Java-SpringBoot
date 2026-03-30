public class N_and_1{
    public static void main(String[] args) {
        int n = 10;
        int i = 1;
        while(i<n) {
            if((i&1)==1){
                System.out.print(i + " ");
            }
            i++;
        }
    }
}