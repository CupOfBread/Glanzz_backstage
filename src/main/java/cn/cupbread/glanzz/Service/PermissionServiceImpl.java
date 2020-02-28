package cn.cupbread.glanzz.Service;

import cn.cupbread.glanzz.DAO.PermissionRepository;
import cn.cupbread.glanzz.Entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Date: 2020/2/25
 * @Author: CupOfBread
 * @Description:
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Transactional
    @Override
    public List<Permission> get_perm(String usergroup) {
        return permissionRepository.findByUserGroup(usergroup);
    }
}
