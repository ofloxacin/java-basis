package com.ofloxacin.m3u8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenshuai
 * @date 2021/06/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TsVo {

    private Double time;

    private String url;
}
