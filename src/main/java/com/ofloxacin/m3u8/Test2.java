package com.ofloxacin.m3u8;

import java.io.IOException;

/**
 * @author chenshuai
 * @date 2020/09/13
 */
public class Test2 {

    public static void main(String[] args) throws IOException {
        M3U8FileLoader m3U8FileLoader = new M3U8FileLoader("/Users/chenshuai/Downloads/temp.m3u8",
                "https://vip4.ddyunbo.com", "/Users/chenshuai/Downloads/m3u8/");
        m3U8FileLoader.load();
        m3U8FileLoader.parallelLoad(1);
    }
}
