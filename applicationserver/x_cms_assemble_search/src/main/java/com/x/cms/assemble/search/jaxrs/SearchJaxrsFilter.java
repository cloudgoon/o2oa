package com.x.cms.assemble.search.jaxrs;

import javax.servlet.annotation.WebFilter;

import com.x.base.core.project.jaxrs.ManagerUserJaxrsFilter;

/**
 * web服务过滤器，将指定的URL定义为需要用户认证的服务，如果用户未登录，则无法访问该服务
 * 
 * @author liyi *
 */
@WebFilter(urlPatterns = { 
		"/jaxrs/spider/*",
		"/jaxrs/search/*"
		}, asyncSupported = true )
public class SearchJaxrsFilter extends ManagerUserJaxrsFilter {

}