import java.util.*;
import java.text.*;

class Road {
    Scanner sc = new Scanner(System.in);

    private ArrayList<Station> route1 = new ArrayList<>();
    private ArrayList<Station> route2 = new ArrayList<>();
    private ArrayList<Station> route_new = new ArrayList<>();
    Cashbox cashbox = new Cashbox();
    Ticket ticket = new Ticket();
    SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");



    void getRoute1Norm() {
        for (Station i:route1){
            i.info();
        }
    }

    ArrayList<Station> getRoute1() {
        return route1;
    }

    void createRoad1(){
        Station sumy = new Station("Суми", 100, true, false);
        Station khark = new Station("Харків", 150, false, false);
        Station polt = new Station("Полтава", 100, false, false);
        Station kyiv = new Station("Київ", 200, false, false);
        Station chern = new Station("Чернігів", 0, false, true);

        route1.add(sumy);
        route1.add(khark);
        route1.add(polt);
        route1.add(kyiv);
        route1.add(chern);
    }

    void createRoad2(){
        Station cherk = new Station("Черкаси", 150, true, false);
        Station vynn = new Station("Вінниця", 100, false, false);
        Station kher = new Station("Херсон", 200, false, false);
        Station odes = new Station("Одеса", 300, false, false);
        Station dnip = new Station("Дніпро", 0, false, true);

        route2.add(cherk);
        route2.add(vynn);
        route2.add(kher);
        route2.add(odes);
        route2.add(dnip);
    }

    void makeRoute1(){
        System.out.println("З якої станції ви хочете відправитися?");
        for (int i=0; i<getRoute1().size()-1; i++){
            System.out.print((i+1) + " - ");
            getRoute1().get(i).info();
        }
        System.out.println(" ");
        int st1 = sc.nextInt();

        System.out.println("Куди ви хочете прибути?");
        for (int i=st1; i<getRoute1().size(); i++){
            int c = 1;
            System.out.print(c + " - ");
            getRoute1().get(i).info();
            c++;
        }
        int st2 = sc.nextInt();

        for (int i=st1-1; i<st2; i++) {
            route_new.add(getRoute1().get(i));
        }

        System.out.println("Ваш маршрут:");
        for (int i=0; i<route_new.size(); i++){
            if (i<route_new.size()&& i!=0){
                System.out.print("- ");
            }
            route_new.get(i).info();
        }


    }

    void route1() {

        for (int i = 0; i < route1.size() - 1; i++) {
            System.out.print((i + 1) + " - ");
            route1.get(i).info();
        }
        System.out.println(" ");
        System.out.println("З якої станції ви хочете відправитися?");
        int st1 = sc.nextInt();
        System.out.println("Куди ви хочете прибути?");
        for (int i = st1; i < route1.size(); i++) {
            System.out.print((i + 1) + " - ");
            route1.get(i).info();
        }
        int st2 = sc.nextInt();

        for (int i = st1 - 1; i < st2; i++) {
            route_new.add(route1.get(i));
        }
        System.out.println("Ваш маршрут:");
        for (int i = 0; i < route_new.size(); i++) {
            if (i < route_new.size() && i != 0) {
                System.out.print("- ");
            }
            route_new.get(i).info();

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int count = st2 - st1 + 1;
        int distance = 0;
        for (int i = 0; i < count - 1; i++) {
            distance += route_new.get(i).dist();
        }
        int speed = 90;
        int min = ((distance / speed) * 60) + (10 * (count - 1));
        int hours = min / 60;
        System.out.println(" ");
        if (hours != 0) {
            int minutes = min % 60;
            if (hours == 1)
                System.out.println("Ваш потяг буде рухатися зі швидкістю 90 км/год. Ви прибудете до місця призначення через " + hours + " годину та " + minutes + " хвилин.");
            else if (hours == 2 || hours == 3 || hours == 4)
                System.out.println("Ваш потяг буде рухатися зі швидкістю 90 км/год. Ви прибудете до місця призначення через " + hours + " години та " + minutes + " хвилин.");
            else
                System.out.println("Ваш потяг буде рухатися зі швидкістю 90 км/год. Ви прибудете до місця призначення через " + hours + " годин та " + minutes + " хвилин.");
        } else {
            if (hours == 1)
                System.out.println("Ваш потяг буде рухатися зі швидкістю 90 км/год. Ви прибудете до місця призначення через " + hours + " годину.");
            else if (hours == 2 || hours == 3 || hours == 4)
                System.out.println("Ваш потяг буде рухатися зі швидкістю 90 км/год. Ви прибудете до місця призначення через " + hours + " години.");
            else
                System.out.println("Ваш потяг буде рухатися зі швидкістю 90 км/год. Ви прибудете до місця призначення через " + hours + " годин.");

        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ціна за квиток буде становити " + distance + "грн.");
        System.out.println("Внесіть кошти (" + distance + ")");
        cashbox.cash(distance);

//        int input = sc.nextInt();
//        sc.nextLine();
//        do {
//            if (input == distance) {
//                System.out.println("Оплата пройшла успішно!");
//            } else System.out.println("Спробуйте ще раз!");
//        }while (input!=distance);

        Date date = new Date();
        Date lastdate = new Date(date.getTime() + min * 60000);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Введіть ваше ім'я:");
        String pass = sc.next();
        ticket.createTicket(pass, route1.get(0).getName(), route1.get(route1.size() - 1).getName(), route_new.get(0).getName(), route_new.get(route_new.size() - 1).getName(), distance, date, lastdate);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        go(route1, route_new, date, lastdate);
    }


    void go(ArrayList<Station> route_old, ArrayList<Station> route, Date date, Date lastdate){
        System.out.println();
        System.out.print("Потяг "+route_old.get(0).getName()+" - "+route_old.get(route_old.size()-1).getName()+" відправляється з міста ");
        route.get(0).info();
        System.out.println("о "+format2.format(date));

        for(int i=1; i<route.size(); i++) {
            System.out.print("Наступна станція - місто ");
            route.get(i).info();
            System.out.println();
            System.out.println();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print("Ви прибули в місто ");
            route.get(i).info();
            System.out.println();


        }
        System.out.println("На годиннику "+format2.format(lastdate));

    }


}