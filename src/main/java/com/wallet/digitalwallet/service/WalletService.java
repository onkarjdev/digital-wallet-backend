package com.wallet.digitalwallet.service;

import com.wallet.digitalwallet.entity.User;
import com.wallet.digitalwallet.entity.Wallet;
import com.wallet.digitalwallet.repository.UserRepository;
import com.wallet.digitalwallet.repository.WalletRepository;
import com.wallet.digitalwallet.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
public class WalletService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Transactional
    public User registerUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        User savedUser = userRepository.save(user);

        Wallet wallet = new Wallet();
        wallet.setUser(savedUser);
        wallet.setBalance(0.0);
        walletRepository.save(wallet);

        return savedUser;
    }

    @Transactional
    public String addMoney(Long userId, Double amount) {
        Wallet wallet = walletRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found for User ID: " + userId));

        wallet.setBalance(wallet.getBalance() + amount);
        walletRepository.save(wallet);

        return "Successfully added " + amount + ". New Balance: " + wallet.getBalance();
    }

    @Transactional
    public String transferFunds(Long senderId, Long receiverId, Double amount) {
        Wallet senderWallet = walletRepository.findByUserId(senderId)
                .orElseThrow(() -> new RuntimeException("Sender wallet not found"));

        Wallet receiverWallet = walletRepository.findByUserId(receiverId)
                .orElseThrow(() -> new RuntimeException("Receiver wallet not found"));

        if (senderWallet.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }

        senderWallet.setBalance(senderWallet.getBalance() - amount);
        receiverWallet.setBalance(receiverWallet.getBalance() + amount);

        walletRepository.save(senderWallet);
        walletRepository.save(receiverWallet);

        return "Transfer Successful";
    }
}