package accounts;

import dbService.UserService;
import dbService.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class AccountService {

    private final Map<String, User> currentUsers;
    private UserService userService;
    private static AccountService instance;

    private AccountService() {
        userService = new UserService();
        currentUsers = userService.findAllUsers().stream().collect(Collectors.toMap(User::getName, value -> value));
    }

    public static AccountService getInstance() {
        if (instance == null) {
            instance = new AccountService(); // TODO synchronized?
        }
        return instance;
    }

    public void addNewUser(User userProfile) {
        userService.saveUser(userProfile);
        currentUsers.put(userProfile.getSessionId(), userProfile);
    }

    public void logout(User user) {
        userService.closeSession(user);
    }

    public User find(String sessionId) {
        return currentUsers.get(sessionId);
    }

}
