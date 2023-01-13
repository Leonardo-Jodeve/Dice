//import java.util.Scanner;
//
//public class Main
//{
//    static void hanoi(int n, char from_rod, char to_rod, char helper_rod)
//    {
//        if(n == 1)
//        {
//            System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
//            return;
//        }
//        hanoi(n-1, from_rod, helper_rod, to_rod);
//        System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);
//        hanoi(n-1, helper_rod, to_rod, from_rod);
//    }
//
//    public static void main(String[] args)
//    {
//        int n = 3;
//        hanoi(n, 'A', 'C', 'B');
//    }
//}
