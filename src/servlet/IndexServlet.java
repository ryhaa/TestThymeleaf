package servlet;

import config.ThymeleafConfig;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yyh
 * @date 2019/7/23-15:53
 */
@WebServlet("/")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateEngine engine = ThymeleafConfig.TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        //WebExpressionContext context = new WebExpressionContext(engine.getConfiguration(),request, response, request.getServletContext());
        WebContext context=new WebContext(request, response, request.getServletContext());
        response.setCharacterEncoding("utf-8");
        context.setVariable("recipient", "e-learn");
        //request.setAttribute("username","admin");
        engine.process("index.html", context, response.getWriter());
    }
}
