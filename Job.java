import java.util.Arrays;

public class Job {
    public String jobType;
    public String submitTime;
    public String jobId;
    public String estRuntime;
    public String core;
    public String memory;
    public String disk;

    public Job(String entery) {
        String[] tempHold = entery.split(" ");
        jobType = tempHold[0];
        // System.out.println(Arrays.toString(tempHold));
        // System.out.println("there is literally nothing here?");
        // System.out.println(jobType + "+" + "JOBN" + "=" + (jobType.equals("JOBN")));
        if (jobType.equals("JOBN")) {
            submitTime = tempHold[1];
            jobId = tempHold[2];
            estRuntime = tempHold[3];
            core = tempHold[4];
            memory = tempHold[5];
            disk = tempHold[6];

        }

    }

}

// JOBN submitTime jobID estRuntime core memory disk
// JOBP submitTime jobID estRuntime core memory disk
// JCPL endTime jobID serverType serverID
// RESF serverType serverID timeOfFailure
// RESR serverType serverID timeOfRecovery
// CHKQ - indicate no new jobs, but some in the queue
// NONE