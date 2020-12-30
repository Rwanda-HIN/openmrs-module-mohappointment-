package org.openmrs.module.mohappointment.extension.html;

import java.util.HashMap;
import java.util.Map;
import org.openmrs.module.Extension;
import org.openmrs.module.web.extension.AdministrationSectionExt;

public class AdminList extends AdministrationSectionExt {
	public AdminList() {
	}

	public Extension.MEDIA_TYPE getMediaType() {
		return Extension.MEDIA_TYPE.html;
	}

	public String getTitle() {
		return "mohappointment.title";
	}

	public Map<String, String> getLinks() {
		Map<String, String> map = new HashMap();

		map.put("module/mohappointment/home.htm", "Appointment Home");

		return map;
	}

	public String getRequiredPrivilege() {
		return "View Appointments";
	}
}