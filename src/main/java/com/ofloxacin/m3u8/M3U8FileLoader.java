package com.ofloxacin.m3u8;

import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenshuai
 * @date 2021/06/20
 */
public class M3U8FileLoader {

    private String prefix;

    private String dir;

    private String url;

    private List<TsVo> tsVos = Lists.newArrayList();

    public M3U8FileLoader(String url, String prefix, String dir) {
        this.url = url;
        this.prefix = prefix;
        this.dir = dir;
    }

    public void load() throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            if (url.startsWith("http://") || url.startsWith("https://")) {
                IOUtils.copy(new URL(url), outputStream);
            } else {
                IOUtils.copy(new FileInputStream(url), outputStream);
            }
            try (BufferedReader reader = new BufferedReader(new StringReader(outputStream.toString()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("#EXTINF")) {
                        double time = Double.parseDouble(line.substring(8, line.length() - 1));
                        String url = reader.readLine();
                        tsVos.add(new TsVo(time, Paths.get(prefix, url).toString()));
                    }
                }
            }
        }
    }

    public void parallelLoad(int threadSize) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadSize);
        for (int i = 0; i < tsVos.size(); i++) {
            int finalI = i;
            TsVo tsVo = tsVos.get(i);
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    File file = new File(dir, finalI + ".ts");
                    try {
                        Thread.sleep(1000);
                        if (!file.exists() && file.createNewFile()) {
                            IOUtils.copy(new URL(tsVo.getUrl()), file);
                            System.out.println("success. file=" + file.getAbsolutePath());
                        }
                    } catch (Exception e) {
                        if (file.exists()) {
                            file.delete();
                        }
                        System.out.println("fail. file=" + file.getAbsolutePath());
                    }
                }
            });
        }
    }
}
