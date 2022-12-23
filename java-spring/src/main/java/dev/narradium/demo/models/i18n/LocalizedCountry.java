package dev.narradium.demo.models.i18n;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@NoArgsConstructor
@AllArgsConstructor
public class LocalizedCountry {

    @EmbeddedId
    private LocalizedCode localizedCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("code")
    @JoinColumn(name = "code")
    private Country country;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalizedCode getLocalizedCode() {
        return this.localizedCode;
    }

    public void setLocalizedCode(LocalizedCode localizedCode) {
        this.localizedCode = localizedCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
