public class Demo09 {
    public static void main(String[] args) {
        OrderRepository sqlRepo = new SqlOrderRepository();
        OrderController sqlController = new OrderController(sqlRepo);
        sqlController.create("ORD-1");
    }
}
