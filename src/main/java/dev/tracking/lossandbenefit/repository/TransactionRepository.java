package dev.tracking.lossandbenefit.repository;

import dev.tracking.lossandbenefit.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {
    List<TransactionEntity> findByUserId(Long UserId);
    List<TransactionEntity> findByUserIdAndDateBetween(Long userId, LocalDateTime startDate, LocalDateTime endDate);
}