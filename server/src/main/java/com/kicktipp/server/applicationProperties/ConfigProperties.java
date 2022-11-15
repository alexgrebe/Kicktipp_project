package com.kicktipp.server.applicationProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "tippspiel")
public class ConfigProperties {

    private boolean defaultLogin;

    public boolean isDefaultLogin() {
        return defaultLogin;
    }

    public void setDefaultLogin(boolean defaultLogin) {
        this.defaultLogin = defaultLogin;
    }
}
