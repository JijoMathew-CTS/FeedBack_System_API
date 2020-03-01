package com.fms.repo;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fms.entity.EventPK;
import com.fms.entity.VolunteerUnregistered;

public interface VolunteerUnregisteredRepo extends CrudRepository<VolunteerUnregistered, EventPK> {

	public Optional<VolunteerUnregistered> findByEventPK(EventPK eventPK);

	@Override
	@Query
	default <S extends VolunteerUnregistered> Iterable<S> saveAll(Iterable<S> list) {
		list.forEach(ele -> {
			if (!findByEventPK(ele.getEventPK()).isPresent()) {
				save(ele);
			}
		});
		return null;
	}

	public List<VolunteerUnregistered> findByEmailStatus(String string);

	@Query(value = "SELECT distinct employee_id FROM fmsdb.vol_event_unregistered", nativeQuery = true)
	public List<String> findDistinctUnRegistered();

}
