package de.kaimon.schoolproject.simon.cheesechampiongui;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.linear.Queue;
import de.kaimon.schoolproject.implementations.datenstrukturklassen.linear.Stack;

public class CheeseChampion {

    private Queue<Mouse> input;
    private Queue<Mouse> output;
    private final Stack<Mouse> press;
    private final GUI gui = new GUI();

    public CheeseChampion() {
        input = new Queue<>();
        output = new Queue<>();
        press = new Stack<>();
    }

    public void insertMouse(Mouse mouse) {
        input.enqueue(mouse);
    }

    public void playSimulation() {
        while (!input.isEmpty() || !press.isEmpty()) {
            if (!input.isEmpty()) {
                sendNextMouse();
            } else if (!press.isEmpty()) {
                output.enqueue(press.top());
                press.pop();
            }
        }
    }

    public void printInput() {
        Queue<Mouse> temp = new Queue<>();
        System.out.println("------------------");
        while (!input.isEmpty()) {
            System.out.println(input.front().toString());
            temp.enqueue(input.front());
            input.dequeue();
        }
        input = temp;
    }

    public void printOutput() {
        Queue<Mouse> temp = new Queue<>();
        System.out.println("------------------");
        while (!output.isEmpty()) {
            System.out.println(output.front().toString());
            temp.enqueue(output.front());
            output.dequeue();
        }
        output = temp;
    }

    private void sendNextMouse() {
        if (!press.isEmpty()) {
            // Abfrage, wer den fight gewonnen hat
            if (input.front().getStrenght() > press.top().getStrenght()) {
                // Maus in den press Gang hinzufügen
                press.push(input.front());
                input.dequeue();
            } else {
                // press Maus in den cheese Gang setzen
                output.enqueue(press.top());
                press.pop();
            }
        } else {
            // Maus in den press Gang setzen
            press.push(input.front());
            input.dequeue();
        }
    }

    public GUI getGui() {
        return gui;
    }

    public Queue<Mouse> getOutput() {
        return output;
    }

    public Queue<Mouse> getInput() {
        return input;
    }

    public Stack<Mouse> getPress() {
        return press;
    }

    public void setOutput(Queue<Mouse> output) {
        this.output = output;
    }

    public void setInput(Queue<Mouse> input) {
        this.input = input;
    }
}
