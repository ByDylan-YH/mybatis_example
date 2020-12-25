package mybatis;

import mybatis.dao.UserDao;
import mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author:BY
 * Date:2020/3/24
 * Description:
 */
class MybatisTest {
    public static void main(String[] args) {
        //1.读取配置文件
        try {
            InputStream in = Resources.getResourceAsStream("bilibili/b_annotation/SqlMapConfig.xml");
            //2.创建SqlSessionFactory工厂,建造者模式:封装繁琐细节
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            //3.使用工厂生产SqlSession对象,工厂模式:解耦,不用new对象
            SqlSession session = factory.openSession();
            //4.使用SqlSession创建Dao接口的代理对象,代理模式:不修改源码的基础上对已有方法增强
            UserDao userDao = session.getMapper(UserDao.class);
            //5.使用代理对象执行方法
            List<User> users = userDao.findAll();
            for (User user : users) {
                System.out.println(user);
            }
            //6.释放资源
            session.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
