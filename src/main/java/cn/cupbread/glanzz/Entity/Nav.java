package cn.cupbread.glanzz.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ：Cup_Of_Bread
 * @Date ：Created in 2020/5/25 8:52
 * @Description ：
 * @Version: :
 */

@Entity
@Table(name = "glanzz_nav")
@Accessors(chain = true)
@JsonIgnoreProperties(value = {"sonNav"})
@Data
public class Nav {
    @Id
    @GeneratedValue
    private Long id;

    private String location;
    private String name;
    private String url;

    @OneToMany(mappedBy = "parentNav",fetch = FetchType.EAGER)
    private List<Nav> sonNav=new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Nav parentNav;

}
