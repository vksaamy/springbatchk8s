package com.abc.asia.mikohata.config;

import com.abc.asia.mikohata.fillbagbatchjob.model.AgentExtApi;
import com.abc.asia.mikohata.fillbagbatchjob.model.AgentSite;
import com.abc.asia.mikohata.fillbagbatchjob.model.CompBiometrics;
import com.abc.asia.mikohata.fillbagbatchjob.security.TokenManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;

public class AddProfileItemProcessor implements ItemProcessor<ArrayList<AgentExtApi>, AgentSite> {

    private static final Logger log = LoggerFactory.getLogger(AddProfileItemProcessor.class);
    @Autowired private TokenManager tokenManager;
    public static final String AUTHORIZATION = "Authorization";

    @Autowired private DiscoveryClient discoveryClient;
    @Autowired private Environment environment;
    private static final String AGENTSITE_URL = "http://agentsite";

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    private String hostname;

    @Override
    public AgentSite process(final ArrayList<AgentExtApi> agentExtApis) throws Exception {

        log.info("inside AddProfileItemProcessor");
        /*RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String token = "";
        if (tokenManager != null) {
            token = tokenManager.getAccessToken();
        }
        headers.set("Accept", "application/json");
        // log.info("Bearer token" + token);
        headers.add(AUTHORIZATION, "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String baseUrl = AGENTSITE_URL + "/profile/query";

        Iterator<AgentExtApi> itr = agentExtApis.iterator();
        ArrayList<AgentSite> agentSites = null;
        if (itr.hasNext()) agentSites = new ArrayList<AgentSite>();
        while (itr.hasNext()) {
            AgentExtApi agentExtApi = itr.next();
            AgentSite agentSite = new AgentSite();
            agentSite.traveldocNo(agentExtApi.getTraveldocNum());
            agentSite.traveldocExpiry(agentExtApi.getTraveldocExpiry());
            agentSite.traveldocIssueState(agentExtApi.getTraveldocIssueState());
            agentSite.traveldocNatCode(agentExtApi.getTraveldocNatCode());
            agentSite.traveldocBirthdate(agentExtApi.getTraveldocBirthdate());
            agentSite.traveldocGender(agentExtApi.getTraveldocGender());
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = Obj.writeValueAsString(agentSite);
            try {
                log.info("jsonStr : " + jsonStr);
                HttpEntity<String> request = new HttpEntity<String>(jsonStr, headers);
                ResponseEntity<AgentSite> response = null;
                if (Arrays.asList(environment.getActiveProfiles()).contains("test")
                        || (Arrays.asList(environment.getActiveProfiles()).contains("local"))) {
                    baseUrl = AppConstants.WIREMOCK_URL + "/agentsite/profile/query";
                    try {
                        log.debug("Calling agentsite service through wiremock");
                        response = restTemplate.postForEntity(baseUrl, request, AgentSite.class);

                        log.debug("Response from agentsite from WIREMOCK " + response);
                    } catch (Exception e) {
                        log.error("Cant find server" + e);
                    }

                } else {
                    try {
                        log.debug("Calling agentsite service");
                        response = restTemplate.postForEntity(baseUrl, request, AgentSite.class);

                        log.debug("Response from agentsite" + response);
                    } catch (Exception e) {
                        log.error("Cant find server" + e);
                    }
                }
                if (response != null) {
                    AgentSite agentSiteResponse = response.getBody();
                    if (agentSiteResponse != null)
                        log.debug("AgentSite response ; " + agentSiteResponse.getAppRefNo());
                    log.debug("AgentSite Creating PerosnID ");

                    agentSiteResponse.setPersonId(
                            (agentSiteResponse.getPersonId() == null
                                    ? UUID.randomUUID().toString()
                                    : agentSiteResponse.getPersonId()));
                    List<CompBiometrics> compBiometrics = agentSiteResponse.getBiometrics();
                    Iterator<CompBiometrics> compBiometricsItr = compBiometrics.iterator();
                    while (compBiometricsItr.hasNext()) {
                        CompBiometrics compBiometric = compBiometricsItr.next();
                        log.debug("CompBiometrics Creating BmsGuid ");

                        compBiometric.setBmsGuid(
                                (compBiometric.getBmsGuid() == null
                                        ? UUID.randomUUID().toString()
                                        : compBiometric.getBmsGuid()));
                    }
                    agentSites.add(agentSiteResponse);
                }
            } catch (Exception e) {
                log.error("Exception : ", e);
            }
        }
        return agentSites;*/
        ArrayList<AgentSite> agentSites = null;
        AgentSite agentSite = new AgentSite();
        agentSite.setAppRefNo("K12345678_GBN_19820116");
        agentSite.traveldocNo("K12345678");
        agentSite.traveldocExpiry("20281231");
        agentSite.traveldocIssueState("GBN");
        agentSite.traveldocNatCode("GBN");
        agentSite.traveldocBirthdate("19820116");
        agentSite.traveldocGender("M");

        agentSite.setPersonId(
                (agentSite.getPersonId() == null
                        ? UUID.randomUUID().toString()
                        : agentSite.getPersonId()));

        List<CompBiometrics> biometrics = new ArrayList<CompBiometrics>();
        CompBiometrics compBiometricsLeft = new CompBiometrics();
        compBiometricsLeft.setBiometricType("iris");
        compBiometricsLeft.setBlobBase64("ANCDREELLL");
        compBiometricsLeft.setBlobFiletype("png");
        compBiometricsLeft.setPosition("1");
        compBiometricsLeft.setSubmissionType("enrolment");
        compBiometricsLeft.setBmsGuid(
                (compBiometricsLeft.getBmsGuid() == null
                        ? UUID.randomUUID().toString()
                        : compBiometricsLeft.getBmsGuid()));
        biometrics.add(compBiometricsLeft);
        CompBiometrics compBiometricsRight = new CompBiometrics();
        compBiometricsRight.setBiometricType("iris");
        compBiometricsRight.setBlobBase64("ANCDREERRR");
        compBiometricsRight.setBlobFiletype("png");
        compBiometricsRight.setPosition("2");
        compBiometricsRight.setSubmissionType("enrolment");
        compBiometricsRight.setBmsGuid(
                (compBiometricsRight.getBmsGuid() == null
                        ? UUID.randomUUID().toString()
                        : compBiometricsRight.getBmsGuid()));
        biometrics.add(compBiometricsRight);

        CompBiometrics compBiometricsFace = new CompBiometrics();
        compBiometricsFace.setBiometricType("face");
        compBiometricsFace.setBlobBase64("ANCDREEFFF");
        compBiometricsFace.setBlobFiletype("png");
        compBiometricsFace.setPosition("F");
        compBiometricsFace.setSubmissionType("enrolment");
        compBiometricsFace.setBmsGuid(
                (compBiometricsFace.getBmsGuid() == null
                        ? UUID.randomUUID().toString()
                        : compBiometricsFace.getBmsGuid()));
        biometrics.add(compBiometricsFace);

        agentSite.setBiometrics(biometrics);
        log.info("AddProfileItemProcessor End");

        return agentSite;
    }
}
