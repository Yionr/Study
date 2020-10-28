package cn.yionr.beans;

public class Bean1 {
    private BeanChild child;
    public Bean1(BeanChild child){
        this.child = child;
        System.out.println("bean1 created!");
    }

    public BeanChild getChild() {
        return child;
    }

    public void setChild(BeanChild child) {
        this.child = child;
    }

    public Bean1() {
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "child=" + child +
                '}';
    }

    public void fun(){
        System.out.println("fun");
    }
    public void aboutChild(){
        System.out.println(child);
    }
}
