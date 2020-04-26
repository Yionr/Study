package cloud.yionr.score;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.util.LineReader;

import java.io.IOException;
import java.net.URI;

public class AutoRecordReader extends RecordReader<Text,Text> {
    public AutoRecordReader() {
        super();
    }
    LineReader lineReader;
    Text key,value;

    @Override
    public void initialize(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        FileSplit s = (FileSplit) inputSplit;
        Path path = s.getPath();
        FileSystem fileSystem = FileSystem.get(URI.create(path.toString()), taskAttemptContext.getConfiguration());
        FSDataInputStream in = fileSystem.open(path);
        lineReader = new LineReader(in);
    }

    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {
        Text str = new Text();
        int i = lineReader.readLine(str);

        if (i == 0)
            return false;

        key = new Text();
        key.set(str.getBytes(),0,str.getLength());
        value = new Text();
        lineReader.readLine(str);
        value.set(str.getBytes(),0,str.getLength());
        Text seq = new Text(";");
        value.append(seq.getBytes(),0,seq.getLength());
        lineReader.readLine(str);
        value.append(str.getBytes(),0,str.getLength());

        return true;
    }

    @Override
    public Text getCurrentKey() throws IOException, InterruptedException {
        return key;
    }

    @Override
    public Text getCurrentValue() throws IOException, InterruptedException {
        return value;
    }

    @Override
    public float getProgress() throws IOException, InterruptedException {
        return 0;
    }

    @Override
    public void close() throws IOException {
        lineReader.close();
    }
}
