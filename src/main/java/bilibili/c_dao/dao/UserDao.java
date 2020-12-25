package bilibili.c_dao.dao;

import bilibili.c_dao.entity.User;

import java.util.List;

/**
 * Author:BY
 * Date:2020/3/24
 * Description:用户的持久层接口
 */
public interface UserDao {
    //    查询全部
    List<User> findAll();

    //    保存
    void saveUser(User user);

    //    更新用户
    void updateUser(User user);

    //    根据Id删除用户
    void deleteUser(Integer userId);

    //    根据id查询用户信息
    User findById(Integer userId);

    //    根据名称模糊查询用户信息
    List<User> findByName(String username);

    //    查询总用户数
    int findTotal();
}
