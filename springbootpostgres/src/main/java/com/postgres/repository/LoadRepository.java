
package com.postgres.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgres.entities.Load;

@Repository
public interface LoadRepository extends JpaRepository<Load, Long> {

}
