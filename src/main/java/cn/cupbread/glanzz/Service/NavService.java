package cn.cupbread.glanzz.Service;

import cn.cupbread.glanzz.Entity.Nav;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NavService{

    List<Nav> get_nav_list();

}
