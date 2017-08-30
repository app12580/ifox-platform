package com.ifox.platform.dao.sys.impl;

import com.ifox.platform.dao.common.impl.GenericHibernateDaoImpl;
import com.ifox.platform.dao.sys.MenuPermissionDao;
import com.ifox.platform.entity.sys.MenuPermissionEO;
import com.ifox.platform.utility.dao.HQLUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MenuPermissionDaoImpl extends GenericHibernateDaoImpl<MenuPermissionEO, String> implements MenuPermissionDao{

    /**
     * 获取菜单的最大层级
     * @return 最大层级
     */
    @Override
    public Integer getBottomLevel() {
        String hql = "SELECT max(menu.level) FROM MenuPermissionEO menu";
        return getHibernateTemplate().execute(session -> {
            Object result = HQLUtil.createQueryByHQL(session, hql, null).uniqueResult();
            return result == null ? null : Integer.valueOf(result.toString());
        });
    }

    /**
     * 删除菜单权限和角色的关联关系
     * @param menuId
     */
    @Override
    public void deleteMenuRoleRelation(String menuId) {
        String sql = "DELETE isrmp FROM ifox_sys_role_menu_permission AS isrmp WHERE isrmp.menu_permission = :menuId";
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.createSQLQuery(sql).setParameter("menuId", menuId).executeUpdate();
    }
}
