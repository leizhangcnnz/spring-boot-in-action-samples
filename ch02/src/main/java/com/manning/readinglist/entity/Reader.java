package com.manning.readinglist.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Reader implements UserDetails {

  private static final long serialVersionUID = 1L;

  @Id
  private String username;
  
  private String fullname;
  private String password;

  @Override
  public String getUsername() {
    return username;
  }

  public Reader setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getFullname() {
    return fullname;
  }

  public Reader setFullname(String fullname) {
    this.fullname = fullname;
    return this;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public Reader setPassword(String password) {
    this.password = password;
    return this;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority("ROLE_READER"));
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
