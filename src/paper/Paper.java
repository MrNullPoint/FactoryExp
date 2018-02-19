package paper;

import framework.Product;

/**
 * 纸张类，包含厚度和类型
 */
public class Paper extends Product {

    private int thick;
    private String type;

    public Paper(String type) {
        this.thick = (int) (10 * Math.random());
        this.type = type;
    }

    @Override
    public void use() {
        System.out.println("使用尺寸为：" + type + "的纸");
    }

    public int getThick() {
        return thick;
    }

    public String getType() {
        return type;
    }

}
