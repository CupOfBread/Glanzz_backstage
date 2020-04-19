package cn.cupbread.glanzz.DAO;

import cn.cupbread.glanzz.Entity.Classification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Date: 2020/2/22
 * @Author: CupOfBread
 * @Description:
 */

public interface ClassificationRepository extends JpaRepository<Classification,Long> {
    Classification findByName(String name);
}
