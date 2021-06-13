package ui.utilities;

public class LoanApprovalDetails {
    private String loanAmount;
    private String monthlyPayment;
    private String term;
    private String intrestRate;
    private String apr;

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(String monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getIntrestRate() {
        return intrestRate;
    }

    public void setIntrestRate(String intrestRate) {
        this.intrestRate = intrestRate;
    }

    public String getApr() {
        return apr;
    }

    public void setApr(String apr) {
        this.apr = apr;
    }

}
