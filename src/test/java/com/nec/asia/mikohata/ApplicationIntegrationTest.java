package com.abc.asia.mikohata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.abc.asia.mikohata.common.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ApplicationIntegrationTest extends AbstractIntegrationTest {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    void encryptDecryptContextTest() throws Exception {
        //        String testString = "Hello World";
        //        EnvCrypto envCrypto = new EnvCrypto();
        //        envCrypto.setEncryptIn(testString);
        //        logger.info("encryptDecryptContextTest: encrypt: " + envCrypto.getEncryptIn());
        //        MvcResult result =
        //                mockMvc.perform(
        //                                MockMvcRequestBuilders.post("/env/crypto/encrypt")
        //                                        .content(toJsonString(envCrypto))
        //                                        .contentType(MediaType.APPLICATION_JSON)
        //                                        .accept(MediaType.APPLICATION_JSON))
        //
        // .andExpect(MockMvcResultMatchers.jsonPath("$.encrypt_out").isNotEmpty())
        //                        .andReturn();
        //
        //        String input = result.getResponse().getContentAsString();
        //        envCrypto = (EnvCrypto) fromJsonString(input, envCrypto);
        //        logger.info("encryptDecryptContextTest: decrypt: " + envCrypto.getEncryptOut());
        //        envCrypto.setDecryptIn(envCrypto.getEncryptOut());
        //        envCrypto.setEncryptOut(null);
        //        result =
        //                mockMvc.perform(
        //                                MockMvcRequestBuilders.post("/env/crypto/decrypt")
        //                                        .content(toJsonString(envCrypto))
        //                                        .contentType(MediaType.APPLICATION_JSON)
        //                                        .accept(MediaType.APPLICATION_JSON))
        //
        // .andExpect(MockMvcResultMatchers.jsonPath("$.decrypt_out").isNotEmpty())
        //                        .andReturn();
        //
        //        input = result.getResponse().getContentAsString();
        //        envCrypto = (EnvCrypto) fromJsonString(input, envCrypto);
        //        assert (testString.equals(envCrypto.getDecryptOut()));
    }

    @Test
    void hashVerifyContextTest() throws Exception {
        //        String testString = "Hello World";
        //        EnvCrypto envCrypto = new EnvCrypto();
        //        envCrypto.setHashIn(testString);
        //        logger.info("hashVerifyContextTest: hash: " + envCrypto.getHashIn());
        //        MvcResult result =
        //                mockMvc.perform(
        //                                MockMvcRequestBuilders.post("/env/crypto/hash")
        //                                        .content(toJsonString(envCrypto))
        //                                        .contentType(MediaType.APPLICATION_JSON)
        //                                        .accept(MediaType.APPLICATION_JSON))
        //
        // .andExpect(MockMvcResultMatchers.jsonPath("$.hash_out").isNotEmpty())
        //                        .andReturn();
        //
        //        String input = result.getResponse().getContentAsString();
        //        envCrypto = (EnvCrypto) fromJsonString(input, envCrypto);
        //        logger.info("hashVerifyContextTest: verify: " + envCrypto.getHashOut());
        //        envCrypto.setVerifyIn(testString + "@" + envCrypto.getHashOut());
        //        envCrypto.setHashOut(null);
        //        result =
        //                mockMvc.perform(
        //                                MockMvcRequestBuilders.post("/env/crypto/verify")
        //                                        .content(toJsonString(envCrypto))
        //                                        .contentType(MediaType.APPLICATION_JSON)
        //                                        .accept(MediaType.APPLICATION_JSON))
        //
        // .andExpect(MockMvcResultMatchers.jsonPath("$.verify_out").isNotEmpty())
        //                        .andReturn();
        //
        //        input = result.getResponse().getContentAsString();
        //        envCrypto = (EnvCrypto) fromJsonString(input, envCrypto);
        //        assert ("true".equals(envCrypto.getVerifyOut()));
    }

    public String toJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object fromJsonString(String str, Object obj) {
        try {
            return new ObjectMapper().readValue(str, obj.getClass());
        } catch (JsonProcessingException e) {
            logger.error("Unable to convert JSON string to Object");
            return null;
        }
    }
}
