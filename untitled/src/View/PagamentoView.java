package View;

import Entities.Carrinho.Carrinho;
import Entities.Carrinho.FormaDePagamento;

import static Entities.Carrinho.FormaDePagamento.*;


public interface PagamentoView extends Views{


    PagamentoView INSTANCE = new PagamentoView() {
    };

    static PagamentoView getInstance() {
        return INSTANCE;
    }

    default void fecharPedido(){
        System.out.println("Valor final do pedido: " + Carrinho.getInstance().getValorTotalDasCompras());
        Carrinho.getInstance().mostrarProdutoNoCarrinho();
        selecionarFormaDePagamento();
    }


    default void selecionarFormaDePagamento(){
        System.out.println();
        System.out.println("Qual a forma de pagamento:");
        System.out.println("1 - " + BOLETO);
        System.out.println("2 - " + CREDITO);
        System.out.println("3 - " + DEBITO);
        System.out.println("4 - " + FormaDePagamento.PAYPAL);
        try{
            int opcaoDePagamento = Integer.parseInt(sc.nextLine());
            switch (opcaoDePagamento){
                case 1:
                    Carrinho.getInstance().setFormaDePagamento(BOLETO);
                case 2:
                    Carrinho.getInstance().setFormaDePagamento(CREDITO);
                    parcelamento();
                case 3:
                    Carrinho.getInstance().setFormaDePagamento(DEBITO);
                case 4:
                    Carrinho.getInstance().setFormaDePagamento(PAYPAL);
                default:
                    System.out.println("Opção inválida, tente novamente");
                    fecharPedido();
            }
        } catch (Exception e) {
            System.out.println("Comportamento inesperado, o sistema vai precisar ser reiniciado");
        }
    }

    default void parcelamento(){
        double valorParcela = 0.0;
        System.out.println();
        System.out.print("Opção de crédito, permite parcelamento em até 3x, em quantas deseja parcelar: ");
        int parcelamento = Integer.parseInt(sc.nextLine());
        if (parcelamento > 3) {
            System.out.println("Opção inválida, tente novamente!");
            parcelamento();
        } else {
            valorParcela = Carrinho.getInstance().getValorTotalDasCompras() / parcelamento;
            System.out.println("Pagamento em " + parcelamento + "x de R$ " + String.format("%.2f",valorParcela));
        }
    }
}



