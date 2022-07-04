package Thread.RaceCondition;

public class OrderMatic implements Runnable{
    private volatile int orderNo;
    private final Object LOCK=new Object();

    public OrderMatic() {
        this.orderNo = 0;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        increaseOrder();
    }

    private synchronized void increaseOrder() {
        this.orderNo++;
        System.out.println(Thread.currentThread().getName()+ "- OrderNo => "+this.orderNo);
    }
}
