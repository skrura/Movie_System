package movies.bean;

public class Business extends User{
    private String address;
    private String shop_name;

    public Business() {
    }

    public Business(String login_name, String real_name, String password, Character gender, String telephone_number, Double account_amount, String address, String shop_name) {
        super(login_name, real_name, password, gender, telephone_number, account_amount);
        this.address = address;
        this.shop_name = shop_name;
    }

    @Override
    public String toString() {
        return "Business{" +
                "address='" + address + '\'' +
                ", shop_name='" + shop_name + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }
}
