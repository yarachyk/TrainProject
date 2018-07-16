import java.util.Scanner;

public class Cashbox {

    Scanner scan = new Scanner(System.in);

    public void cash (int check) {
        System.out.println("Ціна за квиток буде становити " + check + "грн.");
        System.out.println("Внесіть кошти (" + check + ")");
         while(true){
            int money = scan.nextInt();
            if (money==check){
                System.out.println("Оплата пройшла успішно!"); break;
            }
            else System.out.println("Спробуйте ще раз!");
        }

    }
}
