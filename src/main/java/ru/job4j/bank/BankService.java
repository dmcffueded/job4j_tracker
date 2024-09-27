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
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        if (users.containsKey(findByPassport(passport))
                && !users.get(findByPassport(passport)).contains(account)) {
            users.get(findByPassport(passport)).add(account);
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
        if (users.containsKey(findByPassport(sourcePassport))
                && users.get(findByPassport(sourcePassport)).contains(findByRequisite(sourcePassport, sourceRequisite))
                && users.containsKey(findByPassport(destinationPassport))
                && users.get(findByPassport(destinationPassport)).contains(findByRequisite(destinationPassport, destinationRequisite))
                && findByRequisite(sourcePassport, sourceRequisite).getBalance() >= amount) {
            findByRequisite(destinationPassport, destinationRequisite).setBalance(findByRequisite(destinationPassport, destinationRequisite).getBalance()
                    + amount);
            findByRequisite(sourcePassport, sourceRequisite).setBalance(findByRequisite(sourcePassport, sourceRequisite).getBalance()
                    - amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}