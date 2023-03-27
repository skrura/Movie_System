package movies.run;

import movies.bean.Business;
import movies.bean.Client;
import movies.bean.Movie;
import movies.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SystemMovie {
    public static final List<User> ALL_USERS = new ArrayList<>();
    public static Map<Business,Set<Movie>> ALL_MOVIES = new HashMap<>();
    public static final Scanner SCInput = new Scanner(System.in);
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //静态正在登录对象
    public static User LoginUser;
    public static final Logger LOGGER = LoggerFactory.getLogger("SystemMovie.class");
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
        while (true) {
            System.out.println("==================HomeMenu===================");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.退出");
            System.out.println("输入操作命令: \n");
            String command = SCInput.nextLine();
            switch (command){
                case "1": login(); break;
                case  "2": enroll(); break;
                case  "3": return;
                default: break;
            }
        }

    }
    public static void login(){
        while (true) {
            System.out.println("==================Login===================");
            System.out.println("Input login name");
            String loginName = SCInput.nextLine();
            System.out.println("Input login password");
            String loginPassword = SCInput.nextLine();

            //根据用户名查询用户对象
            User loginUser = getUserByLoginName(loginName);
            //
            if (loginUser != null){
                if (loginUser.getPassword().equals(loginPassword)) {
                    LoginUser = loginUser;
                    LOGGER.info("登录成功");
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
        System.out.println("欢迎"+LoginUser.getReal_name()+"您的余额为"+LoginUser.getAccount_amount());
        System.out.println("选择需要的功能");
        System.out.println("1.展示全部影片信息");
        System.out.println("2.根据电影名称查询电影信息");
        System.out.println("3.根据评分筛选全部电影");
        System.out.println("4.评分");
        System.out.println("5.购票");
        System.out.println("6.退出");
        while (true){
            System.out.println("输入需要的功能：");
            String command = SCInput.nextLine();
            switch (command){
                case "1" :showAllMovies();
                    break;
                case "2" :
                    break;
                case "3" :
                    break;
                case "4" :
                    break;
                case "5" : buyMovie();
                    break;
                case "6" :
                    return;
                default:
                    System.out.println("不存在");
                    break;
            }
        }
    }

    private static void buyMovie() {
        while (true) {
            System.out.println("============buyMovie===============");
            Client LoginClient = (Client) LoginUser;
            while (true) {
                System.out.println("输入要在哪家影院购买");
                String shopName = SCInput.nextLine();
                Business business = getBusinessByShopName(shopName);
                if(business == null) {
                    System.out.println("对不起，没有该店铺！请确认");
                }
                else {
                    while (true){
                        System.out.println("输入要购买的电影名称");
                        String input = SCInput.nextLine();
                        Movie movie = getMovieByShopAndName(business,input);
                        if(movie == null) {
                            System.out.println("没有要购买的电影");
                        }else {
                            while (true) {
                                System.out.println("输入要购买的数量");
                                String s_count = SCInput.nextLine();
                                Integer count = Integer.valueOf(s_count);
                                Double sellingPrice = count * movie.getPrice();
                                Double money = LoginClient.getAccount_amount();
                                Integer Remaining = movie.getNumber();
                                if(sellingPrice <= money) {
                                    if(Remaining >= count){
                                        LoginClient.setAccount_amount(money-sellingPrice);
                                        business.setAccount_amount(business.getAccount_amount() + money);
                                        movie.setNumber(Remaining-count);
                                        System.out.println("购买"+movie.getName()+count+"张"+"成功");
                                        break;
                                    }
                                   else {
                                     System.out.println("余票不足");
                                   }
                                }
                                else {
                                    System.out.println("余额不足");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static Movie getMovieByShopAndName(Business business,String name) {
        Set<Movie> movies = ALL_MOVIES.get(business);
        for (Movie movie : movies) {
            if(movie.getName().contains(name)){
                return movie;
            }
        }
        return null;
    }

    public static Business getBusinessByShopName(String shopName){
        Set<Business> businesses = ALL_MOVIES.keySet();
        for (Business business : businesses) {
            if(business.getShop_name().equals(shopName)){
                return  business;
            }
        }
        return null;
    }
    private static Set<Movie> getShopByName(String shopName) {
        Set<Movie> movies = ALL_MOVIES.get(shopName);
        if(movies!=null) {
            return movies;
        }else {
            System.out.println("商家无影片");
            return null;
        }
    }

    private static void showAllMovies() {
        System.out.println("=============showAllMovies================");
        ALL_MOVIES.forEach((business, movies) -> {
            System.out.println(business);
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        });
    }

    //商家菜单
    public static void showBusinessMenu(){
        System.out.println("===============BusinessMenu====================");

        Business loginUser = (Business) LoginUser;
        LOGGER.info(loginUser.getReal_name()+"进入商家界面");
        System.out.println("欢迎"+LoginUser.getReal_name()+"您的商城为"+loginUser.getShop_name());
        System.out.println("选择需要的功能");
        System.out.println("1.展示全部影片信息");
        System.out.println("2.上架电影");
        System.out.println("3.下架电影");
        System.out.println("4.修改电影");
        System.out.println("5.退出");
        while (true){
            System.out.println("输入需要的功能：");
            String command = SCInput.nextLine();
            switch (command) {
                case "1" -> ShowBusinessMovie();
                case "2" -> addMovie();
                case "3" -> deleteMovie();
                case "4" -> updateMovie();
                case "5" -> {
                    return;
                }
                default -> System.out.println("不存在");
            }
        }
    }
    public static void ShowBusinessMovie(){
        Business loginUser = (Business) LoginUser;
        System.out.println("欢迎"+LoginUser.getReal_name()+"您的商城："+loginUser.getShop_name()+"地址："+loginUser.getAddress());
        System.out.println("电话："+loginUser.getTelephone_number());
        Set<Movie> LoginBusinessMovie =  ALL_MOVIES.get(loginUser);
        if(LoginBusinessMovie.size()==0) {
            System.out.println("未上架任何电影");
            return;
        }
        for (Movie movie : LoginBusinessMovie) {
            System.out.println(movie);
        }
    }
    public static void addMovie(){
        System.out.println("===============BusinessAddMovieMenu====================");
        // 根据商家对象(就是登录的用户loginUser)，作为Map集合的键 提取对应的值就是其排片信息 ：Map<Business , List<Movie>> ALL_MOVIES
        Business business = (Business) LoginUser;
        Set<Movie> movies = ALL_MOVIES.get(business);
        System.out.println("请您输入新片名：");
        String name  = SCInput.nextLine();
        System.out.println("请您输入主演：");
        String actor  = SCInput.nextLine();
        System.out.println("请您输入时长：");
        String time  = SCInput.nextLine();
        System.out.println("请您输入票价：");
        String price  = SCInput.nextLine();
        System.out.println("请您输入票数：");
        String totalNumber  = SCInput.nextLine(); // 200\n

        while (true) {
            try {
                System.out.println("请您输入影片放映时间：");
                String stime  = SCInput.nextLine();
                //  public Movie( String name, String actor, Double time, Double price, Integer number, Date start_time)      // 封装成电影对象 ，加入集合movices中去
                Movie movie =  new Movie(name,actor,Double.valueOf(time),Double.valueOf(price),Integer.valueOf(totalNumber),sdf.parse(stime));
                movies.add(movie);
                System.out.println("您已经成功上架了：《" + movie.getName() + "》");
                return; // 直接退出去
            } catch (ParseException e) {
                e.printStackTrace();
                LOGGER.error("时间解析出了毛病");
            }
        }
    }
    public static void deleteMovie(){
        System.out.println("================deleteMovie====================");
        Business business = (Business) LoginUser;
        Set<Movie> movies = ALL_MOVIES.get(business);
        if(movies.size() == 0) {
            System.out.println("当期无片可以下架~~");
            return;
        }

        // 2、让用户选择需要下架的电影名称
        while (true) {
            System.out.println("请您输入需要下架的电影名称：");
            String movieName = SCInput.nextLine();

            // 3、去查询有没有这个影片对象。
            Movie movie = getMovieByName(movieName);
            if(movie != null){
                // 下架它
                movies.remove(movie);
                System.out.println("您当前店铺已经成功下架了：" + movie.getName());
                ShowBusinessMovie();
                return;
            }else {
                System.out.println("您的店铺没有上架该影片！");
                System.out.println("请问继续下架吗？y/n");
                String command = SCInput.nextLine();
                switch (command) {
                    case "y":
                        break;
                    default:
                        System.out.println("好的！");
                        return;
                }
            }
        }
    }
    public static Movie getMovieByName(String movieName){
        Business business = (Business) LoginUser;
        Set<Movie> movies = ALL_MOVIES.get(business);
        for (Movie movie : movies) {
            if(movie.getName().contains(movieName)) {
                return movie;
            }
        }
        return null;
    }
    private static void updateMovie() {
        System.out.println("================updateMovie====================");
        Business business = (Business) LoginUser;
        Set<Movie> movies = ALL_MOVIES.get(business);

        if(movies.size() == 0) {
            System.out.println("当期无片可以修改~~");
            return;
        }

        // 2、让用户选择需要修改的电影名称
        while (true) {
            System.out.println("请您输入需要修改的电影名称：");
            String movieName = SCInput.nextLine();

            // 3、去查询有没有这个影片对象。
            Movie movie = getMovieByName(movieName);
            if(movie != null){
                // 修改它
                System.out.println("请您输入修改后的片名：");
                String name  = SCInput.nextLine();
                System.out.println("请您输入修改后主演：");
                String actor  = SCInput.nextLine();
                System.out.println("请您输入修改后时长：");
                String time  = SCInput.nextLine();
                System.out.println("请您输入修改后票价：");
                String price  = SCInput.nextLine();
                System.out.println("请您输入修改后票数：");
                String totalNumber  = SCInput.nextLine(); // 200\n
                while (true) {
                    try {
                        System.out.println("请您输入修改后的影片放映时间：");
                        String stime  = SCInput.nextLine();

                        movie.setName(name);
                        movie.setActor(actor);
                        movie.setPrice(Double.valueOf(price));
                        movie.setTime(Double.valueOf(time));
                        movie.setNumber(Integer.valueOf(totalNumber));
                        movie.setStart_time(sdf.parse(stime));

                        System.out.println("恭喜您，您成功修改了该影片了！！！");
                        ShowBusinessMovie();
                        return; // 直接退出去
                    } catch (Exception e) {
                        e.printStackTrace();
                        LOGGER.error("时间解析出了毛病");
                    }
                }
            }else {
                System.out.println("您的店铺没有上架该影片！");
                System.out.println("请问继续修改吗？y/n");
                String command = SCInput.nextLine();
                switch (command) {
                    case "y":
                        break;
                    default:
                        System.out.println("好的！");
                        return;
                }
            }
        }
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
