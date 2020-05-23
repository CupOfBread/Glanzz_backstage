package cn.cupbread.glanzz.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Date: 2020/2/22
 * @Author: CupOfBread
 * @Description:
 */
@Entity
@Table(name = "glanzz_user")
@Accessors(chain = true)
@Data
@ToString(callSuper = true,exclude = {"articles","comments"})
@JsonIgnoreProperties(value = {"articles","comments"})
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;  //用户名
    private String mail;  //邮箱  [用于登录]
    private String gravatar;  //头像
    private String password;  //密码[MD5加密]
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String description;  //个人描述
    private String state;  //状态
    private String createTime;  //创建时间

    private String userGroup;  //用户组

    private String wx;
    private String qq;

    @OneToMany(mappedBy = "user")
    private List<Article> articles=new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments=new ArrayList<>();

}
