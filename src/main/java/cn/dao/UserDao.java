package cn.dao;

import cn.entity.TbUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: sfpy
 * @Date: 19/07/31 20:06
 * @Descirption
 * @Version 1.0
 */
@Repository
public interface UserDao {
    @Select("SELECT count(*) FROM tb_user t  WHERE t.userName=#{userName} and t.password=#{password} AND STATUS=10")
    public int userLogin(@Param("username") String userName, @Param("password") String password);

    @Select("SELECT count(*) FROM tb_user t  WHERE t.username=#{userName} AND STATUS=10 ")
    public int getCountByUserName(String userName);

    @Select("SELECT * FROM tb_user t  WHERE t.userName=#{userName} AND t.password=#{password} AND STATUS=10")
    TbUser findUserByAccount(String userName, String password);

    @Select("SELECT * FROM tb_user t  WHERE t.status=10")
    List<TbUser> getAllUserList();

    @Insert("insert into tb_user(id, userName, password, email, phone, creatDate, updateDate, status) " +
            "values( #{id}, #{userName},#{password},#{email}, #{phone}, #{creatDate},#{updateDate}, #{status})")
    void addUser(TbUser user);

    @Delete("UPDATE TB_USER SET STATUS=-1  WHERE ID = #{userId} AND STATUS=10")
    void deleteUserById(String userId);
}
