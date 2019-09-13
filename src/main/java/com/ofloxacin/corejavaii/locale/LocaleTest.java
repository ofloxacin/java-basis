package com.ofloxacin.corejavaii.locale;

import java.text.CollationKey;
import java.text.Collator;

/**
 * @author chenshuai
 * @date 2018/12/09
 */
public class LocaleTest {

    public static void main(String[] args) {
        String a = "nihao";
        Collator collator = Collator.getInstance();
        CollationKey aKey = collator.getCollationKey(a);
        String b = "nihao";
        System.out.println(aKey.compareTo(collator.getCollationKey(b)));
    }
}
