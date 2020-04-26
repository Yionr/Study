package cloud.yionr.score;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ScoreMapper extends Mapper<Text, Text,Text, IntWritable> {
    @Override
    protected void map(Text key, Text value, Context context) throws IOException, InterruptedException {
        String s = value.toString();
        String[] split = s.split(";");
        for (String str :
                split) {
            String[] s1 = str.split(" ");
            context.write(key,new IntWritable(Integer.parseInt(s1[1])));
        }

    }
}
