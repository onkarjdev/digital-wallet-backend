package com.wallet.digitalwallet.controller;

import com.wallet.digitalwallet.entity.User;
import com.wallet.digitalwallet.entity.Wallet;
import com.wallet.digitalwallet.repository.UserRepository;
import com.wallet.digitalwallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletRepository walletRepository;

    @GetMapping("/test")
    public String test() {
        return "Digital Wallet API is working!";
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {

        User savedUser = userRepository.save(user);

        Wallet wallet = new Wallet();
        wallet.setUser(savedUser);
        wallet.setBalance(0.0);

        walletRepository.save(wallet);

        return savedUser;
    }
}