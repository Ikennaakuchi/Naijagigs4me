package com.naijagis4me.v1.repositories;

import com.naijagis4me.v1.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
