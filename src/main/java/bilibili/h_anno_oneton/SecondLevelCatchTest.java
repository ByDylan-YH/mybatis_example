package bilibili.h_anno_oneton;

import bilibili.h_anno_oneton.dao.UserDao;
import bilibili.h_anno_oneton.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Author:BY
 * Date:2020/3/25
 * Description:
 */
public class SecondLevelCatchTest {

    private InputStream in;
    private SqlSessionFactory factory;


    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("bilibili/h_anno_oneton/SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    @After
    public void destroy() throws Exception {
        in.close();
    }

    @Test
    public void testFindOne() {
        SqlSession session = factory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        User user = userDao.findById(57);
        System.out.println(user);

        session.close();//释放一级缓存

        SqlSession session1 = factory.openSession();//再次打开session
        UserDao userDao1 = session1.getMapper(UserDao.class);
        User user1 = userDao1.findById(57);
        System.out.println(user1);
        session1.close();
    }
}
