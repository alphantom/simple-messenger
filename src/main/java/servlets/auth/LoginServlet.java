package servlets.auth;

import accounts.AccountService;
import dbService.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private final AccountService accountService;

    public LoginServlet(AccountService service) {
        accountService = service;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: create session?
        // TODO: redirect to home page
        resp.setContentType("text/html;charset=utf-8");
        User acc;
        if ((acc = accountService.getUserByLogin(req.getParameter("login"))) != null) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("Authorized: " + acc.getName());
        } else {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().println("Unauthorized");
        }
    }
}
