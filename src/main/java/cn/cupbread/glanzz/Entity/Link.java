package cn.cupbread.glanzz.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Date: 2020/6/27 20:30
 * @Author: CupOfBread
 * @Description: 友情链接
 */
@Entity
@Table(name = "glanzz_link")
@Accessors(chain = true)
@Data
public class Link implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String siteName;
    private String authorName;
    private String url;
    private String description;
    private String avatar;
    private String bgpic;
}
