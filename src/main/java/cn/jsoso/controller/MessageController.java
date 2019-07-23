package cn.jsoso.controller;

import cn.jsoso.constant.ResultMsg;
import cn.jsoso.constant.ResultStatus;
import cn.jsoso.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 留言版controller
 */
@RestController
@RequestMapping("msg")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("addMsg")
    public ResultMsg addMessage(@RequestBody Map msgJson) {
        System.out.println(msgJson);
        ResultMsg resultMsg = new ResultMsg();
        return resultMsg;
    }

    @GetMapping("getMsgCount")
    public ResultMsg getMessageCount() {
        ResultMsg msg = new ResultMsg();
        msg.setCode(ResultStatus.SUCCESS.getId());
        msg.setData(messageService.getMessageCount());
        return msg;
    }
}

