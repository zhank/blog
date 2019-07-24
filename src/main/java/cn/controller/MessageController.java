package cn.controller;

import cn.constant.ResultMsg;
import cn.entity.TbMessage;
import cn.constant.ResultStatus;
import cn.service.MessageService;
import cn.util.EmptyUtils;
import cn.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
/**
 * 留言版controller
 */
@RestController
@RequestMapping("msg")
public class MessageController {

    private static int pageSize = 10;

    @Autowired
    private MessageService messageService;

    @Autowired
    private IpUtil ipUtil;

    @PostMapping("addMsg")
    public ResultMsg addMessage(@RequestBody TbMessage tbMessage, HttpServletRequest request) {
        ResultMsg resultMsg = new ResultMsg();
        if(EmptyUtils.isEmpty(tbMessage.getUserName()) || EmptyUtils.isEmpty(tbMessage.getMsgContent()) || EmptyUtils.isEmpty(tbMessage.getHeadUrl())) {
            resultMsg.setCode(ResultStatus.FAIL.getId());
            resultMsg.setMsg("There is a blank value in the required parameters.");
            return resultMsg;
        }
        // 数据库操作
        //保存用户IP
        tbMessage.setUserIp(ipUtil.getIpAddr(request));

        int code = messageService.insertUserMsg(tbMessage);
        if(code == 0) {
            resultMsg.setCode(ResultStatus.FAIL.getId());
            resultMsg.setMsg("system error, Message failure!");
        } else {
            resultMsg.setCode(ResultStatus.SUCCESS.getId());
        }
        return resultMsg;
    }

    @GetMapping("getMsgCount")
    public ResultMsg getMessageCount() {
        ResultMsg msg = new ResultMsg();
        msg.setCode(ResultStatus.SUCCESS.getId());
        msg.setData(messageService.getMessageCount());
        return msg;
    }

    @GetMapping("getMsgByPageNum")
    public ResultMsg getMessage(int pageNum) {
        ResultMsg msg = new ResultMsg();
        msg.setCode(ResultStatus.SUCCESS.getId());
        msg.setData(messageService.getMessageList(pageNum, pageSize));
        return msg;
    }

}

