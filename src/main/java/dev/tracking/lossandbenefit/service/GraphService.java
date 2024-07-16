package dev.tracking.lossandbenefit.service;

import dev.tracking.lossandbenefit.dto.TransactionDto;
import dev.tracking.lossandbenefit.entity.TransactionEntity;
import dev.tracking.lossandbenefit.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class GraphService {
    @Autowired
    private TransactionRepository transactionRepository;
    public List<TransactionDto> getTransactionsForUser(Long userId, LocalDateTime startDate, LocalDateTime endDate) {
        List<TransactionEntity> transactions = transactionRepository.findByUserIdAndDateBetween(userId, startDate, endDate);
        return transactions.stream().map(this::convertDto).collect(Collectors.toList());
    }

    private TransactionDto convertDto(TransactionEntity transactionEntity) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transactionEntity.getId());
        transactionDto.setUserId(transactionEntity.getUser().getId());
        transactionDto.setCategory(transactionEntity.getCategory());
        transactionDto.setAmount(transactionEntity.getAmount());
        transactionDto.setDate(transactionEntity.getDate());
        transactionDto.setBenefit(transactionDto.isBenefit());
        return transactionDto;
    }
}
