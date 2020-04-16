package global.sesoc.brr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * ?¬?©? λ‘κ·Έ?Έ ??Έ ?Έ?°??°. HandlerInterceptorAdapterλ₯? ??λ°μ? ? ?.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	// μ½νΈλ‘€λ¬? λ©μ? ?€? ? ? μ²λ¦¬
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.debug("LoginInterceptor ?€?");

		// ?Έ?? λ‘κ·Έ?Έ ? λ³? ?½κΈ?
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		// λ‘κ·Έ?Έ?μ§? ??? κ²½μ° λ‘κ·Έ?Έ ??΄μ§?λ‘? ?΄?
		if (id == null) {
			// request.getContextPath()λ‘? λ£¨νΈ κ²½λ‘λ₯? κ΅¬ν?¬ ? ?? κ²½λ‘λ‘? μ²λ¦¬
			response.sendRedirect(request.getContextPath() + "/member/login");
			return false;
		}
		// λ‘κ·Έ?Έ ? κ²½μ° ?μ²?? κ²½λ‘λ‘? μ§ν
		return super.preHandle(request, response, handler);
	}

}
