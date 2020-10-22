package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Core {
    ArrayList<Process> arrProcess = new ArrayList<>();
    Random rand = new Random();
    private final int time = 8;

    public void printListProcesses() {
        for (int i = 0; i < arrProcess.size(); i++) {
            System.out.println("Процесс " + arrProcess.get(i).getpID());
            for (int j = 0; j < arrProcess.get(i).getArrThread().size(); j++) {
                System.out.println("   Поток " + arrProcess.get(i).getArrThread().get(j).getID() + " время: " + arrProcess.get(i).getArrThread().get(j).getNecessaryTime());
            }
        }
        System.out.println("\n\n\n");
    }

    public void createProcesses() {
        for (int i = 0; i < 3 + rand.nextInt(10); i++) {
            arrProcess.add(new Process(i));
            arrProcess.get(i).createThreads();
        }
    }

public void start(){
    createProcesses();
    printListProcesses();
Process process = new Process();
process.planProcess(arrProcess);
}


}