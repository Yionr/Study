package cn.yionr.beans;

public class StaticUserFactory {
    public static User getInstance(String name,int age){
        User temp = new User();
        temp.setName(name);
        temp.setAge(age);
        return temp;
    }
}
