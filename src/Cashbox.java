import java.util.Scanner;

public class Cashbox {

    Scanner scan = new Scanner(System.in);

    public void cash (int check) {
         while(true){
            int money = scan.nextInt();
            if (money==check){
                System.out.println("Оплата пройшла успішно!"); break;
            }
            else System.out.println("Спробуйте ще раз!");
        }

    }
}
