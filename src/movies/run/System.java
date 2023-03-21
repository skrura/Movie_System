package movies.run;

import movies.bean.Business;
import movies.bean.Client;
import movies.bean.Movie;
import movies.bean.User;

import java.util.*;

public class System {
    public static final Set<User> ALL_USERS = new HashSet<>();
    public static Map<Business,Set<Movie>> ALL_MOVIES = new HashMap<>();
    static {
        Client c = new Client();
        c.setLogin_name("yh123456");
        c.setPassword("123456");
        c.setReal_name("刘德华");
        c.setGender('男');
        c.setAccount_amount(10000.0);
        c.setTelephone_number("110110");
        ALL_USERS.add(c);

        Client c1 = new Client();
        c1.setLogin_name("yh654321");
        c1.setPassword("654321");
        c1.setReal_name("关之琳");
        c1.setGender('女');
        c1.setAccount_amount(2000.0);
        c1.setTelephone_number("111111");
        ALL_USERS.add(c1);

        Business b = new Business();
        b.setLogin_name("yh888888");
        b.setPassword("888888");
        b.setReal_name("包租公");
        b.setAccount_amount(0.0);
        b.setGender('男');
        b.setTelephone_number("110110");
        b.setAddress("海王星8号8B八层");
        b.setShop_name("甜甜圈国际影城");
        ALL_USERS.add(b);
        // 注意，商家一定需要加入到店铺排片信息中去
        Set<Movie> movies = new HashSet<>();
        ALL_MOVIES.put(b , movies); // b = []

        Business b2 = new Business();
        b2.setLogin_name("yh666666");
        b2.setPassword("666666");
        b2.setReal_name("包租婆");
        b2.setAccount_amount(0.0);
        b2.setGender('女');
        b2.setTelephone_number("110110");
        b2.setAddress("土星6号6b六层");
        b2.setShop_name("巧克力国际影城");
        ALL_USERS.add(b2);
        // 注意，商家一定需要加入到店铺排片信息中去
        Set<Movie> movies3 = new HashSet<>();
        ALL_MOVIES.put(b2 , movies3); // b2 = []
    }

    public static void main(String[] args) {

    }
}
