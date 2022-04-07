package za.ac.cput.entity;

import java.time.*;

public class Account {

    private int accountId;
    private LocalDateTime openDate;
    private LocalDateTime closeDate;

    private Account(){}

    private Account (Builder builder){
        this.accountId = builder.accountId;
        this.openDate = builder.openDate;
        this.closeDate = builder.closeDate;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public LocalDateTime getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDateTime openDate) {
        this.openDate = openDate;
    }

    public LocalDateTime getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDateTime closeDate) {
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
        private int accountId;
        private LocalDateTime openDate;
        private LocalDateTime closeDate;

        public Builder setAccountId(int accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder setOpenDate(LocalDateTime openDate) {
            this.openDate = openDate;
            return this;
        }

        public Builder setCloseDate(LocalDateTime closeDate) {
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

