package cn.cupbread.glanzz.Service;

import cn.cupbread.glanzz.Entity.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> get_perm(String usergroup);
}
