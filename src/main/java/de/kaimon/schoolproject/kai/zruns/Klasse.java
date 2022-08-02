package de.kaimon.schoolproject.kai.zruns;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.linear.List;
import de.kaimon.schoolproject.implementations.datenstrukturklassen.linear.Queue;
import de.kaimon.schoolproject.implementations.datenstrukturklassen.linear.Stack;

class Klasse{
    List<Integer> list;
    Queue<Integer> queue;
    Stack<Integer> stack;
    Integer[] array;
    //standard Befullung: 15, 8, 23, 16, 29, 9, 24.

    public Klasse(){
        //Datentypen implementieren
        list = new List<Integer>();
        queue = new Queue<Integer>();
        stack = new Stack<Integer>();
        array = new Integer[7];
        array[0] = 15;
        array[1] = 8;
        array[2] = 23;
        array[3] = 16;
        array[4] = 29;
        array[5] = 9;
        array[6] = 24;
        //Alle Datentypen reihenweise befullen
        for (int i = 0; i < array.length; i++){
            list.append(array[i]);
            queue.enqueue(array[i]);
            stack.push(array[i]);
        }
    }

    /*
     * Sortiert die Queue, indem sie ein Array als Hilfs-Speicher verwendet.
     * Methode funktioniert. 08.05.22., 21:43 Uhr
     */
    public void sortList(){
        List tempList = new List<Integer>();
        list.toFirst();
        while(list.isEmpty() == false){
            list.toFirst();
            Integer min = list.getContent();
            while(list.hasAccess() == true){
                if(list.getContent() < min){
                    min = list.getContent();
                }
                list.next();
            }
            list.toFirst();
            while(min != list.getContent()){
                list.next();
            }
            tempList.append(min);
            list.remove();
        }
        list = tempList;
        tempList = null;
    }

    /*
     * Sortiert die Queue, indem sie ein Array als Hilfs-Speicher verwendet.
     * Methode funktioniert. 08.05.22., 20:38 Uhr
     */
    public void sortQueue(){
        Queue tempQueue = new Queue<Integer>();
        int queueLength = 1;
        // Anzahl der Elemente ermitteln
        int temp = queue.front();
        queue.enqueue(queue.front());
        queue.dequeue();
        while(queue.front() != temp){
            queue.enqueue(queue.front());
            queue.dequeue();
            queueLength++;
        }
        //es wird so oft gesucht, bis alles Elemente sortiert worden sind
        for (int i = 0; i < queueLength; i++){
            //Kleinstes Element ermitteln:
            int min = queue.front();
            //Queue auf kleinstes Element durchsuchen
            for (int e = 0; e < queueLength -i; e++){
                if(queue.front() < min){
                    min = queue.front();
                }
                queue.enqueue(queue.front());
                queue.dequeue();
            }
            //Kleinstes Element loeschen
            while(queue.front() != min){
                queue.enqueue(queue.front());
                queue.dequeue();
            }
            queue.dequeue();
            tempQueue.enqueue(min);
        }
        queue = tempQueue;
        System.out.println("sortQueue succeed");
    }

    /*
     * Sortiert die Queue, indem sie den Array als Hilfe verwendet.
     * Methode funktioniert. 08.05.22., 20:38 Uhr
     */
    public void sortQueueByArray(){
        //Anzahl Elemente ermitteln
        int queueLength = 1;
        int temp = queue.front();
        queue.enqueue(queue.front());
        queue.dequeue();
        while(queue.front() != temp){
            queue.enqueue(queue.front());
            queue.dequeue();
            queueLength++;
        }
        int[] array = new int[queueLength];
        //Alle Werte in den Array schieben
        for (int i = 0; i < queueLength; i++){
            array[i] = queue.front();
            queue.dequeue();
        }
        //array sortieren
        for(int i = 0; i < queueLength-1; i++){
            for(int e = 0; e < queueLength-2; e++){
                if(array[e] > array[e+1]){
                    int temp2 = array[e];
                    array[e] = array[e+1];
                    array[e+1] = temp2;
                }
            }
        }
        //alles zurueck in die Queue schieben
        for(int i = 0; i < queueLength; i++){
            queue.enqueue(array[i]);
        }
        System.out.println("sortQueue succeed");
    }

    public void sortStack(){

    }

    public void sucheInList(Integer pInt){
        list.toFirst();
        boolean ampel = false;
        while (list.hasAccess() == true){
            if (list.getContent() == pInt){
                ampel = true;
            }
            list.next();
        }
        System.out.println("Anfrage: List auf - " + pInt + " - durchsuchen. Ergebnis: " + ampel);
        System.out.println(" ");
    }

    public void sucheInQueue(Integer pInt){
        Integer temp = new Integer(queue.front());
        queue.enqueue(queue.front());
        queue.dequeue();
        while(temp != queue.front()){

        }
    }

    public void sucheInStack(Integer pInt){

    }

    public void printList(){
        System.out.println("Liste");
        list.toFirst();
        while(list.hasAccess() == true){
            System.out.println(list.getContent());
            list.next();
        }
        System.out.println("");
    }

    public void printQueue(){
        if (queue.isEmpty() == false){
            System.out.println("Queue");
            Queue lokalQueue = new Queue<Integer>();
            lokalQueue = queue;
            while(lokalQueue.isEmpty() == false){
                System.out.println(lokalQueue.front() + " " + queue.front());
                lokalQueue.dequeue();
            }
            System.out.println("");
        }else{
            System.out.println("ich bin leer du Idiot");
        }
    }

    public void printStack(){
        System.out.println("Stack");
        Stack localStack = new Stack<Integer>();
        localStack = stack;
        while (localStack.isEmpty() == false){
            System.out.println(localStack.top());
            localStack.pop();
        }
        System.out.println("");
    }
}