public class ZwillingsPrime  <K,V> {
    private final K erste;
    private final V zweite;

    public ZwillingsPrime(K erste, V zweite){
        this.erste = erste;
        this.zweite = zweite;
    }

    @Override
    public String toString() {
        return "ZwillingsPrime{" +
                "erste=" + erste +
                ", zweite=" + zweite +
                '}';
    }
}