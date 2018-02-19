package framework;

/**
 * 工厂类
 */
public abstract class Factory {

    // 创建产品
    protected abstract Product createProduct(String name);

    // 检查产品
    protected abstract void checkProduct(Product product);

    // 生产产品
    public final Product build(String name) {
        Product p = createProduct(name);
        checkProduct(p);
        return p;
    }

}
