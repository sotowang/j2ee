package servlet;

import bean.Hero;
import net.sf.json.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetManyServlet")
public class GetManyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            Hero hero = new Hero();
            hero.setName("name"+i);
            hero.setHp(500+i);
            heros.add(hero);
        }

        String result = JSONSerializer.toJSON(heros).toString();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(result);
    }
}
