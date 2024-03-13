package banktask;

import java.util.Date;

public class Transaction {
    private int transId;
    private int accountId;
    private String transactionType;
    private double transAmount;
    private String transStatus;
    private Date transDateTime;

    public Transaction() {
    }

    public Transaction(int transId, int accountId, String transactionType, double transAmount, String transStatus, Date transDateTime) {
        this.transId = transId;
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.transAmount = transAmount;
        this.transStatus = transStatus;
        this.transDateTime = transDateTime;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public Date getTransDateTime() {
        return transDateTime;
    }

    public void setTransDateTime(Date transDateTime) {
        this.transDateTime = transDateTime;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "transId=" + transId +
                ", accountId=" + accountId +
                ", transactionType='" + transactionType + '\'' +
                ", transAmount=" + transAmount +
                ", transStatus='" + transStatus + '\'' +
                ", transDateTime=" + transDateTime +
                '}';
    }
}

