package org.mybatis.example.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.example.domain.Blog;

public interface BlogMapper {


    /**
     * //@Select("select * from Blog where bid = #{id}")
     * @param id
     * @return
     */
    Blog selectBlog(int id);

    /**
     *
     * @param id
     * @return
     */
    @Select({"select * from blog where bid = #{value}"})
    Blog selectBlogById(int id);

    @Select("select * from blog where ${param1} = #{param2}")
    Blog findByColumn(String columnName, String columnValue);

}
