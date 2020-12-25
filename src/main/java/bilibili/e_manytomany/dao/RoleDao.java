package bilibili.e_manytomany.dao;

import bilibili.e_manytomany.entity.Role;

import java.util.List;

/**
 * Author:BY
 * Date:2020/3/25
 * Description:
 */
public interface RoleDao {

//    查询所有角色
    List<Role> findAll();
}