package com.oldcapstone.maack.common.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "cloud.aws.s3")
public class S3BucketProperties {
    private String bucket;
}
