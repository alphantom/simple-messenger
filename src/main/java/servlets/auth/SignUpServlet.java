package servlets.auth;

import accounts.AccountService;
import dbService.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;

    public SignUpServlet(AccountService service) {
        accountService = service;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        accountService.addNewUser(new User(req.getParameter("login"), req.getParameter("Password")));
        // TODO: create session?
        // TODO: redirect to home page
        resp.setStatus(HttpServletResponse.SC_OK);
//        resp.sendRedirect("/");
    }
}
