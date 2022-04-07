package za.ac.cput.entity;

import java.time.*;

public class Account {

    private String accountId;
    private String openDate;
    private String closeDate;

    private Account(){}

    private Account (Builder builder){
        this.accountId = builder.accountId;
        this.openDate = builder.openDate;
        this.closeDate = builder.closeDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", openDate=" + openDate +
                ", closeDate=" + closeDate +
                '}';
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
}

