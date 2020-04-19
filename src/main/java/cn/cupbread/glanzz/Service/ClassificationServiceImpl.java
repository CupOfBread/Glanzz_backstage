package cn.cupbread.glanzz.Service;

import cn.cupbread.glanzz.DAO.ClassificationRepository;
import cn.cupbread.glanzz.Entity.Classification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Date: 2020/3/22
 * @Author: CupOfBread
 * @Description:
 */
@Service
public class ClassificationServiceImpl implements ClassificationService {
    @Autowired
    private ClassificationRepository classificationRepository;

    @Transactional
    @Override
    public Classification save_classifi(Classification classification) {
        return classificationRepository.save(classification);
    }

    @Transactional
    @Override
    public void del_classifi(Long id) {
        classificationRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Classification get_classifi_by_id(Long id) {
        return classificationRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Classification get_classifi_by_name(String name) {
        return classificationRepository.findByName(name);
    }

    @Transactional
    @Override
    public List<Classification> get_classifi_list() {
        return classificationRepository.findAll();
    }
}
