package com.abc.asia.mikohata.fillbagbatchjob.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

/** CompBiometrics */
@Validated
@jakarta.annotation.Generated(
        value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
        date = "2023-02-06T05:56:04.170099296Z[GMT]")
public class CompBiometrics {
    @JsonProperty("biometric_type")
    private String biometricType = null;

    @JsonProperty("submission_type")
    private String submissionType = null;

    @JsonProperty("blob_base64")
    private String blobBase64 = null;

    @JsonProperty("blob_filetype")
    private String blobFiletype = null;

    @JsonProperty("blob_width_pixels")
    private Integer blobWidthPixels = null;

    @JsonProperty("blob_height_pixels")
    private Integer blobHeightPixels = null;

    @JsonProperty("position")
    private String position = null;

    @JsonProperty("created_datetime")
    private String createdDatetime = null;

    @JsonProperty("bms_guid")
    private String bmsGuid = null;

    public CompBiometrics biometricType(String biometricType) {
        this.biometricType = biometricType;
        return this;
    }

    /**
     * Get biometricType
     *
     * @return biometricType
     */
    @Schema(description = "")
    public String getBiometricType() {
        return biometricType;
    }

    public void setBiometricType(String biometricType) {
        this.biometricType = biometricType;
    }

    public CompBiometrics submissionType(String submissionType) {
        this.submissionType = submissionType;
        return this;
    }

    /**
     * Get submissionType
     *
     * @return submissionType
     */
    @Schema(description = "")
    public String getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(String submissionType) {
        this.submissionType = submissionType;
    }

    public CompBiometrics blobBase64(String blobBase64) {
        this.blobBase64 = blobBase64;
        return this;
    }

    /**
     * Get blobBase64
     *
     * @return blobBase64
     */
    @Schema(description = "")
    public String getBlobBase64() {
        return blobBase64;
    }

    public void setBlobBase64(String blobBase64) {
        this.blobBase64 = blobBase64;
    }

    public CompBiometrics blobFiletype(String blobFiletype) {
        this.blobFiletype = blobFiletype;
        return this;
    }

    /**
     * Get blobFiletype
     *
     * @return blobFiletype
     */
    @Schema(description = "")
    public String getBlobFiletype() {
        return blobFiletype;
    }

    public void setBlobFiletype(String blobFiletype) {
        this.blobFiletype = blobFiletype;
    }

    public CompBiometrics blobWidthPixels(Integer blobWidthPixels) {
        this.blobWidthPixels = blobWidthPixels;
        return this;
    }

    /**
     * Get blobWidthPixels
     *
     * @return blobWidthPixels
     */
    @Schema(description = "")
    public Integer getBlobWidthPixels() {
        return blobWidthPixels;
    }

    public void setBlobWidthPixels(Integer blobWidthPixels) {
        this.blobWidthPixels = blobWidthPixels;
    }

    public CompBiometrics blobHeightPixels(Integer blobHeightPixels) {
        this.blobHeightPixels = blobHeightPixels;
        return this;
    }

    /**
     * Get blobHeightPixels
     *
     * @return blobHeightPixels
     */
    @Schema(description = "")
    public Integer getBlobHeightPixels() {
        return blobHeightPixels;
    }

    public void setBlobHeightPixels(Integer blobHeightPixels) {
        this.blobHeightPixels = blobHeightPixels;
    }

    public CompBiometrics position(String position) {
        this.position = position;
        return this;
    }

    /**
     * Get position
     *
     * @return position
     */
    @Schema(description = "")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public CompBiometrics createdDatetime(String createdDatetime) {
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

    public CompBiometrics bmsGuid(String bmsGuid) {
        this.bmsGuid = bmsGuid;
        return this;
    }

    /**
     * Get bmsGuiid
     *
     * @return bmsGuiid
     */
    @Schema(description = "")
    public String getBmsGuid() {
        return bmsGuid;
    }

    public void setBmsGuid(String bmsGuid) {
        this.bmsGuid = bmsGuid;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CompBiometrics compBiometrics = (CompBiometrics) o;
        return Objects.equals(this.biometricType, compBiometrics.biometricType)
                && Objects.equals(this.submissionType, compBiometrics.submissionType)
                && Objects.equals(this.blobBase64, compBiometrics.blobBase64)
                && Objects.equals(this.blobFiletype, compBiometrics.blobFiletype)
                && Objects.equals(this.blobWidthPixels, compBiometrics.blobWidthPixels)
                && Objects.equals(this.blobHeightPixels, compBiometrics.blobHeightPixels)
                && Objects.equals(this.position, compBiometrics.position)
                && Objects.equals(this.createdDatetime, compBiometrics.createdDatetime)
                && Objects.equals(this.bmsGuid, compBiometrics.bmsGuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                biometricType,
                submissionType,
                blobBase64,
                blobFiletype,
                blobWidthPixels,
                blobHeightPixels,
                position,
                createdDatetime,
                bmsGuid);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CompBiometrics {\n");

        sb.append("    biometricType: ").append(toIndentedString(biometricType)).append("\n");
        sb.append("    submissionType: ").append(toIndentedString(submissionType)).append("\n");
        sb.append("    blobBase64: ").append(toIndentedString(blobBase64)).append("\n");
        sb.append("    blobFiletype: ").append(toIndentedString(blobFiletype)).append("\n");
        sb.append("    blobWidthPixels: ").append(toIndentedString(blobWidthPixels)).append("\n");
        sb.append("    blobHeightPixels: ").append(toIndentedString(blobHeightPixels)).append("\n");
        sb.append("    position: ").append(toIndentedString(position)).append("\n");
        sb.append("    createdDatetime: ").append(toIndentedString(createdDatetime)).append("\n");
        sb.append("    bmsGuiid: ").append(toIndentedString(bmsGuid)).append("\n");
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
