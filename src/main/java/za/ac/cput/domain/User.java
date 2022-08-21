package za.ac.cput.domain;
/*
User.java
This class implement builder pattern for User
Siphelele Nyathi 218334028
21.08.2022
 */
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
@Entity
@Table(name = "user_records")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    @Column @NotNull private String name;
    @Column @NotNull private String email;
    @Column @NotNull private String password;
    @Column @NotNull private String address;


    protected User(){}

    private User(Builder builder) {

        this.userId = builder.userId;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.address = builder.address;
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


    public static class Builder{

        private String userId, name, email, password, address;

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

        public Builder copy(User user){

            this.userId = user.userId;
            this.name = user.name;
            this.email = user.email;
            this.password = user.password;
            this.address = user.address;

            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return userId.equals(that.userId) &&
                name.equals(that.name) &&
                email.equals(that.email) &&
                password.equals(that.password) &&
                address.equals(that.address);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(userId, name, email, password, address);
    }
}

