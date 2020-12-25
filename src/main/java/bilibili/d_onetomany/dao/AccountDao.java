package bilibili.d_onetomany.dao;

import bilibili.d_onetomany.entity.Account;
import bilibili.d_onetomany.entity.AccountUser;

import java.util.List;

/**
 * Author:BY
 * Date:2020/3/25
 * Description:用户的持久层接口
 */
public interface AccountDao {

    //    查询所有账户，同时还要获取到当前账户的所属用户信息
    List<Account> findAll();

    //    查询所有账户，并且带有用户名称和地址信息
    List<AccountUser> findAllAccount();
}
