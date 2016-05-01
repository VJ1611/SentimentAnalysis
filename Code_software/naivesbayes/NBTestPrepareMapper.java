package naivebayes;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class NBTestPrepareMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws InterruptedException, IOException {
        
        String valuestr = value.toString();
        if (valuestr.contains(",")) { // this is a model line
            String [] a = valuestr.split("\\s");
            context.write(new Text(a[0]), new Text(a[1]));
        } else if (valuestr.contains(":")) { // this is a review line
            String[] doc = valuestr.split(" ");
            String truelabel = doc[0].replaceAll(":", "");
            String id = doc[1].replaceAll(":", "");
        
            for (int i = 2; i < doc.length; i++) { 
                String word=doc[i].trim();
                if (!word.isEmpty()){
                    String outstr="1:"+id+truelabel;
                    context.write(new Text(word), new Text(outstr));
                }
            }
        }// else if
    }//map
}
