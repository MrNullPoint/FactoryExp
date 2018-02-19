package toy;

import framework.Product;

/**
 * 玩具类，包含玩具名称和玩具重量
 */
public class Toy extends Product{

    private String toyName;
    private int weight;

    public Toy(String toyName) {
        this.toyName = toyName;
        this.weight = (int) (10 * Math.random());
    }

    @Override
    public void use() {
        System.out.println("使用名为" + toyName + "的玩具");
    }

    public int getWeight() {
        return weight;
    }

    public String getToyName() {
        return toyName;
    }
}
