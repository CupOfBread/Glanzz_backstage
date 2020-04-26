package cn.cupbread.glanzz.Service;

import cn.cupbread.glanzz.Component.RetResponse;
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
    public RetResponse del_classifi(Long id) {
        Classification classification=get_classifi_by_id(id);
        if (classification.getArticles()!=null){
            classificationRepository.deleteById(id);
            return new RetResponse().makeOKRsp(200);
        }
        return new RetResponse().makeErrRsp(500,"当前分类下仍有文章！");
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
