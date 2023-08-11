package com.ofloxacin.aleo;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class PuzzleCommitment {

    private static final String SEPERATOR = "1";

    private static final int CHECKSUM_LENGTH = 6;

    private static final byte[] CHARSET_REV =
            {
                    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                    15, -1, 10, 17, 21, 20, 26, 30, 7, 5, -1, -1, -1, -1, -1, -1, -1, 29, -1, 24, 13, 25, 9, 8, 23,
                    -1, 18, 22, 31, 27, 19, -1, 1, 0, 3, 16, 11, 28, 12, 14, 6, 4, 2, -1, -1, -1, -1, -1, -1, 29,
                    -1, 24, 13, 25, 9, 8, 23, -1, 18, 22, 31, 27, 19, -1, 1, 0, 3, 16, 11, 28, 12, 14, 6, 4, 2, -1,
                    -1, -1, -1, -1
            };

    public static void main(String[] args) {
        Pair<String, byte[]> decode = bech32decord("puzzle1sppa6r2qmn0g6hlh50rwkfz54cxgpxrczpsg3suw8l3wt5j8jnwg82gv4t60lz8z9t58heq5sgdgzf7fl0m");
        System.out.println(decode.getKey());
        System.out.println(Arrays.toString(decode.getValue()));
        byte[] bytes = from_base32(decode.getValue());
        System.out.println(Arrays.toString(bytes));
        System.out.println(toTarget(bytes));
    }

    public static Pair<String, byte[]> bech32decord(String str) {
        int idx = str.indexOf(SEPERATOR);
        String hrd = str.substring(0, idx);
        String dataStr = str.substring(idx + 1);
        byte[] data = new byte[dataStr.length()];
        for (int i = 0; i < dataStr.length(); i++) {
            char c = dataStr.charAt(i);
            data[i] = CHARSET_REV[c];
        }
        return Pair.of(hrd, Arrays.copyOf(data, data.length - CHECKSUM_LENGTH));
    }

    public static String toTarget(byte[] bytes) {
        BigInteger numerator = BigInteger.valueOf(2).pow(64).subtract(BigInteger.valueOf(1));
        byte[] dump = sha256(sha256(bytes));
        BigInteger denominator = new BigInteger(1, new byte[]{dump[7], dump[6], dump[5], dump[4], dump[3], dump[2], dump[1], dump[0]});
        BigInteger result = numerator.divide(denominator);
        return result.toString();
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

    public static byte[] from_base32(byte[] b32) {
        return convert_bits(b32, 5, 8, false);
    }

    private static byte[] convert_bits(byte[] data, int from, int to, boolean pad) {
        if (from > 8 || to > 8 || from == 0 || to == 0) {
            throw new RuntimeException("convertBits `from` and `to` parameters 0 or greater than 8");
        }
        int acc = 0;
        int bits = 0;
        List<Byte> ret = Lists.newArrayList();
        int maxv = (1 << to) - 1;
        for (byte value : data) {
            int v = (int) value;
            if (v >> from != 0) {
                throw new RuntimeException("InvalidData");
            }
            acc = (acc << from) | v;
            bits += from;
            while (bits >= to) {
                bits -= to;
                ret.add((byte) ((acc >> bits) & maxv));
            }
        }
        if (pad) {
            if (bits > 0) {
                ret.add((byte) ((acc << (to - bits)) & maxv));
            }
        } else if (bits >= from || ((acc << (to - bits)) & maxv) != 0) {
            throw new RuntimeException("InvalidPadding");
        }
        byte[] result = new byte[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            result[i] = ret.get(i);
        }
        return result;
    }
}
