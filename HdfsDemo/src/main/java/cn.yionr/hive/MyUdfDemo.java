package cloud.yionr.hive;

import org.apache.hadoop.hive.ql.exec.UDF;

public class MyUdfDemo extends UDF {
    public  String evaluate(String str){
        return str.toUpperCase() + "WINNER!!!!";
    }
}
