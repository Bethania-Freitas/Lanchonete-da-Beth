package View;

import Entities.Carrinho.Carrinho;
import Entities.Carrinho.Credito;
import Entities.Carrinho.FormaDePagamento;
import Entities.Lanchonete.Lanchonete;

import static Entities.Carrinho.FormaDePagamento.*;


public interface PagamentoView extends Views {

    PagamentoView INSTANCE = new PagamentoView() {};
    static PagamentoView getInstance() {
        return INSTANCE;
    }

    default void confirmarPedido(){
        Carrinho.getInstance().mostrarProdutoNoCarrinho();
        selecionarFormaDePagamento();
        System.out.println();
        System.out.println("Forma de pagamento selecionada: "+ Carrinho.getInstance().getFormaDePagamento());
        if (Carrinho.getInstance().getFormaDePagamento().equals(CREDITO) ){
            System.out.println("Pagamento em " + Credito.getInstance().getParcelas()
                    + "x de R$ " + String.format("%.2f",Credito.getInstance().getValorParcela()));
        }
        System.out.println("Digite:");
        System.out.println("1 - para confirmar");
        System.out.println("2 - para editar pagamento");
        System.out.println("3 - para editar pedido");
        System.out.println("4 - cancelar pedido");
        try{
            int opcaoDePagamento = Integer.parseInt(sc.nextLine());
            switch (opcaoDePagamento){
                case 1:
                    finalizarPedido();
                    break;
                case 2:
                    selecionarFormaDePagamento();
                    break;
                case 3:
                    MenuView.getInstance().menuInicial();
                    break;
                case 4:
                    cancelarPedido();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
                    confirmarPedido();
            }
        } catch (Exception e) {
            System.out.println("Comportamento inesperado, o sistema vai precisar ser reiniciado");
        }

    }

    default void cancelarPedido(){
        System.out.println("Tudo bem, vamos limpar o seu carrinho, e reiniciar o programa!");
        Carrinho.getInstance().limparCarrinho();
        MenuView.getInstance().menuInicial();
    };

    default void finalizarPedido(){
        System.out.println("Pedido finalizado com sucesso!");
        System.out.println("Aguarde até ser chamado pelo nome");
        System.out.println("OBRIGADA E VOLTE SEMPRE!");
        Lanchonete.getInstance().sair();
    };


    default void selecionarFormaDePagamento(){
        int opcaoDePagamento = 0;
        System.out.println();
        System.out.println("Qual a forma de pagamento:");
        System.out.println("1 - " + BOLETO);
        System.out.println("2 - " + CREDITO);
        System.out.println("3 - " + DEBITO);
        System.out.println("4 - " + FormaDePagamento.PAYPAL);
        System.out.println("5 - voltar para Menu");
        try{
            opcaoDePagamento = Integer.parseInt(sc.nextLine());
            switch (opcaoDePagamento){
                case 1:
                    Carrinho.getInstance().setFormaDePagamento(BOLETO);
                    break;
                case 2:
                    Carrinho.getInstance().setFormaDePagamento(CREDITO);
                    parcelar();
                    break;
                case 3:
                    Carrinho.getInstance().setFormaDePagamento(DEBITO);
                    break;
                case 4:
                    Carrinho.getInstance().setFormaDePagamento(PAYPAL);
                    break;
                case 5:
                    MenuView.getInstance().menuInicial();
                default:
                    System.out.println("Opção inválida, tente novamente");
                    confirmarPedido();
            }
        } catch (Exception e) {
            System.out.println("Comportamento inesperado, o sistema vai precisar ser reiniciado");
        }
    }

    default void parcelar(){
        System.out.println();
        System.out.print("Opção de crédito, permite parcelamento em até 3x, em quantas deseja parcelar: ");
        int parcela = Integer.parseInt(sc.nextLine());
        if (parcela > 3) {
            System.out.println("Opção inválida, tente novamente!");
        } else {
            Credito.getInstance().setValorParcela(parcela);
        }
    }
}



