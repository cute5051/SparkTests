package model;

public class SparkMetricModel {
    private long stageId;
    private long executorDeserializeTime;
    private long executorDeserializeCpuTime;
    private long executorRunTime;
    private long executorCpuTime;
    private long resultSize;
    private long jvmGCTime;
    private long resultSerializationTime;
    private long memoryBytesSpilled;
    private long diskBytesSpilled;
    private long peakExecutionMemory;
    private long shuffleReadRemoteBlocksFetched;
    private long shuffleReadLocalBlocksFetched;
    private long shuffleReadRemoteBytesRead;
    private long shuffleReadRemoteBytesReadToDisk;
    private long shuffleReadLocalBytesRead;
    private long shuffleReadFetchWaitTime;
    private long shuffleReadRecordsRead;
    private long shuffleWriteBytesWritten;
    private long shuffleWriteRecordsWritten;
    private long shuffleWriteWriteTime;
    private long inputBytesRead;
    private long inputRecordsRead;
    private long outputBytesWritten;
    private long outputRecordsWritten;

    public SparkMetricModel() {
    }

    public SparkMetricModel(long stageId, long executorDeserializeTime, long executorDeserializeCpuTime, long executorRunTime, long executorCpuTime, long resultSize, long jvmGCTime, long resultSerializationTime, long memoryBytesSpilled, long diskBytesSpilled, long peakExecutionMemory, long shuffleReadRemoteBlocksFetched, long shuffleReadLocalBlocksFetched, long shuffleReadRemoteBytesRead, long shuffleReadRemoteBytesReadToDisk, long shuffleReadLocalBytesRead, long shuffleReadFetchWaitTime, long shuffleReadRecordsRead, long shuffleWriteBytesWritten, long shuffleWriteRecordsWritten, long shuffleWriteWriteTime, long inputBytesRead, long inputRecordsRead, long outputBytesWritten, long outputRecordsWritten) {
        this.stageId = stageId;
        this.executorDeserializeTime = executorDeserializeTime;
        this.executorDeserializeCpuTime = executorDeserializeCpuTime;
        this.executorRunTime = executorRunTime;
        this.executorCpuTime = executorCpuTime;
        this.resultSize = resultSize;
        this.jvmGCTime = jvmGCTime;
        this.resultSerializationTime = resultSerializationTime;
        this.memoryBytesSpilled = memoryBytesSpilled;
        this.diskBytesSpilled = diskBytesSpilled;
        this.peakExecutionMemory = peakExecutionMemory;
        this.shuffleReadRemoteBlocksFetched = shuffleReadRemoteBlocksFetched;
        this.shuffleReadLocalBlocksFetched = shuffleReadLocalBlocksFetched;
        this.shuffleReadRemoteBytesRead = shuffleReadRemoteBytesRead;
        this.shuffleReadRemoteBytesReadToDisk = shuffleReadRemoteBytesReadToDisk;
        this.shuffleReadLocalBytesRead = shuffleReadLocalBytesRead;
        this.shuffleReadFetchWaitTime = shuffleReadFetchWaitTime;
        this.shuffleReadRecordsRead = shuffleReadRecordsRead;
        this.shuffleWriteBytesWritten = shuffleWriteBytesWritten;
        this.shuffleWriteRecordsWritten = shuffleWriteRecordsWritten;
        this.shuffleWriteWriteTime = shuffleWriteWriteTime;
        this.inputBytesRead = inputBytesRead;
        this.inputRecordsRead = inputRecordsRead;
        this.outputBytesWritten = outputBytesWritten;
        this.outputRecordsWritten = outputRecordsWritten;
    }

    public long getStageId() {
        return stageId;
    }

    public void setStageId(long stageId) {
        this.stageId = stageId;
    }

    public long getExecutorDeserializeTime() {
        return executorDeserializeTime;
    }

    public void setExecutorDeserializeTime(long executorDeserializeTime) {
        this.executorDeserializeTime = executorDeserializeTime;
    }

    public long getExecutorDeserializeCpuTime() {
        return executorDeserializeCpuTime;
    }

    public void setExecutorDeserializeCpuTime(long executorDeserializeCpuTime) {
        this.executorDeserializeCpuTime = executorDeserializeCpuTime;
    }

    public long getExecutorRunTime() {
        return executorRunTime;
    }

    public void setExecutorRunTime(long executorRunTime) {
        this.executorRunTime = executorRunTime;
    }

    public long getExecutorCpuTime() {
        return executorCpuTime;
    }

    public void setExecutorCpuTime(long executorCpuTime) {
        this.executorCpuTime = executorCpuTime;
    }

    public long getResultSize() {
        return resultSize;
    }

    public void setResultSize(long resultSize) {
        this.resultSize = resultSize;
    }

    public long getJvmGCTime() {
        return jvmGCTime;
    }

    public void setJvmGCTime(long jvmGCTime) {
        this.jvmGCTime = jvmGCTime;
    }

    public long getResultSerializationTime() {
        return resultSerializationTime;
    }

    public void setResultSerializationTime(long resultSerializationTime) {
        this.resultSerializationTime = resultSerializationTime;
    }

    public long getMemoryBytesSpilled() {
        return memoryBytesSpilled;
    }

    public void setMemoryBytesSpilled(long memoryBytesSpilled) {
        this.memoryBytesSpilled = memoryBytesSpilled;
    }

    public long getDiskBytesSpilled() {
        return diskBytesSpilled;
    }

    public void setDiskBytesSpilled(long diskBytesSpilled) {
        this.diskBytesSpilled = diskBytesSpilled;
    }

    public long getPeakExecutionMemory() {
        return peakExecutionMemory;
    }

    public void setPeakExecutionMemory(long peakExecutionMemory) {
        this.peakExecutionMemory = peakExecutionMemory;
    }

    public long getShuffleReadRemoteBlocksFetched() {
        return shuffleReadRemoteBlocksFetched;
    }

    public void setShuffleReadRemoteBlocksFetched(long shuffleReadRemoteBlocksFetched) {
        this.shuffleReadRemoteBlocksFetched = shuffleReadRemoteBlocksFetched;
    }

    public long getShuffleReadLocalBlocksFetched() {
        return shuffleReadLocalBlocksFetched;
    }

    public void setShuffleReadLocalBlocksFetched(long shuffleReadLocalBlocksFetched) {
        this.shuffleReadLocalBlocksFetched = shuffleReadLocalBlocksFetched;
    }

    public long getShuffleReadRemoteBytesRead() {
        return shuffleReadRemoteBytesRead;
    }

    public void setShuffleReadRemoteBytesRead(long shuffleReadRemoteBytesRead) {
        this.shuffleReadRemoteBytesRead = shuffleReadRemoteBytesRead;
    }

    public long getShuffleReadRemoteBytesReadToDisk() {
        return shuffleReadRemoteBytesReadToDisk;
    }

    public void setShuffleReadRemoteBytesReadToDisk(long shuffleReadRemoteBytesReadToDisk) {
        this.shuffleReadRemoteBytesReadToDisk = shuffleReadRemoteBytesReadToDisk;
    }

    public long getShuffleReadLocalBytesRead() {
        return shuffleReadLocalBytesRead;
    }

    public void setShuffleReadLocalBytesRead(long shuffleReadLocalBytesRead) {
        this.shuffleReadLocalBytesRead = shuffleReadLocalBytesRead;
    }

    public long getShuffleReadFetchWaitTime() {
        return shuffleReadFetchWaitTime;
    }

    public void setShuffleReadFetchWaitTime(long shuffleReadFetchWaitTime) {
        this.shuffleReadFetchWaitTime = shuffleReadFetchWaitTime;
    }

    public long getShuffleReadRecordsRead() {
        return shuffleReadRecordsRead;
    }

    public void setShuffleReadRecordsRead(long shuffleReadRecordsRead) {
        this.shuffleReadRecordsRead = shuffleReadRecordsRead;
    }

    public long getShuffleWriteBytesWritten() {
        return shuffleWriteBytesWritten;
    }

    public void setShuffleWriteBytesWritten(long shuffleWriteBytesWritten) {
        this.shuffleWriteBytesWritten = shuffleWriteBytesWritten;
    }

    public long getShuffleWriteRecordsWritten() {
        return shuffleWriteRecordsWritten;
    }

    public void setShuffleWriteRecordsWritten(long shuffleWriteRecordsWritten) {
        this.shuffleWriteRecordsWritten = shuffleWriteRecordsWritten;
    }

    public long getShuffleWriteWriteTime() {
        return shuffleWriteWriteTime;
    }

    public void setShuffleWriteWriteTime(long shuffleWriteWriteTime) {
        this.shuffleWriteWriteTime = shuffleWriteWriteTime;
    }

    public long getInputBytesRead() {
        return inputBytesRead;
    }

    public void setInputBytesRead(long inputBytesRead) {
        this.inputBytesRead = inputBytesRead;
    }

    public long getInputRecordsRead() {
        return inputRecordsRead;
    }

    public void setInputRecordsRead(long inputRecordsRead) {
        this.inputRecordsRead = inputRecordsRead;
    }

    public long getOutputBytesWritten() {
        return outputBytesWritten;
    }

    public void setOutputBytesWritten(long outputBytesWritten) {
        this.outputBytesWritten = outputBytesWritten;
    }

    public long getOutputRecordsWritten() {
        return outputRecordsWritten;
    }

    public void setOutputRecordsWritten(long outputRecordsWritten) {
        this.outputRecordsWritten = outputRecordsWritten;
    }

    @Override
    public String toString() {
        return "SparkMetricModel{" +
                "stageId=" + stageId +
                ", executorDeserializeTime=" + executorDeserializeTime +
                ", executorDeserializeCpuTime=" + executorDeserializeCpuTime +
                ", executorRunTime=" + executorRunTime +
                ", executorCpuTime=" + executorCpuTime +
                ", resultSize=" + resultSize +
                ", jvmGCTime=" + jvmGCTime +
                ", resultSerializationTime=" + resultSerializationTime +
                ", memoryBytesSpilled=" + memoryBytesSpilled +
                ", diskBytesSpilled=" + diskBytesSpilled +
                ", peakExecutionMemory=" + peakExecutionMemory +
                ", shuffleReadRemoteBlocksFetched=" + shuffleReadRemoteBlocksFetched +
                ", shuffleReadLocalBlocksFetched=" + shuffleReadLocalBlocksFetched +
                ", shuffleReadRemoteBytesRead=" + shuffleReadRemoteBytesRead +
                ", shuffleReadRemoteBytesReadToDisk=" + shuffleReadRemoteBytesReadToDisk +
                ", shuffleReadLocalBytesRead=" + shuffleReadLocalBytesRead +
                ", shuffleReadFetchWaitTime=" + shuffleReadFetchWaitTime +
                ", shuffleReadRecordsRead=" + shuffleReadRecordsRead +
                ", shuffleWriteBytesWritten=" + shuffleWriteBytesWritten +
                ", shuffleWriteRecordsWritten=" + shuffleWriteRecordsWritten +
                ", shuffleWriteWriteTime=" + shuffleWriteWriteTime +
                ", inputBytesRead=" + inputBytesRead +
                ", inputRecordsRead=" + inputRecordsRead +
                ", outputBytesWritten=" + outputBytesWritten +
                ", outputRecordsWritten=" + outputRecordsWritten +
                '}';
    }

    public static String toFieldNames() {
        return "stageId,executorDeserializeTime,executorDeserializeCpuTime,executorRunTime,executorCpuTime,resultSize,jvmGCTime,resultSerializationTime,memoryBytesSpilled,diskBytesSpilled,peakExecutionMemory,shuffleReadRemoteBlocksFetched,shuffleReadLocalBlocksFetched,shuffleReadRemoteBytesRead,shuffleReadRemoteBytesReadToDisk,shuffleReadLocalBytesRead,shuffleReadFetchWaitTime,shuffleReadRecordsRead,shuffleWriteBytesWritten,shuffleWriteRecordsWritten,shuffleWriteWriteTime,inputBytesRead,inputRecordsRead,outputBytesWritten,outputRecordsWritten";
    }

    public String toValueInObj() {
        return stageId+","+executorDeserializeTime+","+executorDeserializeCpuTime+","+executorRunTime+","+executorCpuTime+","+resultSize+","+jvmGCTime+","+resultSerializationTime+","+memoryBytesSpilled+","+diskBytesSpilled+","+peakExecutionMemory+","+shuffleReadRemoteBlocksFetched+","+shuffleReadLocalBlocksFetched+","+shuffleReadRemoteBytesRead+","+shuffleReadRemoteBytesReadToDisk+","+shuffleReadLocalBytesRead+","+shuffleReadFetchWaitTime+","+shuffleReadRecordsRead+","+shuffleWriteBytesWritten+","+shuffleWriteRecordsWritten+","+shuffleWriteWriteTime+","+inputBytesRead+","+inputRecordsRead+","+outputBytesWritten+","+outputRecordsWritten;
    }
    
}
