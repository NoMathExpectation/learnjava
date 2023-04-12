package nme.cs209a.lab7;

import java.util.concurrent.locks.ReentrantLock;

public class LockedAccount extends Account {
  private double balance;

  private final ReentrantLock lock = new ReentrantLock();

  /**
   * @param money
   */
  @Override
  public void deposit(double money) {
    try {
      lock.lock();
      double newBalance = balance + money;
      try {
        Thread.sleep(10);   // Simulating this service takes some processing time
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
      balance = newBalance;
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      lock.unlock();
    }

  }


  public double getBalance() {
    return balance;
  }
}