package servlet;

import config.TemplateEngineUtil;
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
 * @date 2019/7/25-14:30
 */
@WebServlet("/logre")
public class logreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //得到模板引擎
        TemplateEngine engine= TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context=new WebContext(request,response,request.getServletContext());
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String s = request.getParameter("s");
        if(s==null){
            engine.process("index.html", context, response.getWriter());
        }else if ("1".equals(s)) {
            engine.process("login.html", context, response.getWriter());
        } else if ("2".equals(s)) {
            engine.process("register.html", context, response.getWriter());
        }else{
           engine.process("index.html",context,response.getWriter());
        }

    }
}
