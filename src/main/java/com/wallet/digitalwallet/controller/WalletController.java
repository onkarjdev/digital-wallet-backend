package com.wallet.digitalwallet.controller;

import com.wallet.digitalwallet.entity.User;
import com.wallet.digitalwallet.entity.Wallet;
import com.wallet.digitalwallet.repository.WalletRepository;
import com.wallet.digitalwallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private WalletRepository walletRepository;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return walletService.registerUser(user);
    }

    @PostMapping("/add-money")
    public String addMoney(@RequestParam Long userId, @RequestParam Double amount) {
        return walletService.addMoney(userId, amount);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam Double amount) {
        return walletService.transferFunds(senderId, receiverId, amount);
    }

    @GetMapping("/balance/{userId}")
    public Double getBalance(@PathVariable Long userId) {
        return walletRepository.findByUserId(userId)
                .map(Wallet::getBalance)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}