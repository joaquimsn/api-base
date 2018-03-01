package com.joaquimsn.apibase.expose.security;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;

import com.joaquimsn.apibase.expose.security.enums.Access;
import com.joaquimsn.apibase.expose.security.enums.Rule;

@InterceptorBinding
@Retention(RUNTIME)
@Target({TYPE, METHOD})
@Documented
public @interface SenacAuthorization {
	@Nonbinding Rule[] rules() default Rule.DEFAULT;
	@Nonbinding Access[] access() default Access.ANY;
}
