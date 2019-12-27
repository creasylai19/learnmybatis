package org.mybatis.example;

public interface BlogMapper {


    /**
     * //@Select("select * from Blog where bid = #{id}")
     * @param id
     * @return
     */
    Blog selectBlog(int id);

}
