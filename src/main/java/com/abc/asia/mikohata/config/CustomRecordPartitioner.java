package com.abc.asia.mikohata.config;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

public class CustomRecordPartitioner implements Partitioner {

    private static final Logger log = LoggerFactory.getLogger(CustomRecordPartitioner.class);
    private int totalRecords;

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        log.info("partition totalRec : " + totalRecords);

        Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();

        // int range = 4;
        log.info("Grid Size " + gridSize);
        int noofrecsperthread = 1;
        if (noofrecsperthread == 0) noofrecsperthread = totalRecords;

        log.info("Number of records  " + totalRecords);
        log.info("Number of records per thread " + noofrecsperthread);

        int fromId = 0;
        int toId = 1;
        ExecutionContext value = new ExecutionContext();

        value.putInt("minValue", fromId);
        value.putInt("maxValue", toId);
        value.putString("name", "Thread1");
        result.put("partition" + 1, value);

        // if (noofrecsperthread == 0) toId = 0;
        /*for (int i = 1; i <= gridSize; i++) {

            ExecutionContext value = new ExecutionContext();

            log.info("Starting : Thread" + i);
            log.info("fromId : " + fromId);
            log.info("toId : " + toId);

            value.putInt("minValue", fromId);
            value.putInt("maxValue", toId);

            // give each thread a name, thread 1,2,3
            value.putString("name", "Thread" + i);

            result.put("partition" + i, value);
            log.info("Partition " + i + " from " + fromId + " to " + toId);
            fromId = toId + 1;
            toId = fromId + noofrecsperthread - 1;
        }*/

        return result;
    }

    public void setTotalRecords(int totalRec) {
        totalRecords = totalRec;
        log.info("setTotalRecords totalRec : " + totalRecords);
    }
}
