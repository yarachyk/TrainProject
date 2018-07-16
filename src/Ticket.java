import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ticket {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    Scanner sc = new Scanner(System.in);

    void createTicket(String first, String last, String firstst, String lastst, int price, Date firstdate, Date lastdate){
        System.out.println("Введіть ваше ім'я:");
        String name = sc.next();

        System.out.println("Ваш квиток:");
        System.out.println("------------------------------------------------");
        System.out.println("Пасажир: "+name);
        System.out.println("Потяг: "+first+" - "+last);
        System.out.println("Маршрут: "+firstst+" - "+lastst);
        System.out.println("Ціна: "+price+"грн.");
        System.out.println("Дата та час відправлення: "+format.format(firstdate));
        System.out.println("Дата та час прибуття: "+format.format(lastdate));
        System.out.println("------------------------------------------------");
    }
}
