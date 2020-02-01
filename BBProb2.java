import java.util.ArrayList;
import java.util.List;

/*
Name: NGUYEN, Minh Tien
ID  : 1810445
Time: 2020/02/01
*/

public class BBProb2 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> log = new ArrayList<Integer>();
        MonitorBBuf2<Integer> buf = new MonitorBBuf2<Integer>(2, log);
        List<Integer> msgsSent = new ArrayList<Integer>();

        for (int i = 0; i < 2; i++) msgsSent.add(i);

        List<Integer> msgsReceived = new ArrayList<Integer>();
        int nom = msgsSent.size() + msgsSent.size();

        Sender2<Integer> Sender2 = new Sender2<Integer>(buf, msgsSent);
        Receiver2<Integer> Receiver2 = new Receiver2<Integer>(buf, msgsReceived, nom);

        Sender2.start();
        Receiver2.start();
        Sender2.join();
        Receiver2.join();

        System.out.println("msgsSent: " + msgsSent);
        System.out.println("msgsReceived: " + msgsReceived);
        if (msgsReceived.equals(msgsSent)) System.out.println("Success!");
        else System.out.println("Failure!");

        assert msgsReceived.equals(log);
    }
}