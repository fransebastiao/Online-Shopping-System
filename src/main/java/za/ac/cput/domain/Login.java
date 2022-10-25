package za.ac.cput.domain;
/*
Online Shopping System
Lihle Langa 217181147
entity for Login
//25.10.2022
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Login implements Serializable {
    @NotNull
    @Id
    @Column(name = "login_id")
    private String userEmail;

    @NotNull
    private String userPassword;


    private Login(Builder builder) {
        this.userEmail = builder.userEmail;
        this.userPassword = builder.userPassword;
    }

    // This was a private constructor - Needs to be Public!
    public Login() {

    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public String toString() {
        return "Login{" + "userEmail='" + userEmail + '\'' + ", userPassword='" + userPassword + '\'' + '}';
    }

    public static class Builder {
        private String userEmail;
        private String userPassword;


        public Builder setUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public Builder setUserPassword(String userPassword) {
            this.userPassword = userPassword;
            return this;
        }


        public Builder copy(Login login) {
            this.userEmail = login.userEmail;
            this.userPassword = login.getUserPassword();
            return this;
        }

        public Login build() {
            return new Login(this);
        }
    }
}