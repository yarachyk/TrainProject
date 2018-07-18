import java.util.*;

class Run {


    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("Який потяг вас цікавить?");
        System.out.println("1: Суми - Чернігів");
        System.out.println("2: Черкаси - Дніпро");
        Road r = new Road();
        int p = scan.nextInt();

        switch (p) {
            case 1:
                r.createRoute1();
                r.route(r.getRoute1());
                break;

            case 2:
                r.createRoute2();
                r.route(r.getRoute2());
                break;

            default: System.out.println("Ви ввели неправильне значення! До побачення!");
            break;
        }
        if (p==1||p==2){
            System.out.println("Вітаємо в пункті призначення!");
        }

    }

}
