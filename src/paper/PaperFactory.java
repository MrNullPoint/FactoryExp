package paper;

import framework.Factory;
import framework.Product;

/**
 * 造纸厂，纸张厚度小于3mm表示不合格
 */
public class PaperFactory extends Factory {
    @Override
    protected Product createProduct(String name) {
        return new Paper(name);
    }

    @Override
    protected void checkProduct(Product product) {
        Paper paper = (Paper) product;
        if(paper.getThick() < 3) {
            System.out.println(paper.getType() + ":不合格");
        } else {
            System.out.println(paper.getType() + ":合格");
        }
    }
}
