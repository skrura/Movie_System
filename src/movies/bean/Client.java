package movies.bean;

import java.util.List;


public class Client extends User{

    public Client(String login_name, String real_name, String password, Character gender, String telephone_number, Double account_amount) {
        this.login_name = login_name;
        this.real_name = real_name;
        this.password = password;
        this.gender = gender;
        this.telephone_number = telephone_number;
        this.account_amount = account_amount;
    }

}
