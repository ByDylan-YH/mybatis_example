package mybatis.dao;

import mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Author:BY
 * Date:2020/3/24
 * Description:用户的持久层接口,可以用注解,也可以配置 dao.xml,批量插入只能配置 xml
 * <!-- 保存用户,parameterType 传入参数 -->
 * <insert id="saveBatchData">
 * INSERT INTO hive_table_detail
 * (table_name,column_name,column_type,column_comment,create_time,modify_time)
 * VALUES
 * <foreach collection="list" item="dataEntity" separator=",">
 * (#{dataEntity.tableName}, #{dataEntity.columnName}, #{dataEntity.columnType}, #{dataEntity.columnComment},
 * #{dataEntity.createTime}, #{dataEntity.modifyTime})
 * </foreach>
 * </insert>
 * <p>
 * open="(" close=")" separator="," 这样写会把所有语句最后用括号包起来
 * <p>
 * 多参数写法
 * <insert id="saveBatchData">
 * INSERT INTO ${param1}
 * (table_name,column_name,column_type,column_comment,create_time,modify_time)
 * VALUES
 * <foreach collection="param2" item="dataEntity" separator=",">
 * (#{dataEntity.tableName}, #{dataEntity.columnName}, #{dataEntity.columnType}, #{dataEntity.columnComment},
 * #{dataEntity.createTime}, #{dataEntity.modifyTime})
 * </foreach>
 * </insert>
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
    @Select("select * from user where id=#{id} ")
    User findById(Integer userId);

    //    根据id查询用户
    @Select("select * from user where id=#{id} ")
    User findById2(@Param("id") Integer userId);

    //    根据用户名称模糊查询,string 类型 用 $,不能用 #
    @Select("select * from user where username like '%${value}%';")
    List<User> findUserByName(String username);

    //    查询总用户数量
    @Select("select count(`) from user;")
    int findTotalUser();
}
