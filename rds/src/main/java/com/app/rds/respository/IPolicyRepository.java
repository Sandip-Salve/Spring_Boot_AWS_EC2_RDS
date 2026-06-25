package com.app.rds.respository;

import com.app.rds.entities.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPolicyRepository extends JpaRepository<Policy, Long> {
}
