package naivebayes;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class NBTrainingMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws InterruptedException, IOException {

    	String[] doc = value.toString().split(" ");
        String label = doc[0];
        
        for (int i = 2; i < doc.length; i++) { 
        	String word=doc[i].trim();
        	if (!word.isEmpty()){
        		context.write(new Text(word), new Text("1"+label));
        	}
        }
    }
}
