package Entities.Carrinho;

import Entities.Produtos.Produtos;
import View.PagamentoView;

import java.util.ArrayList;
import java.util.List;

import static Entities.Lanchonete.Lanchonete.produtos;

public class Carrinho {
    static final Carrinho INSTANCE = new Carrinho() {};
    public static Carrinho getInstance() {
        return INSTANCE;
    }

    private static List<Produtos> produtoNoCarrinho = new ArrayList<>();
    private Double valorTotalDasCompras;
    private Enum FormaDePagamento;

    public Carrinho() {

        this.valorTotalDasCompras = 0.0;
    }

    public static List<Produtos> getProdutoNoCarrinho() {

        return produtoNoCarrinho;
    }

    public Double getValorTotalDasCompras() {
        valorTotalDasCompras = 0.0;
        for(int i = 0; i < produtoNoCarrinho.size();i++){
            valorTotalDasCompras += produtoNoCarrinho.get(i).getPrice();
        }
        return valorTotalDasCompras;
    }

    public Enum getFormaDePagamento() {

        return FormaDePagamento;
    }

    public void setFormaDePagamento(Enum formaDePagamento) {

        FormaDePagamento = formaDePagamento;
    }

    public void adicionarProdutoNoCarrinho(Produtos produto){
        if (produtoNoCarrinho.contains(produto)) {
            produto.adicionarQuantidade();
        } else {
            produtoNoCarrinho.add(produto);
        }
    }

    public void removerProdutoNoCarrinho(Produtos produto){
        if (produtoNoCarrinho.contains(produto)) {
            produto.removerQuantidade();
        } else {
            produtoNoCarrinho.remove(produto);
        }
    }

    public void mostrarProdutoNoCarrinho(){
        System.out.println();
        System.out.println("-------- CARRINHO--------");
        System.out.println("Qtde - Produto - Preço");
        for (int i = 0; i < produtoNoCarrinho.size(); i++){
            System.out.println(
                    produtoNoCarrinho.get(i).getQuantity()
                            + " - "
                            + produtoNoCarrinho.get(i).getName()
                            + " - "
                            + produtoNoCarrinho.get(i).getPrice());
        }
        System.out.println("Valor total: R$ " + getValorTotalDasCompras());
    }


    public void limparCarrinho() {
        for (Produtos produtos : produtos) {
            removerProdutoNoCarrinho(produtos);
        }
    }
}
