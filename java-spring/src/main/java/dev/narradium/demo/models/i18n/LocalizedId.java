package dev.narradium.demo.models.i18n;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalizedId {
    private Long id;
    private String locale;

    public LocalizedId(String locale)
    {
        this.locale = locale;
    }
}
