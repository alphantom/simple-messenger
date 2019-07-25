package dbService.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
public class User implements Serializable {

    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String password;

    @Column(name="session_id")
    private String sessionId;

    @SuppressWarnings("UnusedDeclaration")
    public User() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public User(String name) {
        this.setName(name);
    }

    @SuppressWarnings("UnusedDeclaration")
    public User(String name, String password) {
        this.setName(name);
        this.setPassword(password);
    }

    @SuppressWarnings("UnusedDeclaration")
    public User(String name, String password, String sessionId) {
        this.setName(name);
        this.setPassword(password);
        this.setSessionId(password);
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setPassword(String password) {
        this.password = password;
    }

    @SuppressWarnings("UnusedDeclaration")
    public long getId() {
        return id;
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getSessionId() {
        return sessionId;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
