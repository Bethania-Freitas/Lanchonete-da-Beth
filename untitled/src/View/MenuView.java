package View;

import Entities.Carrinho.Carrinho;
import Entities.Lanchonete.Lanchonete;
import Entities.Produtos.Produtos;

import java.util.InputMismatchException;

import static Entities.Lanchonete.Lanchonete.produtos;

public interface MenuView extends Views {

    static final MenuView INSTANCE = new MenuView() {
    };

    public static MenuView getInstance() {
        return INSTANCE;
    }

    default void menuInicial() {
        System.out.println();
        System.out.println("Digite: ");
        System.out.println("1 - Mostrar Menu");
        System.out.println("2 - Para adicionar produto no carrinho");
        System.out.println("3 - Para fechar pedido");
        System.out.println("4 - para retirar produto do carrinho");
        System.out.println("5 - Para sair");
        try{
            int opcaoCliente = Integer.parseInt(sc.nextLine());
            switch (opcaoCliente){
                case 1:
                    Lanchonete.getInstance().menuDeProdutos();
                    menuInicial();
                case 2:
                    adicionarProduto();
                    menuInicial();
                case 3:
                    if (Carrinho.getProdutoNoCarrinho().isEmpty()){
                        System.out.println("Não existem produtos no carrinho, adicione produtos antes de fechar o pedido");
                        menuInicial();
                    }
                    PagamentoView.getInstance().fecharPedido();
                    break;
                case 4:
                    if (Carrinho.getProdutoNoCarrinho().isEmpty()){
                        System.out.println("Seu carrinho de compras já esta vazio");
                        menuInicial();
                    }
                    removerProduto();
                    menuInicial();
                case 5:
                    Lanchonete.getInstance().sair();
                    break;
                default:
                    System.out.println("Opção inválida");
                    menuInicial();
            }
        } catch (Exception e) {
            System.out.println("Comportamento inesperado, o sistema vai precisar ser encerrado");
        }
    }

    public default void adicionarProduto(){
        System.out.println();
        System.out.print("Faça seu pedido pelo numero do produto: ");
        try {
            int opcaoProduto = Integer.parseInt(sc.nextLine());;
            for (Produtos produto : produtos) {
                if (opcaoProduto == produto.getId()) {
                    Carrinho.getInstance().adicionarProdutoNoCarrinho(produto);
                }
            }
        } catch (InputMismatchException e){
            throw new IllegalStateException();
        }
        Carrinho.getInstance().mostrarProdutoNoCarrinho();
    }

    public default void removerProduto(){
        System.out.println();
        System.out.print("Digite o numero do produto que deseja remover: ");
        try {
            int opcaoProduto = Integer.parseInt(sc.nextLine());
            for (Produtos produto : produtos) {
                if (opcaoProduto == produto.getId()) {
                    Carrinho.getInstance().removerProdutoNoCarrinho(produto);
                }
            }
        } catch (InputMismatchException e){
            throw new IllegalStateException();
        }
        Carrinho.getInstance().mostrarProdutoNoCarrinho();
    }
}
