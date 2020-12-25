package bilibili.d_onetomany.dao;

import bilibili.d_onetomany.entity.User;

import java.util.List;

/**
 * Author:BY
 * Date:2020/3/25
 * Description:用户的持久层接口
 */
public interface UserDao {

//    查询所有用户，同时获取到用户下所有账户的信息
    List<User> findAll();

//    根据id查询用户信息
    User findById(Integer userId);

}
