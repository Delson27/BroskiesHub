package BroskiesHubTask1;
import java.util.Scanner;
public class bht1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = sc.nextInt();
        if (num % 2 == 0) {
            System.out.println("The given number " + num + " is even.");
        } else {
            System.out.println("The given number " + num + " is odd.");
        }
        sc.close();
    }
}
