package com.efundzz.verificationservice.util;

import com.efundzz.verificationservice.model.authbridge.AuthbridgeEncryptedRequestDTO;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeEncryptedResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Optional;
import java.util.Random;

public class AesCbcCrypto {

    private static String CIPHER_NAME = "AES/CBC/PKCS5PADDING";
    private static int CIPHER_KEY_LEN = 16; // 128 bits

    public static String encrypt(String key, String iv, String data) {
        try {
            byte[] sha = generateSha512Hash(key.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
// converting byte[] type SHA into Hexadecimal representation string
            for (int i = 0; i < sha.length; i++) {
                sb.append(Integer.toString((sha[i] & 0xff) + 0x100, 16).substring(1));
            }
            String shaKey = sb.substring(0, 16);
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
            SecretKeySpec secretKey = new SecretKeySpec(fixKey(shaKey)
                    .getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance(AesCbcCrypto.CIPHER_NAME);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
            byte[] encryptedData = cipher.doFinal((data.getBytes()));
            String encryptedDataInBase64 = Base64.getEncoder().encodeToString(encryptedData);
            String ivInBase64 = Base64.getEncoder().encodeToString(iv.getBytes("UTF-8"));
            return encryptedDataInBase64 + ":" + ivInBase64;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    private static String fixKey(String key) {
        if (key.length() < AesCbcCrypto.CIPHER_KEY_LEN) {
            int numPad = AesCbcCrypto.CIPHER_KEY_LEN - key.length();
            for (int i = 0; i < numPad; i++) {
                key += "0"; // 0 pad to len 16 bytes
            }
            return key;
        }
        if (key.length() > AesCbcCrypto.CIPHER_KEY_LEN) {
            return key.substring(0, CIPHER_KEY_LEN); // truncate to 16 bytes
        }
        return key;
    }


    public static String decrypt(String key, String data) {
        try {
            byte sha[] = generateSha512Hash(key.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sha.length; i++) {
                sb.append(Integer.toString((sha[i] & 0xff) + 0x100, 16).substring(1));
            }
            String shaKey = sb.substring(0, 16);
            String[] parts = data.split(":");
            IvParameterSpec iv = new IvParameterSpec(Base64.getDecoder()
                    .decode(parts[1]));
            SecretKeySpec secretKey = new SecretKeySpec(
                    shaKey.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance(AesCbcCrypto.CIPHER_NAME);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            byte[] decodedEncryptedData = Base64.getDecoder().decode(parts[0]);
            byte[] original = cipher.doFinal(decodedEncryptedData);
            return new String(original);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String getIV() {
        String ivCHARS = "1234567890";
        StringBuilder iv = new StringBuilder();
        Random rnd = new Random();
        while (iv.length() < 16) { // length of the random string.
            int index = (int) (rnd.nextFloat() * ivCHARS.length());
            iv.append(ivCHARS.charAt(index));
        }
        return iv.toString();
    }

    public static byte[] generateSha512Hash(byte[] data) {
        String algorithm = "SHA-512";
        byte[] hash = null;
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance(algorithm);
            digest.reset();
            hash = digest.digest(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

    public static AuthbridgeEncryptedRequestDTO getEncryptedRequest(Object object) {
        ObjectMapper mapper = new ObjectMapper();

        String requestString = null;
        try {
            requestString = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return AuthbridgeEncryptedRequestDTO.builder()
                .requestData(encrypt(CommonVariables.AUTH_BRIDGE_KEY, AesCbcCrypto.getIV(), requestString)).build();
    }


    public static String decryptResponse(AuthbridgeEncryptedResponseDTO response) {
        return Optional.ofNullable(response).map(AuthbridgeEncryptedResponseDTO::getResponseData)
                .map(res -> AesCbcCrypto.decrypt(CommonVariables.AUTH_BRIDGE_KEY, res)).orElse("");
    }
}
