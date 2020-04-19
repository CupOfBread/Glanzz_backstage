package cn.cupbread.glanzz.Service;

import cn.cupbread.glanzz.Entity.Classification;

import java.util.List;

public interface ClassificationService {
    Classification save_classifi(Classification classification);
    void del_classifi(Long id);
    Classification get_classifi_by_id(Long id);
    Classification get_classifi_by_name(String name);
    List<Classification> get_classifi_list();

}
