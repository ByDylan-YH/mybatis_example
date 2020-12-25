package bilibili.e_manytomany.dao;

import bilibili.e_manytomany.entity.User;

import java.util.List;

/**
 * Author:BY
 * Date:2020/3/25
 * Description:
 */
public interface UserDao {

//    查询所有用户，同时获取到用户下所有账户的信息
    List<User> findAll();

//    根据id查询用户信息
    User findById(Integer userId);

}
