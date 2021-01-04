package com.learning.java8.base64;

import java.util.Base64;

public class Base64Main {

	public static void main(String [] args) {
		//Base64 Encoding
		String originalInput = "original";
		String encodedString = Base64.getEncoder()
				.encodeToString(originalInput.getBytes());
		System.out.println("Encoded value : "+encodedString);
		
		//Base64 Decoding
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		String decodedString = new String(decodedBytes);
		System.out.println("Decoded value : "+decodedString);
		
		//Base64 URL Encoding
		String originalUrl = "https://www.google.com?param1=java&param2=8";
		String encodedUrl = Base64.getUrlEncoder().encodeToString(originalUrl.getBytes());
		System.out.println("Encoded URL : "+encodedUrl);
		
		//Base64 URL Decoding
		byte[] decodedUrlBytes = Base64.getUrlDecoder().decode(encodedUrl);
		String decodedUrl = new String(decodedUrlBytes);
		System.out.println("Decoded URL : "+decodedUrl);
	}
	
}
