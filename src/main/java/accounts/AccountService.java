package accounts;

import dbService.UserService;
import dbService.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class AccountService {
    // TODO change to 'currentUsers'
    // TODO set id as key, session_id as value??
    private final Map<String, User> loginToProfile;
    private UserService userService;
    // TODO think if it needs??
    // TODO use as Singleton
    public AccountService() {
        userService = new UserService();
        loginToProfile = userService.findAllUsers().stream().collect(Collectors.toMap(User::getName, value -> value));
    }

    public void addNewUser(User userProfile) {
        userService.saveUser(userProfile);
        loginToProfile.put(userProfile.getName(), userProfile);
    }

    public void logout(User user) {
//        loginToProfile.put(user.getId(), null);
        userService.closeSession(user);
    }

    public User getUserByLogin(String login) {
        return loginToProfile.get(login);
    }

}
