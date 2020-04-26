package cn.cupbread.glanzz.Entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @Author ：Cup_Of_Bread
 * @Date ：Created in 2020/4/21 10:40
 * @Description ：
 * @Version: :
 */
@Entity
@Table(name = "glanzz_navigation")
@Accessors(chain = true)
@Data
public class Navigation {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String ename;
    private String location;
    private String parent;
}
