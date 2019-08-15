package config;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author yyh
 * @date 2019/7/23-15:51
 */
@WebListener
public class ThymeleafConfig implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        TemplateEngine engine = templateEngine(sce.getServletContext());
        TemplateEngineUtil.storeTemplateEngine(sce.getServletContext(), engine);
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

    private TemplateEngine templateEngine(ServletContext servletContext) {
        TemplateEngine engine = new TemplateEngine();

        engine.setTemplateResolver(templateResolver(servletContext));
        return engine;
    }

    private ITemplateResolver templateResolver(ServletContext servletContext) {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(servletContext);
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }

    /**
     * @author yyh
     * @date 2019/7/23-15:48
     * Store and retrieves Thymeleaf TemplateEngine into the application servlet context.
     */
    @WebListener
    public static class TemplateEngineUtil {
        private static final String TEMPLATE_ENGINE_ATTR = "com.e-learn.thymeleaf3.TemplateEngineInstance";

        public static void storeTemplateEngine(ServletContext context, TemplateEngine engine) {
            context.setAttribute(TEMPLATE_ENGINE_ATTR, engine);
        }

        public static TemplateEngine getTemplateEngine(ServletContext context) {
            return (TemplateEngine) context.getAttribute(TEMPLATE_ENGINE_ATTR);
        }

    }
}
