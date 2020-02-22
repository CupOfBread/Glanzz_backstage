package cn.cupbread.glanzz.Entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

/**
 * @Date: 2020/2/22
 * @Author: CupOfBread
 * @Description:
 */
@Entity
@Table(name = "glanzz_article")
@Accessors(chain = true)
@Data
public class Token {
    @Id
    @GeneratedValue
    private Long id;

    private String token;
    private String mail;  //用户邮箱
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;  //过期时间
}
