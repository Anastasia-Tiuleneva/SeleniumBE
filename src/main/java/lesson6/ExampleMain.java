package lesson6;
import lesson6.db.dao.CategoriesMapper;
import lesson6.db.model.Categories;
import lesson6.db.model.CategoriesExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;



public class ExampleMain {

    public static void main( String[] args ) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CategoriesMapper mapper = session.getMapper(CategoriesMapper.class);
            Categories cat = mapper.selectByPrimaryKey(1L);
        }


        }


//    private static CategoriesMapper getCategoriesMapper(String resource) throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new
//                SqlSessionFactoryBuilder().build(inputStream);
//        sqlSessionFactory.openSession();
//        SqlSession session = sqlSessionFactory.openSession();
//        return session.getMapper(CategoriesMapper.class);
//    }
//
////    public static Integer countNumberOfAllCategories() {
////        String resource = "mybatis-config.xml";
////        CategoriesMapper categoriesMapper = getCategoriesMapper(resource);
////        CategoriesExample example = new CategoriesExample();
////        return Math.toIntExact(categoriesMapper.countByExample(example));
////    }
//
////    private static CategoriesMapper getCategoriesMapper(String resource) {
////        InputStream inputStream = Resources.getResourceAsStream(resource);
////        SqlSessionFactory sqlSessionFactory = new
////                SqlSessionFactoryBuilder().build(inputStream);
////        sqlSessionFactory.openSession();
////        SqlSession session = sqlSessionFactory.openSession();
////        return session.getMapper(CategoriesMapper.class);
////    }
}