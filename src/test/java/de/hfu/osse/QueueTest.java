package de.hfu.osse;

import static org.junit.Assert.*;

import org.junit.Test;


public class QueueTest {
    

    @Test
    public void shouldAnswerWithTrue(){
        Queue TestQueue = new Queue(3);
        TestQueue.enqueue(20);
        assertTrue(TestQueue.dequeue() == 20);
        TestQueue.enqueue(1);
        TestQueue.enqueue(2);
        TestQueue.enqueue(3);
        assertTrue(TestQueue.dequeue() == 1);
        assertTrue(TestQueue.dequeue() == 2);
        assertTrue(TestQueue.dequeue() == 3);
    }
    @Test
    public void shouldAnswerWithFalse(){
        Queue TestQueue = new Queue(3);
        TestQueue.enqueue(3);
        TestQueue.enqueue(2);
        TestQueue.enqueue(1);
        assertFalse(TestQueue.dequeue() == 1);
        TestQueue.enqueue(9);
        TestQueue.enqueue(8);
        TestQueue.dequeue();
        TestQueue.dequeue();
        assertFalse(TestQueue.dequeue()==9);
        TestQueue.enqueue(7);
        assertFalse(TestQueue.dequeue()==8);
    }
    @Test
    public void shouldThrowException(){
        try{
            Queue ExecQueue = new Queue(0);
            fail("Should've thrown Exec");

    }catch (Exception e){}
        try{
            Queue ExecQueue = new Queue(3);
            ExecQueue.dequeue();
            fail("Should've thrown Exec");
        }catch (Exception e){}
    }
}
