package th.Tread;


/**
 * shijinliang
 * Feb 2, 2012
 * Interview
 **/
public class BankThread {
    
    private static Account account = new Account(1000);
    private static Customer depositOne = new Customer(account);
    private static Customer depositTwo = new Customer(account);
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	depositOne.drawMoney(800);
	depositTwo.drawMoney(800);
	Thread depositOneThread = new Thread(depositOne, "depositOne");
	Thread depositTwoThread = new Thread(depositTwo, "depositTwo");
	depositOneThread.start();
	depositTwoThread.start();
    }

}

class Account {
    public int residualMoney;
    public Account(int initMoney) {
	residualMoney = initMoney;
    }
    
    public synchronized void drawMoney(int drawMoney) {
	String name = Thread.currentThread().getName();
	if(drawMoney > residualMoney) {
	    System.out.println(name + " : The balance of account is insufficient!");
	} else {
	    System.out.println(name + " drawMoney:" + drawMoney + "$");
	    try {
		Thread.sleep(1);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    residualMoney -= drawMoney;
	    System.out.println("This account remains: " + residualMoney + "$");
	}
    }
}

class Customer implements Runnable {

    private Account account;
    private int drawMoney;
    
    public Customer(Account account) {
	this.account = account;
    }
    
    public void drawMoney(int drawMoney) {
	this.drawMoney = drawMoney;
    }
    @Override
    public void run() {
	// TODO Auto-generated method stub
	account.drawMoney(drawMoney);
    }
    
}