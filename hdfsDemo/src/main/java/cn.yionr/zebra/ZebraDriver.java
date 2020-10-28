package cn.yionr.zebra;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ZebraDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "zebra");
		job.setJarByClass(ZebraDriver.class);
		
		job.setMapperClass(ZebraMapper.class);
		job.setReducerClass(ZebraReducer.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(HttpAppHost.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(NullWritable.class);
		
		//mr����Դ���� ������hdfs��ָ�����ļ� ���� ָ��Ŀ¼
		FileInputFormat.setInputPaths(job, new Path("hdfs://192.168.233.129:9000/zebra"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.233.129:9000/zebra_result"));

		if (!job.waitForCompletion(true))
			return;
	}

}
