package com.example.userbackend;

import com.example.userbackend.model.response.UploadFileResponse;
import com.example.userbackend.service.FileService;
import com.example.userbackend.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UserBackendApplicationTests {
    @Autowired
    private FileService fileService;

    @Test
    void test_getExtensionFile() {
        assertThat(Utils.getFileExtension("hello.png")).isEqualTo("png");
        assertThat(Utils.getFileExtension("hello.png.png")).isEqualTo("png");
        assertThat(Utils.getFileExtension("hello.jpg")).isNotEqualTo("png");

        System.out.println(Utils.getFileExtension("hello.png"));
    }

    @Test
    void test_uploadFile() throws IOException {
        File fileDemo = new File(Paths.get(
                "uploads/1/3a83fce0-59a0-4076-9e21-bf0ed5b2f8d8.png").toString());
        FileInputStream fileInputStream = new FileInputStream(fileDemo);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        MultipartFile file = new MockMultipartFile(
                "Ảnh test",
                "image.png",
                MediaType.IMAGE_JPEG_VALUE,
                bufferedInputStream.readAllBytes());

        UploadFileResponse data = fileService.uploadFile(2, file);
        System.out.println(data.getFilePath());
    }
}
