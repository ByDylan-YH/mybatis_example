package bilibili.a_crud.dao;

import bilibili.a_crud.entity.QueryVo;
import bilibili.a_crud.entity.User;

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

    //    根据queryVo中的条件查询用户
    List<User> findUserByVo(QueryVo vo);

    //    根据传入参数条件,查询的条件：有可能有用户名,有可能有性别,也有可能有地址,还有可能是都有
    List<User> findUserByCondition(User user);

    //    根据queryvo中提供的id集合，查询用户信息
    List<User> findUserInIds(QueryVo vo);
}
