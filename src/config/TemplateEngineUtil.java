package config;

import org.thymeleaf.TemplateEngine;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

/**
 * @author yyh
 * @date 2019/7/23-16:13
 */
@WebListener
public class TemplateEngineUtil {
    private static final String TEMPLATE_ENGINE_ATTR = "com.e-learn.thymeleaf3.TemplateEngineInstance";

    public static void storeTemplateEngine(ServletContext context, TemplateEngine engine) {
        context.setAttribute("e-learn", engine);
    }

    public static TemplateEngine getTemplateEngine(ServletContext context) {
        return (TemplateEngine) context.getAttribute(TEMPLATE_ENGINE_ATTR);
    }
}
