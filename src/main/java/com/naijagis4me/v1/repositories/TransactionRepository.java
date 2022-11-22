package com.naijagis4me.v1.repositories;

import com.naijagis4me.v1.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
