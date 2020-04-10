package com.inter.desafioInter.Facades;

import com.inter.desafioInter.dto.UserDTO;
import java.security.PublicKey;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SecurityFacade {

    private PublicKey publicKey;

    public UserDTO encryptUserData(UserDTO userDto) throws Exception{
        String encodedUsername = encrypt(userDto.getUsername());
        userDto.setUsername(encodedUsername);

        String encodedEmail = encrypt(userDto.getEmail());
        userDto.setEmail(encodedEmail);

        return userDto;
    }

    public String encrypt(String plainText) throws Exception {
        if(publicKey == null){
            throw new Exception("Public key not found");
        }
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] cipherText = encryptCipher.doFinal(plainText.getBytes(UTF_8));

        return Base64.getEncoder().encodeToString(cipherText);
    }

    /**
     * Generates a PublicKey instance from a string containing the Base64-encoded public key.
     * @param encodedPublicKey Base64-encoded public key
     * @throws IllegalArgumentException if encodedPublicKey is invalid
     */
    public void generatePublicKey(String encodedPublicKey) throws Exception{
        try {
            byte[] decodedKey = Base64.getDecoder().decode(encodedPublicKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(decodedKey));
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }
}
