package dev.narradium.demo.models.i18n;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    private String isocode;

    @Transient
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKey(name = "localizedCode.locale")
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
    private Map<String, LocalizedCountry> localizations = new HashMap<>();

    public String getName(String locale)
    {
        return this.localizations.get(locale).getName();
    }

    public void setName(String locale, String name)
    {
        if (this.localizations.containsKey(locale)) {
            this.localizations.get(locale).setName(name);
        }
    }
}
