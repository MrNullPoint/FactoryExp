package toy;

import framework.Factory;
import framework.Product;

/**
 * 玩具工厂类，如果玩具质量大于7磅就不合格
 */
public class ToyFactory extends Factory {

    @Override
    protected Product createProduct(String name) {
        return new Toy(name);
    }

    @Override
    protected void checkProduct(Product product) {
        Toy toy = (Toy) product;
        if(toy.getWeight() > 7) {
            System.out.println(toy.getToyName() + ":不合格");
        } else {
            System.out.println(toy.getToyName() + ":合格");
        }
    }
}
