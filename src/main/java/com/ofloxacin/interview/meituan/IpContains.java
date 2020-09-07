package com.ofloxacin.interview.meituan;

/**
 * @author chenshuai
 * @date 2020/09/07
 */
public class IpContains {

    public static void main(String[] args) {
        System.out.println(ip2long("125.213.100.123"));
        System.out.println(long2ip(2111136891));
    }

    public static boolean valid(String start, String end, String ip) {
        long startL = ip2long(start);
        long endL = ip2long(end);
        long ipL = ip2long(ip);
        return startL <= ipL && ipL <= endL;
    }

    public static long ip2long(String ip) {
        long[] ips = new long[4];
        int j = 0, k = 0;
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == '.') {
                ips[k++] = Long.parseLong(ip.substring(j, i));
                j = i + 1;
            }
        }
        ips[k] = Long.parseLong(ip.substring(j));
        return (ips[0] << 24) + (ips[1] << 16) + (ips[2] << 8) + ips[3];
    }

    public static String long2ip(long ip) {
        StringBuilder sb = new StringBuilder();
        sb.append(ip >> 24);
        sb.append('.');
        sb.append((ip & 0x00FFFFFF) >> 16);
        sb.append('.');
        sb.append((ip & 0x0000FFFF) >> 8);
        sb.append('.');
        sb.append((ip & 0x000000FF));
        return sb.toString();
    }
}
