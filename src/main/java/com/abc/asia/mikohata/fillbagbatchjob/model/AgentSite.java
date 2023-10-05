package com.abc.asia.mikohata.fillbagbatchjob.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/** AgentSite */
@Validated
@jakarta.annotation.Generated(
        value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
        date = "2023-06-06T02:07:03.366329473Z[GMT]")
public class AgentSite {
    @JsonProperty("record_id")
    private String recordId = null;

    @JsonProperty("person_id")
    private String personId = null;

    @JsonProperty("app_ref_no")
    private String appRefNo = null;

    @JsonProperty("genno")
    private String genno = null;

    @JsonProperty("serno")
    private String serno = null;

    @JsonProperty("biometrics")
    @Valid
    private List<CompBiometrics> biometrics = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("source")
    private String source = null;

    @JsonProperty("pool")
    private String pool = null;

    @JsonProperty("created_datetime")
    private String createdDatetime = null;

    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("updated_datetime")
    private String updatedDatetime = null;

    @JsonProperty("updated_by")
    private String updatedBy = null;

    @JsonProperty("expiry_datetime")
    private String expiryDatetime = null;

    @JsonProperty("expiry_by")
    private String expiryBy = null;

    @JsonProperty("traveldoc_no")
    private String traveldocNo = null;

    @JsonProperty("traveldoc_expiry")
    private String traveldocExpiry = null;

    @JsonProperty("traveldoc_issue_state")
    private String traveldocIssueState = null;

    @JsonProperty("traveldoc_nat_code")
    private String traveldocNatCode = null;

    @JsonProperty("traveldoc_birthdate")
    private String traveldocBirthdate = null;

    @JsonProperty("traveldoc_gender")
    private String traveldocGender = null;

    @JsonProperty("transaction_location")
    private String transactionLocation = null;

    @JsonProperty("transaction_user_id")
    private String transactionUserId = null;

    @JsonProperty("transaction_datetime")
    private String transactionDatetime = null;

    public AgentSite recordId(String recordId) {
        this.recordId = recordId;
        return this;
    }

    /**
     * Get recordId
     *
     * @return recordId
     */
    @Schema(description = "")
    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public AgentSite personId(String personId) {
        this.personId = personId;
        return this;
    }

    /**
     * Get personId
     *
     * @return personId
     */
    @Schema(description = "")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public AgentSite appRefNo(String appRefNo) {
        this.appRefNo = appRefNo;
        return this;
    }

    /**
     * Get appRefNo
     *
     * @return appRefNo
     */
    @Schema(description = "")
    public String getAppRefNo() {
        return appRefNo;
    }

    public void setAppRefNo(String appRefNo) {
        this.appRefNo = appRefNo;
    }

    public AgentSite genno(String genno) {
        this.genno = genno;
        return this;
    }

    /**
     * Get genno
     *
     * @return genno
     */
    @Schema(description = "")
    public String getGenno() {
        return genno;
    }

    public void setGenno(String genno) {
        this.genno = genno;
    }

    public AgentSite serno(String serno) {
        this.serno = serno;
        return this;
    }

    /**
     * Get serno
     *
     * @return serno
     */
    @Schema(description = "")
    public String getSerno() {
        return serno;
    }

    public void setSerno(String serno) {
        this.serno = serno;
    }

    public AgentSite biometrics(List<CompBiometrics> biometrics) {
        this.biometrics = biometrics;
        return this;
    }

    public AgentSite addBiometricsItem(CompBiometrics biometricsItem) {
        if (this.biometrics == null) {
            this.biometrics = new ArrayList<CompBiometrics>();
        }
        this.biometrics.add(biometricsItem);
        return this;
    }

    /**
     * Get biometrics
     *
     * @return biometrics
     */
    @Schema(description = "")
    @Valid
    public List<CompBiometrics> getBiometrics() {
        return biometrics;
    }

    public void setBiometrics(List<CompBiometrics> biometrics) {
        this.biometrics = biometrics;
    }

    public AgentSite name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @Schema(description = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AgentSite source(String source) {
        this.source = source;
        return this;
    }

    /**
     * Get source
     *
     * @return source
     */
    @Schema(description = "")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public AgentSite pool(String pool) {
        this.pool = pool;
        return this;
    }

    /**
     * Get pool
     *
     * @return pool
     */
    @Schema(description = "")
    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public AgentSite createdDatetime(String createdDatetime) {
        this.createdDatetime = createdDatetime;
        return this;
    }

    /**
     * Get createdDatetime
     *
     * @return createdDatetime
     */
    @Schema(description = "")
    public String getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(String createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public AgentSite createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Get createdBy
     *
     * @return createdBy
     */
    @Schema(description = "")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public AgentSite updatedDatetime(String updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
        return this;
    }

    /**
     * Get updatedDatetime
     *
     * @return updatedDatetime
     */
    @Schema(description = "")
    public String getUpdatedDatetime() {
        return updatedDatetime;
    }

    public void setUpdatedDatetime(String updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }

    public AgentSite updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    /**
     * Get updatedBy
     *
     * @return updatedBy
     */
    @Schema(description = "")
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public AgentSite expiryDatetime(String expiryDatetime) {
        this.expiryDatetime = expiryDatetime;
        return this;
    }

    /**
     * Get expiryDatetime
     *
     * @return expiryDatetime
     */
    @Schema(description = "")
    public String getExpiryDatetime() {
        return expiryDatetime;
    }

    public void setExpiryDatetime(String expiryDatetime) {
        this.expiryDatetime = expiryDatetime;
    }

    public AgentSite expiryBy(String expiryBy) {
        this.expiryBy = expiryBy;
        return this;
    }

    /**
     * Get expiryBy
     *
     * @return expiryBy
     */
    @Schema(description = "")
    public String getExpiryBy() {
        return expiryBy;
    }

    public void setExpiryBy(String expiryBy) {
        this.expiryBy = expiryBy;
    }

    public AgentSite traveldocNo(String traveldocNo) {
        this.traveldocNo = traveldocNo;
        return this;
    }

    /**
     * Get traveldocNo
     *
     * @return traveldocNo
     */
    @Schema(description = "")
    public String getTraveldocNo() {
        return traveldocNo;
    }

    public void setTraveldocNo(String traveldocNo) {
        this.traveldocNo = traveldocNo;
    }

    public AgentSite traveldocExpiry(String traveldocExpiry) {
        this.traveldocExpiry = traveldocExpiry;
        return this;
    }

    /**
     * Get traveldocExpiry
     *
     * @return traveldocExpiry
     */
    @Schema(description = "")
    public String getTraveldocExpiry() {
        return traveldocExpiry;
    }

    public void setTraveldocExpiry(String traveldocExpiry) {
        this.traveldocExpiry = traveldocExpiry;
    }

    public AgentSite traveldocIssueState(String traveldocIssueState) {
        this.traveldocIssueState = traveldocIssueState;
        return this;
    }

    /**
     * Get traveldocIssueState
     *
     * @return traveldocIssueState
     */
    @Schema(description = "")
    public String getTraveldocIssueState() {
        return traveldocIssueState;
    }

    public void setTraveldocIssueState(String traveldocIssueState) {
        this.traveldocIssueState = traveldocIssueState;
    }

    public AgentSite traveldocNatCode(String traveldocNatCode) {
        this.traveldocNatCode = traveldocNatCode;
        return this;
    }

    /**
     * Get traveldocNatCode
     *
     * @return traveldocNatCode
     */
    @Schema(description = "")
    public String getTraveldocNatCode() {
        return traveldocNatCode;
    }

    public void setTraveldocNatCode(String traveldocNatCode) {
        this.traveldocNatCode = traveldocNatCode;
    }

    public AgentSite traveldocBirthdate(String traveldocBirthdate) {
        this.traveldocBirthdate = traveldocBirthdate;
        return this;
    }

    /**
     * Get traveldocBirthdate
     *
     * @return traveldocBirthdate
     */
    @Schema(description = "")
    public String getTraveldocBirthdate() {
        return traveldocBirthdate;
    }

    public void setTraveldocBirthdate(String traveldocBirthdate) {
        this.traveldocBirthdate = traveldocBirthdate;
    }

    public AgentSite traveldocGender(String traveldocGender) {
        this.traveldocGender = traveldocGender;
        return this;
    }

    /**
     * Get traveldocGender
     *
     * @return traveldocGender
     */
    @Schema(description = "")
    public String getTraveldocGender() {
        return traveldocGender;
    }

    public void setTraveldocGender(String traveldocGender) {
        this.traveldocGender = traveldocGender;
    }

    public AgentSite transactionLocation(String transactionLocation) {
        this.transactionLocation = transactionLocation;
        return this;
    }

    /**
     * Get transactionLocation
     *
     * @return transactionLocation
     */
    @Schema(description = "")
    public String getTransactionLocation() {
        return transactionLocation;
    }

    public void setTransactionLocation(String transactionLocation) {
        this.transactionLocation = transactionLocation;
    }

    public AgentSite transactionUserId(String transactionUserId) {
        this.transactionUserId = transactionUserId;
        return this;
    }

    /**
     * Get transactionUserId
     *
     * @return transactionUserId
     */
    @Schema(description = "")
    public String getTransactionUserId() {
        return transactionUserId;
    }

    public void setTransactionUserId(String transactionUserId) {
        this.transactionUserId = transactionUserId;
    }

    public AgentSite transactionDatetime(String transactionDatetime) {
        this.transactionDatetime = transactionDatetime;
        return this;
    }

    /**
     * Get transactionDatetime
     *
     * @return transactionDatetime
     */
    @Schema(description = "")
    public String getTransactionDatetime() {
        return transactionDatetime;
    }

    public void setTransactionDatetime(String transactionDatetime) {
        this.transactionDatetime = transactionDatetime;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AgentSite agentSite = (AgentSite) o;
        return Objects.equals(this.recordId, agentSite.recordId)
                && Objects.equals(this.personId, agentSite.personId)
                && Objects.equals(this.appRefNo, agentSite.appRefNo)
                && Objects.equals(this.genno, agentSite.genno)
                && Objects.equals(this.serno, agentSite.serno)
                && Objects.equals(this.biometrics, agentSite.biometrics)
                && Objects.equals(this.name, agentSite.name)
                && Objects.equals(this.source, agentSite.source)
                && Objects.equals(this.pool, agentSite.pool)
                && Objects.equals(this.createdDatetime, agentSite.createdDatetime)
                && Objects.equals(this.createdBy, agentSite.createdBy)
                && Objects.equals(this.updatedDatetime, agentSite.updatedDatetime)
                && Objects.equals(this.updatedBy, agentSite.updatedBy)
                && Objects.equals(this.expiryDatetime, agentSite.expiryDatetime)
                && Objects.equals(this.expiryBy, agentSite.expiryBy)
                && Objects.equals(this.traveldocNo, agentSite.traveldocNo)
                && Objects.equals(this.traveldocExpiry, agentSite.traveldocExpiry)
                && Objects.equals(this.traveldocIssueState, agentSite.traveldocIssueState)
                && Objects.equals(this.traveldocNatCode, agentSite.traveldocNatCode)
                && Objects.equals(this.traveldocBirthdate, agentSite.traveldocBirthdate)
                && Objects.equals(this.traveldocGender, agentSite.traveldocGender)
                && Objects.equals(this.transactionLocation, agentSite.transactionLocation)
                && Objects.equals(this.transactionUserId, agentSite.transactionUserId)
                && Objects.equals(this.transactionDatetime, agentSite.transactionDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                recordId,
                personId,
                appRefNo,
                genno,
                serno,
                biometrics,
                name,
                source,
                pool,
                createdDatetime,
                createdBy,
                updatedDatetime,
                updatedBy,
                expiryDatetime,
                expiryBy,
                traveldocNo,
                traveldocExpiry,
                traveldocIssueState,
                traveldocNatCode,
                traveldocBirthdate,
                traveldocGender,
                transactionLocation,
                transactionUserId,
                transactionDatetime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AgentSite {\n");

        sb.append("    recordId: ").append(toIndentedString(recordId)).append("\n");
        sb.append("    personId: ").append(toIndentedString(personId)).append("\n");
        sb.append("    appRefNo: ").append(toIndentedString(appRefNo)).append("\n");
        sb.append("    genno: ").append(toIndentedString(genno)).append("\n");
        sb.append("    serno: ").append(toIndentedString(serno)).append("\n");
        sb.append("    biometrics: ").append(toIndentedString(biometrics)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    pool: ").append(toIndentedString(pool)).append("\n");
        sb.append("    createdDatetime: ").append(toIndentedString(createdDatetime)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    updatedDatetime: ").append(toIndentedString(updatedDatetime)).append("\n");
        sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
        sb.append("    expiryDatetime: ").append(toIndentedString(expiryDatetime)).append("\n");
        sb.append("    expiryBy: ").append(toIndentedString(expiryBy)).append("\n");
        sb.append("    traveldocNo: ").append(toIndentedString(traveldocNo)).append("\n");
        sb.append("    traveldocExpiry: ").append(toIndentedString(traveldocExpiry)).append("\n");
        sb.append("    traveldocIssueState: ")
                .append(toIndentedString(traveldocIssueState))
                .append("\n");
        sb.append("    traveldocNatCode: ").append(toIndentedString(traveldocNatCode)).append("\n");
        sb.append("    traveldocBirthdate: ")
                .append(toIndentedString(traveldocBirthdate))
                .append("\n");
        sb.append("    traveldocGender: ").append(toIndentedString(traveldocGender)).append("\n");
        sb.append("    transactionLocation: ")
                .append(toIndentedString(transactionLocation))
                .append("\n");
        sb.append("    transactionUserId: ")
                .append(toIndentedString(transactionUserId))
                .append("\n");
        sb.append("    transactionDatetime: ")
                .append(toIndentedString(transactionDatetime))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first
     * line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
