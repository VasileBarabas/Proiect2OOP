package App.Classes;

import App.Interface.IUser;

public class UserClass implements IUser {
    private String username;
    private String password;

    public UserClass(String password, String username)
    {
        this.password=password;
        this.username=username;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
