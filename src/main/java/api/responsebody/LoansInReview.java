package api.responsebody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class LoansInReview {

    private int id;
    private String uuid;
    private String status;
    private String productType;
    private String hasBackendCounter;
    private String purpose;
    private String createDate;
    private String postIssuanceStatus;
    private String addon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getHasBackendCounter() {
        return hasBackendCounter;
    }

    public void setHasBackendCounter(String hasBackendCounter) {
        this.hasBackendCounter = hasBackendCounter;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getPostIssuanceStatus() {
        return postIssuanceStatus;
    }

    public void setPostIssuanceStatus(String postIssuanceStatus) {
        this.postIssuanceStatus = postIssuanceStatus;
    }

    public String getAddon() {
        return addon;
    }

    public void setAddon(String addon) {
        this.addon = addon;
    }

}
