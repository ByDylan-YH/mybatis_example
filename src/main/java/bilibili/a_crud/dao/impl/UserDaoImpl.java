package bilibili.a_crud.dao.impl;

import bilibili.a_crud.dao.UserDao;
import bilibili.a_crud.entity.QueryVo;
import bilibili.a_crud.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Author:BY
 * Date:2020/3/24
 * Description:
 */
public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        //1.使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //2.使用session执行查询所有方法
        List<User> users = session.selectList("bilibili.a_dao.dao.UserDao.findAll");
        session.close();
        //3.返回查询结果
        return users;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public User findById(Integer userId) {
        return null;
    }

    @Override
    public List<User> findByName(String username) {
        return null;
    }

    @Override
    public int findTotal() {
        return 0;
    }

    @Override
    public List<User> findUserByVo(QueryVo vo) {
        return null;
    }

    @Override
    public List<User> findUserByCondition(User user) {
        return null;
    }

    @Override
    public List<User> findUserInIds(QueryVo vo) {
        return null;
    }
}
