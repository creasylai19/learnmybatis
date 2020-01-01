package org.mybatis.example.domain;

import java.util.List;

/**
 *     uid int primary key auto_increment,
 *     user_name varchar(20),
 *     user_age int
 */
public class User {

    private int userId;
    private String userName;
    private int userAge;

    private List<BookOrder> userBookOrders;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public List<BookOrder> getUserBookOrders() {
        return userBookOrders;
    }

    public void setUserBookOrders(List<BookOrder> userBookOrders) {
        this.userBookOrders = userBookOrders;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
