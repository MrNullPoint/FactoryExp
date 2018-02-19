一天一个设计模式 - Factory

Factory 模式

Factory 字面的含义就是工厂，之前 Template 模式中我们把算法和流程在父类中定义，在子类中具体实现，如果我们用 Template 模式来构建生成实例的工厂，这就是 Factory 模式。

这会儿你还不太好理解，映射到现实生活中我来举个栗子方便大家理解。工厂就是负责生产商品，我们可以建造玩具厂生产玩具，也可以建造造纸厂生产卫生纸，现在我们把工厂生产商品这个过程抽象化，具体工厂是玩具厂还是造纸厂由程序逻辑来决定，这就是工厂模式。

示例程序

产品

首先我们定义产品，这里比较简单就定义了产品一个方法就是 use() ，当然现实生活中，产品还有很多抽象方法，这边就拿使用做一个栗子，我们不管产品怎么用，玩具肯定有玩具的用法，卫生纸肯定有卫生纸的用法 2333。

    package framework;
    
    /**
     * 表示产品的类，定义了抽象方法 use()
     * 具体实现由子类实现，父类不管产品具体使用方法
     */
    public abstract class Product {
        public abstract void use();
    }

工厂

工厂都是干嘛的呢？工厂就负责把产品制造出来，制造这个过程当然包含一系列手续啦。我们这边简化一下，制造产品流程就包括创建产品和检查产品。

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

玩具

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

玩具厂

具体实现玩具制造和检查的类，其中检查玩具是否合格根据玩具重量是否大于7磅决定。

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
    

纸张

包含纸张类型和纸张厚度。

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

造纸厂

具体实现造纸和检查纸张合格情况，其中如果纸张厚度小于3mm则不合格。

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

至此，我们就实现了玩具厂和造纸厂，两者都能够生产相应产品，同时检查产品是否合格。

代码地址：https://github.com/MrNullPoint/FactoryExp

解惑

框架与具体加工

工厂模式的引入，可以让我们把 框架 和 加工 分开，当我们需要另外一个工厂的时候，只需要引入 Factory 类和Product 类即可。


