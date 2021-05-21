package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

/**
 * Класс реализует модель Банковских операций.
 * В системе можно производить следующие действия:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 *
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
     *
     * @param user - входной параметр метода содержит объект класса User.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет Клиента.
     *
     * @param passport - паспортные данные Клиента.
     * @param account  - расчетный счет Клиента.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAccounts = users.get(user.get());
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод ищет Клиента по данным его паспорта.
     *
     * @param passport - паспортные данные Клиента.
     * @return - результатом метода является Клиент.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream().filter(el -> el.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет расчетный счет Клиента по реквизитам.
     *
     * @param passport  - паспортные данные.
     * @param requisite - реквизиты счета.
     * @return - результатом метода является расчетный счет Клиент.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAccounts = users.get(user.get());
            rsl = userAccounts.stream()
                    .filter(el -> el.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
    }

    /**
     * Метод перечисляет деньги с одного расчетного счета Клиента на другой расчетный счет.
     * Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
     * то метод должен вернуть false.
     *
     * @param srcPassport   - паспортные данные Клиента списания.
     * @param srcRequisite  - реквизиты расчетного счета списания.
     * @param destPassport  - паспортные данные Клиента зачисления.
     * @param destRequisite - реквизиты расчетного счета зачисления.
     * @param amount        - количество денежных средств для транзакции.
     * @return - результат метода true - успешная транзакция, false - транзакция не прошла.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = true;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isEmpty()
                || destAccount.isEmpty()
                || srcAccount.get().getBalance() < amount) {
            return false;
        }
        srcAccount.get().setBalance(destAccount.get().getBalance() - amount);
        destAccount.get().setBalance(destAccount.get().getBalance() + amount);
        return rsl;
    }
}
