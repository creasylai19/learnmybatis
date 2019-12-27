import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.example.Blog;
import org.mybatis.example.BlogMapper;

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
        }
        inputStream.close();
        /*System.out.println(insertPersonSql());
        new TestBrace(){{
            System.out.println("MainClass");
        }}.toString();*/
    }

    public static String insertPersonSql() {
        return new SQL() {{
            INSERT_INTO("PERSON");
            VALUES("ID, FIRST_NAME", "#{id}, #{firstName}");
            VALUES("LAST_NAME", "#{lastName}");
        }}.toString();
    }
}
