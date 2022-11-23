package com.naijagis4me.v1.repositories;

import com.naijagis4me.v1.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
