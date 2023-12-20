package com.kavish.tutorials.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//WHat is this?
@Retention(RetentionPolicy.RUNTIME)//WHat is this?
public @interface Loggable { //Difference b/w @interface and Interface?
}
