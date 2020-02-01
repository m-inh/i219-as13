import java.util.List;

/*
Name: NGUYEN, Minh Tien
ID  : 1810445
Time: 2020/02/01
*/

public class FReceiver1<E> extends Thread {
    private FMonitorBBuf1<E> buf;
    private List<E> msgs;
    private int nom;

    public FReceiver1(FMonitorBBuf1<E> buf, List<E> msgs, int nom) {
        this.buf = buf;
        this.msgs = msgs;
        this.nom = nom;
    }

    public void run() {
        for (int i = 0; i < nom; i++) {
            try {
                msgs.add(buf.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}