package com.web.court.config;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Set;

/**
 * This class is a ServletContainerInitializer implementation that is used to define a Servlet of type CourtDispatcherServlet.
 * This is the core Servlet class that receives web requests and dispatches them to the appropriate handlers.
 * The servlets name is set to court and maps all the URLs using a forward slash (/) - representing the root directory of the app.
 * Note: The URL pattern can be set to more granular patterns
 * Larger applications may delegate patterns to several servlets.
 * To have the CourtServletContainerIntializer class detected, you add the file named jakarta.servlet.ServletContainerInitializer to the META-INF/services directory.
 * The content of the file should be the fully qualified name of the class that implements the ServletContainerInitializer interface.
 * The file is loaded by the web server/servlet container and used to bootstrap the application.
 */

public class CourtServletContainerInitializer implements ServletContainerInitializer {

    public static final String MSG = "Starting Court Web Application";

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {

        ctx.log(MSG);

        var applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(CourtConfiguration.class);

        var dispatcherServlet = new DispatcherServlet(applicationContext);

        var courtRegistration = ctx.addServlet("court", dispatcherServlet);
        courtRegistration.addMapping("/");
        courtRegistration.setLoadOnStartup(1);
    }
}
