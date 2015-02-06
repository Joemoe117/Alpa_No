package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class PasswordValidator 
 implements Validator {

	@Override
	public void validate(
			FacesContext fc, 
			UIComponent comp, 
			Object ref)
			throws ValidatorException {
		System.out.println("PasswordValidator");
		
		UIInput input = (UIInput)comp.getAttributes().get("ident");
		String ident = (String) input.getValue();
		
		String mdp = ref.toString();
		
		System.out.println("ident = "+ident);
		System.out.println("mdp = "+mdp);
		
		if (ident.equals(mdp)) {
			FacesMessage message = 
				new FacesMessage(
					FacesMessage.SEVERITY_ERROR, 
					"Problème de validation", 
					"L'identifiant et le mot de passe doivent être différents");
			throw new ValidatorException(message);
		}
				
		
		
	}
	

}
