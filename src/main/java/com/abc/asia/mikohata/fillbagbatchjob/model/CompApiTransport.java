package com.abc.asia.mikohata.fillbagbatchjob.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

/** CompApiTransport */
@Validated
@jakarta.annotation.Generated(
        value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
        date = "2023-04-07T08:37:25.978277515Z[GMT]")
public class CompApiTransport {
    @JsonProperty("transport_domain")
    private String transportDomain = null;

    @JsonProperty("transport_id")
    private String transportId = null;

    @JsonProperty("transport_datetime")
    private String transportDatetime = null;

    public CompApiTransport transportDomain(String transportDomain) {
        this.transportDomain = transportDomain;
        return this;
    }

    /**
     * Get transportDomain
     *
     * @return transportDomain
     */
    @Schema(description = "")
    public String getTransportDomain() {
        return transportDomain;
    }

    public void setTransportDomain(String transportDomain) {
        this.transportDomain = transportDomain;
    }

    public CompApiTransport transportId(String transportId) {
        this.transportId = transportId;
        return this;
    }

    /**
     * Get transportId
     *
     * @return transportId
     */
    @Schema(description = "")
    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public CompApiTransport transportDatetime(String transportDatetime) {
        this.transportDatetime = transportDatetime;
        return this;
    }

    /**
     * Get transportDatetime
     *
     * @return transportDatetime
     */
    @Schema(description = "")
    public String getTransportDatetime() {
        return transportDatetime;
    }

    public void setTransportDatetime(String transportDatetime) {
        this.transportDatetime = transportDatetime;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CompApiTransport compApiTransport = (CompApiTransport) o;
        return Objects.equals(this.transportDomain, compApiTransport.transportDomain)
                && Objects.equals(this.transportId, compApiTransport.transportId)
                && Objects.equals(this.transportDatetime, compApiTransport.transportDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transportDomain, transportId, transportDatetime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CompApiTransport {\n");

        sb.append("    transportDomain: ").append(toIndentedString(transportDomain)).append("\n");
        sb.append("    transportId: ").append(toIndentedString(transportId)).append("\n");
        sb.append("    transportDatetime: ")
                .append(toIndentedString(transportDatetime))
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
