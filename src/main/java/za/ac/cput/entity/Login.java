package za.ac.cput.entity;

import org.jetbrains.annotations.Contract;

public class Login {
    private String loginId;
    private String userId;
    private String userEmail;
    private String userPassword;

    private Login(){
    }

public Login (Builder builder){
        this.loginId = builder.loginId;
        this.userId = builder.userId;
        this.userEmail = builder.userEmail;
        this.userPassword = builder.userPassword;

}

    public String getLoginid() {
        return loginId;
    }

    public void setLoginid(String loginid) {
        loginId = loginid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String toString(){
        return "Login{"+ "LoginID='" + loginId + '\'' +
                ", userID='" + userId + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword +"}";

    }

    //my builder;

    public static class Builder{
        private String loginId;
        private String userId;
        private String userEmail;
        private String userPassword;



    public Builder setLoginid(String loginId){
        this.loginId = loginId;
        return this;
    }
    public Builder setUserid(String userId){
    this.userId = userId;
    return this;
    }
    public Builder setUseremail(String userEmail){
        this.userEmail = userEmail;
        return this;
    }
    public Builder setUserpassword(String userPassword){
        this.userPassword = userPassword;
        return this;
    }
    public Builder copy(Login login){
        this.loginId = login.loginId;
        this.userId = login.userId;
        this.userEmail = login.userEmail;
        this.userPassword = login.userPassword;
        return this;
    }
    public Login build(){
        return new Login(this);
    }
    }


}

