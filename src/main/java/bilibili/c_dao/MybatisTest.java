package bilibili.c_dao;

import bilibili.c_dao.dao.UserDao;
import bilibili.c_dao.dao.impl.UserDaoImpl;
import bilibili.c_dao.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author:BY
 * Date:2020/3/24
 * Description:
 */
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    //用于在测试方法执行之前执行
    @Before
    public void init() {
        try {
            //1.读取配置文件，生成字节输入流
            in = Resources.getResourceAsStream("bilibili/c_dao/SqlMapConfig.xml");
            //2.获取SqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            // 一丶没有实现类的写法:
            //3.使用工厂生产SqlSession对象,工厂模式:解耦,不用new对象
            sqlSession = factory.openSession();
            //4.使用SqlSession创建Dao接口的代理对象,代理模式:不修改源码的基础上对已有方法增强
//            userDao = sqlSession.getMapper(UserDao.class);
            // 二丶有实现类
            userDao = new UserDaoImpl(factory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //用于在测试方法执行之后执行
    @After
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    //  测试查询所有
    @Test
    public void testFindAll() {
        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    //测试保存操作
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("root");
        user.setPassword("By921644606");
        System.out.println("保存操作之前：" + user);
        //5.执行保存方法
        userDao.saveUser(user);
        System.out.println("保存操作之后：" + user);
    }

    //   测试更新操作
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1);
        user.setUsername("root");
        user.setPassword("By960122");

        //5.执行保存方法
        userDao.updateUser(user);
    }

    //    测试删除操作
    @Test
    public void testDelete() {
        userDao.deleteUser(0);
    }

    //    测试模糊查询操作
    @Test
    public void testFindByName() {
        //5.执行查询一个方法
        List<User> users = userDao.findByName("%oo%");
//        List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    //    测试查询总记录条数
    @Test
    public void testFindTotal() {
        //5.执行查询一个方法
        int count = userDao.findTotal();
        System.out.println(count);
    }
}
