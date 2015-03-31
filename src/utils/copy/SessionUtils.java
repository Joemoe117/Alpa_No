package utils.copy;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Easier access to Session
 * 
 * @author baptiste
 *
 */
public class SessionUtils {

	/**
	 * Return the current session
	 * @return
	 * 		current session
	 */
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	/**
	 * Return the current request
	 * @return
	 * 		current request
	 */
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	/*
	 * public static String getUserName() { HttpSession session = (HttpSession)
	 * FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	 * return session.getAttribute("username").toString(); }
	 * 
	 * public static String getUserId() { HttpSession session = getSession(); if
	 * ( session != null ) return (String) session.getAttribute("userid"); else
	 * return null; }
	 */
}
