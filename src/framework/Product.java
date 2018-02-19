package framework;

/**
 * 表示产品的类，定义了抽象方法 use()
 * 具体实现由子类实现，父类不管产品具体使用方法
 */
public abstract class Product {
    public abstract void use();
}
