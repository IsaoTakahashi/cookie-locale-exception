package itaka.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by isao.takahashi on 2017/01/24.
 */
@Controller
@Slf4j
public class DemoController {

    @GetMapping("index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        Locale locale = LocaleContextHolder.getLocale();
        log.info("locale : {}", locale);

        // set resolved locale into cookie
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        localeResolver.setLocale(request, response, locale);
        return "index";
    }

    /**
     * sample endpoint to confirm {@link itaka.demo.ErrorHandler} works
     */
    @GetMapping("exception")
    public String throwException() {
        throw new RuntimeException("error!");
    }
}
