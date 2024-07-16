package dev.tracking.lossandbenefit.service;
import dev.tracking.lossandbenefit.dto.TransactionDto;
import dev.tracking.lossandbenefit.entity.TransactionEntity;
import dev.tracking.lossandbenefit.entity.User;
import dev.tracking.lossandbenefit.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired private TransactionRepository transactionRepository;

    /**
     * @param userId userId
     * @return List<TransactionDto>
     */
    public List<TransactionDto> getTransactionsByUserId(Long userId) {
        List<TransactionEntity> transactions = transactionRepository.findByUserId(userId);
        return transactions.stream().map(this::ConvertToDto).collect(Collectors.toList());
    }

    /**
     * @param transactionEntity
     * @return TransactionDto
     */
    private TransactionDto ConvertToDto(TransactionEntity transactionEntity) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transactionEntity.getId());
        transactionDto.setUserId(transactionEntity.getUser().getId());
        transactionDto.setCategory(transactionEntity.getCategory());
        transactionDto.setAmount(transactionEntity.getAmount());
        transactionDto.setDate(transactionEntity.getDate());
        transactionDto.setBenefit(transactionEntity.isBenefit());
        return transactionDto;
    }

    /**
     * @param transactionDto
     * @return TransactionDto
     */
    public TransactionDto addTransaction(TransactionDto transactionDto) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setId(transactionEntity.getId());
        transactionEntity.setUser(new User(transactionDto.getUserId()));
        transactionEntity.setCategory(transactionDto.getCategory());
        transactionEntity.setAmount(transactionEntity.getAmount());
        transactionEntity.setBenefit(transactionEntity.isBenefit());
        transactionEntity.setDate(transactionDto.getDate());
        return transactionDto;
    }
}
