package com.adidas.challenge;

import javax.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@Data
@ConfigurationProperties(prefix = "doc")
public class Properties {

  @NotNull
  private API api;

  @Data
  public static class API {

    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String version;
    @NotNull
    private Maintainer maintainer;

    private String termsOfServiceUrl;
    private String license;
    private String licenseUrl;

  }

  @Data
  public static class Maintainer {

    @NotNull
    private String name;
    @NotNull
    private String email;

  }

}
