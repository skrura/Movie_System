package movies.bean;

public class User {
    private String login_name;
    private String real_name;
    private String password;
    private Character gender;
    private String telephone_number;
    private Double account_amount;

    public User() {
    }

    public User(String login_name, String real_name, String password, Character gender, String telephone_number, Double account_amount) {
        this.login_name = login_name;
        this.real_name = real_name;
        this.password = password;
        this.gender = gender;
        this.telephone_number = telephone_number;
        this.account_amount = account_amount;
    }

    @Override
    public String toString() {
        return "User{" +
                "login_name='" + login_name + '\'' +
                ", real_name='" + real_name + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", telephone_number='" + telephone_number + '\'' +
                ", account_amount=" + account_amount +
                '}';
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public Double getAccount_amount() {
        return account_amount;
    }

    public void setAccount_amount(Double account_amount) {
        this.account_amount = account_amount;
    }
}
