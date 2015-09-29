package com.datafinances.sort;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by vagrant on 2015/9/29.
 */
public class SortReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        StringBuilder csv = new StringBuilder(16);
        for (Text value : values) {
            if (csv.length() > 0) csv.append(",");
            csv.append(value.toString());
        }
        String result = csv.toString();
        context.write(key, new Text(result));
    }

}
