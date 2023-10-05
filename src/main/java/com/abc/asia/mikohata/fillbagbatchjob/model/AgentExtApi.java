package com.abc.asia.mikohata.fillbagbatchjob.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/** AgentExtApi */
@Validated
@jakarta.annotation.Generated(
        value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
        date = "2023-04-07T08:37:25.978277515Z[GMT]")
public class AgentExtApi {
    @JsonProperty("record_id")
    private String recordId = null;

    @JsonProperty("app_ref_no")
    private String appRefNo = null;

    @JsonProperty("traveldoc_num")
    private String traveldocNum = null;

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

    @JsonProperty("biometrics")
    @Valid
    private List<CompBiometrics> biometrics = null;

    @JsonProperty("transport_info")
    private CompApiTransport transportInfo = null;

    @JsonProperty("add_mode")
    private String addMode = null;

    public AgentExtApi recordId(String recordId) {
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

    public AgentExtApi appRefNo(String appRefNo) {
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

    public AgentExtApi traveldocNum(String traveldocNum) {
        this.traveldocNum = traveldocNum;
        return this;
    }

    /**
     * Get traveldocNum
     *
     * @return traveldocNum
     */
    @Schema(description = "")
    public String getTraveldocNum() {
        return traveldocNum;
    }

    public void setTraveldocNum(String traveldocNum) {
        this.traveldocNum = traveldocNum;
    }

    public AgentExtApi traveldocExpiry(String traveldocExpiry) {
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

    public AgentExtApi traveldocIssueState(String traveldocIssueState) {
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

    public AgentExtApi traveldocNatCode(String traveldocNatCode) {
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

    public AgentExtApi traveldocBirthdate(String traveldocBirthdate) {
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

    public AgentExtApi traveldocGender(String traveldocGender) {
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

    public AgentExtApi biometrics(List<CompBiometrics> biometrics) {
        this.biometrics = biometrics;
        return this;
    }

    public AgentExtApi addBiometricsItem(CompBiometrics biometricsItem) {
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

    public AgentExtApi transportInfo(CompApiTransport transportInfo) {
        this.transportInfo = transportInfo;
        return this;
    }

    /**
     * Get transportInfo
     *
     * @return transportInfo
     */
    @Schema(description = "")
    @Valid
    public CompApiTransport getTransportInfo() {
        return transportInfo;
    }

    public void setTransportInfo(CompApiTransport transportInfo) {
        this.transportInfo = transportInfo;
    }

    public AgentExtApi addMode(String addMode) {
        this.addMode = addMode;
        return this;
    }

    /**
     * Get addMode
     *
     * @return addMode
     */
    @Schema(description = "")
    public String getAddMode() {
        return addMode;
    }

    public void setAddMode(String addMode) {
        this.addMode = addMode;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AgentExtApi agentExtApi = (AgentExtApi) o;
        return Objects.equals(this.recordId, agentExtApi.recordId)
                && Objects.equals(this.appRefNo, agentExtApi.appRefNo)
                && Objects.equals(this.traveldocNum, agentExtApi.traveldocNum)
                && Objects.equals(this.traveldocExpiry, agentExtApi.traveldocExpiry)
                && Objects.equals(this.traveldocIssueState, agentExtApi.traveldocIssueState)
                && Objects.equals(this.traveldocNatCode, agentExtApi.traveldocNatCode)
                && Objects.equals(this.traveldocBirthdate, agentExtApi.traveldocBirthdate)
                && Objects.equals(this.traveldocGender, agentExtApi.traveldocGender)
                && Objects.equals(this.biometrics, agentExtApi.biometrics)
                && Objects.equals(this.transportInfo, agentExtApi.transportInfo)
                && Objects.equals(this.addMode, agentExtApi.addMode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                recordId,
                appRefNo,
                traveldocNum,
                traveldocExpiry,
                traveldocIssueState,
                traveldocNatCode,
                traveldocBirthdate,
                traveldocGender,
                biometrics,
                transportInfo,
                addMode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AgentExtApi {\n");

        sb.append("    recordId: ").append(toIndentedString(recordId)).append("\n");
        sb.append("    appRefNo: ").append(toIndentedString(appRefNo)).append("\n");
        sb.append("    traveldocNum: ").append(toIndentedString(traveldocNum)).append("\n");
        sb.append("    traveldocExpiry: ").append(toIndentedString(traveldocExpiry)).append("\n");
        sb.append("    traveldocIssueState: ")
                .append(toIndentedString(traveldocIssueState))
                .append("\n");
        sb.append("    traveldocNatCode: ").append(toIndentedString(traveldocNatCode)).append("\n");
        sb.append("    traveldocBirthdate: ")
                .append(toIndentedString(traveldocBirthdate))
                .append("\n");
        sb.append("    traveldocGender: ").append(toIndentedString(traveldocGender)).append("\n");
        sb.append("    biometrics: ").append(toIndentedString(biometrics)).append("\n");
        sb.append("    transportInfo: ").append(toIndentedString(transportInfo)).append("\n");
        sb.append("    addMode: ").append(toIndentedString(addMode)).append("\n");
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
