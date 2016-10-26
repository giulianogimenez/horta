
package br.gov.sp.fatec.horta.filter;

import br.gov.sp.fatec.horta.util.UsuarioSession;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author giuliano.gimenez
 */
@WebFilter("/*")
public class UrlFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();

        if (isPublicUrl(uri)) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = request.getSession();
        UsuarioSession usuarioSession = new UsuarioSession();
        if (session.getAttribute("usuarioSession") != null) {
            usuarioSession = (UsuarioSession) session.getAttribute("usuarioSession");
        }

        if (usuarioSession == null || usuarioSession.getId() == null) {
            response.sendRedirect("/horta/login");
            return;
        } 
    }

    public void destroy() {

    }
    
    private Boolean isPublicUrl(String url) {
        return url.endsWith(".css")
                || url.endsWith(".js")
                || url.endsWith(".png")
                || url.endsWith(".jpg")
                || url.endsWith("/horta/")
                || url.endsWith("/horta")
                || url.endsWith("/login");
    }
    
}
