package cn.entity;



import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TbUser implements java.io.Serializable{

    public String id;

    public String userName;

    public String password;

    public String phone;

    public Date createDate;

    public Date updateDate;

    public String email;

    public int status;

}