/*
User.java
This class implement builder pattern for User
Siphelele Nyathi 218334028
//25.10.2022
 */
package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class User implements Serializable {
    @NotNull
    @Id
    @Column(name = "user_id")
    private String userId;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String address;

    private User(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.address = builder.address;
    }


    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(address, user.address);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, email, password, address);
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {
        private String userId;
        private String name;
        private String email;
        private String password;
        private String address;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder copy(User user) {
            this.userId = user.userId;
            this.name = user.name;
            this.email = user.email;
            this.password = user.password;
            this.address = user.address;

            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

