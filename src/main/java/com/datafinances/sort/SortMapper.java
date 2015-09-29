package com.datafinances.sort;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by vagrant on 2015/9/29.
 */
public class SortMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Iterable<String> split = Splitter.on(',').limit(2).split(value.toString());

        context.write(new Text(Iterables.getLast(split)), new Text(Iterables.getFirst(split, "")));
    }

}
