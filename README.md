# Bank application - Live Demo version

> This is a live demo version of the bank application. 
> It is a simple application that allows you to log in with an IBAN and pincode.
> And also allows you to transfer money to other accounts, show your balance and transaction history.
> 
> Created By Yannick Van Ham en Nick Bauters
> 
> Prerequisites:   
> Knowledge of Basic Java up until Exception handling and Arrays.   
> Usage of Git and GitHub
> 
> Technology
> - Java 21
> - IntelliJ IDEA
> - Git and GitHub
> - In memory Cached data (No Database)

## Installation
This app uses Java 21.   
For Mac and linux, it can be installed by using JDKMan.   
For Windows, it can be installed by using Chocolatey.   

## UseCases
- [X] Have a login system in place that lets you log in with IBAN and Pincode.
  - [X] An existing IBAN needs to be used.
  - [X] The pincode needs to be correct.
  - [X] A pincode can only be entered wrong three times. After that the account locks
- [X] Have a menu system in place that lets you choose between the following options:
  - [X] Transfer money
  - [X] Show transaction history
  - [X] Log out
- [X] Be able to transfer money to another account
  - [X] The recipient IBAN needs to be correct
  - [X] The amount needs to be a positive number
  - [X] The amount needs to be available on the account
- [X] Be able to show the balance of the account
- [X] Be able to show the transaction history of the account
  - [X] Show all incoming transactions
  - [X] Show all outgoing transactions
- [X] Be able to log out of the account
- [ ] OPTIONAL features
  - [ ] Have a menu system in place that lets you choose between the following options:
    - [ ] Withdraw money
    - [ ] Deposit money
  - [ ] Have fine-grained transaction history options
    - [ ] Show a sorted list of all transactions made with an account
    - [ ] Show a sorted list of all transactions between two dates