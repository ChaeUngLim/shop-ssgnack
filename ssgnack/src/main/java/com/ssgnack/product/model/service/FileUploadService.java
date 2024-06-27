package com.ssgnack.product.model.service;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class FileUploadService {

    private static final Logger log = LoggerFactory.getLogger(FileUploadService.class);
    @Value("${ftp.server.host}")
    private String server;

    @Value("${ftp.server.port}")
    private int port;

    @Value("${ftp.server.username}")
    private String username;

    @Value("${ftp.server.password}")
    private String password;

    public String upload(MultipartFile multipartFile) throws IOException {
        FTPClient ftpClient = new FTPClient();
        log.info("✈️ 로깅1 ✈️");
        try {
            ftpClient.connect(server, port);
            log.info("✈️ 로깅2 ✈️");
            ftpClient.login(username, password);
            log.info("✈️ 로깅3 ✈️");
            ftpClient.enterLocalPassiveMode();
            log.info("✈️ 로깅4 ✈️");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            log.info("✈️ 로깅5 ✈️");

            try (InputStream inputStream = multipartFile.getInputStream()) {
                log.info("✈️ 로깅6 ✈️");
                String contentType = multipartFile.getContentType();
                log.info("✈️ 로깅7 ✈️");
                String originalFilename = multipartFile.getOriginalFilename();
                log.info("✈️ 로깅8 ✈️");
                String dir = "/";
                log.info("✈️ 로깅9 ✈️");
                String renamedFilename = getRenamedFilename(originalFilename);
                // 실제 파일전송
                log.info("✈️✈️✈️✈️파일 전송 : {} ✈️✈️✈️✈️",renamedFilename);
                boolean done = ftpClient.storeFile(dir + renamedFilename, inputStream);
                if (!done)
                    throw new RuntimeException("[" + multipartFile + "] 파일 업로드에 실패했습니다.");

                // Builder패턴을 사용한 객체 생성
                return renamedFilename;
            }
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String getRenamedFilename(String originalFilename) {
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        return "%s%s".formatted(UUID.randomUUID().toString(), ext);
    }

}
