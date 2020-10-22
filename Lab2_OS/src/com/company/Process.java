package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Process {
    private int pID;
    private int sumTime = 0;

    private ArrayList<Thread> arrThread = new ArrayList<>();

    private Random rand = new Random();

    public Process(int pID) {
        this.pID = pID;
    }
 public Process(){

 }
    public int getpID() {
        return pID;
    }

    public ArrayList<Thread> getArrThread() {
        return arrThread;
    }

    public void createThreads() {
        for (int i = 0; i < 1 + rand.nextInt(10); i++) {
            int nesTime = 1 + rand.nextInt(10);
            arrThread.add(new Thread(i, nesTime));
            sumTime += nesTime;
        }
    }

    private final int time = 8;
    public void planProcess(ArrayList<Process> arrProcess) {
        while (!arrProcess.isEmpty()) {
            for (int i = 0; i < arrProcess.size(); i++) {

                for (int j = 0; j < arrProcess.get(i).getArrThread().size(); j++) {
                    int threadId = arrProcess.get(i).getArrThread().get(j).getID();
                    int processId = arrProcess.get(i).getpID();
                    int threadTime = arrProcess.get(i).getArrThread().get(j).getNecessaryTime();
                    System.out.println("Поток " + threadId + " процесса " + processId + " начал выполнение");
                    if (threadTime - time > 0) {
                        arrProcess.get(i).getArrThread().get(j).changeNecessaryTime(time);
                        System.out.println("Поток " + threadId + " процесса " + processId + " прерван; требуемое время: " + threadTime + "; выделяемое время: " + time + "; оставшееся время: " + (threadTime - time));
                    }
                    if (threadTime - time <= 0) {
                        arrProcess.get(i).getArrThread().get(j).threadDone();
                        arrProcess.get(i).getArrThread().remove(j);
                        j--;
                    }
                }
                if (arrProcess.get(i).getArrThread().isEmpty()) {
                    arrProcess.get(i).processDone();
                    arrProcess.remove(i);
                    i--;
                }
            }
        }
    }

    public void processDone() {
        System.out.println("Процесс " + pID + " выполнился успешно за время " + sumTime);
    }
}
