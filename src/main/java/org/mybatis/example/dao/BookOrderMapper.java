package org.mybatis.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.example.domain.BookOrder;

import java.util.List;

/**
 *     oid int primary key auto_increment,
 *     order_code varchar(20),
 *     amount double,
 *     user_id int
 */
@Mapper
public interface BookOrderMapper {

    @Select("select * from book_order where user_id = #{uid}")
    public List<BookOrder> findBookOrdersByUserId(int uid);

}
