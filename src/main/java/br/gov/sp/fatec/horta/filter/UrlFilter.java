
package br.gov.sp.fatec.horta.filter;

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

        chain.doFilter(request, response);
    }

    public void destroy() {

    }
    
    private Boolean isPublicUrl(String url) {
        return url.endsWith(".css")
                || url.endsWith(".js")
                || url.endsWith(".png")
                || url.endsWith("/horta/")
                || url.endsWith("/login");
    }
    
}
