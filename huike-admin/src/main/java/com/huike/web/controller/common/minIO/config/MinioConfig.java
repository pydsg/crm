package com.huike.web.controller.common.minIO.config;

import com.huike.web.controller.common.minIO.pojo.MinioProperties;
import io.minio.MinioClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenxin
 */
@Configuration
@Data
public class MinioConfig {

    @Autowired
    private MinioProperties minioProperties;

    @Bean
    public MinioClient minioClient() {
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint(minioProperties.getEndpoint())
                        .credentials(minioProperties.getAccessKey(),
                                minioProperties.getSecretKey())
                        .build();
        return minioClient;
    }
}
