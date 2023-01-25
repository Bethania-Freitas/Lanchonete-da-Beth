package Entities.Produtos;

public class Produtos {

    private String emoji;
    private int id;
    private String name;
    private String description;
    private Double price;
    private int quantity;

    public Produtos(String emoji, int id, String name, String description, Double price) {
        this.emoji = emoji;
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = 1;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price * quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void adicionarQuantidade() {
        quantity++;
    }

    public void removerQuantidade() {
        quantity--;
    }

    @Override
    public String toString() {
        return emoji
                + "- " + id
                + "- " + name
                + "- " + description
                + "- R$ " + price;
    }
}
