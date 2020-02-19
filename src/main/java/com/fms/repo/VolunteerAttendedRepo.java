package com.fms.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fms.entity.EventPK;
import com.fms.entity.VolunteerAttended;

public interface VolunteerAttendedRepo extends CrudRepository<VolunteerAttended, EventPK> {

	public Optional<VolunteerAttended> findByEventPK(EventPK eventPK);
	
	public List<VolunteerAttended> findByEmailStatus(String emailStatus);

	@Override
	@Query
	default <S extends VolunteerAttended> Iterable<S> saveAll(Iterable<S> list) {
		list.forEach(ele -> {
			if (!findByEventPK(ele.getEventPK()).isPresent()) {
				save(ele);
			}
		});
		return null;
	}

	@Query(value="SELECT distinct employee_id FROM fmsdb.vol_event_attended", nativeQuery=true)
	public List<String> findDistinctAttended();

}
