package common;

import org.springframework.beans.factory.annotation.Value;

public class JwtAuthenticationConfig {

    @Value("${knightech.security.jwt.url:/login}")
    private String url;

    @Value("${knightech.security.jwt.header:Authorization}")
    private String header;

    @Value("${knightech.security.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${knightech.security.jwt.expiration:#{24*60*60}}")
    private int expiration; // default 24 hours

    @Value("${knightech.security.jwt.secret}")
    private String secret;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "JwtAuthenticationConfig{" +
                "url='" + url + '\'' +
                ", header='" + header + '\'' +
                ", prefix='" + prefix + '\'' +
                ", expiration=" + expiration +
                ", secret='" + secret + '\'' +
                '}';
    }
}
