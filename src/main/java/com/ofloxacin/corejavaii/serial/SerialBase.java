package com.ofloxacin.corejavaii.serial;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author chens
 * @date 2018/11/27 12:49
 */
@Getter
@Setter
public class SerialBase implements Serializable {
    private static final long serialVersionUID = -7078416769668318459L;
    protected Integer a;
}
