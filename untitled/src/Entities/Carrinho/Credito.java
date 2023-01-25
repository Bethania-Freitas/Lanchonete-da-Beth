package Entities.Carrinho;

public class Credito {
    static final Credito INSTANCE = new Credito() {};
    public static Credito getInstance() {
        return INSTANCE;
    }
    private double valorParcela;
    private int parcelas;

    public double getValorParcela() {
        valorParcela = Carrinho.getInstance().getValorTotalDasCompras() / parcelas;
        return valorParcela;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public String toString(){
        return "Pagamento em "
                + parcelas
                + " parcelas no valor de R$ "
                + String.format("%.2f",getValorParcela());
    }
}
