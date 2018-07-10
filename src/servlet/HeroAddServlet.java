package servlet;

import bean.Hero;
import dao.HeroDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HeroAddServlet")
public class HeroAddServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Hero hero = new Hero();

        hero.setDamage(Integer.parseInt(request.getParameter("damage")));
        hero.setHp(Float.parseFloat(request.getParameter("hp")));
        hero.setName(request.getParameter("name"));

        new HeroDAO().add(hero);
        response.sendRedirect("/listHero");
    }
}
