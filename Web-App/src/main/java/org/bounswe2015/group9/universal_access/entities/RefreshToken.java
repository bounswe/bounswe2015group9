package org.bounswe2015.group9.universal_access.entities;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity
@Table(name = "oauth_refresh_token")
public class RefreshToken {
    @Id
    @Generated(GenerationTime.NEVER)
    @Column(name = "token_id")
    private String token_id;

    @Column(name = "token")
    @Lob
    private byte[] token;

    @Column(name = "authentication")
    @Lob
    private byte[] authentication;

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
    public byte[] getAuthentication() {
        return authentication;
    }
    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }
}