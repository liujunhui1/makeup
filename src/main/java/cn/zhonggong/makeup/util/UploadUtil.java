package cn.zhonggong.makeup.util;

import cn.zhonggong.makeup.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.descriptor.web.SecurityRoleRef;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 军辉
 * 2019-07-17 20:50
 */
@Slf4j
@Component
public class UploadUtil {

    @Value("${preread.uploadPath}")
    private static String path = "d:/images/";


    public static ResultVO uploadPic(MultipartFile file) {
        if (file == null) {
            return ResultVOUtil.Fail("文件为空");
        }
        String originName = file.getOriginalFilename();
        String ext = null;
        if (originName.contains(".")) {
            ext = originName.substring(originName.lastIndexOf("."));
        } else {
            ext = "";
        }
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String name = uuid + ext;
        //  String filePath = "d:/imgage/";
        System.out.println("path:" + path);
        File tarFile = new File(path, name);
        if (!tarFile.getParentFile().exists()) {
            tarFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(tarFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pictureUrl = path.split(":")[1] + name;
        log.info(pictureUrl);
        return ResultVOUtil.Success(pictureUrl);


    }
}
