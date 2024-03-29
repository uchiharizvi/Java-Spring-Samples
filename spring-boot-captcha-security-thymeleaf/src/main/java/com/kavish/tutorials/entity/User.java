package com.kavish.tutorials.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    @Transient//TODO check usage
    private String captcha;
    @Transient
    private String hiddenCaptcha;
    @Transient
    private String realCaptcha;
}
