package com.customer.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.customer.exception.EncryptionException;

public class Crypto {

  private static final String SECRET_KEY = "secured-long-secret-key";
  private static final String PADDING = "AES/ECB/PKCS5Padding";

  private Crypto() {}

  private static SecretKeySpec getKey() {

    SecretKeySpec secretKey = null;

    try {
      byte[] key = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
      MessageDigest sha = MessageDigest.getInstance("SHA-1");
      key = sha.digest(key);
      key = Arrays.copyOf(key, 16);
      secretKey = new SecretKeySpec(key, "AES");
    } catch (NoSuchAlgorithmException e) {
      throw new EncryptionException("Error while generating secrect key", e);
    }

    return secretKey;
  }

  public static String encrypt(String strToEncrypt) {
    try {
      Cipher cipher = Cipher.getInstance(PADDING);
      cipher.init(Cipher.ENCRYPT_MODE, getKey());
      return Base64.getEncoder()
          .encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
    } catch (Exception e) {
      throw new EncryptionException("Error while encrypting", e);
    }
  }

  public static String decrypt(String strToDecrypt) {
    try {
      Cipher cipher = Cipher.getInstance(PADDING);
      cipher.init(Cipher.DECRYPT_MODE, getKey());
      return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
    } catch (Exception e) {
      throw new EncryptionException("Error while decrypting", e);
    }
  }
}
