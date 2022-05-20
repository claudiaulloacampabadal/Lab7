/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package domain;

import org.testng.annotations.Test;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class HeaderLinkedQueueNGTest {

    public HeaderLinkedQueueNGTest() {
    }
//
//    @Test
//    public void test() {
//        try {
//            HeaderLinkedQueue queue = new HeaderLinkedQueue();
//            queue.enQueue(10);
//            queue.enQueue(20);
//            queue.enQueue(30);
//            queue.enQueue(50);
//            queue.enQueue(80);
//            queue.enQueue(70);
//            queue.enQueue(90);
//            queue.enQueue(2);
//            System.out.println("Header Linked queue front element: "
//                    +queue.front());
//            System.out.println("Header Linked queue size: "+queue.size());
//            System.out.println(queue.toString());
//            System.out.println("DEQUEUE? "+queue.deQueue());
//            System.out.println("DEQUEUE? "+queue.deQueue());
//            System.out.println("Contains 50? " +queue.contains(50)+", indexOf: "+queue.indexOf(50));
//            System.out.println("Contains 17? " +queue.contains(17)+", indexOf: "+queue.indexOf(17));
//            System.out.println("Header Linked queue size: "+queue.size());            
//            System.out.println(queue.toString());
//
//            
//        } catch (QueueException ex) {
//            Logger.getLogger(ArrayQueueNGTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    //Cree e instancie tres nuevos objetos tipo HeaderLinkedQueue: q1, q2, q3: listo
    public HeaderLinkedQueue q1 = new HeaderLinkedQueue();
    public HeaderLinkedQueue q2 = new HeaderLinkedQueue();
    public HeaderLinkedQueue q3 = new HeaderLinkedQueue();

    @Test
    public void testSomeMethod() throws QueueException {

//        Encole 10 objetos tipo Climate (Place (SJ, Cartago, Limón, Guanacaste),Weather (sunny, rainy, thunderstorm, cloudy)) en q1: listo
        q1.enQueue(new Climate(new Place("san jose"), new Weather("sunny")));
        q1.enQueue(new Climate(new Place("cartago"), new Weather("rainy")));
        q1.enQueue(new Climate(new Place("limón"), new Weather("thunderstorm")));
        q1.enQueue(new Climate(new Place("alajuela"), new Weather("cloudy")));
        q1.enQueue(new Climate(new Place("alajuela"), new Weather("sunny")));
        q1.enQueue(new Climate(new Place("limón"), new Weather("rainy")));
        q1.enQueue(new Climate(new Place("cartago"), new Weather("thunderstorm")));
        q1.enQueue(new Climate(new Place("san jose"), new Weather("cloudy")));
        q1.enQueue(new Climate(new Place("cartago"), new Weather("sunny")));
        q1.enQueue(new Climate(new Place("alajuela"), new Weather("rainy")));
        q1.enQueue(new Climate(new Place("san jose"), new Weather("thunderstorm")));
        
        //en cola 1 quedaría al-cloudy, limón-rainy, sj-cloudy, al-rainy
        //en cola 2 sj-sunny, al-sunny, cart-sunny, limon-ts, sj-ts
        //en cola 3 cartago-rainy, cartago-ts, limon-ts, sj-ts

        //Muestre el contenido de la cola1 por consola: listo
        System.out.println("Cola 1: \n");
        System.out.println(q1.toString());

        HeaderLinkedQueue temp = new HeaderLinkedQueue();
        //Desencole todos los objetos con estado del tiempo “sunny” de q1 y encólelos en q2: listo
        while (!q1.isEmpty()) {
            Climate climate = (Climate) q1.peek();
            if ((climate.getWeather().getWeather().equals("sunny"))) {
                q1.deQueue();
                q2.enQueue(climate);
            } else {
                temp.enQueue(climate);
                q1.deQueue();
            }
        }
        while (!temp.isEmpty()) {
            q1.enQueue(temp.peek());
            temp.deQueue();
        }

        //Muestre el contenido de q1 y q2 por consola
        System.out.println("Desencolar sunny de la cola 1:\n" + q1.toString());
        System.out.println("Colar sunny en la cola 2:\n" + q2.toString());

        //Desencole todos los objetos pertenecientes al lugar “Cartago” de q1 y encólelos en q3
        while (!q1.isEmpty()) {
            Climate climate = (Climate) q1.peek();
            if ((climate.getPlace().getName().equals("cartago"))) {
                q1.deQueue();
                q3.enQueue(climate);
            } else {
                temp.enQueue(climate);
                q1.deQueue();
            }
        }
        while (!temp.isEmpty()) {
            q1.enQueue(temp.peek());
            temp.deQueue();
        }
        //Muestre el contenido de q1 y q3 por consola
        System.out.println("Desencolar Cartago de la cola 1:\n" + q1.toString());
        System.out.println("Colar Cartago en la cola 3:\n" + q3.toString());

        //Desencole todos los objetos con estado del tiempo “thunderstorm” de q1 y encólelos en q2 y q3
        while (!q1.isEmpty()) {
            Climate climate = (Climate) q1.peek();
            if ((climate.getWeather().getWeather().equals("thunderstorm"))) {
                q1.deQueue();
                q2.enQueue(climate);
                q3.enQueue(climate);
            } else {
                temp.enQueue(climate);
                q1.deQueue();
            }
        }
        while (!temp.isEmpty()) {
            q1.enQueue(temp.peek());
            temp.deQueue();

            //Muestre el contenido de q1, q2 y q3 por consola
            System.out.println("Mostrar todas las colas\n");
            System.out.println("Cola 1:\n" + q1.toString() + "\n");
            System.out.println("Cola 2:\n" + q2.toString() + "\n");
            System.out.println("Cola 3:\n" + q3.toString() + "\n");
        }

        
    }
    
}//END END 

