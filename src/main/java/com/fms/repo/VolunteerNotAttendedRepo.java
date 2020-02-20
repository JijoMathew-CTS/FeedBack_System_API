package com.fms.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fms.entity.EventPK;
import com.fms.entity.VolunteerNotAttendedEntity;

@Repository
public interface VolunteerNotAttendedRepo extends CrudRepository<VolunteerNotAttendedEntity, EventPK> {
	public Optional<VolunteerNotAttendedEntity> findByEventPK(EventPK eventPK);

	@Override
	default <S extends VolunteerNotAttendedEntity> Iterable<S> saveAll(Iterable<S> list) {
		list.forEach(ele -> {
			if (!findByEventPK(ele.getEventPK()).isPresent()) {
				save(ele);
			}
		});
		return null;
	}

	@Query(value="SELECT distinct employee_id FROM outreachfeedbackdb.vol_event_not_attended", nativeQuery=true)
	public List<String> findDistinctNotAttended();

}
