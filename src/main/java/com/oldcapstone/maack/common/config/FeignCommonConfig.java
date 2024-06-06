package com.oldcapstone.maack.common.config;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.oldcapstone.maack.infra.feign.BaseFeignClientPackage;
import feign.Logger;
import feign.codec.Decoder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackageClasses = {BaseFeignClientPackage.class})
public class FeignCommonConfig {

}
