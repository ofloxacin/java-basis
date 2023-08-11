package com.ofloxacin.aleo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class AleoTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Object[] result = Bech32.bech32ToSegwit("puzzle1sppa6r2qmn0g6hlh50rwkfz54cxgpxrczpsg3suw8l3wt5j8jnwg82gv4t60lz8z9t58heq5sgdgzf7fl0m");
        System.out.println(Arrays.toString(result));
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
