package com.example.rros;


public class RR {
    private int[] arrival_time;
    private int[]processId;
    private int[]brustTime;
    private int	quantum;
    int n;
    int[] WaitingTime;
    int [] TurnAroundTime;
    int[] completion_time;
    String s;
    int[] WeightedTurnaroundTime;
    int[] WeightedWaitingTime;
    public RR( int[] processid,int[] arrival_time, int[] brusttime, int quantum) {
        super();
        this.arrival_time = arrival_time;
        this.processId = processid;
        this.brustTime = brusttime;
        this.quantum = quantum;
        this.n = processid.length;

        this.WaitingTime=new int[n];
        this.TurnAroundTime= new int[n];
        this.completion_time= new int[n];

        this.WeightedTurnaroundTime= new int[this.n];
        this.WeightedWaitingTime = new int[this.n];
        findCompletionTime();
        findTurnAroundTime();
        findAvgTime();
    }
    public String getS() {
        return s;
    }
    public void setS(String s) {
        this.s = s;
    }
    public int[] getArrival_time() {
        return arrival_time;
    }
    public void setArrival_time(int[] arrival_time) {
        this.arrival_time = arrival_time;
    }
    public int[] getProcessId() {
        return processId;
    }
    public void setProcessId(int[] processid) {
        this.processId = processid;
    }
    public int[] getBrustTime() {
        return brustTime;
    }
    public void setBrustTime(int[] brusttime) {
        this.brustTime = brusttime;
    }
    public int getQuantum() {
        return quantum;
    }
    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    void findCompletionTime(){

        int rem_time[] = new int[this.n];

        for(int i=0;i<this.n;i++){
            rem_time[i]= this.brustTime[i];
        }
        int t=0;
        int arrival=0;
        // processing until the value of element of rem_time array is 0
        while(true){
//           ;
            boolean done = true;
            for(int i=0;i<n;i++){
                if(rem_time[i]>0){
                    done =false;
                    if(rem_time[i]>this.quantum && this.arrival_time[i]<=arrival){
                        t +=this.quantum;
                        rem_time[i]-=this.quantum;
                        arrival++;
                    }
                    else{
                        if(this.arrival_time[i]<=arrival){
                            arrival++;
                            t+=rem_time[i];
                            rem_time[i]=0;
                            this.completion_time[i]=t; }
                    }
                }
            }

            if(done==true)
            {
                break;
            }
        }
    }
    void findTurnAroundTime(){
        for(int i=0;i<n;i++){
            this.TurnAroundTime[i]= this.completion_time[i]-this.arrival_time[i];
            this.WaitingTime[i] = this.TurnAroundTime[i]-this.brustTime[i];


        }

    }
    void findAvgTime(){

        int total_wt = 0, total_tat = 0;

        this.s="Processes " +" \tArrival Time"+ " \t Burst time "+"  \tcompletion time"+
                " \tTurn Around Time " + "\t Waiting time\t(WTT)  \t\t(WWT)";
        for (int i=0; i<n; i++)
        {
            total_wt = total_wt + this.WaitingTime[i];
            total_tat = total_tat + this.TurnAroundTime[i];
            this.WeightedTurnaroundTime[i]=  this.TurnAroundTime[i] / this.completion_time[i];
            this.WeightedWaitingTime[i]= this.WaitingTime[i] / this.completion_time[i];
            this.s+=" " + this.processId[i] + "\t\t"+ this.arrival_time[i]+"\t\t"+ + this.brustTime[i] +"\t " +this.completion_time[i]+"\t\t"
                    +this.TurnAroundTime[i] +"\t\t " + this.WaitingTime[i]+"\t\t"+this.WeightedTurnaroundTime+"\t"+this.WeightedWaitingTime+"\n";
        }

        this.s+="Average waiting time = " +
                (float)total_wt / (float)n+"\n";
        this.s+="Average turn around time = " +
                (float)total_tat / (float)n;
        this.setS(s);
    }
    @Override
    public String toString() {
        return "RR [" + getS() + "]";
    }


}
