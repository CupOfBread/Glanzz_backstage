package cn.cupbread.glanzz.Service;

import cn.cupbread.glanzz.DAO.NavRepository;
import cn.cupbread.glanzz.Entity.Nav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author ：Cup_Of_Bread
 * @Date ：Created in 2020/5/25 9:06
 * @Description ：
 * @Version: :
 */

@Service
public class NavServiceImpl implements NavService {
    @Autowired
    private NavRepository navRepository;

    @Transactional
    @Override
    public List<Nav> get_nav_list() {
        return navRepository.findAll();
    }
}
