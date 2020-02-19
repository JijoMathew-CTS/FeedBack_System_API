package com.fms.entity;

import java.util.Date;

public interface EventDetails {
	
	public String  getMonth();
	public String  getBase_location();
	public String  getBeneficiary_name();
	public String   getVenue_address();
	public String  getCouncil_name();
	public String getProject();
	public String getCatagory();
	public String getEvent_name();
	public String getEvent_description();
	public Date getEvent_date();
	public Integer getTotal_vol_no();
	public Integer getTotal_vol_hrs();
	public Integer getTotal_travel_hrs();
	public Integer getOverall_vol_hrs();
	public Integer getLives_impact();
	public String getActivity_type();
	public String getStatus();
	public Integer getPoc_contact();
	public String getEvent_Id();
	public String getPoc_Id();
	public String getPoc_Name();
}
