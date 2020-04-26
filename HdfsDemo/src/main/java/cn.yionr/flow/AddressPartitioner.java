package cn.yionr.flow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AddressPartitioner extends Partitioner<Text,Flow> {

    @Override
    public int getPartition(Text text, Flow flow, int i) {
        String address = flow.getAddress();
        switch (address){
            case "bj":
                return 0;
            case "sh":
                return 1;
            case "sz":
                return 2;
            default:
                return 3;
        }
    }
}
