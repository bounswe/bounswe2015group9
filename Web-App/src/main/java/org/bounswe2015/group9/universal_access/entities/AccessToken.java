package org.bounswe2015.group9.universal_access.entities;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity
@Table(name = "oauth_access_token")
public class AccessToken {
    @Id
    @Generated(GenerationTime.NEVER)
    @Column(name = "token_id")
    private String token_id;

    @Column(name = "token")
    @Lob
    private byte[] token;

    @Column(name = "authentication_id")
    private String authentication_id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "client_id")
    private String client_id;

    @Column(name = "authentication")
    @Lob
    private byte[] authentication;

    @Column(name = "refresh_token")
    private String refresh_token;

    public String getToken_id() {
        return token_id;
    }

    public void setToken_id(String token_id) {
        this.token_id = token_id;
    }

    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    public String getAuthentication_id() {
        return authentication_id;
    }

    public void setAuthentication_id(String authentication_id) {
        this.authentication_id = authentication_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
