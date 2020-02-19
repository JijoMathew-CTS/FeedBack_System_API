package com.fms.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vol_event_attended")
public class VolunteerAttended extends EventInformationEntity{

	private static final long serialVersionUID = 1L;
}