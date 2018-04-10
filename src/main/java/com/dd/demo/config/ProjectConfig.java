package com.dd.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:/project.properties")
@ConfigurationProperties(prefix = "")
public class ProjectConfig {
    private String fileSavePath;

    public String getFileSavePath() {
        return fileSavePath;
    }

    public void setFileSavePath(String fileSavePath) {
        this.fileSavePath = fileSavePath;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "fileSavePath='" + fileSavePath + '\'' +
                '}';
    }
}
