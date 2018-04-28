package com.leren.shiro;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lee
 * @Date:01/03/2018
 */
@ConfigurationProperties("application-cas.properties")
public class CasConstantConfig {

    static final String separator = ",";

    private String validateFilters;
    private String signOutFilters;
    private String authFilters;
    private String assertionFilters;
    private String requestWrapperFilters;

    private String casServerUrlPrefix;
    private String casServerLoginUrl;
    private String serverName;
    
    private boolean useSession = true;
    private boolean redirectAfterValidation = true;

    public String getValidateFilters() {
        return validateFilters;
    }

    public void setValidateFilters(String validateFilters) {
        this.validateFilters = validateFilters;
    }

    public String getSignOutFilters() {
        return signOutFilters;
    }

    public void setSignOutFilters(String signOutFilters) {
        this.signOutFilters = signOutFilters;
    }

    public String getAuthFilters() {
        return authFilters;
    }

    public void setAuthFilters(String authFilters) {
        this.authFilters = authFilters;
    }

    public String getAssertionFilters() {
        return assertionFilters;
    }

    public void setAssertionFilters(String assertionFilters) {
        this.assertionFilters = assertionFilters;
    }

    public String getRequestWrapperFilters() {
        return requestWrapperFilters;
    }

    public void setRequestWrapperFilters(String requestWrapperFilters) {
        this.requestWrapperFilters = requestWrapperFilters;
    }

    public String getCasServerUrlPrefix() {
        return casServerUrlPrefix;
    }

    public void setCasServerUrlPrefix(String casServerUrlPrefix) {
        this.casServerUrlPrefix = casServerUrlPrefix;
    }

    public String getCasServerLoginUrl() {
        return casServerLoginUrl;
    }

    public void setCasServerLoginUrl(String casServerLoginUrl) {
        this.casServerLoginUrl = casServerLoginUrl;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public boolean isUseSession() {
        return useSession;
    }

    public void setUseSession(boolean useSession) {
        this.useSession = useSession;
    }

    public boolean isRedirectAfterValidation() {
        return redirectAfterValidation;
    }

    public void setRedirectAfterValidation(boolean redirectAfterValidation) {
        this.redirectAfterValidation = redirectAfterValidation;
    }
}
