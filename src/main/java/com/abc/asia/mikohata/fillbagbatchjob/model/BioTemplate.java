package com.abc.asia.mikohata.fillbagbatchjob.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/** BioTemplate */
@Validated
@jakarta.annotation.Generated(
        value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
        date = "2023-02-23T09:57:25.259557369Z[GMT]")
public class BioTemplate {
    @JsonProperty("bio_uuid")
    private String bioUuid = null;

    @JsonProperty("person_id")
    private String personId = null;

    @JsonProperty("biometrics")
    @Valid
    private List<CompBiometrics> biometrics = null;

    public BioTemplate bioUuid(String bioUuid) {
        this.bioUuid = bioUuid;
        return this;
    }

    /**
     * Get bioUuid
     *
     * @return bioUuid
     */
    @Schema(description = "")
    public String getBioUuid() {
        return bioUuid;
    }

    public void setBioUuid(String bioUuid) {
        this.bioUuid = bioUuid;
    }

    public BioTemplate personId(String personId) {
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

    public BioTemplate biometrics(List<CompBiometrics> biometrics) {
        this.biometrics = biometrics;
        return this;
    }

    public BioTemplate addBiometricsItem(CompBiometrics biometricsItem) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BioTemplate bioTemplate = (BioTemplate) o;
        return Objects.equals(this.bioUuid, bioTemplate.bioUuid)
                && Objects.equals(this.personId, bioTemplate.personId)
                && Objects.equals(this.biometrics, bioTemplate.biometrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bioUuid, personId, biometrics);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BioTemplate {\n");

        sb.append("    bioUuid: ").append(toIndentedString(bioUuid)).append("\n");
        sb.append("    personId: ").append(toIndentedString(personId)).append("\n");
        sb.append("    biometrics: ").append(toIndentedString(biometrics)).append("\n");
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
