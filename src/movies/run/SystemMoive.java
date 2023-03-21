package movies.run;

import movies.bean.Business;
import movies.bean.Client;
import movies.bean.Movie;
import movies.bean.User;

import java.util.*;

public class SystemMoive {
    public static final List<User> ALL_USERS = new ArrayList<>();
    public static Map<Business,Set<Movie>> ALL_MOVIES = new HashMap<>();
    public static final Scanner SCInput = new Scanner(System.in);
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
        showMenu();
    }
    public static void showMenu(){
        System.out.println("==================HomeMenu===================");
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("输入操作命令: \n");
        String command = SCInput.nextLine();
        switch (command){
            case "1": login(); break;
            case  "2": enroll(); break;
            default: break;
        }

    }
    public static void login(){
        while (true) {
            System.out.println("==================Login===================");
            System.out.println("Input login name\n");
            String loginName = SCInput.nextLine();
            System.out.println("Input login password\n");
            String loginPassword = SCInput.nextLine();

            //根据用户名查询用户对象
            User loginUser = getUserByLoginName(loginName);
            //
            if (loginUser != null){
                if (loginUser.getPassword().equals(loginPassword)) {
                     if(loginUser instanceof Client) {
                         showClientMenu();
                     }
                     if (loginUser instanceof Business){
                         showBusinessMenu();
                     }
                     return;//返回首页
                }else {
                    System.out.println("login password error");
                }
            }else {
                System.out.println("login name Does not exist\n");
            }
        }
    }
    //客户菜单
    public static void showClientMenu(){
        System.out.println("===============ClientMenu====================");

    }
    //商家菜单
    public static void showBusinessMenu(){

    }
    public static void enroll(){
        System.out.println("==================EnrollMenu===================");
        System.out.println("1.客户注册");
        System.out.println("2.商户注册");
        while (true) {
            System.out.println("输入操作命令: \n");
            String command = SCInput.nextLine();
            switch (command){
                case "1": enrollClient(); break;
                case  "2": enrollBusiness(); break;
                default:
                    System.out.println("error command");
            }
        }
    }
    public static void enrollClient(){

    }
    public static void enrollBusiness(){

    }
    public static User getUserByLoginName(String loginName){
        if (ALL_USERS.isEmpty())
            return null;
        for (User user : ALL_USERS) {
            if(user.getLogin_name().equals(loginName)){
                return user;
            }
        }
        return null;
    }
}