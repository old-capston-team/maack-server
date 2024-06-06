package com.oldcapstone.maack.infra.aws;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;

@Component
@RequiredArgsConstructor
public class S3Uploader {

    private final AmazonS3Client amazonS3;

    public String upload(byte[] content, String bucket, String folder, String fileName) {
        String key = folder + "/" + fileName;
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(content.length);

        // 특정 폴더에 대해 Content-Disposition 설정
        if ("musicxml".equals(folder)) {
            metadata.setContentDisposition("inline");
        }

        ByteArrayInputStream inputStream = new ByteArrayInputStream(content);
        amazonS3.putObject(bucket, key, inputStream, metadata);

        return amazonS3.getUrl(bucket, key).toString();
    }
}
