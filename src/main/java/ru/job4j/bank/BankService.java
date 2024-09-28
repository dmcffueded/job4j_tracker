package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (users.containsKey(user) && !accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            for (Account req : users.get(findByPassport(passport))) {
                if (req.getRequisite().equals(requisite)) {
                    return req;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        User userSource = findByPassport(sourcePassport);
        Account accountsSource = findByRequisite(sourcePassport, sourceRequisite);
        User userDestinstion = findByPassport(destinationPassport);
        Account accountsDestinstion = findByRequisite(destinationPassport, destinationRequisite);
        if (accountsSource != null
                && users.get(userSource).contains(accountsSource)
                && accountsDestinstion != null
                && users.get(userDestinstion).contains(accountsDestinstion)
                && accountsSource.getBalance() >= amount) {
            accountsDestinstion.setBalance(accountsDestinstion.getBalance()
                    + amount);
            accountsSource.setBalance(accountsSource.getBalance()
                    - amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}