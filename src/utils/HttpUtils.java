package utils;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 * usefull functions for redirections,...
 * @author baptiste
 *
 */
public class HttpUtils {

	/**
	 * Redirect the user to the given page
	 * Log an error if this page does not exist.
	 * @param newPage
	 * 		the new page to display
	 */
	public static void redirect(String newPage){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
		try {
			response.sendRedirect(newPage + ".xhtml");
		} catch (IOException e) {
			System.out.println("Impossible d'ouvrir la page " + newPage);
		}
	}
}
