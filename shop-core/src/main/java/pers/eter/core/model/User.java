package pers.eter.core.model;

/**
 * Created by Eter on 17-6-5.
 */
public class User {
    private int userId;
    private String uname;
    private String pwd;
    private String nation;
    private String location;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", nation='" + nation + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
