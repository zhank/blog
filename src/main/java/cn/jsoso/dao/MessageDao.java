package cn.jsoso.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao {

    @Select("select count(*) from tb_message")
    public int getMessageCount();
}
