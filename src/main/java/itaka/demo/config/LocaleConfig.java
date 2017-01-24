package itaka.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

/**
 * Created by isao.takahashi on 2017/01/24.
 */
@Configuration
public class LocaleConfig {
    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver r = new CookieLocaleResolver();
        r.setCookieName("locale");
        return r;
    }
}
