package ru.pas.javalearn;

public class WorkerInterfaceTest {

    @FunctionalInterface
    private interface WorkerInterface {
        void doSomeWork();

    }
    private static void execute(WorkerInterface worker) {
        worker.doSomeWork();
    }

    public static void main(String [] args) {

        execute( () -> System.out.println("Worker вызван через Lambda") );
    }

}
