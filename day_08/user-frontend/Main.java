import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    //cau1
    //In ra màn hình hình vuông
    public static void printSquare(Object[][] multiArray) {
        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length && j < multiArray.length; j++) {
                System.out.print(multiArray[i][j]);
            }
            System.out.println("");
        }
    }

    //In ra màn hình hình tam giác
    public static void printTriangle(Object[][] multiArray) {
        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(multiArray[i][j]);
            }
            System.out.println("");
        }
    }

    //Cau 2
    //Đếm số từ trong chuỗi
    public static int countCharsOfString(String str) {
        String[] array = str.split("");
        return array.length;
    }


    //Đếm và in ra index của các ký tự o trong chuỗi
    public static int countAndPrintString(String str) {
        String[] array = str.split("");
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("o")) {
                result++;
                System.out.println("Index of char \"o\" is: " + i);
            }
        }
        System.out.print("Number of indexes \"o\" is: ");
        return result;
    }

    //Phương thức kiểm tra số nguyên tố
    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //check random number is PrimeNumber
    public static void checkPrimeNumber(int bound) {
        Random rd = new Random();
        int n = rd.nextInt(bound);
        if (isPrimeNumber(n)) {
            System.out.println(n + " is not a prime number");
        } else {
            System.out.println(n + " is a prime number");
        }
    }


    public static void main(String[] args) {
        String[][] shape = new String[4][5];
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                shape[i][j] = "*";
            }
        }
        printSquare(shape);
        System.out.println("-----------------------------");
        printTriangle(shape);
        System.out.println("-----------------------------");
        System.out.println("Đếm số từ trong chuỗi");
        System.out.println(countCharsOfString("sdflkasjdfhsdsf"));
        System.out.println("-----------------------------");
        System.out.println("Đếm và in ra index của các ký tự o trong chuỗi: ");
        System.out.println(countAndPrintString("asfhwewoadfsofosdfao"));

        System.out.println("-----------------------------");

        //bai3
        System.out.println("");
        checkPrimeNumber(100);
        System.out.println("-----------------------------");

        //bai4.1
        int count = 0;
        System.out.println("10 first PrimeNumbers are: ");
        for (int i = 2; i < 30; i++) {
            if (isPrimeNumber(i)) {
                System.out.print(i);
                System.out.print("-");
                count++;
            }

            if (count == 10) {
                break;
            }
        }
        System.out.println("");
        System.out.println("-----------------------------");

        //bai4.2
        System.out.println("PrimeNumbers < 10 are: ");
        for (int i = 2; i < 10; i++) {
            if (isPrimeNumber(i)) {
                System.out.print(i);
                System.out.print("-");
            }
        }
        System.out.println("");
        System.out.println("-----------------------------");

        //bai5
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number of rows");
        int rows = sc.nextInt();
        System.out.println("Input number of columns");
        int columns = sc.nextInt();
        int[][] multiArray1 = new int[rows][columns];
        //Nhập các phần tử mảng
        for (int i = 0; i < multiArray1.length; i++) {
            for (int j = 0; j < multiArray1[i].length; j++) {
                System.out.printf("Input index at row %d and column %d \n", i, j);
                multiArray1[i][j] = sc.nextInt();
            }
        }
        System.out.println("-----------------------------");

        //In thông tin mảng ra màn hình
        for (int i = 0; i < multiArray1.length; i++) {
            System.out.println(Arrays.toString(multiArray1[i]));
        }
        System.out.println("-----------------------------");

        //Liệt kê các phần tử nằm trên đường chéo chính
        System.out.print("các phần tử nằm trên đường chéo chính:  ");
        for (int i = 0; i < multiArray1.length; i++) {
            for (int j = 0; j < multiArray1[i].length; j++) {
                if (j == i) {
                    System.out.print(multiArray1[i][j]);
                    System.out.print("-");
                }
            }
        }
        System.out.println("");
        //Tạo thêm 1 mảng hai chiều có cùng số dòng và số cột thực hiện cộng hai mảng với nhau
        int[][] multiArray2 = new int[rows][columns];
        for (int i = 0; i < multiArray2.length; i++) {
            for (int j = 0; j < multiArray2[i].length; j++) {
                System.out.printf("Input index at row %d and column %d \n", i, j);
                multiArray2[i][j] = sc.nextInt();
            }
        }
        System.out.println("mang 2 la");
        for (int i = 0; i < multiArray2.length; i++) {
            System.out.println(Arrays.toString(multiArray2[i]));
        }
        System.out.println("-----------------------");
        //Cong 2 mang
        int[][] multiArray3 = new int[rows][columns];
        for (int i = 0; i < multiArray3.length; i++) {
            for (int j = 0; j < multiArray3[i].length; j++) {
                multiArray3[i][j] = multiArray1[i][j] + multiArray2[i][j];
            }
        }

        System.out.println("Cong 2 mang");
        for (int i = 0; i < multiArray3.length; i++) {
            System.out.println(Arrays.toString(multiArray3[i]));
        }

        //Bai 6
        sc.nextLine();
        System.out.println("Input an email");
        String email = sc.nextLine();
        System.out.println("Input a phone number");
        String phoneNumber = sc.nextLine();

        String regexPhoneNumber = "^[0-9]{9,11}$";
        //\\d for index
        Pattern p1 = Pattern.compile(regexPhoneNumber);

        String regexEmail = "^[a-zA-Z][0-9a-zA-Z+_.-]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+$";
        Pattern p2 = Pattern.compile(regexEmail);

        System.out.println("Is email valid: " + p2.matcher(email).find());
        System.out.println("Is phone number valid: " + p1.matcher(phoneNumber).find());
    }

}
