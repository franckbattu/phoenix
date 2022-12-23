package dev.narradium.demo.config;

import java.util.Locale;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class AppLocaleResolver extends AcceptHeaderLocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        if (lang == null) {
            return Locale.getDefault();
        }
        return StringUtils.parseLocaleString(lang);
    }
}
