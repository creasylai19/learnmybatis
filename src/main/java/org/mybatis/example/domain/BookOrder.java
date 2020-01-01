package org.mybatis.example.domain;

/**
 *     oid int primary key auto_increment,
 *     order_code varchar(20),
 *     amount double,
 *     user_id int
 */
public class BookOrder {

    private int oid;
    private String order_code;
    private double amount;
    private int user_id;

    private User user;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BookOrder{" +
                "oid=" + oid +
                ", order_code='" + order_code + '\'' +
                ", amount=" + amount +
                ", user_id=" + user_id +
                ", user=" + user +
                '}';
    }
}
