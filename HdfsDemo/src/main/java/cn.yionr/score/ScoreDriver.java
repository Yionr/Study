package cn.yionr.score;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class ScoreDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf,"score");
        job.setJarByClass(ScoreDriver.class);
        job.setMapperClass(ScoreMapper.class);
        job.setReducerClass(ScoreReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setInputFormatClass(AutoInputFormat.class);

        FileInputFormat.setInputPaths(job,new Path("hdfs://192.168.233.129:9000/park/score.txt"));
        FileOutputFormat.setOutputPath(job,new Path("hdfs://192.168.233.129:9000/park/score"));

        if (!job.waitForCompletion(true)){
            return;
        }
    }
}
