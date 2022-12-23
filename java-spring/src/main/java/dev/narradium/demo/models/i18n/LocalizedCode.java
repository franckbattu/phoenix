package dev.narradium.demo.models.i18n;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalizedCode {

    private String code;
    private String locale;

    public LocalizedCode(String locale)
    {
        this.locale = locale;
    }
}
