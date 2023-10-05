package com.abc.asia.mikohata.config;

import com.abc.asia.mikohata.fillbagbatchjob.model.AgentBMS;
import com.abc.asia.mikohata.fillbagbatchjob.model.AgentSite;
import com.abc.asia.mikohata.fillbagbatchjob.model.BioPerson;
import com.abc.asia.mikohata.fillbagbatchjob.model.BioTemplate;
import com.abc.asia.mikohata.fillbagbatchjob.model.BiometricType;
import com.abc.asia.mikohata.fillbagbatchjob.model.CompBiometrics;
import com.abc.asia.mikohata.fillbagbatchjob.security.TokenManager;
import com.abc.asia.mikohata.utils.AppConstants;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProfileUpdateWriter implements ItemWriter<AgentSite> {

    private static final Logger log = LoggerFactory.getLogger(ProfileUpdateWriter.class);
    @Autowired private TokenManager tokenManager;
    public static final String AUTHORIZATION = "Authorization";
    @Autowired private DiscoveryClient discoveryClient;
    @Autowired private Environment environment;
    @Autowired private RestTemplate restTemplate;
    private static final String BIOPERSON_URL = "http://bioperson/";
    private static final String BIOIRIS_URL = "http://bioiris/";
    private static final String BIOFACE_URL = "http://biofacial/";
    private static final String BMSAGENT_URL = "http://bmsagent/";

    @Override
    public void write(Chunk<? extends AgentSite> agentSites) throws Exception {
        log.debug("Sample");
        for (AgentSite agentSite : agentSites) {
            log.info("Add Person info start");
            BioPerson bioPerson = getBioPerson(agentSite);
            log.info("Add Person info End");

            /* log.info("Register BMS Facial start");
                        AgentBMS agentBMS = registerBMSFacial(agentSite);
                        log.info("Register BMS Facial End");
            */
            log.info("Save DB Facial start");
            BioTemplate bioTemplate = saveFacialDB(agentSite);
            log.info("Save DB Facial End");

            /*          log.info("Register BMS Facial start");
                        AgentBMS agentBMSIris = registerBMSIris(agentSite);
                        log.info("Register BMS Facial End");
            */
            log.info("Save DB Facial start");
            BioTemplate bioTemplateIris = saveIrisDB(agentSite);
            log.info("Save DB Facial End");
        }
    }

    private BioPerson addBioPerson(AgentSite agentSite) {
        // RestTemplate restTemplate = new RestTemplate();
        log.info("inside FillBagItemWriter");
        HttpHeaders headers = new HttpHeaders();
        String token = "";
        if (tokenManager != null) {
            token = tokenManager.getAccessToken();
        }
        headers.set("Accept", "application/json");
        log.info("Bearer token" + token);
        headers.add(AUTHORIZATION, "Bearer " + token);

        log.info("insert BioPerson");

        BioPerson bioPerson = prepareBioPerson(agentSite);
        HttpEntity<String> request = new HttpEntity<String>(bioPerson.toString(), headers);
        ResponseEntity<Void> response = null;

        if (Arrays.asList(environment.getActiveProfiles()).contains("test")
                || (Arrays.asList(environment.getActiveProfiles()).contains("local"))) {
            String baseUrl = AppConstants.WIREMOCK_URL + "/bioperson/" + bioPerson.getSource();
            try {
                log.debug("Calling addBioPerson service through wiremock");
                response = restTemplate.postForEntity(baseUrl, request, Void.class);

                log.debug("Response from addBioPerson from WIREMOCK " + response);
            } catch (Exception e) {
                log.error("Cant find server" + e);
            }

        } else {
            log.info("Source " + bioPerson.getSource());
            String baseUrl = BIOPERSON_URL + "air";
            restTemplate.postForEntity(baseUrl, request, Void.class);
        }
        log.info("BioPerson Successfully added");
        return bioPerson;
    }

    private BioPerson getBioPerson(AgentSite agentsite) {
        // RestTemplate restTemplate = new RestTemplate();
        log.info("inside FillBagItemWriter");
        HttpHeaders headers = new HttpHeaders();
        String token = "";
        if (tokenManager != null) {
            token = tokenManager.getAccessToken();
        }
        headers.set("Accept", "application/json");
        log.info("Bearer token" + token);
        headers.add(AUTHORIZATION, "Bearer " + token);

        log.info("insert BioPerson");

        BioPerson bioPerson = prepareBioPerson(agentsite);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<Void> response = null;

        if (Arrays.asList(environment.getActiveProfiles()).contains("test")
                || (Arrays.asList(environment.getActiveProfiles()).contains("local"))) {
            String baseUrl = AppConstants.WIREMOCK_URL + "/bioperson/" + bioPerson.getSource();
            try {
                log.debug("Calling addBioPerson service through wiremock");
                response = restTemplate.postForEntity(baseUrl, request, Void.class);

                log.debug("Response from addBioPerson from WIREMOCK " + response);
            } catch (Exception e) {
                log.error("Cant find server" + e);
            }

        } else {
            log.info("Source " + bioPerson.getSource());
            String baseUrl = BIOPERSON_URL + "/bioperson/air/563ce220-c4c6-445a-81b2-d641781795eb";
            response = restTemplate.exchange(baseUrl, HttpMethod.GET, request, Void.class);
            log.info("Response 123 *****" + response.getBody());
        }
        log.info("BioPerson Successfully added");
        return bioPerson;
    }

    private BioPerson prepareBioPerson(AgentSite agentSite) {
        BioPerson bioPerson = new BioPerson();
        bioPerson.setAppRefNo(agentSite.getAppRefNo());
        bioPerson.setPool(agentSite.getPool());
        bioPerson.setPersonId(agentSite.getPersonId());
        bioPerson.setGenno(agentSite.getGenno());
        bioPerson.setName(agentSite.getName());
        bioPerson.setSerno(agentSite.getSerno());
        bioPerson.setSource(agentSite.getSource());
        bioPerson.setTravelDocBirthDate(agentSite.getTraveldocBirthdate());
        bioPerson.setTravelDocExpiry(agentSite.getTraveldocExpiry());
        bioPerson.setTravelDocGender(agentSite.getTraveldocGender());
        bioPerson.setTravelDocIssueState(agentSite.getTraveldocIssueState());
        bioPerson.setTravelDocNatCode(agentSite.getTraveldocNatCode());
        bioPerson.setTravelDocNo(agentSite.getTraveldocNo());
        bioPerson.setUin(agentSite.getAppRefNo());
        return bioPerson;
    }

    private AgentBMS registerBMSFacial(AgentSite agentSite) {

        // RestTemplate restTemplate = new RestTemplate();
        log.info("inside FillBagItemWriter");
        HttpHeaders headers = new HttpHeaders();
        String token = "";
        if (tokenManager != null) {
            token = tokenManager.getAccessToken();
        }
        headers.set("Accept", "application/json");
        // log.info("Bearer token" + token);
        headers.add(AUTHORIZATION, "Bearer " + token);

        log.info("insert BMSFacial");

        AgentBMS agentBMS = new AgentBMS();
        agentBMS.setPersonId(agentSite.getPersonId());
        List<CompBiometrics> biometrics = agentSite.getBiometrics();

        Iterator<CompBiometrics> itrCompBiometrics = biometrics.iterator();
        while (itrCompBiometrics.hasNext()) {
            BioTemplate bioTemplate = new BioTemplate();
            CompBiometrics compBiometrics = itrCompBiometrics.next();
            if (BiometricType.FACE.equals(compBiometrics.getBiometricType())) {
                bioTemplate.setBioUuid(
                        (bioTemplate.getBioUuid() == null
                                ? UUID.randomUUID().toString()
                                : bioTemplate.getBioUuid()));
                bioTemplate.addBiometricsItem(compBiometrics);
                agentBMS.addBiometricsItem(bioTemplate);
                HttpEntity<String> request = new HttpEntity<String>(agentBMS.toString(), headers);
                ResponseEntity<Void> response = null;
                if (Arrays.asList(environment.getActiveProfiles()).contains("test")
                        || (Arrays.asList(environment.getActiveProfiles()).contains("local"))) {
                    String baseUrl =
                            AppConstants.WIREMOCK_URL + "/bmsagent/" + agentSite.getSource();
                    try {
                        log.debug("Calling registerBMSFacial service through wiremock");
                        response = restTemplate.postForEntity(baseUrl, request, Void.class);

                        log.debug("Response from registerBMSFacial from WIREMOCK " + response);
                    } catch (Exception e) {
                        log.error("Cant find server" + e);
                    }

                } else {
                    String baseUrl = BMSAGENT_URL + agentSite.getSource();
                    response = restTemplate.postForEntity(baseUrl, request, Void.class);
                }
                log.debug("Register Facial Writer completed");
            }
        }
        log.debug("AgentBMS Created Successfully;");
        return agentBMS;
    }

    private BioTemplate saveFacialDB(AgentSite agentSite) {

        // RestTemplate restTemplate = new RestTemplate();
        log.info("inside FillBagItemWriter");
        HttpHeaders headers = new HttpHeaders();
        String token = "";
        if (tokenManager != null) {
            token = tokenManager.getAccessToken();
        }
        headers.set("Accept", "application/json");
        // log.info("Bearer token" + token);
        headers.add(AUTHORIZATION, "Bearer " + token);

        log.info("insert BMSFacial");

        List<CompBiometrics> biometrics = agentSite.getBiometrics();
        Iterator<CompBiometrics> itrCompBiometrics = biometrics.iterator();
        BioTemplate bioTemplate = new BioTemplate();

        while (itrCompBiometrics.hasNext()) {
            CompBiometrics compBiometrics = itrCompBiometrics.next();
            if (BiometricType.FACE.equals(compBiometrics.getBiometricType())) {
                bioTemplate.setBioUuid(
                        (bioTemplate.getBioUuid() == null
                                ? UUID.randomUUID().toString()
                                : bioTemplate.getBioUuid()));
                bioTemplate.addBiometricsItem(compBiometrics);
                bioTemplate.setPersonId(agentSite.getPersonId());
                HttpEntity<String> request =
                        new HttpEntity<String>(bioTemplate.toString(), headers);
                ResponseEntity<Void> response = null;
                if (Arrays.asList(environment.getActiveProfiles()).contains("test")
                        || (Arrays.asList(environment.getActiveProfiles()).contains("local"))) {
                    String baseUrl =
                            AppConstants.WIREMOCK_URL + "/biofacial/" + agentSite.getSource();
                    try {
                        log.debug("Calling registerBMSFacial service through wiremock");
                        response = restTemplate.postForEntity(baseUrl, request, Void.class);

                        log.debug("Response from registerBMSFacial from WIREMOCK " + response);
                    } catch (Exception e) {
                        log.error("Cant find server" + e);
                    }

                } else {
                    String baseUrl = BIOFACE_URL + agentSite.getSource();
                    response = restTemplate.postForEntity(baseUrl, request, Void.class);
                }
                log.debug("Register BIOFacial Writer completed");
            }
        }

        log.info("BioFace Successfully added");
        return bioTemplate;
    }

    private AgentBMS registerBMSIris(AgentSite agentSite) {

        // RestTemplate restTemplate = new RestTemplate();
        log.info("inside registerBMSIris");
        HttpHeaders headers = new HttpHeaders();
        String token = "";
        if (tokenManager != null) {
            token = tokenManager.getAccessToken();
        }
        headers.set("Accept", "application/json");
        // log.info("Bearer token" + token);
        headers.add(AUTHORIZATION, "Bearer " + token);

        log.info("insert BMSFacial");
        List<CompBiometrics> biometrics = agentSite.getBiometrics();
        AgentBMS agentBMS = new AgentBMS();
        Iterator<CompBiometrics> itrCompBiometrics = biometrics.iterator();
        while (itrCompBiometrics.hasNext()) {
            BioTemplate bioTemplate = new BioTemplate();
            CompBiometrics compBiometrics = itrCompBiometrics.next();
            if (BiometricType.IRIS.equals(compBiometrics.getBiometricType())) {
                bioTemplate.setBioUuid(
                        (bioTemplate.getBioUuid() == null
                                ? UUID.randomUUID().toString()
                                : bioTemplate.getBioUuid()));
                bioTemplate.addBiometricsItem(compBiometrics);
                agentBMS.addBiometricsItem(bioTemplate);
                HttpEntity<String> request = new HttpEntity<String>(agentBMS.toString(), headers);

                ResponseEntity<Void> response = null;
                if (Arrays.asList(environment.getActiveProfiles()).contains("test")
                        || (Arrays.asList(environment.getActiveProfiles()).contains("local"))) {
                    String baseUrl =
                            AppConstants.WIREMOCK_URL + "/bmsagent/" + agentSite.getSource();
                    try {
                        log.debug("Calling BMSFacial service through wiremock");
                        response = restTemplate.postForEntity(baseUrl, request, Void.class);

                        log.debug("Response from BMSFacial from WIREMOCK " + response);
                    } catch (Exception e) {
                        log.error("Cant find server" + e);
                    }

                } else {
                    String baseUrl = BMSAGENT_URL + agentSite.getSource();
                    restTemplate.postForEntity(baseUrl, request, Void.class);
                }
                log.debug("Register Iris Writer completed");
            }
        }
        log.debug("AgentBMS Iris Created Successfully;");
        return agentBMS;
    }

    private BioTemplate saveIrisDB(AgentSite agentSite) {

        // RestTemplate restTemplate = new RestTemplate();
        log.info("inside saveIrisDB");
        HttpHeaders headers = new HttpHeaders();
        String token = "";
        if (tokenManager != null) {
            token = tokenManager.getAccessToken();
        }
        headers.set("Accept", "application/json");
        // log.info("Bearer token" + token);
        headers.add(AUTHORIZATION, "Bearer " + token);

        log.info("insert BMSIris");

        AgentBMS agentBMS = new AgentBMS();
        agentBMS.setPersonId(agentSite.getPersonId());
        List<CompBiometrics> biometrics = agentSite.getBiometrics();

        Iterator<CompBiometrics> itrCompBiometrics = biometrics.iterator();
        BioTemplate bioTemplate = new BioTemplate();

        while (itrCompBiometrics.hasNext()) {

            CompBiometrics compBiometrics = itrCompBiometrics.next();
            if (BiometricType.IRIS.equals(compBiometrics.getBiometricType())) {
                bioTemplate.setBioUuid(
                        (bioTemplate.getBioUuid() == null
                                ? UUID.randomUUID().toString()
                                : bioTemplate.getBioUuid()));
                bioTemplate.addBiometricsItem(compBiometrics);
                bioTemplate.setPersonId(agentSite.getPersonId());

                HttpEntity<String> request =
                        new HttpEntity<String>(bioTemplate.toString(), headers);
                ResponseEntity<Void> response = null;
                if (Arrays.asList(environment.getActiveProfiles()).contains("test")
                        || (Arrays.asList(environment.getActiveProfiles()).contains("local"))) {
                    String baseUrl =
                            AppConstants.WIREMOCK_URL + "/bioiris/" + agentSite.getSource();
                    try {
                        log.debug("Calling BMSFacial service through wiremock");
                        response = restTemplate.postForEntity(baseUrl, request, Void.class);

                        log.debug("Response from BMSFacial from WIREMOCK " + response);
                    } catch (Exception e) {
                        log.error("Cant find server" + e);
                    }

                } else {
                    String baseUrl = BIOIRIS_URL + agentSite.getSource();
                    restTemplate.postForEntity(baseUrl, request, Void.class);
                }
            }
        }

        log.debug("Register BIOiris Writer completed");

        log.info("BioIris Successfully added");
        return bioTemplate;
    }
}
