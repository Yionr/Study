package cn.yionr.beans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ComplexBean {
    private List<Bean1> bean1s;
    private Map<Integer,Bean1> map;
    private int[] arr;
    private Properties properties;

    public ComplexBean() {
    }

    @Override
    public String toString() {
        return "ComplexBean{" +
                "bean1s=" + bean1s +
                ", map=" + map +
                ", arr=" + Arrays.toString(arr) +
                ", properties=" + properties +
                '}';
    }

    public List<Bean1> getBean1s() {
        return bean1s;
    }

    public void setBean1s(List<Bean1> bean1s) {
        this.bean1s = bean1s;
    }

    public Map<Integer, Bean1> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Bean1> map) {
        this.map = map;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
