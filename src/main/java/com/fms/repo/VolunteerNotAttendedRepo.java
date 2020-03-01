package com.fms.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fms.entity.EventPK;
import com.fms.entity.VolunteerNotAttended;

public interface VolunteerNotAttendedRepo extends CrudRepository<VolunteerNotAttended, EventPK> {
	public Optional<VolunteerNotAttended> findByEventPK(EventPK eventPK);

	@Override
	@Query
	default <S extends VolunteerNotAttended> Iterable<S> saveAll(Iterable<S> list) {
		list.forEach(ele -> {
			if (!findByEventPK(ele.getEventPK()).isPresent()) {
				save(ele);
			}
		});
		return null;
	}

	public List<VolunteerNotAttended> findByEmailStatus(String string);

	@Query(value="SELECT distinct employee_id FROM fmsdb.vol_event_not_attended", nativeQuery=true)
	public List<String> findDistinctNotAttended();

}
