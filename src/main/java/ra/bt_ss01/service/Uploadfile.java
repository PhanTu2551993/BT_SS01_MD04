package ra.bt_ss01.service;

import org.springframework.web.multipart.MultipartFile;

public interface Uploadfile {
    public String uploadToLocal(MultipartFile multipartFile);
    public String uploadToFirebase(String localPath);
}
