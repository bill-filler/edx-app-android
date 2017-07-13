package org.edx.mobile.model.api;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class TranscriptModel extends HashMap<String, String> {
    public LinkedHashMap<String, String> getLanguageList() {
        LinkedHashMap<String, String> languageArray = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : this.entrySet()) {
            if (entry.getValue() != null) {
                final Locale locale = new Locale(entry.getKey());
                languageArray.put(entry.getKey(), locale.getDisplayLanguage());
            }
        }
        return this.size() == 0 ? null : languageArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TranscriptModel that = (TranscriptModel) o;
        if (size() != that.size()) {
            return false;
        }

        for (Map.Entry<String, String> entry : this.entrySet()) {
            final String value = entry.getValue();
            final String thatValue = that.get(entry.getKey());
            if (value != null ? !value.equals(thatValue) : thatValue != null) {
                return false;
            }
        }
        return true;
    }
}
