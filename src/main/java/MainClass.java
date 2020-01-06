import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.example.dao.UserMapper;
import org.mybatis.example.domain.Blog;
import org.mybatis.example.dao.BlogMapper;
import org.mybatis.example.domain.User;
import org.mybatis.example.utils.ExamplePlugin;

import java.io.IOException;
import java.io.InputStream;

public class MainClass {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlog(1);
            System.out.println(blog);

            blog = mapper.findByColumn("bname", "数据结构");
//            Blog blog = mapper.selectBlogById(2);
            System.out.println(blog);

//            UserMapper userMapper = session.getMapper(UserMapper.class);
//            User user = userMapper.findUserById(1);
//            System.out.println(user);
//            System.out.println(user.getBookOrders());

//            blog.setbName("新的值");
//            session.update("org.mybatis.example.dao.BlogMapper.updateBlog", blog);
//            session.commit();
        }
        inputStream.close();
        /*System.out.println(insertPersonSql());
        new TestBrace(){{
            System.out.println("MainClass");
        }}.toString();*/
        System.out.println(ExamplePlugin.class.getInterfaces());
        System.out.println(ExamplePlugin.class.getCanonicalName());
        System.out.println(ExamplePlugin.class.getSimpleName());
        System.out.println(ExamplePlugin.class.getName());
        System.out.println(ExamplePlugin.class.getTypeName());
    }

    public static String insertPersonSql() {
        return new SQL() {{
            INSERT_INTO("PERSON");
            VALUES("ID, FIRST_NAME", "#{id}, #{firstName}");
            VALUES("LAST_NAME", "#{lastName}");
        }}.toString();
    }
}
