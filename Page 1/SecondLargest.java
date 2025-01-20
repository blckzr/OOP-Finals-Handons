import java.util.Scanner;

public class SecondLargest {
    public static int findSecondLargest(int[] arr){
        int secondLargest = arr[0];
        int largest = arr[0];

        for(int num : arr){
            if(num > largest){
                secondLargest = largest;
                largest = num;
            }
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        int size;
        try (Scanner console = new Scanner(System.in)) {
            System.out.print("Enter the size of array: ");
            size = console.nextInt();
            
            int[] arr = new int[size];
            
            for(int i = 0; i < size; i++){
                System.out.print("Enter element #" + (i + 1) + ": ");
                arr[i] = console.nextInt();
            }
            
            System.out.println("The second largest from the array: " + findSecondLargest(arr));
        }
    }
}