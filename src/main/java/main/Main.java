package main;

import accounts.AccountService;
import filters.AuthFilter;
import org.eclipse.jetty.server.Dispatcher;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.auth.LoginServlet;
import servlets.auth.LogoutServlet;
import servlets.auth.SignUpServlet;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) throws Exception {

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(new SignUpServlet()), "/auth/signup");
        context.addServlet(new ServletHolder(new LoginServlet()), "/auth/login");
        context.addServlet(new ServletHolder(new LogoutServlet()), "/auth/logout");
        // TODO: should i use one authServlet for handling requests?

        context.addFilter(AuthFilter.class, "/*", EnumSet.of(DispatcherType.INCLUDE,DispatcherType.REQUEST));

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        Logger.getGlobal().info("Server started");
        server.join();
    }
}
