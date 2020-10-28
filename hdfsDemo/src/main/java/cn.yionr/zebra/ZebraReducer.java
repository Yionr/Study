package cn.yionr.zebra;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ZebraReducer extends Reducer<Text, HttpAppHost, Text,NullWritable> {


	@Override
	protected void reduce(Text key, Iterable<HttpAppHost> hahs,
			Reducer<Text, HttpAppHost, Text, NullWritable>.Context context) throws IOException, InterruptedException {
		
		//��hah����Ҫ�����������ɻ���
		HttpAppHost thatHah = new HttpAppHost();
		
		//��hahs���� ����������ɻ��ܵ�  thathah��
		for(HttpAppHost  thishah : hahs){
			//�Ǽ����������õ�����hah��
			thatHah.setReportTime(thishah.getReportTime());
			thatHah.setAppType(thishah.getAppType());
			thatHah.setAppSubType(thishah.getAppSubType());
			thatHah.setUserIP(thishah.getUserIP());
			thatHah.setUserPort(thishah.getUserPort());
			thatHah.setAppServerIP(thishah.getAppServerIP());
			thatHah.setAppServerPort(thishah.getAppServerPort());
			thatHah.setHost(thishah.getHost());
			thatHah.setCellid(thishah.getCellid());
			
			//����������ݽ������  �ۼӵ�  thathah��
			thatHah.setAttempts(thatHah.getAttempts() + thishah.getAttempts());
			thatHah.setAccepts(thatHah.getAccepts()+thishah.getAccepts());
			thatHah.setTrafficUL(thatHah.getTrafficUL()+thishah.getTrafficUL());
			thatHah.setTrafficDL(thatHah.getRetranDL()+thishah.getTrafficDL());
			thatHah.setRetranUL(thatHah.getRetranUL()+thishah.getRetranUL());
			thatHah.setRetranDL(thatHah.getRetranDL()+thishah.getRetranDL());
			thatHah.setFailCount(thatHah.getFailCount()+thishah.getFailCount());
			thatHah.setTransDelay(thatHah.getTransDelay()+thishah.getTransDelay());
		}
		
		//�޸�tostring ����  �������ݸ�ʽ  ÿ�����ݼ�ʹ�����߷ָ�
		String result = thatHah.toString();
		
		//�������
		context.write(new Text(result), NullWritable.get());
	}

}
