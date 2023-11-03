package com.Test.praktek.modelTransaction.repository;

import com.Test.praktek.modelTransaction.entity.TopUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopupRepository extends JpaRepository<TopUp, Long> {
}
