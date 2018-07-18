import java.util.*;
import java.text.*;

class Road {
    Scanner sc = new Scanner(System.in);

    private ArrayList<Station> route1 = new ArrayList<>();
    private ArrayList<Station> route2 = new ArrayList<>();
    private ArrayList<Station> route_new = new ArrayList<>();
    private Cashbox cashbox = new Cashbox();
    private Ticket ticket = new Ticket();
    private SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
    private int st1;
    private int st2;
    private int speed = 90;
    private int distance;
    private Date date;
    private Date lastdate;


    private void pause(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected ArrayList<Station> getRoute2() {
        return route2;
    }

    protected ArrayList<Station> getRoute1() {
        return route1;
    }

    protected void createRoute1(){
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

    protected void createRoute2(){
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

    private void makeRoute(ArrayList<Station> route) {
        System.out.println("З якої станції ви хочете відправитися?");
        for (int i = 0; i < route.size() - 1; i++) {
            System.out.print((i + 1) + " - ");
            route.get(i).info();
        }
        System.out.println();
        st1 = sc.nextInt();

        System.out.println("Куди ви хочете прибути?");
        for (int i = st1; i < route.size(); i++) {
            System.out.print((i+1) + " - ");
            route.get(i).info();
        }
        System.out.println();
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

    private void distan(ArrayList<Station> route_new){
        int count = st2 - st1+1;
        distance = 0;
        for (int i = 0; i < count - 1; i++) {
            distance += route_new.get(i).dist();
        }
        double min = (((double) distance / speed) * 60) + (10 * (count - 2));
        int hours = (int)min / 60;
        System.out.println(" ");
        int minutes = (int)min % 60;
        System.out.println("Ваш потяг буде рухатися зі швидкістю 90 км/год. Ви прибудете до місця призначення через " + hours + " год. та " + minutes + " хв.");


    }


    private int getMin(){
        int count = st2 - st1+1;
        distance = 0;
        for (int i = 0; i < count - 1; i++) {
            distance += route_new.get(i).dist();
        }
        double min = (((double)distance / speed) * 60) + (10 * (count - 2));
        int minut = (int)min;
        return minut;
    }




    private void go(ArrayList<Station> route_old, ArrayList<Station> route, Date date, Date lastdate){
        System.out.println();
        System.out.print("Потяг "+route_old.get(0).getName()+" - "+route_old.get(route_old.size()-1).getName()+" відправляється з міста ");
        route.get(0).info();
        System.out.println("о "+format2.format(date));
//        Date nextSt;
//        double temp=0;
        for(int i=1; i<route.size(); i++) {
            System.out.print("Наступна станція - місто ");
            route.get(i).info();
            System.out.println();
            System.out.println();
            pause();
            System.out.print("Ви прибули в місто ");
            route.get(i).info();
            System.out.print(" о ");
//            temp += ((double)route.get(i-1).toNext/speed)*360000;
//            Date nextSt = new Date(date.getTime()+((int)temp*360000) + (10*60000));
//            System.out.println(format2.format(nextSt));
            if (i!=route.size()-1) {
                System.out.println();
                System.out.println("Зупинка 10 хвилин!");
            }
            pause();
        }
        System.out.println();
        System.out.println("На годиннику "+format2.format(lastdate));

    }


    protected void route(ArrayList<Station> route) {
        makeRoute(route);
        pause();
        distan(route_new);
        pause();
        cashbox.cash(distance);
        date = new Date();
        lastdate = new Date(date.getTime() + getMin() * 60000);
        pause();
        ticket.createTicket(route.get(0).getName(), route.get(route.size() - 1).getName(), route_new.get(0).getName(), route_new.get(route_new.size() - 1).getName(), distance, date, lastdate);
        pause();
        go(route, route_new, date, lastdate);
    }



}