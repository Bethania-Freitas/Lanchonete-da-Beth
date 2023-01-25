package Entities.Lanchonete;

import Entities.Produtos.Produtos;
import View.MenuView;
import View.Views;

import java.util.ArrayList;
import java.util.List;

public class Lanchonete {
    public static List<Produtos> produtos = new ArrayList<>();

    private static final Lanchonete INSTANCE = new Lanchonete();

    public static Lanchonete getInstance() {
        return INSTANCE;
    }

    public void iniciar() {
        System.out.println("-------------------------LANCHONETE DA BETH-------------------------------");
        System.out.println();
        instanciarProdutos();
        menuDeProdutos();
        MenuView.getInstance().menuInicial();
    }

    public void menuDeProdutos() {
        for (Produtos produto : produtos){
            System.out.println(produto);
        }
    }

    public void instanciarProdutos(){
        produtos.add(new Produtos("🌭", 001, "Hot Dog", "Pão de hot-dog, com 1 salsicha, maionese, katchup, mostarda e batata palha.", 8.00));
        produtos.add(new Produtos("🍔", 002, "X-Salada", "Pao de hamburguer, queijo, hargurguer, maionese, tomate e alface", 12.00));
        produtos.add(new Produtos("🥪", 003, "Lanche Natural", "Pão de forma, patê de atum, alface e tomate", 10.00));
        produtos.add(new Produtos("🍟", 004, "Batata frita", "Batata palito porção individual", 8.00));
        produtos.add(new Produtos("🧃", 005, "Suco de caixinha", "Suco de caixinha, sabores, morango, manga ou uva", 6.00));
        produtos.add(new Produtos("🥤", 006, "Refrigerante", "Coca-cola, guaraná antartica, fanta ou sprite", 10.00));
        produtos.add(new Produtos("☕", 007, "Café", "Café expresso puro ou com leite", 6.00));
    }

    public void sair(){
        System.out.println("Programa encerrado - Volte Sempre");
    }


}