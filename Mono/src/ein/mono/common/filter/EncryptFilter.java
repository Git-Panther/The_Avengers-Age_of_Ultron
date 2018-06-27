package ein.mono.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import ein.mono.common.wrapper.EncryptWrapper;

@WebFilter("*.au")
public class EncryptFilter implements Filter {
    public EncryptFilter() {
    }
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest originRequest = (HttpServletRequest) request;
		// 암호화하기 전 원본 비밀번호 저장
		request.setAttribute("originPwd", originRequest.getParameter("userPwd"));
		EncryptWrapper ew = new EncryptWrapper(originRequest);
		
		chain.doFilter(ew, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
