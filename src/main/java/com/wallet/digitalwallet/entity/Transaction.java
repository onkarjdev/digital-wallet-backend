package com.wallet.digitalwallet.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long senderWalletId;

    private Long receiverWalletId;

    private Double amount;

    private String status;

    private String transactionType;

    private LocalDateTime timestamp;

    private String remarks;
}