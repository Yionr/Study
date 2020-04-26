package cloud.yionr.flow;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowMapper extends Mapper<LongWritable, Text,Text, Flow> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String msg = value.toString();
        String[] item = msg.split(" ");
        Flow f = new Flow();
        f.setPhone(item[0]);
        f.setAddress(item[1]);
        f.setName(item[2]);
        f.setFlow(Integer.parseInt(item[3]));
        context.write(new Text(f.getName()),f);

    }
}
