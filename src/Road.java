import java.util.*;

public class Road {
    Scanner sc = new Scanner(System.in);
    Station st;

    void route1(){
        Station sumy = new Station("Суми", 100, true, false);
        Station khark = new Station("Харків", 150, false, false);
        Station polt = new Station("Полтава", 100, false, false);
        Station kyiv = new Station("Київ", 200, false, false);
        Station chern = new Station("Чернігів", 0, false, true);

        List<Station> route1 = new ArrayList<>();
        route1.add(0, sumy);
        route1.add(1, khark);
        route1.add(2, polt);
        route1.add(3, kyiv);
        route1.add(4, chern);


        for (int i=0; i<route1.size()-1; i++){
            System.out.print((i+1) + " - ");
            route1.get(i).info();
        }
        System.out.println(" ");
        System.out.println("З якої станції ви хочете відправитися?");
        int st1 = sc.nextInt();
        System.out.println("Куди ви хочете прибути?");
        for (int i=st1; i<route1.size(); i++){
            System.out.print((i+1) + " - ");
            route1.get(i).info();
        }
        int st2 = sc.nextInt();

        List<Station> route_new = new ArrayList<>();
        for (int i=st1-1; i<st2; i++) {
            route_new.add(route1.get(i));
        }
        System.out.println("Ваш маршрут:");
        for (int i=0; i<route_new.size(); i++){
            if (i<route_new.size()&& i!=0){
                System.out.print("- ");
            }
            route_new.get(i).info();

        }

//        Train t = new Train(90);
        int count = st2-st1+1;
//        System.out.println(sumy.distance(count));
        int distance = 0;
        for (int i=0; i<count-1; i++){
            distance += route_new.get(i).dist();
        }
        int speed = 90;
        int min = ((distance/speed)*60)+(10*(count-1));
        int hours = min/60;
        System.out.println(" ");
        if (hours!=0) {
            int minutes = min % 60;
            if (hours==1) System.out.println("Ваш потяг буде рухатися зі швидкістю 90 км/год. Ви прибудете до місця призначення через "+hours+" годину та "+minutes+" хвилин.");
            else if (hours==2||hours==3||hours==4) System.out.println("Ваш потяг буде рухатися зі швидкістю 90 км/год. Ви прибудете до місця призначення через "+hours+" години та "+minutes+" хвилин.");
            else System.out.println("Ваш потяг буде рухатися зі швидкістю 90 км/год. Ви прибудете до місця призначення через "+hours+" годин та "+minutes+" хвилин.");
        }
        else {
            if (hours==1) System.out.println("Ваш потяг буде рухатися зі швидкістю 90 км/год. Ви прибудете до місця призначення через "+hours+" годину.");
            else if (hours==2||hours==3||hours==4) System.out.println("Ваш потяг буде рухатися зі швидкістю 90 км/год. Ви прибудете до місця призначення через "+hours+" години.");
            else System.out.println("Ваш потяг буде рухатися зі швидкістю 90 км/год. Ви прибудете до місця призначення через "+hours+" годин.");

        }

        System.out.println("Ціна за квиток буде становити "+distance+"грн.");
        System.out.println("Внесіть кошти ("+distance+")");
        int input = sc.nextInt();
        sc.nextLine();
        do {
            if (input == distance) {
                System.out.println("Оплата пройшла успішно!");
            } else System.out.println("Спробуйте ще раз!");
        }while (input!=distance);
        System.out.println("Введіть ваше ім'я:");
        String pass = sc.nextLine();
        System.out.println("Ваш квиток:");
        System.out.println("-------------------------------------------");
        System.out.println("Пасажир: "+pass);
        System.out.println("Потяг: Суми - Чернігів");
        System.out.print("Маршрут: ");
        route_new.get(0).info();
        System.out.print("- ");
        route_new.get(route_new.size()-1).info();
        System.out.println(" ");
        System.out.println("Ціна: "+distance+"грн.");
        System.out.println("Час відправлення: ");
        System.out.println("Час прибуття: ");
        System.out.println("-------------------------------------------");

    }




    void route2(){
        Station cherk = new Station("Черкаси", 150, true, false);
        Station vynn = new Station("Вінниця", 100, false, false);
        Station kher = new Station("Херсон", 200, false, false);
        Station odes = new Station("Одеса", 300, false, false);
        Station dnip = new Station("Дніпро", 0, false, true);

        List<Station> route2 = new ArrayList<>();
        route2.add(cherk);
        route2.add(vynn);
        route2.add(kher);
        route2.add(odes);
        route2.add(dnip);

        for (int i=0; i<route2.size()-1; i++){
            System.out.print((i+1) + " - ");
            route2.get(i).info();
        }
        System.out.println(" ");
        System.out.println("З якої станції ви хочете відправитися?");
        int st1 = sc.nextInt();
        System.out.println("Куди ви хочете прибути?");
        for (int i=st1; i<route2.size(); i++){
            System.out.print((i+1) + " - ");
            route2.get(i).info();
        }
        int st2 = sc.nextInt();

        List<Station> route_new = new ArrayList<>();
        for (int i=st1-1; i<st2; i++) {
            route_new.add(route2.get(i));
        }
        System.out.println("Ваш маршрут:");
        for (int i=0; i<route_new.size(); i++){
            if (i<route_new.size()&& i!=0){
                System.out.print("- ");
            }
            route_new.get(i).info();

        }


    }

}

