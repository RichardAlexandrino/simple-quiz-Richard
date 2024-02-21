package com.mjv.school.repository;

import com.mjv.school.model.Alternative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlternativeRepository extends JpaRepository<Alternative, Long> {

}
