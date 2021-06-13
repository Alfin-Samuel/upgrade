package api.responsebody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class LoanAccountSummaryAto {

    private String loanAccountNumber;
    private String postIssuanceLoanStatus;
    private String daysPastDue;
    private String loanProductType;

    public String getLoanAccountNumber() {
        return loanAccountNumber;
    }

    public void setLoanAccountNumber(String loanAccountNumber) {
        this.loanAccountNumber = loanAccountNumber;
    }

    public String getPostIssuanceLoanStatus() {
        return postIssuanceLoanStatus;
    }

    public void setPostIssuanceLoanStatus(String postIssuanceLoanStatus) {
        this.postIssuanceLoanStatus = postIssuanceLoanStatus;
    }

    public String getDaysPastDue() {
        return daysPastDue;
    }

    public void setDaysPastDue(String daysPastDue) {
        this.daysPastDue = daysPastDue;
    }

    public String getLoanProductType() {
        return loanProductType;
    }

    public void setLoanProductType(String loanProductType) {
        this.loanProductType = loanProductType;
    }

}
