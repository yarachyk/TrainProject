import java.util.*;

public class Run {

    public void runToNextSt(Station F, Station S){
        //      int startTime = 1;
        //      int n = 5; //тут будет ввод с клавы
        //       Road r = new Road(n);
        //       System.out.println("Train starts road in"+ startTime);
        System.out.println("Ви прибули на станцію " +F);
        System.out.println("Наступна станція - "+S);

    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("Який потяг вас цікавить?");
        System.out.println("1: Суми - Чернігів");
        System.out.println("2: Черкаси - Дніпро");
        Road r = new Road();
        int p = scan.nextInt();


        switch (p) {
            case 1:
                r.route1();
                break;

            case 2:
                r.route2();
                break;

            default: System.out.println("Ви ввели неправильне значення! До побачення!");
            break;
        }
        if (p==1||p==2){
            System.out.println("Вітаємо в пункті призначення!");
        }





//        for (int i = st1; i<6; i++){
//            if (i<5) {
//                System.out.println("Ви прибули на станцію "+i+" о");
//                System.out.println("Наступна станція - " + (i + 1));
//            }
//            else{
//               System.out.println("Ви прибули на станцію призначення.");
//            }
//        }

        //       System.out.println("First try!");
    }

}
