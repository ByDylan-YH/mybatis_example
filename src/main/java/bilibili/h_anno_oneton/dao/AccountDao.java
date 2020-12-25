package bilibili.h_anno_oneton.dao;

import bilibili.h_anno_oneton.entity.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Author:BY
 * Date:2020/3/25
 * Description:
 */
public interface AccountDao {

//    查询所有账户，并且获取每个账户所属的用户信息
    @Select("select * from account;")
    @Results(id="accountMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one=@One(select="bilibili.h_anno_oneton.dao.UserDao.findById",fetchType= FetchType.EAGER))
    })
    List<Account> findAll();

    //    根据用户id查询账户信息
    @Select("select * from account where uid = #{userId};")
    List<Account> findAccountByUid(Integer userId);
}
