package ds.lambdas;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Predicate;

public class Test {

    static class Person {
        private String firstName, lastName;
        private int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    '}';
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    static void print(List<Person> persons, Predicate<Person> valid) {
        for (Person person : persons) {
            if (valid.test(person)) {
                System.out.println(person);
            }
        }

    }

    interface Process {
        void process(int i);
    }

    public static void doProcess(int i, Process process) {
        process.process(i);
    }


    public static void main(String[] args) throws Exception {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                throw new RuntimeException("laude lag gaye");

            }
        }, 0, 1000);

        Thread.sleep(1000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {


            }
        }, 0, 1000);

        timer.wait();





    }

}
