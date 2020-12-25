package bilibili.b_annotation.dao;

import bilibili.b_annotation.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Author:BY
 * Date:2020/3/24
 * Description:用户的持久层接口
 */
public interface UserDao {

//    查询所有用户
    @Select("select * from user")
    List<User> findAll();

//    保存用户
    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

//    更新用户
    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    void updateUser(User user);

//    删除用户
    @Delete("delete from user where id=#{id} ")
    void deleteUser(Integer userId);

//    根据id查询用户
    @Select("select * from user  where id=#{id} ")
    User findById(Integer userId);

//    根据用户名称模糊查询
//    @Select("select * from user where username like #{username};")
    @Select("select * from user where username like '%${value}%';")
    List<User> findUserByName(String username);

//    查询总用户数量
    @Select("select count(`) from user;")
    int findTotalUser();
}
