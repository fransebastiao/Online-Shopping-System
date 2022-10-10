package za.ac.cput.domain;
/*
Online Shopping System
Lihle Langa 217181147
entity for Login
 */

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Login implements Serializable {
    @Id
    @NotNull
    @Column(name = "user_email")
    private String userEmail;
    @NotNull
    private String userPassword;

    protected Login(){
    }

    public Login (Builder builder){
        /*this.loginId = builder.loginId;
        this.userId = builder.userId;*/
        this.userEmail = builder.userEmail;
        this.userPassword = builder.userPassword;

    }

   /* public String getLoginid() {
        return loginId;
    }

    public String getUserId() {
        return userId;
    }*/

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String toString(){
        return "Login{"+ ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword +"}";

    }

    //my builder;

    public static class Builder{
        /*private String loginId;
        private String userId;*/
        private String userEmail;
        private String userPassword;



        /*public Builder setLoginid(String loginId){
            this.loginId = loginId;
            return this;
        }
        public Builder setUserid(String userId){
        this.userId = userId;
        return this;
        }*/
        public Builder setUseremail(String userEmail){
            this.userEmail = userEmail;
            return this;
        }
        public Builder setUserpassword(String userPassword){
            this.userPassword = userPassword;
            return this;
        }
        public Builder copy(Login login){
        /*this.loginId = login.loginId;
        this.userId = login.userId;*/
            this.userEmail = login.userEmail;
            this.userPassword = login.userPassword;
            return this;
        }
        public Login build(){
            return new Login(this);
        }
    }


}

