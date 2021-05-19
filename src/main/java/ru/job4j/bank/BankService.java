package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс реализует модель Банковских операций.
 * В системе можно производить следующие действия:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 * @author Nikolay Polegaev
 * @version 1.0.
 */
public class BankService {
    /**
     * Поле users содержит всех Клиентов с привязанными к ним счетами.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет Клиента в систему.
     * @param user - входной параметр метода содержит объект класса User.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет Клиента.
     * @param passport - паспортные данные Клиента.
     * @param account - расчетный счет Клиента.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> userAccounts = users.get(user);
        userAccounts.add(account);
        users.putIfAbsent(user, userAccounts);
    }

    /**
     * Метод ищет Клиента по данным его паспорта.
     * @param passport - паспортные данные Клиента.
     * @return - результатом метода является Клиент.
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
     * Метод ищет расчетный счет Клиента по реквизитам.
     * @param passport - паспортные данные.
     * @param requisite - реквизиты счета.
     * @return - результатом метода является расчетный счет Клиент.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        List<Account> userAccounts = users.get(user);
        for (Account userAccount : userAccounts) {
            if (userAccount.getRequisite().equals(requisite)) {
                return userAccount;
            }
        }
        return null;
    }

    /**
     * Метод перечисляет деньги с одного расчетного счета Клиента на другой расчетный счет.
     * Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
     * то метод должен вернуть false.
     * @param srcPassport - паспортные данные Клиента списания.
     * @param srcRequisite - реквизиты расчетного счета списания.
     * @param destPassport - паспортные данные Клиента зачисления.
     * @param destRequisite - реквизиты расчетного счета зачисления.
     * @param amount - количество денежных средств для транзакции.
     * @return - результат метода true - успешная транзакция, false - транзакция не прошла.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null || srcAccount.getBalance() < amount) {
            return false;
        }
        srcAccount.setBalance(destAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        rsl = true;
        return rsl;
    }
}
