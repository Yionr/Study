package cn.yionr.zebra;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

//�������Ϊ����ı�ʶ ��  httpappHost
public class ZebraMapper extends Mapper<LongWritable, Text, Text, HttpAppHost> {

	public void map(LongWritable ikey, Text ivalue, Context context) throws IOException, InterruptedException {
		//���ÿһ����������װ��  cn.yionr.zebra.HttpAppHost
		//��װreportTime  ���ļ������л�ȡ
		FileSplit fs = (FileSplit)context.getInputSplit();
		//��fs�л�ȡ���ļ�����   103_20150615143630_00_00_002.csv
		String filename = fs.getPath().getName();
		//��filename�л�ȡ  yyyy-mm-dd  reporttime
		String time = filename.split("_")[1];//20150615143630

		String reportTime = time.substring(0,4)+"-"
				+time.substring(4, 6)+"-"+time.substring(6, 8);
		//һ������  ����|�ָ�  ������77���ֶ�
		String line = ivalue.toString();
		String[]  infos = line.split("\\|");

		//��ԭʼ��һ������������  ��ȡappType 23λ
		int appType = Integer.parseInt(infos[22]);
		//��ԭʼ��һ������������  ��ȡappSubType 24λ
		int appSubType = Integer.parseInt(infos[23]);
		//��ԭʼ��һ������������  ��ȡuserIP 27λ
		String userIP = infos[26];
		//��ԭʼ��һ������������  ��ȡuserPort 29λ
		int userPort = Integer.parseInt(infos[28]);
		//��ԭʼ��һ������������  ��ȡappServerIP 31λ
		String appServerIP = infos[30];
		//��ԭʼ��һ������������  ��ȡappServerPort 33λ
		int appServerPort = Integer.parseInt(infos[32]);
		//��ԭʼ��һ������������  ��ȡhost 59λ
		String host = infos[58];

		//��ԭʼ��һ������������  ��ȡhost 17λ 
		String cellid;
		if(infos[16].equals("")){
			cellid = "00000000" ;//���С��idΪ�� ��ô�ֶ�����Ϊ9��0
		}else{
			cellid = infos[16];
		}

		//��ȡ�����������
		int appTypeCode = Integer.parseInt(infos[18]);
		String httpWap = infos[54]; //����״̬
		String wtp = infos[67];//�ж�����

		//���Դ���  if( App Type Code=103 ) 
		int attempts = appTypeCode==103 ? 1 : 0;

		//���ܴ���
		String  waps = "10,11,12,13,14,15,32,33,34,35,36,37,38,48,49,50,51,52,53,54,"
				+ "55,199,200,201,202,203,204,205,206,302,304,306";
		//if( App Type Code=103 & HTTP/WAP����״̬ in(10,11,12,13,14,15,32,33,34,35,36,37,38,48,49,50,51,52,53,54,55,199,200,201,202,203,204,205,206,302,304,306) && Wtp�ж�����==NULL) then counter++
		int accepts = 0;
		if(appTypeCode == 103
				&& waps.contains(httpWap)
				&& wtp.equals("")){
			accepts = 1;
		}

		//������������  ��������
		//trafficUL if( App Type Code=103  ) then counter = counter + UL Data
		//trafficDL if( App Type Code=103  ) then counter = counter + DL Data
		//�����ش�������
		//if( App Type Code=103  ) then counter = counter + ����TCP�ش�������
		//if( App Type Code=103  ) then counter = counter + ����TCP�ش�������
		long trafficUL = 0;
		long trafficDL = 0;
		long retranUL = 0;
		long retranDL = 0;
 		if(appTypeCode == 103){
			trafficUL = Long.parseLong(infos[33]);
			trafficDL = Long.parseLong(infos[34]);
			retranUL = Long.parseLong(infos[39]);
			retranDL = Long.parseLong(infos[40]);
		}
 		
 		//����ʧ�ܴ���
 		//if( App Type Code=103 &&  HTTP/WAP����״̬==1  &&  Wtp�ж�����==0 ) then counter = counter + 1
 		int failCount = 0;
 		if(appTypeCode == 103 && httpWap.equals(1) && wtp.equals("0")){
 			failCount = 1;
 		}
 		
 		//����ʱ��
 		//if( App Type Code=103  ) then counter = counter + (Procedure_End_time-Procedure_Start_time)
 		long transDelay = 0;
 		long procedureEndTime = Long.parseLong(infos[20]);
 		long procedureStartTime = Long.parseLong(infos[19]);
 		if(appTypeCode == 103){
 			transDelay = procedureEndTime - procedureStartTime;
 		}

 		//��׼���õ�����  ��װ�� HttpApphost������
 		HttpAppHost hah = new HttpAppHost();
 		hah.setReportTime(reportTime);
 		hah.setAppType(appType);
 		hah.setAppSubType(appSubType);
 		hah.setUserIP(userIP);
 		hah.setUserPort(userPort);
 		hah.setAppServerIP(appServerIP);
 		hah.setAppServerPort(appServerPort);
 		hah.setHost(host);
 		hah.setCellid(cellid);
 		hah.setAttempts(attempts);
 		hah.setAccepts(accepts);
 		hah.setTrafficUL(trafficUL);
 		hah.setTrafficDL(trafficDL);
 		hah.setRetranUL(retranUL);
 		hah.setRetranDL(retranDL);
 		hah.setFailCount(failCount);
 		hah.setTransDelay(transDelay);
 		
 		//׼�������ʶ��key
 		//��hah�зѼ�����������
 		String key = hah.getReportTime() + "|" + hah.getAppType() + "|" + hah.getAppSubType() +
 				"|" + hah.getUserIP() + "|" + hah.getUserPort() + "|" + hah.getAppServerIP() +
 				"|" + hah.getAppServerPort() + "|" + hah.getHost() + "|" + hah.getCellid();
 		context.write(new Text(key), hah);
	}

}
