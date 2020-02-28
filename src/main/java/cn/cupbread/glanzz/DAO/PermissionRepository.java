package cn.cupbread.glanzz.DAO;

import cn.cupbread.glanzz.Entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
    List<Permission> findByUserGroup(String usergroup);
}
