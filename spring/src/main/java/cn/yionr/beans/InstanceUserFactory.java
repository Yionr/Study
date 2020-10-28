package cn.yionr.beans;

public class InstanceUserFactory {
    public User getInstance(String name,int age){
        User temp = new User();
        temp.setName(name);
        temp.setAge(age);
        return temp;
    }
}
