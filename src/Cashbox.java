import java.util.Scanner;

class Cashbox {

    Scanner scan = new Scanner(System.in);
    boolean error = false;


    protected void cash (int check) {
        System.out.println("Ціна за квиток буде становити " + check + "грн.");
        try {
            System.out.println("Внесіть кошти (" + check + ")");
            while (true) {

                int money = scan.nextInt();
                if (money == check) {
                    System.out.println("Оплата пройшла успішно!");
                    break;
                } else System.out.println("Спробуйте ще раз!");
            }
        } catch (Exception e){
            System.out.println("Ви ввели значення неправильного типу!");
            error = true;
        }

    }
}
