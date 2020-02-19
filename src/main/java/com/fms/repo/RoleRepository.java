package com.fms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fms.entity.UserRole;

public interface RoleRepository extends CrudRepository<UserRole, String> {
	public Optional<UserRole> findByAssociateId(String id);

	@Override
	@Query
	default <S extends UserRole> Iterable<S> saveAll(Iterable<S> list) {
		list.forEach(ele -> {
			if (!findById(ele.getAssociateId()).isPresent()) {
				save(ele);
			}
		});
		return null;
	}
}
