package module4;

class MyClass extends Thread {
    
    public void run() {
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();

        System.out.println("Name is: " + name);
        System.out.println("Id is: " + id);
    }
}

public class MultithreadingDemo {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.println("Creating a thread");
            MyClass obj = new MyClass();
            obj.start(); //will automatically call the run() method
        }
        
    }

}
