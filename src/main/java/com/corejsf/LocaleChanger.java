package com.corejsf;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named
@SessionScoped
public class LocaleChanger implements Serializable {

	private static final long serialVersionUID = 1L;

	public void changeLocale(ActionEvent event) {
		UIComponent component = event.getComponent();
		String languageCode = getLanguageCode(component);

		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(languageCode));
	}
	
	private String getLanguageCode(UIComponent component) {
		Map<String, Object> attrs = component.getAttributes();
		
		return (String)attrs.get("languageCode");
	}
	
}
