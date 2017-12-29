package com.xproject.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class XWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {XRootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {XWebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};//将DispatcherServlet映射到"/"
    }
}
