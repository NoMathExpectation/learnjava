package nme.cs209a.lab7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {
        Account account = new Account();
        Account syncedAccount = new SyncedAccount();
        Account lockedAccount = new LockedAccount();
        ExecutorService service = Executors.newFixedThreadPool(300);

        for (int i = 1; i <= 100; i++) {
            service.execute(new DepositThread(account, 10));
            service.execute(new DepositThread(syncedAccount, 10));
            service.execute(new DepositThread(lockedAccount, 10));
        }

        service.shutdown();

        while (!service.isTerminated()) {
        }

        System.out.println("Unsafe balance: " + account.getBalance());
        System.out.println("Synced balance: " + syncedAccount.getBalance());
        System.out.println("Locked balance: " + lockedAccount.getBalance());
    }
}
