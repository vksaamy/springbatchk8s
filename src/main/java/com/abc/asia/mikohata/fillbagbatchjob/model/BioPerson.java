package com.abc.asia.mikohata.fillbagbatchjob.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/** BioPerson */
@Validated
@jakarta.annotation.Generated(
        value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
        date = "2023-02-06T05:56:04.170099296Z[GMT]")
public class BioPerson {
    @JsonProperty("person_id")
    private String personId = null;

    @JsonProperty("app_ref_no")
    private String appRefNo = null;

    @JsonProperty("uin")
    private String uin = null;

    @JsonProperty("genno")
    private String genno = null;

    @JsonProperty("serno")
    private String serno = null;

    @JsonProperty("biometrics")
    @Valid
    private List<BioTemplate> bioTemplates = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("source")
    private String source = null;

    @JsonProperty("pool")
    private String pool = null;

    @JsonProperty("created_datetime")
    private Date createdDatetime = null;

    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("updated_datetime")
    private String updatedDatetime = null;

    @JsonProperty("updated_by")
    private String updatedBy = null;

    @JsonProperty("expiry_datetime")
    private Date expiryDatetime = null;

    @JsonProperty("expiry_by")
    private String expiryBy = null;

    @JsonProperty("traveldoc_no")
    private String travelDocNo = null;

    @JsonProperty("traveldoc_expiry")
    private String travelDocExpiry = null;

    @JsonProperty("traveldoc_issue_state")
    private String travelDocIssueState = null;

    @JsonProperty("traveldoc_nat_code")
    private String travelDocNatCode = null;

    @JsonProperty("traveldoc_birthdate")
    private String travelDocBirthDate = null;

    @JsonProperty("traveldoc_gender")
    private String travelDocGender = null;

    public BioPerson personId(String personId) {
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

    public BioPerson appRefNo(String appRefNo) {
        this.appRefNo = appRefNo;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @Schema(description = "")
    public String getAppRefNo() {
        return appRefNo;
    }

    public void setAppRefNo(String appRefNo) {
        this.appRefNo = appRefNo;
    }

    public BioPerson uin(String uin) {
        this.uin = uin;
        return this;
    }

    /**
     * Get uin
     *
     * @return uin
     */
    @Schema(description = "")
    public String getUin() {
        return uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }

    public BioPerson genno(String genno) {
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

    public BioPerson serno(String serno) {
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

    public BioPerson bioTemplates(List<BioTemplate> bioTemplates) {
        this.bioTemplates = bioTemplates;
        return this;
    }

    public BioPerson addBioTemplatesItem(BioTemplate bioTemplatesItem) {
        if (this.bioTemplates == null) {
            this.bioTemplates = new ArrayList<BioTemplate>();
        }
        this.bioTemplates.add(bioTemplatesItem);
        return this;
    }

    /**
     * Get biometrics
     *
     * @return biometrics
     */
    @Schema(description = "")
    @Valid
    public List<BioTemplate> getBioTemplates() {
        return bioTemplates;
    }

    public void setBioTemplates(List<BioTemplate> bioTemplates) {
        this.bioTemplates = bioTemplates;
    }

    public BioPerson name(String name) {
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

    public BioPerson source(String source) {
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

    public BioPerson pool(String pool) {
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

    public BioPerson createdDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
        return this;
    }

    /**
     * Get createdDatetime
     *
     * @return createdDatetime
     */
    @Schema(description = "")
    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public BioPerson createdBy(String createdBy) {
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

    public BioPerson updatedDatetime(String updatedDatetime) {
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

    public BioPerson updatedBy(String updatedBy) {
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

    public BioPerson expiryDatetime(Date expiryDatetime) {
        this.expiryDatetime = expiryDatetime;
        return this;
    }

    /**
     * Get expiryDatetime
     *
     * @return expiryDatetime
     */
    @Schema(description = "")
    public Date getExpiryDatetime() {
        return expiryDatetime;
    }

    public void setExpiryDatetime(Date expiryDatetime) {
        this.expiryDatetime = expiryDatetime;
    }

    public BioPerson expiryBy(String expiryBy) {
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

    public BioPerson travelDocNo(String travelDocNo) {
        this.travelDocNo = travelDocNo;
        return this;
    }

    /**
     * Get travelDocNo
     *
     * @return travelDocNo
     */
    @Schema(description = "")
    public String getTravelDocNo() {
        return travelDocNo;
    }

    public void setTravelDocNo(String travelDocNo) {
        this.travelDocNo = travelDocNo;
    }

    public BioPerson travelDocExpiry(String travelDocExpiry) {
        this.travelDocExpiry = travelDocExpiry;
        return this;
    }

    /**
     * Get travelDocExpiry
     *
     * @return travelDocExpiry
     */
    @Schema(description = "")
    public String getTravelDocExpiry() {
        return travelDocExpiry;
    }

    public void setTravelDocExpiry(String travelDocExpiry) {
        this.travelDocExpiry = travelDocExpiry;
    }

    public BioPerson travelDocIssueState(String travelDocIssueState) {
        this.travelDocIssueState = travelDocIssueState;
        return this;
    }

    /**
     * Get travelDocIssueStatus
     *
     * @return travelDocIssueStatus
     */
    @Schema(description = "")
    public String getTravelDocIssueState() {
        return travelDocIssueState;
    }

    public void setTravelDocIssueState(String travelDocIssueState) {
        this.travelDocIssueState = travelDocIssueState;
    }

    public BioPerson travelDocNatCode(String travelDocNatCode) {
        this.travelDocNatCode = travelDocNatCode;
        return this;
    }

    /**
     * Get travelDocNatCode
     *
     * @return travelDocNatCode
     */
    @Schema(description = "")
    public String getTravelDocNatCode() {
        return travelDocNatCode;
    }

    public void setTravelDocNatCode(String travelDocNatCode) {
        this.travelDocNatCode = travelDocNatCode;
    }

    public BioPerson travelDocBirthDate(String travelDocBirthDate) {
        this.travelDocBirthDate = travelDocBirthDate;
        return this;
    }

    /**
     * Get travelDocBirthDate
     *
     * @return travelDocBirthDate
     */
    @Schema(description = "")
    public String getTravelDocBirthDate() {
        return travelDocBirthDate;
    }

    public void setTravelDocBirthDate(String travelDocBirthDate) {
        this.travelDocBirthDate = travelDocBirthDate;
    }

    public BioPerson travelDocGender(String travelDocGender) {
        this.travelDocGender = travelDocGender;
        return this;
    }

    /**
     * Get travelDocGender
     *
     * @return travelDocGender
     */
    @Schema(description = "")
    public String getTravelDocGender() {
        return travelDocGender;
    }

    public void setTravelDocGender(String travelDocGender) {
        this.travelDocGender = travelDocGender;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BioPerson bioPerson = (BioPerson) o;
        return Objects.equals(this.personId, bioPerson.personId)
                && Objects.equals(this.uin, bioPerson.uin)
                && Objects.equals(this.genno, bioPerson.genno)
                && Objects.equals(this.serno, bioPerson.serno)
                && Objects.equals(this.bioTemplates, bioPerson.bioTemplates)
                && Objects.equals(this.name, bioPerson.name)
                && Objects.equals(this.source, bioPerson.source)
                && Objects.equals(this.pool, bioPerson.pool)
                && Objects.equals(this.createdDatetime, bioPerson.createdDatetime)
                && Objects.equals(this.createdBy, bioPerson.createdBy)
                && Objects.equals(this.updatedDatetime, bioPerson.updatedDatetime)
                && Objects.equals(this.updatedBy, bioPerson.updatedBy)
                && Objects.equals(this.expiryDatetime, bioPerson.expiryDatetime)
                && Objects.equals(this.expiryBy, bioPerson.expiryBy)
                && Objects.equals(this.travelDocNo, bioPerson.travelDocNo)
                && Objects.equals(this.travelDocExpiry, bioPerson.travelDocExpiry)
                && Objects.equals(this.travelDocIssueState, bioPerson.travelDocIssueState)
                && Objects.equals(this.travelDocNatCode, bioPerson.travelDocNatCode)
                && Objects.equals(this.travelDocBirthDate, bioPerson.travelDocBirthDate)
                && Objects.equals(this.travelDocGender, bioPerson.travelDocGender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                personId,
                uin,
                genno,
                serno,
                bioTemplates,
                name,
                source,
                pool,
                createdDatetime,
                createdBy,
                updatedDatetime,
                updatedBy,
                expiryDatetime,
                expiryBy,
                travelDocNo,
                travelDocExpiry,
                travelDocIssueState,
                travelDocNatCode,
                travelDocBirthDate,
                travelDocGender);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BioPerson {\n");

        sb.append("    personId: ").append(toIndentedString(personId)).append("\n");
        sb.append("    uin: ").append(toIndentedString(uin)).append("\n");
        sb.append("    genno: ").append(toIndentedString(genno)).append("\n");
        sb.append("    serno: ").append(toIndentedString(serno)).append("\n");
        sb.append("    biometrics: ").append(toIndentedString(bioTemplates)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    pool: ").append(toIndentedString(pool)).append("\n");
        sb.append("    createdDatetime: ").append(toIndentedString(createdDatetime)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    updatedDatetime: ").append(toIndentedString(updatedDatetime)).append("\n");
        sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
        sb.append("    expiryDatetime: ").append(toIndentedString(expiryDatetime)).append("\n");
        sb.append("    expiryBy: ").append(toIndentedString(expiryBy)).append("\n");
        sb.append("    travelDocNo: ").append(toIndentedString(travelDocNo)).append("\n");
        sb.append("    travelDocExpiry: ").append(toIndentedString(travelDocExpiry)).append("\n");
        sb.append("    travelDocIssueStatus: ")
                .append(toIndentedString(travelDocIssueState))
                .append("\n");
        sb.append("    travelDocNatCode: ").append(toIndentedString(travelDocNatCode)).append("\n");
        sb.append("    travelDocBirthDate: ")
                .append(toIndentedString(travelDocBirthDate))
                .append("\n");
        sb.append("    travelDocGender: ").append(toIndentedString(travelDocGender)).append("\n");
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
