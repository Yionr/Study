package cn.yionr.beans;

public class BeanChild {
    private int x;

    public BeanChild() {
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "BeanChild{" +
                "x=" + x +
                '}';
    }

    public void setX(int x) {
        this.x = x;
    }
}
