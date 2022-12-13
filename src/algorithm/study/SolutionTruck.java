package algorithm.study;

import java.util.*;

public class SolutionTruck {
    public static void main(String[] args) {
        int[] x = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(new SolutionTruck().solution(100, 100, x));
    }

    class Truck {
        int weight;
        int startTime;
        int curPosition;

        public Truck(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getCurPosition(int currentTime) {
            return currentTime - startTime;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int seconds = 0;
        int curWeight = 0;
        Queue<Truck> waitQ = new LinkedList();
        Queue<Truck> moveQ = new LinkedList();

        for (int trk_w : truck_weights) {
            waitQ.offer(new Truck(trk_w));
        }

        while (!moveQ.isEmpty() || !waitQ.isEmpty()) {
            seconds++;

            if (moveQ.isEmpty()) {
                Truck truck = waitQ.poll();
                truck.setStartTime(seconds);
                curWeight += truck.getWeight();
                moveQ.offer(truck);
                continue;
            }

            if (moveQ.peek().getCurPosition(seconds) == bridge_length) {
                curWeight -= moveQ.peek().getWeight();
                moveQ.poll();
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().getWeight() <= weight) {
                Truck truck = waitQ.poll();
                truck.setStartTime(seconds);
                curWeight += truck.getWeight();
                moveQ.offer(truck);
            }
        }
        return seconds;
    }
}