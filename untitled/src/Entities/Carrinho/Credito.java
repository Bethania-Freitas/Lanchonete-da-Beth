package Entities.Carrinho;

public class Credito {
    static final Credito INSTANCE = new Credito() {};
    public static Credito getInstance() {
        return INSTANCE;
    }
    private double valorParcela;
    private int parcelas;

    public double getValorParcela() {
        return valorParcela / parcelas;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
}
