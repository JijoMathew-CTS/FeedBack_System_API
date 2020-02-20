package com.fms.repo;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fms.entity.EventPK;
import com.fms.entity.VolunteerUnregisteredEntity;

@Repository
public interface VolunteerUnregisteredRepo extends CrudRepository<VolunteerUnregisteredEntity, EventPK> {

	public Optional<VolunteerUnregisteredEntity> findByEventPK(EventPK eventPK);

	@Override
	default <S extends VolunteerUnregisteredEntity> Iterable<S> saveAll(Iterable<S> list) {
		list.forEach(ele -> {
			if (!findByEventPK(ele.getEventPK()).isPresent()) {
				save(ele);
			}
		});
		return null;
	}

	@Query(value = "SELECT distinct employee_id FROM outreachfeedbackdb.vol_event_unregistered", nativeQuery = true)
	public List<String> findDistinctUnRegistered();

}
