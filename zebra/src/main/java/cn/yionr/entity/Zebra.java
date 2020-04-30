package cn.yionr.entity;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Zebra implements Writable {
    private String reportTime;
    private String cellid;
    private String userIP;
    private String appServerIP;
    private String host;
    private int appType;
    private int appSubtype;
    private int userPort;
    private int appServerPort;
    private int attempts;
    private long trafficUL;
    private long trafficDL;
    private long retranUL;
    private long retranDN;
    private long transDelay;

    @Override
    public String toString() {
        return "Zebra{" +
                "reportTime='" + reportTime + '\'' +
                ", cellid='" + cellid + '\'' +
                ", appType=" + appType +
                ", appSubtype=" + appSubtype +
                ", userIP='" + userIP + '\'' +
                ", userPort=" + userPort +
                ", appServerIP='" + appServerIP + '\'' +
                ", appServerPort=" + appServerPort +
                ", host='" + host + '\'' +
                ", attempts=" + attempts +
                ", trafficUL=" + trafficUL +
                ", trafficDL=" + trafficDL +
                ", retranUL=" + retranUL +
                ", retranDN=" + retranDN +
                ", transDelay=" + transDelay +
                '}';
    }

    public Zebra() {
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getCellid() {
        return cellid;
    }

    public void setCellid(String cellid) {
        this.cellid = cellid;
    }

    public int getAppType() {
        return appType;
    }

    public void setAppType(int appType) {
        this.appType = appType;
    }

    public int getAppSubtype() {
        return appSubtype;
    }

    public void setAppSubtype(int appSubtype) {
        this.appSubtype = appSubtype;
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

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
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

    public long getRetranDN() {
        return retranDN;
    }

    public void setRetranDN(long retranDN) {
        this.retranDN = retranDN;
    }

    public long getTransDelay() {
        return transDelay;
    }

    public void setTransDelay(long transDelay) {
        this.transDelay = transDelay;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(reportTime);
        dataOutput.writeUTF(cellid);
        dataOutput.writeUTF(userIP);
        dataOutput.writeUTF(appServerIP);
        dataOutput.writeUTF(host);
        dataOutput.writeInt(appServerPort);
        dataOutput.writeInt(userPort);
        dataOutput.writeInt(appType);
        dataOutput.writeInt(appSubtype);
        dataOutput.writeInt(attempts);
        dataOutput.writeLong(retranDN);
        dataOutput.writeLong(retranUL);
        dataOutput.writeLong(trafficDL);
        dataOutput.writeLong(trafficUL);
        dataOutput.writeLong(transDelay);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.reportTime = dataInput.readUTF();
        this.cellid = dataInput.readUTF();
        this.userIP = dataInput.readUTF();
        this.appServerIP = dataInput.readUTF();
        this.host = dataInput.readUTF();
        this.appServerPort = dataInput.readInt();
        this.userPort = dataInput.readInt();
        this.appType = dataInput.readInt();
        this.appSubtype = dataInput.readInt();
        this.attempts = dataInput.readInt();
        this.retranDN = dataInput.readLong();
        this.retranUL = dataInput.readLong();
        this.trafficDL = dataInput.readLong();
        this.trafficUL = dataInput.readLong();
        this.transDelay = dataInput.readLong();
    }
}
