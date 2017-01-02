package com.scg;

import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

import javax.servlet.MultipartConfigElement;

/**
 * Created by sungbo on 2016-07-08.
 * Spring Boot : maxFileSize, maxRequestSize
 * application.properties
 * multipart.maxFileSize=10Mb
 * multipart.maxRequestSize=-1
 */
@ConfigurationProperties(prefix = "spring.http.multipart", ignoreUnknownFields = false)
public class MultipartProperties {

    /**
     * Enable support of multi-part uploads.
     */
    private boolean enabled = true;

    /**
     * Intermediate location of uploaded files.
     */
    private String location;

    /**
     * Max file size. Values can use the suffixed "MB" or "KB" to indicate a Megabyte or
     * Kilobyte size.
     */
    private String maxFileSize = "10Mb";

    /**
     * Max request size. Values can use the suffixed "MB" or "KB" to indicate a Megabyte
     * or Kilobyte size.
     */
    private String maxRequestSize = "10Mb";

    /**
     * Threshold after which files will be written to disk. Values can use the suffixed
     * "MB" or "KB" to indicate a Megabyte or Kilobyte size.
     */
    private String fileSizeThreshold = "0";

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaxFileSize() {
        return this.maxFileSize;
    }

    public void setMaxFileSize(String maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getMaxRequestSize() {
        return this.maxRequestSize;
    }

    public void setMaxRequestSize(String maxRequestSize) {
        this.maxRequestSize = maxRequestSize;
    }

    public String getFileSizeThreshold() {
        return this.fileSizeThreshold;
    }

    public void setFileSizeThreshold(String fileSizeThreshold) {
        this.fileSizeThreshold = fileSizeThreshold;
    }

    /**
     * Create a new {@link MultipartConfigElement} using the properties.
     * @return a new {@link MultipartConfigElement} configured using there properties
     */
    public MultipartConfigElement createMultipartConfig() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        if (StringUtils.hasText(this.fileSizeThreshold)) {
            factory.setFileSizeThreshold(this.fileSizeThreshold);
        }
        if (StringUtils.hasText(this.location)) {
            factory.setLocation(this.location);
        }
        if (StringUtils.hasText(this.maxRequestSize)) {
            factory.setMaxRequestSize(this.maxRequestSize);
        }
        if (StringUtils.hasText(this.maxFileSize)) {
            factory.setMaxFileSize(this.maxFileSize);
        }
        return factory.createMultipartConfig();
    }

}
