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
    int st1;
    int st2;
    int speed = 90;
    int distance;
    Date date;
    Date lastdate;


    void pause(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    void createRoute1(){
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

    void createRoute2(){
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

    void makeRoute(ArrayList<Station> route) {
        System.out.println("З якої станції ви хочете відправитися?");
        for (int i = 0; i < route.size() - 1; i++) {
            System.out.print((i + 1) + " - ");
            route.get(i).info();
        }
        System.out.println(" ");
        st1 = sc.nextInt();

        System.out.println("Куди ви хочете прибути?");
        for (int i = st1; i < route.size(); i++) {
            System.out.print((i+1) + " - ");
            route.get(i).info();
        }
        st2 = sc.nextInt();

        for (int i = st1 - 1; i < st2; i++) {
            route_new.add(route.get(i));
        }

        System.out.println("Ваш маршрут:");
        for (int i = 0; i < route_new.size(); i++) {
            if (i < route_new.size() && i != 0) {
                System.out.print("- ");
            }
            route_new.get(i).info();
        }
    }

    void distan(ArrayList<Station> route_new){
        int count = st2 - st1 + 1;
        distance = 0;
        for (int i = 0; i < count - 1; i++) {
            distance += route_new.get(i).dist();
        }
        int min = ((distance / speed) * 60) + (10 * (count - 1));
        int hours = min / 60;
        System.out.println(" ");
        int minutes = min % 60;
        System.out.println("Ваш потяг буде рухатися зі швидкістю 90 км/год. Ви прибудете до місця призначення через " + hours + " год. та " + minutes + " хв.");


    }

    int getMin(){
        int count = st2 - st1 + 1;
        distance = 0;
        for (int i = 0; i < count - 1; i++) {
            distance += route_new.get(i).dist();
        }
        int min = ((distance / speed) * 60) + (10 * (count - 1));
        return min;
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


    void route1() {
        makeRoute(route1);
        pause();
        distan(route_new);
        pause();
        cashbox.cash(distance);
        date = new Date();
        lastdate = new Date(date.getTime() + getMin() * 60000);
        pause();
        ticket.createTicket(route1.get(0).getName(), route1.get(route1.size() - 1).getName(), route_new.get(0).getName(), route_new.get(route_new.size() - 1).getName(), distance, date, lastdate);
        pause();
        go(route1, route_new, date, lastdate);
    }


    void route2() {
        makeRoute(route2);
        pause();
        distan(route_new);
        pause();
        cashbox.cash(distance);
        date = new Date();
        lastdate = new Date(date.getTime() + getMin() * 60000);
        pause();
        ticket.createTicket(route2.get(0).getName(), route2.get(route2.size() - 1).getName(), route_new.get(0).getName(), route_new.get(route_new.size() - 1).getName(), distance, date, lastdate);
        pause();
        go(route2, route_new, date, lastdate);
    }

}