package dev.tracking.lossandbenefit.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private List<TransactionDto> transactions;
}