package com.kavish.tutorials.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Accept",
        "Accept-Encoding",
        "Accept-Language",
        "Cache-Control",
        "Host",
        "If-Modified-Since",
        "Pragma",
        "Upgrade-Insecure-Requests",
        "User-Agent",
        "X-Bluecoat-Via"
})
public class Headers {

    @JsonProperty("Accept")
    private String accept;
    @JsonProperty("Accept-Encoding")
    private String acceptEncoding;
    @JsonProperty("Accept-Language")
    private String acceptLanguage;
    @JsonProperty("Cache-Control")
    private String cacheControl;
    @JsonProperty("Host")
    private String host;
    @JsonProperty("If-Modified-Since")
    private String ifModifiedSince;
    @JsonProperty("Pragma")
    private String pragma;
    @JsonProperty("Upgrade-Insecure-Requests")
    private String upgradeInsecureRequests;
    @JsonProperty("User-Agent")
    private String userAgent;
    @JsonProperty("X-Bluecoat-Via")
    private String xBluecoatVia;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Accept")
    public String getAccept() {
        return accept;
    }

    @JsonProperty("Accept")
    public void setAccept(String accept) {
        this.accept = accept;
    }

    @JsonProperty("Accept-Encoding")
    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    @JsonProperty("Accept-Encoding")
    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    @JsonProperty("Accept-Language")
    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    @JsonProperty("Accept-Language")
    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    @JsonProperty("Cache-Control")
    public String getCacheControl() {
        return cacheControl;
    }

    @JsonProperty("Cache-Control")
    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    @JsonProperty("Host")
    public String getHost() {
        return host;
    }

    @JsonProperty("Host")
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty("If-Modified-Since")
    public String getIfModifiedSince() {
        return ifModifiedSince;
    }

    @JsonProperty("If-Modified-Since")
    public void setIfModifiedSince(String ifModifiedSince) {
        this.ifModifiedSince = ifModifiedSince;
    }

    @JsonProperty("Pragma")
    public String getPragma() {
        return pragma;
    }

    @JsonProperty("Pragma")
    public void setPragma(String pragma) {
        this.pragma = pragma;
    }

    @JsonProperty("Upgrade-Insecure-Requests")
    public String getUpgradeInsecureRequests() {
        return upgradeInsecureRequests;
    }

    @JsonProperty("Upgrade-Insecure-Requests")
    public void setUpgradeInsecureRequests(String upgradeInsecureRequests) {
        this.upgradeInsecureRequests = upgradeInsecureRequests;
    }

    @JsonProperty("User-Agent")
    public String getUserAgent() {
        return userAgent;
    }

    @JsonProperty("User-Agent")
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @JsonProperty("X-Bluecoat-Via")
    public String getXBluecoatVia() {
        return xBluecoatVia;
    }

    @JsonProperty("X-Bluecoat-Via")
    public void setXBluecoatVia(String xBluecoatVia) {
        this.xBluecoatVia = xBluecoatVia;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}