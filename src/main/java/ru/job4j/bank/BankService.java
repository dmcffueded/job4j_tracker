package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Модель банковского сервиса. Связывает клиента с его банковским счетом
 */

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет клиента
     * @param user клиент банка
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаляет клиента
     * @param passport паспорт
     */

    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод открывает клиенту счет
     * @param passport паспорт
     * @param account банковский счет
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод находит клиента
     * @param passport паспорт
     * @return клиент
     */

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод находит реквизиты
     * @param passport паспорт
     * @param requisite реквизиты
     * @return банковский счет
     */

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

    /**
     * Метод, подтверждающий перевод
     * @param sourcePassport паспорт отправителя
     * @param sourceRequisite реквизиты отправителя
     * @param destinationPassport паспорт получателя
     * @param destinationRequisite реквизиты получателя
     * @param amount сумма перевода
     * @return true, если перевод выполнен, или false, если нет
     */

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account accountsSource = findByRequisite(sourcePassport, sourceRequisite);
        Account accountsDestinstion = findByRequisite(destinationPassport, destinationRequisite);
        if (accountsSource != null && accountsSource.getBalance() >= amount && accountsDestinstion != null) {
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