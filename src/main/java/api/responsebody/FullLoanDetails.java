package api.responsebody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FullLoanDetails {

    private String firstName;
    private Integer userId;
    private String userUuid;
    private String authenticationLevel;
    private List<Integer> actorIds;
    private List<LoanApplication> loanApplications;
    private List<LoansInReview> loansInReviews;
    private List<LoanAccountSummaryAto> loanAccountSummaryAtoes;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getAuthenticationLevel() {
        return authenticationLevel;
    }

    public void setAuthenticationLevel(String authenticationLevel) {
        this.authenticationLevel = authenticationLevel;
    }

    public List<Integer> getActorIds() {
        return actorIds;
    }

    public void setActorIds(List<Integer> actorIds) {
        this.actorIds = actorIds;
    }

    public List<LoanApplication> getLoanApplications() {
        return loanApplications;
    }

    public void setLoanApplications(List<LoanApplication> loanApplications) {
        this.loanApplications = loanApplications;
    }

    public List<LoansInReview> getLoansInReviews() {
        return loansInReviews;
    }

    public void setLoansInReviews(List<LoansInReview> loansInReviews) {
        this.loansInReviews = loansInReviews;
    }


    public List<LoanAccountSummaryAto> getLoanAccountSummaryAtoes() {
        return loanAccountSummaryAtoes;
    }

    public void setLoanAccountSummaryAtoes(List<LoanAccountSummaryAto> loanAccountSummaryAtoes) {
        this.loanAccountSummaryAtoes = loanAccountSummaryAtoes;
    }

}
