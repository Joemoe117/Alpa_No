package manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.PanelDao;

/**
 * Manager for simulations
 * 
 * @author baptiste
 *
 */
@ManagedBean
@SessionScoped
public class ManagerSimulation {

	/**
	 * input for begin date
	 */
	private String inputDateBegin;

	/**
	 * input for end date
	 */
	private String inputDateEnd;

	/**
	 * Default constructor
	 */
	public ManagerSimulation() {

	}

	/**
	 * Load panels matching the period given in form
	 */
	public void loadPanelsForPeriod() {

		try {
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.FRANCE);
			Date dateBegin = sdf.parse("2010-02-23 16:00:00");
			Date dateEnd = sdf.parse("2020-02-23 18:00:00");
			
			boolean isOk = checkDates(dateBegin, dateEnd);
			
			if (isOk) {
				PanelDao.searchForPeriod(dateBegin, dateEnd);
			}
			
		} catch (ParseException e) {
			System.out.println("Impossible de parser les dates dans un bon format");
		}
		
		
	}
	
	
	/**
	 * Check if the dates are correct
	 * @param begin
	 * 		begin date
	 * @param end
	 * 		end date
	 * @return
	 * 		true if the dates are correct
	 * 		false otherwise
	 */
	private boolean checkDates(Date begin, Date end){
		
		boolean res = true;
		
		if (begin.after(end)){
			res = false;
		}
		
		if (begin.equals(end)){
			res = false;
		}
		
		return res;
	}

	public String getInputDateBegin() {
		return inputDateBegin;
	}

	public void setInputDateBegin(String inputDateBegin) {
		this.inputDateBegin = inputDateBegin;
	}

	public String getInputDateEnd() {
		return inputDateEnd;
	}

	public void setInputDateEnd(String inputDateEnd) {
		this.inputDateEnd = inputDateEnd;
	}
	
	
}
