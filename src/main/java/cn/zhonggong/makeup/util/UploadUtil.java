package cn.zhonggong.makeup.util;

import cn.zhonggong.makeup.vo.ResultVO;
import org.apache.tomcat.util.descriptor.web.SecurityRoleRef;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 军辉
 * 2019-07-17 20:50
 */
public class UploadUtil {

    @Value("${preread.uploadPath}")
    private String path;

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
        String filePath = "d:/imgage/";
        File tarFile = new File(filePath, name);
        if (!tarFile.getParentFile().exists()) {
            tarFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(tarFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultVOUtil.Success(filePath + name);


    }
}
