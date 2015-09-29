package com.datafinances.sort;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by vagrant on 2015/9/29.
 */
public class AverageByAttributeCombiner extends Reducer<Text, Text, Text, Text> {
    @Override
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        double sum = 0;
        int count = 0;
        for (Text value : values) {
            String fields[] = value.toString().split(",");
            sum += Double.parseDouble(fields[0]);
            count += Integer.parseInt(fields[1]);
        }
        context.write(key, new Text(sum + "," + count));
    }
}
