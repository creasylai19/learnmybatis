package org.mybatis.example.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.mybatis.example.domain.User;

@Mapper
public interface UserMapper {

    @Select("select * from user where uid = #{uid}")
    @Results({
            @Result(id = true, column = "uid", property = "userId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "user_age", property = "userAge"),
            @Result(column="uid", property = "userBookOrders", javaType = java.util.ArrayList.class, many = @Many(
                    select = "org.mybatis.example.dao.BookOrderMapper.findBookOrdersByUserId", fetchType = FetchType.LAZY
            ))
    })
    public User findUserById(int uid);

}
