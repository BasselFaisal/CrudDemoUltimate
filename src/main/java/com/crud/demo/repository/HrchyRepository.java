package com.crud.demo.repository;

import com.crud.demo.model.hrchy.Hrchy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HrchyRepository extends JpaRepository<Hrchy, Integer> {
}
