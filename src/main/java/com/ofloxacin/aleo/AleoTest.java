package com.ofloxacin.aleo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class AleoTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        byte[] bytes = sha256(new byte[]{1});
        System.out.println(Arrays.toString(bytes));
    }

    public static byte[] sha256(byte[] input) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return digest.digest(input);
    }
}
