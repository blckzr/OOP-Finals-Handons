import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactor {
    public static void primeFactorization(int num){
        List<Integer> factors = new ArrayList<>();

        while (num % 2 == 0){
            factors.add(2);
            num /= 2;
        }

        for (int i = 3; i * i <= num; i += 2) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }

        if (num > 2)
            factors.add(num);
    
        for(int i = 0; i < factors.size(); i++){
            System.out.print(factors.get(i));
            if (i + 1 != factors.size()){
                System.out.print(" x ");
            }
        }
    }

    public static void main(String[] args) {
        int number;

        Scanner console = new Scanner(System.in);
        System.out.print("Enter a number: ");
        number = console.nextInt();
     
        primeFactorization(number);
        console.close();
    }
}
