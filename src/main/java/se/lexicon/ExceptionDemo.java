package se.lexicon;

import se.lexicon.Exception.FileFormatException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionDemo {


    public static void main(String[] args) {
       /* try {
            readFile("C:\\Users\\deltagare\\Downloads\\workshop-exception\\untitled\\Exception_practice\\PresentMe.txt");
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }*/

        // readFileNew();
        // getNumber();
        readFileWithTrtResources();
    }


    public static void ex1() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a num: ");
            String input = scanner.nextLine();
            try {
                int num = Integer.parseInt(input);
                System.out.println(" result: " + num * num);
            } catch (NumberFormatException e) {
                System.out.println("#####num is not valid######");
            }
        }
    }

    public static void ex2() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter ur name ");
            String name = scanner.nextLine();
            try {
                System.out.println(name.charAt(5));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("error:  " + e.getMessage());

            }
        }
    }

    public static void ex3() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        try {
            System.out.println(numbers[7]);
        } catch (IndexOutOfBoundsException e) {
            e.getStackTrace();
        }

    }

    public static void ex4() {
        String fileName = "C:\\Users\\deltagare\\Downloads\\workshop-exception\\untitled\\Exception_practice\\PresentMe.txt";
        File file = new File(fileName);
        try {
            FileInputStream inputStream = new FileInputStream(file);
            inputStream.read();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String fileName) throws IOException {
        if (fileName.contains(".txt")) {
            throw new FileFormatException("Is not valid");
        }
        File file = new File(fileName);
        FileInputStream inputStream = new FileInputStream(file);
        int x = 0;
        while (!((x = inputStream.read()) != -1)) {
            System.out.println((char) x);


        }
    }

    public static void readFileNew() {

        File file = new File("C:\\Users\\deltagare\\Downloads\\workshop-exception\\untitled\\Exception_practice\\PresentMe.txt");
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            int x = 0;
            while ((x = inputStream.read()) != -1) {
                System.out.print((char) x);
            }
            System.out.println("\n\n");
        } catch (IOException e) {
            System.out.println("IOError: " + e.getMessage());
        } finally {
            try {
                if (inputStream != null) inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("#### finally block #### ");
        }
    }

    public static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        int result = 0;
        try {
            System.out.println("Enter a number:  ");
            num = scanner.nextInt();
            result = num * 2;
            System.out.println("number = " + result);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            scanner.close();
            result = 0;
        }
        return num;
    }

    public static void readFileWithTrtResources() {
        File file = new File("C:\\Users\\deltagare\\Downloads\\workshop-exception\\untitled\\Exception_practice\\PresentMe.txt");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            int x = 0;
            while ((x = inputStream.read()) != -1) {
                System.out.print((char) x);
            }
            System.out.println("\n\n");
        } catch (IOException e) {
            System.out.println("IOError: " + e.getMessage());
        }
    }
}