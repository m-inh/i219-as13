import java.util.ArrayList;
import java.util.List;

/*
Name: NGUYEN, Minh Tien
ID  : 1810445
Time: 2020/02/01
*/

public class FBBProb1 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> log = new ArrayList<Integer>();
        FMonitorBBuf1<Integer> buf = new FMonitorBBuf1<Integer>(2, log);
        List<Integer> msgsSent = new ArrayList<Integer>();

        for (int i = 0; i < 2; i++) msgsSent.add(i);

        List<Integer> msgsReceived = new ArrayList<Integer>();
        int nom = msgsSent.size() + msgsSent.size();

        FSender1<Integer> FSender1 = new FSender1<Integer>(buf, msgsSent);
        FReceiver1<Integer> FReceiver1 = new FReceiver1<Integer>(buf, msgsReceived, nom);

        FSender1.start();
        FReceiver1.start();
        FSender1.join();
        FReceiver1.join();

        System.out.println("msgsSent: " + msgsSent);
        System.out.println("msgsReceived: " + msgsReceived);
        if (msgsReceived.equals(msgsSent)) System.out.println("Success!");
        else System.out.println("Failure!");

        assert msgsReceived.equals(log);
    }
}