package com.fms.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fms.entity.EventPK;
import com.fms.entity.VolunteerAttendedEntity;

@Repository
public interface VolunteerAttendedRepo extends CrudRepository<VolunteerAttendedEntity, EventPK> {

	public Optional<VolunteerAttendedEntity> findByEventPK(EventPK eventPK);
	
	public List<VolunteerAttendedEntity> findByEmailStatus(String emailStatus);

	@Override
	default <S extends VolunteerAttendedEntity> Iterable<S> saveAll(Iterable<S> list) {
		list.forEach(ele -> {
			if (!findByEventPK(ele.getEventPK()).isPresent()) {
				save(ele);
			}
		});
		return null;
	}

	@Query(value="SELECT distinct employee_id FROM outreachfeedbackdb.vol_event_attended", nativeQuery=true)
	public List<String> findDistinctAttended();
	
	@Query(value="SELECT distinct employee_id FROM outreachfeedbackdb.vol_event_attended where event_id in :eventList", nativeQuery=true)
	public List<String> findDistinctAttendedByEvents(List<String> eventList);

}
