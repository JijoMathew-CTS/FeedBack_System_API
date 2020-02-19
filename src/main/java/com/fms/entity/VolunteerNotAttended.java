package com.fms.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vol_event_not_attended")
public class VolunteerNotAttended extends EventInformationEntity {

	private static final long serialVersionUID = 1L;

}
