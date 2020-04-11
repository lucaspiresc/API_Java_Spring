package com.inter.desafiointer.facades;

import com.inter.desafiointer.dto.UserDTO;
import java.security.PublicKey;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SecurityFacade implements ISecurityFacade {

	private static final String RSA = "RSA";

	private PublicKey publicKey;

	public UserDTO encryptUserData(UserDTO userDto) {
		String encodedUsername = encrypt(userDto.getUsername());
		userDto.setUsername(encodedUsername);

		String encodedEmail = encrypt(userDto.getEmail());
		userDto.setEmail(encodedEmail);

		return userDto;
	}

	public String encrypt(String plainText) {
		try {
			if (publicKey == null) {
				throw new SecurityException();
			}
			Cipher encryptCipher = Cipher.getInstance(RSA);
			encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

			byte[] cipherText = encryptCipher.doFinal(plainText.getBytes(UTF_8));

			return Base64.getEncoder().encodeToString(cipherText);
		} catch(Exception ex) {
			throw new SecurityException(ex);
		}
	}

	public void generatePublicKey(String encodedPublicKey) {
		try {
			byte[] decodedKey = Base64.getDecoder().decode(encodedPublicKey);
			KeyFactory keyFactory = KeyFactory.getInstance(RSA);
			publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(decodedKey));
		} catch (Exception e) {
			throw new SecurityException(e);
		}
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
	}
}
