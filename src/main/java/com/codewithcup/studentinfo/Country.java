package com.codewithcup.studentinfo;

import java.util.Locale;

public class Country {
    public static void main(String[] args) {
        String[] codes = java.util.Locale.getISOLanguages();
        for (String isoCode: codes) {
            Locale locale = new Locale(isoCode);
            System.out.println(isoCode.toUpperCase() + "(\"" + locale.getDisplayLanguage(locale) + "\"),");
        }
    }

}
