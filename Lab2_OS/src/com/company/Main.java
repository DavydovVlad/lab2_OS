package com.company;

public class Main {

    public static void main(String[] args) {
        Core core = new Core();
        core.createProcesses();
        core.printListProcesses();
        core.planProcess();
    }
}
