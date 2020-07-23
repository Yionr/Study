package cn.yionr.zebra;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class HttpAppHost implements Writable{
	private String reportTime;  //ʱ��
	private int appType;//Ӧ�ô���
	private int appSubType;//Ӧ��С��
	private String userIP;//�û�ip
	private int userPort;//�û��˿�
	private String appServerIP;//������ip
	private int appServerPort;//�������˿�
	private String host;//����
	private String cellid;//С��id
	private int attempts;//���Դ���
	private int accepts;//���ܴ���
	private long trafficUL;//��������   �����ϴ��ļ�
	private long trafficDL;//��������  ���������ļ���
	private long retranUL;//�ش����б�����
	private long retranDL;//�ش����б�����
	private  int failCount;//ʧ�ܴ���
	private  long transDelay;//����ʱ��
	
	@Override  //���л�
	public void write(DataOutput out) throws IOException {
		out.writeUTF(reportTime);
		out.writeInt(appType);
		out.writeInt(appSubType);//ctrl + alt +��
		out.writeUTF(userIP);
		out.writeInt(userPort);// alt +��
		out.writeUTF(appServerIP);
		out.writeInt(appServerPort);
		out.writeUTF(host);
		out.writeUTF(cellid);
		out.writeInt(attempts);
		out.writeInt(accepts);
		out.writeLong(trafficUL);
		out.writeLong(trafficDL);
		out.writeLong(retranUL);
		out.writeLong(retranDL);
		out.writeInt(failCount);
		out.writeLong(transDelay);
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		this.reportTime = in.readUTF();
		this.appType = in.readInt();
		this.appSubType = in.readInt();
		this.userIP= in.readUTF();
		this.userPort = in.readInt();
		this.appServerIP= in.readUTF();
		this.appServerPort = in.readInt();
		this.host= in.readUTF();
		this.cellid= in.readUTF();
		this.attempts = in.readInt();
		this.accepts = in.readInt();
		this.trafficUL = in.readLong();
		this.trafficDL = in.readLong();
		this.retranUL = in.readLong();
		this.retranDL = in.readLong();
		this.failCount = in.readInt();
		this.transDelay = in.readLong();
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	public int getAppType() {
		return appType;
	}
	public void setAppType(int appType) {
		this.appType = appType;
	}
	public int getAppSubType() {
		return appSubType;
	}
	public void setAppSubType(int appSubType) {
		this.appSubType = appSubType;
	}
	public String getUserIP() {
		return userIP;
	}
	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}
	public int getUserPort() {
		return userPort;
	}
	public void setUserPort(int userPort) {
		this.userPort = userPort;
	}
	public String getAppServerIP() {
		return appServerIP;
	}
	public void setAppServerIP(String appServerIP) {
		this.appServerIP = appServerIP;
	}
	public int getAppServerPort() {
		return appServerPort;
	}
	public void setAppServerPort(int appServerPort) {
		this.appServerPort = appServerPort;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getCellid() {
		return cellid;
	}
	public void setCellid(String cellid) {
		this.cellid = cellid;
	}
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	public int getAccepts() {
		return accepts;
	}
	public void setAccepts(int accepts) {
		this.accepts = accepts;
	}
	public long getTrafficUL() {
		return trafficUL;
	}
	public void setTrafficUL(long trafficUL) {
		this.trafficUL = trafficUL;
	}
	public long getTrafficDL() {
		return trafficDL;
	}
	public void setTrafficDL(long trafficDL) {
		this.trafficDL = trafficDL;
	}
	public long getRetranUL() {
		return retranUL;
	}
	public void setRetranUL(long retranUL) {
		this.retranUL = retranUL;
	}
	public long getRetranDL() {
		return retranDL;
	}
	public void setRetranDL(long retranDL) {
		this.retranDL = retranDL;
	}
	public int getFailCount() {
		return failCount;
	}
	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}
	public long getTransDelay() {
		return transDelay;
	}
	public void setTransDelay(long transDelay) {
		this.transDelay = transDelay;
	}
	@Override
	public String toString() {
		return reportTime + " 00:00:00" + "|" + appType + "|" + appSubType
				+ "|" + userIP + "|" + userPort + "|" + appServerIP + "|"
				+ appServerPort + "|" + host + "|" + cellid + "|" + attempts + "|"
				+ accepts + "|" + trafficUL + "|" + trafficDL + "|" + retranUL
				+ "|" + retranDL + "|" + failCount + "|" + transDelay;
	}

}
