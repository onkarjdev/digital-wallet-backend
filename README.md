======= Digital Wallet Backend ======
===> Project Overview
This is a high-performance Fintech Backend Service built using Spring Boot.
Unlike traditional management systems, this project focuses on the core mechanics of digital asset transfers, real-time balance validation, and transaction integrity.
It is designed as a RESTful Microservice, making it ready to integrate with any modern Mobile or Web frontend.

===> Tech Stack
Language: Java 17+
Framework: Spring Boot (Web, Data JPA)
Build Tool: Maven
Database: MySQL / H2 (In-Memory)
API Testing: Postman
Architecture: Layered Enterprise Architecture (Controller-Service-Repository)

===> Key Features
Transaction Atomicity: Ensures that funds are never lost; if a transfer fails, the system rolls back to the previous state.
Double-Entry Validation: Prevents negative balances and ensures that the total money in the system remains constant during Peer-to-Peer (P2P) transfers.
REST API Endpoints: Clean, documented endpoints for creating wallets, checking balances, and executing transfers.
Scalable Design: Built with service-oriented logic, allowing for easy expansion into a full-stack application.

===> Project Structure
Plaintext
com.wallet.digitalwallet
├── controller    # Handles REST API requests and JSON mapping
├── service       # Contains core Fintech business logic (The "Brain")
├── repository    # Manages Database operations via Spring Data JPA
├── entity        # Defines the Database Schema (Wallet, Transaction)
└── dto           # Data Transfer Objects for secure API communication

 ===> How to Run
Clone the repository: ```bash
git clone [ https://github.com/onkarjdev/digital-wallet-backend ]
Build the project: Run mvn clean install in the terminal or refresh the Maven tab in IntelliJ.
Start the server: Locate the @SpringBootApplication class and click Run. The server will start on http://localhost:8080.
Test the API: Use Postman to send a POST request to:
http://localhost:8080/api/wallet/transfer

