package cloud.yionr.score;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ScoreReduce extends Reducer<Text, IntWritable,Text,IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        int item;
        for (IntWritable value :
                values) {
            item = value.get();
            sum += item;
        }
        sum /= 2;
        context.write(key,new IntWritable(sum));
    }
}
