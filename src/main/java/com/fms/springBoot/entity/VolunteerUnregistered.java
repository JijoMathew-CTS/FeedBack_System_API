package com.fms.springBoot.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vol_event_unregistered")
public class VolunteerUnregistered extends EventInformationEntity {

	private static final long serialVersionUID = 1L;
	
}