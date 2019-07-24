package cn.dao;

import cn.entity.TbMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {

    @Select("select count(*) from tb_message")
    public int getMessageCount();

    @SelectKey(keyProperty = "messageId",resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '')")
    @Options(keyProperty = "messageId", useGeneratedKeys = true)
    @Insert("insert into tb_message (message_id, user_name, msg_content, user_ip, msg_date, head_url)" +
            "values(#{messageId}, #{userName}, #{msgContent}, #{userIp}, #{msgDate}, #{headUrl}) ")
    public int insertUserMsg(TbMessage tbMessage);

    @Select("select user_name as userName, msg_content as msgContent, " +
            " user_ip as userIp, msg_date as msgDate, head_url as headUrl from tb_message order by msgDate desc")
    public List<TbMessage> getAllMessage();
}
