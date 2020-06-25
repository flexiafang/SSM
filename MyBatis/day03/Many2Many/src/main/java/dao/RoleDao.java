package dao;

import domain.Role;

import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/6/10 15:40
 */
public interface RoleDao {
    /**
     * 查询所有角色
     *
     * @return
     */
    List<Role> findAll();
}
