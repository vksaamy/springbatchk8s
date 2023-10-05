package com.abc.asia.mikohata.fillbagbatchjob.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/** AgentBMS */
@Validated
@jakarta.annotation.Generated(
        value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
        date = "2023-04-07T08:37:25.978277515Z[GMT]")
public class AgentBMS {
    @JsonProperty("cache_id")
    private String cacheId = null;

    @JsonProperty("person_id")
    private String personId = null;

    @JsonProperty("biometrics")
    @Valid
    private List<BioTemplate> biometrics = null;

    public AgentBMS cacheId(String cacheId) {
        this.cacheId = cacheId;
        return this;
    }

    /**
     * Get cacheId
     *
     * @return cacheId
     */
    @Schema(description = "")
    public String getCacheId() {
        return cacheId;
    }

    public void setCacheId(String cacheId) {
        this.cacheId = cacheId;
    }

    public AgentBMS personId(String personId) {
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

    public AgentBMS biometrics(List<BioTemplate> biometrics) {
        this.biometrics = biometrics;
        return this;
    }

    public AgentBMS addBiometricsItem(BioTemplate biometricsItem) {
        if (this.biometrics == null) {
            this.biometrics = new ArrayList<BioTemplate>();
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
    public List<BioTemplate> getBiometrics() {
        return biometrics;
    }

    public void setBiometrics(List<BioTemplate> biometrics) {
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
        AgentBMS agentBMS = (AgentBMS) o;
        return Objects.equals(this.cacheId, agentBMS.cacheId)
                && Objects.equals(this.personId, agentBMS.personId)
                && Objects.equals(this.biometrics, agentBMS.biometrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cacheId, personId, biometrics);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AgentBMS {\n");

        sb.append("    cacheId: ").append(toIndentedString(cacheId)).append("\n");
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
