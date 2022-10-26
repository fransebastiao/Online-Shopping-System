package za.ac.cput.domain;
/*
Account Domain
Author: Franciel Danilo de Carvalho Sebastiao
Student Number: 219466912
//25.10.2022
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Account implements Serializable {
    @Id
    @Column(name = "account_id")
    private String accountId;

    @NotNull
    private String openDate;

    @NotNull
    private String closeDate;

    protected Account(){}

    private Account (Builder builder){
        this.accountId = builder.accountId;
        this.openDate = builder.openDate;
        this.closeDate = builder.closeDate;
    }

    public String getAccountId() {
        return accountId;
    }
    public String getOpenDate() {
        return openDate;
    }
    public String getCloseDate() {
        return closeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) && Objects.equals(openDate, account.openDate) && Objects.equals(closeDate, account.closeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, openDate, closeDate);
    }

    public static class Builder{
        private String accountId;
        private String openDate;
        private String closeDate;

        public Builder setAccountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder setOpenDate(String openDate) {
            this.openDate = openDate;
            return this;
        }

        public Builder setCloseDate(String closeDate) {
            this.closeDate = closeDate;
            return this;
        }

        public Builder copy(Account account){
            this.accountId = account.accountId;
            this.openDate = account.openDate;
            this.closeDate = account.closeDate;
            return this;
        }

        public Account build(){
            return new Account(this);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", openDate=" + openDate +
                ", closeDate=" + closeDate +
                '}';
    }
}
//test
