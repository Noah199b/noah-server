package com.noah1996.admin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Admin {

    /** 唯一标书 uuid */
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private Long id;

    /** 用户名 */
    @Column
    private String username;

    /** 用户密码 */
    @Column
    private String password;

    /** 用户昵称 */
    @Column
    private String nickName;

    /** 生日 */
    @Column
    private Date birthday;

    /** 头像（路径） */
    @Column
    private String avatar;

    /** 个性签名 */
    @Column
    private String signature;

    /** 个人标签 */
    @Column
    private String tags;

    /** 自我介绍 */
    @Column
    private String introduction;

    /** 创建时间 */
    @Column
    private Date createDate;

    /** 修改时间 */
    @Column
    private Date modifyDate;


}
