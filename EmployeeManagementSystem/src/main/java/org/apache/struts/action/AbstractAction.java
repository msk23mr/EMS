package org.apache.struts.action;

import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAction extends ActionSupport implements
		SessionAware, ServletRequestAware, ServletResponseAware {

	private HttpServletResponse response;
	private HttpServletRequest request;
	private Map<String, Object> session;

	private Cookie cookies[];
	public static final String AUTH = "auth";

	protected boolean checkLogin() {

		if (!Objects.equals(session.get("AuthId"), null)) {

			cookies = request.getCookies();

			for (int i = 0; i < cookies.length; i++) {

				if (Objects.equals(cookies[i].getName(), "AuthId")) {

					if (Objects.equals(session.get("AuthId"),
							cookies[i].getValue())) {
						return true;
					}
				}
			}
		}

		return false;
	}

	protected void addAuthId() {
		String authId = "1234";
		response.addCookie(new Cookie("AuthId", authId));
		session.put("AuthId", authId);
	}

	protected void removeAuthId() {
		session.remove("AuthId");
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
