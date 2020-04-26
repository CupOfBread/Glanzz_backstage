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
@Table(name = "glanzz_option")
@Accessors(chain = true)
@Data
public class Option {
    @Id
    @GeneratedValue
    private Long id;

    private String opt;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String val1;
    private String val2;
}
