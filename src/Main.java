import framework.Factory;
import framework.Product;
import paper.PaperFactory;
import toy.ToyFactory;

public class Main {
    public static void main(String[] agrs) {
        Factory toyFactory = new ToyFactory();
        Product weenieBear = toyFactory.build("维尼熊");
        Product transformer = toyFactory.build("变形金刚");

        Factory paperFactory = new PaperFactory();
        Product a4Paper = paperFactory.build("A4");
        Product a3Paper = paperFactory.build("A3");

        weenieBear.use();
        transformer.use();

        a4Paper.use();
        a3Paper.use();
    }
}
