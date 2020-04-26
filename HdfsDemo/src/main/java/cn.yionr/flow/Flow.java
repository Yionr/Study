package cloud.yionr.flow;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Flow implements Writable {
    private String phone;
    private String name;
    private String address;
    private int flow;

    @Override
    public String toString() {
        return "Flow{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", city='" + address + '\'' +
                ", flow=" + flow +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    public Flow() {}

//    下面这两个方法是序列化和反序列化时候会调用 的
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(phone);
        dataOutput.writeUTF(name);
        dataOutput.writeUTF(address);
        dataOutput.writeInt(flow);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.phone = dataInput.readUTF();
        this.name = dataInput.readUTF();
        this.address = dataInput.readUTF();
        this.flow = dataInput.readInt();
    }
}
