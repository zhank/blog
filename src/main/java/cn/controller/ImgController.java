package cn.controller;

import cn.config.AppConfig;
import cn.constant.ResultMsg;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("img")
public class ImgController {

    //这个注入配置文件，主要是因为本地的路径和服务器url路径需要动态配置，可以自己写死，也可以动态获取
    @Autowired
    AppConfig appConfig;

    @RequestMapping("uploadImg")
    public ResultMsg uploadImg(MultipartFile file) throws IOException {

        System.out.println(System.getProperty("user.dir"));
        ResultMsg resultMsg = new ResultMsg();

        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if (!path.exists()) {
            path = new File("");
        }
        System.out.println("path:" + path.getAbsolutePath());

        String fileName = "";
        String filePath;
        String imgUrl;
        if (!file.isEmpty()) {
            //返回的是字节长度,1M=1024k=1048576字节 也就是if(fileSize<5*1048576)
            if (file.getSize() > (1048576 * 5)) {
                resultMsg.setMsg("文件太大，请上传小于5MB的");
                return resultMsg;
            }
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            if (StringUtils.isBlank(suffix)) {
                resultMsg.setMsg("文件太上传文件没有后缀，无法识别");
                return resultMsg;
            }
            fileName = System.currentTimeMillis() + suffix;
            imgUrl = File.separator + "uploadImg" + File.separator + fileName;
            filePath = path.getAbsolutePath() + File.separator + "static" + imgUrl;

            File upload = new File(filePath);
            if (!upload.getParentFile().exists()) {
                upload.mkdirs();
            }
            try {
                file.transferTo(upload); //保存文件
            } catch (Exception e) {
                e.printStackTrace();
                resultMsg.setCode(-1);
                resultMsg.setMsg("上传失败" + e.getMessage());
                return resultMsg;
            }
        } else {
            resultMsg.setMsg("上传出错");
            return resultMsg;
        }
        resultMsg.setUrl(imgUrl);
        resultMsg.setCode(200);
        return resultMsg;
    }
}
