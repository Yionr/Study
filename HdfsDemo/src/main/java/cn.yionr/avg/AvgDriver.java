package cn.yionr.avg;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class AvgDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf,"Avg");
        job.setJarByClass(AvgDriver.class);
        job.setMapperClass(AvgMapper.class);
        job.setReducerClass(AvgReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.setInputPaths(job,new Path("hdfs://192.168.233.129:9000/park/grade.txt"));
        FileOutputFormat.setOutputPath(job,new Path("hdfs://192.168.233.129:9000/park/avgResult"));

        if (!job.waitForCompletion(true)){
            return;
        }
    }
}
