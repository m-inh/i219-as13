Name: NGUYEN, Minh Tien\
ID  : 1810445\
Time: 2020/01/30

## Assignment 13: Exercise 11

### 1. Running of SimpInc.java

```
➜  src javac SimpInc.java
➜  src jpf SimpInc.jpf

JavaPathfinder core system v8.0 (rev 31) - (C) 2005-2014 United States Government. All rights reserved.


====================================================== system under test
SimpInc.main()

====================================================== search started: 1/28/20 4:42 PM
count: 1

====================================================== error 1
gov.nasa.jpf.vm.NoUncaughtExceptionsProperty
java.lang.AssertionError
        at SimpInc.main(SimpInc.java:15)


====================================================== trace #1
------------------------------------------------------ transition #0 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"ROOT" ,1/1,isCascaded:false}
      [3157 insn w/o sources]
  SimpInc.java:1                 : public class SimpInc extends Thread {
      [2 insn w/o sources]
  SimpInc.java:1                 : public class SimpInc extends Thread {
  SimpInc.java:2                 : private static int count = 0;
  SimpInc.java:3                 : private static int count2 = 0;
  SimpInc.java:1                 : public class SimpInc extends Thread {
      [1 insn w/o sources]
  SimpInc.java:10                : Thread t = new SimpInc();
  SimpInc.java:1                 : public class SimpInc extends Thread {
      [145 insn w/o sources]
  SimpInc.java:1                 : public class SimpInc extends Thread {
  SimpInc.java:10                : Thread t = new SimpInc();
  SimpInc.java:11                : t.start();
      [1 insn w/o sources]
------------------------------------------------------ transition #1 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"START" ,1/2,isCascaded:false}
      [2 insn w/o sources]
  SimpInc.java:12                : count++;
  SimpInc.java:13                : t.join();
      [1 insn w/o sources]
------------------------------------------------------ transition #2 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"JOIN" ,1/1,isCascaded:false}
      [1 insn w/o sources]
  SimpInc.java:1                 : public class SimpInc extends Thread {
  SimpInc.java:6                 : count2++;
  SimpInc.java:7                 : }
  SimpInc.java:4                 :
------------------------------------------------------ transition #3 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"TERMINATE" ,1/1,isCascaded:false}
      [2 insn w/o sources]
  SimpInc.java:14                : System.out.println("count: " + count);
      [2 insn w/o sources]
  SimpInc.java:14                : System.out.println("count: " + count);
      [2 insn w/o sources]
  SimpInc.java:14                : System.out.println("count: " + count);
      [2 insn w/o sources]
  SimpInc.java:14                : System.out.println("count: " + count);
      [2 insn w/o sources]
  SimpInc.java:14                : System.out.println("count: " + count);
      [2 insn w/o sources]
  SimpInc.java:15                : assert count == 2;
      [21 insn w/o sources]

====================================================== snapshot #1
thread java.lang.Thread:{id:0,name:main,status:RUNNING,priority:5,isDaemon:false,lockCount:0,suspendCount:0}
  call stack:
        at SimpInc.main(SimpInc.java:15)


====================================================== results
error #1: gov.nasa.jpf.vm.NoUncaughtExceptionsProperty "java.lang.AssertionError  at SimpInc.main(SimpInc...."

====================================================== statistics
elapsed time:       00:00:00
states:             new=4,visited=0,backtracked=0,end=0
search:             maxDepth=4,constraints=0
choice generators:  thread=4 (signal=0,lock=1,sharedRef=0,threadApi=2,reschedule=1), data=0
heap:               new=383,released=5,maxLive=356,gcCycles=3
instructions:       3394
max memory:         245MB
loaded code:        classes=66,methods=1516

====================================================== search finished: 1/28/20 4:42 PM
```

In the first running, the assertion is to let value of “count” variable equals to “2”. Because the running fails the assertion, so Java Path Finder (JPF) finds a state in which the assertion fails and shows a trace leading to the state. This fail is simple causes by wrong logic implementation, not by synchronized problem.


### 2. Running of SimpConcInc.java

```
➜  src javac SimpConcInc.java
➜  src jpf SimpConcInc.jpf

JavaPathfinder core system v8.0 (rev 31) - (C) 2005-2014 United States Government. All rights reserved.


====================================================== system under test
SimpConcInc.main()

====================================================== search started: 1/28/20 6:46 PM
count: 2
count: 1

====================================================== error 1
gov.nasa.jpf.vm.NoUncaughtExceptionsProperty
java.lang.AssertionError
        at SimpConcInc.main(SimpConcInc.java:14)


====================================================== trace #1
------------------------------------------------------ transition #0 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"ROOT" ,1/1,isCascaded:false}
      [3157 insn w/o sources]
  SimpConcInc.java:1             : public class SimpConcInc extends Thread {
      [2 insn w/o sources]
  SimpConcInc.java:1             : public class SimpConcInc extends Thread {
  SimpConcInc.java:2             : private static int count = 0;
  SimpConcInc.java:1             : public class SimpConcInc extends Thread {
      [1 insn w/o sources]
  SimpConcInc.java:9             : Thread t = new SimpConcInc();
  SimpConcInc.java:1             : public class SimpConcInc extends Thread {
      [145 insn w/o sources]
  SimpConcInc.java:1             : public class SimpConcInc extends Thread {
  SimpConcInc.java:9             : Thread t = new SimpConcInc();
  SimpConcInc.java:10            : t.start();
      [1 insn w/o sources]
------------------------------------------------------ transition #1 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"START" ,2/2,isCascaded:false}
      [1 insn w/o sources]
  SimpConcInc.java:1             : public class SimpConcInc extends Thread {
  SimpConcInc.java:5             : count++;
------------------------------------------------------ transition #2 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,1/2,isCascaded:false}
      [2 insn w/o sources]
  SimpConcInc.java:11            : count++;
------------------------------------------------------ transition #3 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,1/2,isCascaded:false}
  SimpConcInc.java:11            : count++;
------------------------------------------------------ transition #4 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,2/2,isCascaded:false}
  SimpConcInc.java:5             : count++;
------------------------------------------------------ transition #5 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,1/2,isCascaded:false}
  SimpConcInc.java:11            : count++;
  SimpConcInc.java:12            : t.join();
      [1 insn w/o sources]
------------------------------------------------------ transition #6 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"JOIN" ,1/1,isCascaded:false}
  SimpConcInc.java:5             : count++;
  SimpConcInc.java:6             : }
  SimpConcInc.java:4             : public void run() {
------------------------------------------------------ transition #7 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"TERMINATE" ,1/1,isCascaded:false}
      [2 insn w/o sources]
  SimpConcInc.java:13            : System.out.println("count: " + count);
      [2 insn w/o sources]
  SimpConcInc.java:13            : System.out.println("count: " + count);
      [2 insn w/o sources]
  SimpConcInc.java:13            : System.out.println("count: " + count);
      [2 insn w/o sources]
  SimpConcInc.java:13            : System.out.println("count: " + count);
      [2 insn w/o sources]
  SimpConcInc.java:13            : System.out.println("count: " + count);
      [2 insn w/o sources]
  SimpConcInc.java:14            : assert count == 2;
      [21 insn w/o sources]

====================================================== snapshot #1
thread java.lang.Thread:{id:0,name:main,status:RUNNING,priority:5,isDaemon:false,lockCount:0,suspendCount:0}
  call stack:
        at SimpConcInc.main(SimpConcInc.java:14)


====================================================== results
error #1: gov.nasa.jpf.vm.NoUncaughtExceptionsProperty "java.lang.AssertionError  at SimpConcInc.main(Simp..."

====================================================== statistics
elapsed time:       00:00:00
states:             new=12,visited=1,backtracked=5,end=1
search:             maxDepth=8,constraints=0
choice generators:  thread=11 (signal=0,lock=1,sharedRef=4,threadApi=4,reschedule=2), data=0
heap:               new=389,released=22,maxLive=356,gcCycles=7
instructions:       3452
max memory:         245MB
loaded code:        classes=66,methods=1516

====================================================== search finished: 1/28/20 6:46 PM
```

In the second running, JPF finds a state in which the assertion fails.\
By seeing the trace, we can recognize the problem caused by a race condition (from `transition #1` to `transition #6`).

The race condition can be explained by below steps:
1. Thread 1 (T1) get value of `count` variable (get 0).
1. Thread 0 (T0) get value of `count` variable (get 0).
1. Thread 0 increases the given value by 1.
1. Thread 1 increases the given value by 1.
1. Thread 0 stores the increased value into `count` variable (the value of `count` becomes 1).
1. Thread 1 stores the increased value into `count` variable (the value of `count` becomes 1).

Because the expected value in this running is 2, so an assertion error occurs.


### 3. Running of UnsafeInc.java

```
➜  src javac UnsafeInc.java
➜  src jpf UnsafeInc.jpf

JavaPathfinder core system v8.0 (rev 31) - (C) 2005-2014 United States Government. All rights reserved.


====================================================== system under test
UnsafeInc.main()

====================================================== search started: 1/28/20 6:55 PM
count: 2
count: 2
count: 1

====================================================== error 1
gov.nasa.jpf.vm.NoUncaughtExceptionsProperty
java.lang.AssertionError
        at UnsafeInc.main(UnsafeInc.java:15)


====================================================== trace #1
------------------------------------------------------ transition #0 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"ROOT" ,1/1,isCascaded:false}
      [3157 insn w/o sources]
  UnsafeInc.java:1               : public class UnsafeInc extends Thread {
      [2 insn w/o sources]
  UnsafeInc.java:1               : public class UnsafeInc extends Thread {
      [1 insn w/o sources]
  UnsafeInc.java:7               : Thread t1 = new UnsafeInc();
  UnsafeInc.java:1               : public class UnsafeInc extends Thread {
      [145 insn w/o sources]
  UnsafeInc.java:1               : public class UnsafeInc extends Thread {
  UnsafeInc.java:7               : Thread t1 = new UnsafeInc();
  UnsafeInc.java:8               : Thread t2 = new UnsafeInc();
  UnsafeInc.java:1               : public class UnsafeInc extends Thread {
      [145 insn w/o sources]
  UnsafeInc.java:1               : public class UnsafeInc extends Thread {
  UnsafeInc.java:8               : Thread t2 = new UnsafeInc();
  UnsafeInc.java:9               : t1.start();
      [1 insn w/o sources]
------------------------------------------------------ transition #1 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"START" ,1/2,isCascaded:false}
      [2 insn w/o sources]
  UnsafeInc.java:10              : Thread.sleep(1000);
      [4 insn w/o sources]
------------------------------------------------------ transition #2 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SLEEP" ,1/2,isCascaded:false}
      [3 insn w/o sources]
  UnsafeInc.java:11              : t2.start();
      [1 insn w/o sources]
------------------------------------------------------ transition #3 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"START" ,1/3,isCascaded:false}
      [2 insn w/o sources]
  UnsafeInc.java:12              : t1.join();
      [1 insn w/o sources]
------------------------------------------------------ transition #4 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"JOIN" ,1/2,isCascaded:false}
      [1 insn w/o sources]
  UnsafeInc.java:1               : public class UnsafeInc extends Thread {
  UnsafeInc.java:3               : (new FCounter()).inc();
      [1 insn w/o sources]
------------------------------------------------------ transition #5 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"LOCK" ,1/2,isCascaded:false}
      [1 insn w/o sources]
  FCounter.java:2                : private static int x = 0;
  FCounter.java:1                : public class FCounter {
  UnsafeInc.java:3               : (new FCounter()).inc();
  FCounter.java:1                : public class FCounter {
      [1 insn w/o sources]
  FCounter.java:1                : public class FCounter {
  UnsafeInc.java:3               : (new FCounter()).inc();
------------------------------------------------------ transition #6 thread: 2
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"LOCK" ,2/2,isCascaded:false}
      [1 insn w/o sources]
  UnsafeInc.java:1               : public class UnsafeInc extends Thread {
  UnsafeInc.java:3               : (new FCounter()).inc();
  FCounter.java:1                : public class FCounter {
      [1 insn w/o sources]
  FCounter.java:1                : public class FCounter {
  UnsafeInc.java:3               : (new FCounter()).inc();
------------------------------------------------------ transition #7 thread: 2
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"LOCK" ,2/2,isCascaded:false}
  UnsafeInc.java:3               : (new FCounter()).inc();
  FCounter.java:9                : x++;
------------------------------------------------------ transition #8 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,1/2,isCascaded:false}
  UnsafeInc.java:3               : (new FCounter()).inc();
  FCounter.java:9                : x++;
------------------------------------------------------ transition #9 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,1/2,isCascaded:false}
  FCounter.java:9                : x++;
------------------------------------------------------ transition #10 thread: 2
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,2/2,isCascaded:false}
  FCounter.java:9                : x++;
------------------------------------------------------ transition #11 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,1/2,isCascaded:false}
  FCounter.java:9                : x++;
  FCounter.java:10               : }
------------------------------------------------------ transition #12 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"TERMINATE" ,1/2,isCascaded:false}
      [2 insn w/o sources]
  UnsafeInc.java:13              : t2.join();
      [1 insn w/o sources]
------------------------------------------------------ transition #13 thread: 2
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"JOIN" ,1/1,isCascaded:false}
  FCounter.java:9                : x++;
  FCounter.java:10               : }
------------------------------------------------------ transition #14 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"TERMINATE" ,1/1,isCascaded:false}
      [2 insn w/o sources]
  UnsafeInc.java:14              : System.out.println("count: " + FCounter.get());
      [2 insn w/o sources]
  UnsafeInc.java:14              : System.out.println("count: " + FCounter.get());
      [2 insn w/o sources]
  UnsafeInc.java:14              : System.out.println("count: " + FCounter.get());
  FCounter.java:5                : return x;
  UnsafeInc.java:14              : System.out.println("count: " + FCounter.get());
      [2 insn w/o sources]
  UnsafeInc.java:14              : System.out.println("count: " + FCounter.get());
      [2 insn w/o sources]
  UnsafeInc.java:14              : System.out.println("count: " + FCounter.get());
      [2 insn w/o sources]
  UnsafeInc.java:15              : assert FCounter.get() == 2;
  FCounter.java:5                : return x;
  UnsafeInc.java:15              : assert FCounter.get() == 2;
      [21 insn w/o sources]

====================================================== snapshot #1
thread java.lang.Thread:{id:0,name:main,status:RUNNING,priority:5,isDaemon:false,lockCount:0,suspendCount:0}
  call stack:
        at UnsafeInc.main(UnsafeInc.java:15)


====================================================== results
error #1: gov.nasa.jpf.vm.NoUncaughtExceptionsProperty "java.lang.AssertionError  at UnsafeInc.main(Unsafe..."

====================================================== statistics
elapsed time:       00:00:00
states:             new=26,visited=6,backtracked=17,end=2
search:             maxDepth=15,constraints=0
choice generators:  thread=25 (signal=0,lock=5,sharedRef=5,threadApi=9,reschedule=6), data=0
heap:               new=409,released=61,maxLive=365,gcCycles=25
instructions:       3772
max memory:         245MB
loaded code:        classes=67,methods=1520

====================================================== search finished: 1/28/20 6:55 PM
```

In the third running, although a synchronized mechanism is applied, but JPF even finds a state in which the assertion fails.

By seeing the trace, we can recognize the problem caused by a race condition (from `transition #7` to `transition #11` and `transition #13`).

Instead of using one object for lock, each thread uses it's own lock. So when program is running, `inc()` function of `FCounter` class cannot be synchrozied.


## 4. Running of SafeInc.java

```
➜  src javac SafeInc.java 
➜  src jpf SafeInc.jpf

JavaPathfinder core system v8.0 (rev 31) - (C) 2005-2014 United States Government. All rights reserved.


====================================================== system under test
SafeInc.main()

====================================================== search started: 1/30/20 2:52 PM
count: 2
count: 2
count: 2

====================================================== results
no errors detected

====================================================== statistics
elapsed time:       00:00:00
states:             new=166,visited=179,backtracked=345,end=3
search:             maxDepth=16,constraints=0
choice generators:  thread=166 (signal=0,lock=49,sharedRef=61,threadApi=15,reschedule=41), data=0
heap:               new=467,released=137,maxLive=366,gcCycles=304
instructions:       5847
max memory:         245MB
loaded code:        classes=63,methods=1479

====================================================== search finished: 1/30/20 2:52 PM
```

In the fourth running, JPF doesn't find any fail cases. It's caused by just using one lock object for every function call.


## 5. Running of SafeInc2.java

```
➜  src javac SafeInc2.java 
➜  src jpf SafeInc2.jpf

JavaPathfinder core system v8.0 (rev 31) - (C) 2005-2014 United States Government. All rights reserved.


====================================================== system under test
SafeInc2.main()

====================================================== search started: 1/30/20 2:59 PM
count: 2
count: 2
count: 2

====================================================== results
no errors detected

====================================================== statistics
elapsed time:       00:00:00
states:             new=105,visited=104,backtracked=209,end=3
search:             maxDepth=14,constraints=0
choice generators:  thread=105 (signal=0,lock=20,sharedRef=46,threadApi=12,reschedule=27), data=0
heap:               new=390,released=71,maxLive=364,gcCycles=162
instructions:       4517
max memory:         245MB
loaded code:        classes=63,methods=1478

====================================================== search finished: 1/30/20 2:59 PM
```

In the fifth running, JPF doesn't find any fail cases. It's caused by just using one lock object for every function call. (this ideal is same as the fourth implementation).


## 6. Running of BBProb.java

```
➜  src javac BBProb.java 
➜  src jpf BBProb.jpf 

JavaPathfinder core system v8.0 (rev 31) - (C) 2005-2014 United States Government. All rights reserved.


====================================================== system under test
BBProb.main()

====================================================== search started: 1/30/20 4:30 PM
msgsSent: [0, 1]
msgsReceived: [0, 1]
Success!
msgsSent: [0, 1]
msgsReceived: [0, 1]
Success!
msgsSent: [0, 1]
msgsReceived: [0, 1]
Success!

====================================================== results
no errors detected

====================================================== statistics
elapsed time:       00:00:00
states:             new=1797,visited=2361,backtracked=4158,end=3
search:             maxDepth=87,constraints=0
choice generators:  thread=1797 (signal=43,lock=137,sharedRef=1473,threadApi=90,reschedule=54), data=0
heap:               new=1101,released=344,maxLive=675,gcCycles=3752
instructions:       42141
max memory:         245MB
loaded code:        classes=80,methods=1835

====================================================== search finished: 1/30/20 4:30 PM
```

In the sixth running, JPF doesn't find any fail cases.


## 7. Running BBProb2.java

```
➜  src javac BBProb2.java 
➜  src jpf BBProb.jpf

JavaPathfinder core system v8.0 (rev 31) - (C) 2005-2014 United States Government. All rights reserved.


====================================================== system under test
BBProb2.main()

====================================================== search started: 2/1/20 6:15 PM

====================================================== error 1
gov.nasa.jpf.vm.NotDeadlockedProperty
deadlock encountered:
  thread java.lang.Thread:{id:0,name:main,status:WAITING,priority:5,isDaemon:false,lockCount:0,suspendCount:0}
  thread Sender2:{id:1,name:Thread-1,status:TERMINATED,priority:5,isDaemon:false,lockCount:0,suspendCount:0}
  thread Receiver2:{id:2,name:Thread-2,status:WAITING,priority:5,isDaemon:false,lockCount:1,suspendCount:0}


====================================================== trace #1
------------------------------------------------------ transition #0 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"ROOT" ,1/1,isCascaded:false}
      [3157 insn w/o sources]
  BBProb2.java:10                : public class BBProb2 {
      [2 insn w/o sources]
  BBProb2.java:10                : public class BBProb2 {
  BBProb2.java:1                 : import java.util.ArrayList;
      [1 insn w/o sources]
  BBProb2.java:12                : List<Integer> log = new ArrayList<Integer>();
      [9 insn w/o sources]
  BBProb2.java:12                : List<Integer> log = new ArrayList<Integer>();
      [16 insn w/o sources]
  BBProb2.java:12                : List<Integer> log = new ArrayList<Integer>();
  BBProb2.java:13                : MonitorBBuf2<Integer> buf = new MonitorBBuf2<Integer>(2, log);
  MonitorBBuf2.java:15           : public MonitorBBuf2(int cap, List<E> log) {
      [1 insn w/o sources]
  MonitorBBuf2.java:12           : private int noe = 0;
  MonitorBBuf2.java:16           : this.queue = new EmpQueue<E>();
  EmpQueue.java:7                : public class EmpQueue<E> implements Queue<E> {
      [1 insn w/o sources]
  EmpQueue.java:7                : public class EmpQueue<E> implements Queue<E> {
  MonitorBBuf2.java:16           : this.queue = new EmpQueue<E>();
  MonitorBBuf2.java:17           : this.capacity = cap;
  MonitorBBuf2.java:18           : this.log = log;
  MonitorBBuf2.java:19           : }
  BBProb2.java:13                : MonitorBBuf2<Integer> buf = new MonitorBBuf2<Integer>(2, log);
  BBProb2.java:14                : List<Integer> msgsSent = new ArrayList<Integer>();
      [16 insn w/o sources]
  BBProb2.java:14                : List<Integer> msgsSent = new ArrayList<Integer>();
  BBProb2.java:16                : for (int i = 0; i < 2; i++) msgsSent.add(i);
      [2 insn w/o sources]
  BBProb2.java:16                : for (int i = 0; i < 2; i++) msgsSent.add(i);
      [121 insn w/o sources]
  BBProb2.java:16                : for (int i = 0; i < 2; i++) msgsSent.add(i);
      [2 insn w/o sources]
  BBProb2.java:16                : for (int i = 0; i < 2; i++) msgsSent.add(i);
      [44 insn w/o sources]
  BBProb2.java:16                : for (int i = 0; i < 2; i++) msgsSent.add(i);
  BBProb2.java:18                : List<Integer> msgsReceived = new ArrayList<Integer>();
      [16 insn w/o sources]
  BBProb2.java:18                : List<Integer> msgsReceived = new ArrayList<Integer>();
  BBProb2.java:19                : int nom = msgsSent.size() + msgsSent.size();
      [3 insn w/o sources]
  BBProb2.java:19                : int nom = msgsSent.size() + msgsSent.size();
      [3 insn w/o sources]
  BBProb2.java:19                : int nom = msgsSent.size() + msgsSent.size();
  BBProb2.java:21                : Sender2<Integer> Sender2 = new Sender2<Integer>(buf, msgsSent);
  Sender2.java:13                : public Sender2(MonitorBBuf2<E> buf, List<E> msgs) {
      [145 insn w/o sources]
  Sender2.java:14                : this.buf = buf;
  Sender2.java:15                : this.msgs = msgs;
  Sender2.java:16                : }
  BBProb2.java:21                : Sender2<Integer> Sender2 = new Sender2<Integer>(buf, msgsSent);
  BBProb2.java:22                : Receiver2<Integer> Receiver2 = new Receiver2<Integer>(buf, msgsReceived, nom);
  Receiver2.java:14              : public Receiver2(MonitorBBuf2<E> buf, List<E> msgs, int nom) {
      [145 insn w/o sources]
  Receiver2.java:15              : this.buf = buf;
  Receiver2.java:16              : this.msgs = msgs;
  Receiver2.java:17              : this.nom = nom;
  Receiver2.java:18              : }
  BBProb2.java:22                : Receiver2<Integer> Receiver2 = new Receiver2<Integer>(buf, msgsReceived, nom);
  BBProb2.java:24                : Sender2.start();
      [1 insn w/o sources]
------------------------------------------------------ transition #1 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"START" ,1/2,isCascaded:false}
      [2 insn w/o sources]
  BBProb2.java:25                : Receiver2.start();
      [1 insn w/o sources]
------------------------------------------------------ transition #2 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"START" ,1/3,isCascaded:false}
      [2 insn w/o sources]
  BBProb2.java:26                : Sender2.join();
      [1 insn w/o sources]
------------------------------------------------------ transition #3 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"JOIN" ,1/2,isCascaded:false}
      [1 insn w/o sources]
  Sender2.java:1                 : import java.util.List;
  Sender2.java:19                : for (int i = 0; i < msgs.size(); i++){
------------------------------------------------------ transition #4 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  Sender2.java:19                : for (int i = 0; i < msgs.size(); i++){
      [2 insn w/o sources]
------------------------------------------------------ transition #5 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [2 insn w/o sources]
  Sender2.java:19                : for (int i = 0; i < msgs.size(); i++){
  Sender2.java:21                : buf.put(msgs.get(i));
------------------------------------------------------ transition #6 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  Sender2.java:21                : buf.put(msgs.get(i));
------------------------------------------------------ transition #7 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  Sender2.java:21                : buf.put(msgs.get(i));
      [6 insn w/o sources]
------------------------------------------------------ transition #8 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [8 insn w/o sources]
------------------------------------------------------ transition #9 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [3 insn w/o sources]
------------------------------------------------------ transition #10 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_ARRAY" ,1/2,isCascaded:false}
      [3 insn w/o sources]
  Sender2.java:21                : buf.put(msgs.get(i));
------------------------------------------------------ transition #11 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"LOCK" ,1/2,isCascaded:false}
  Sender2.java:21                : buf.put(msgs.get(i));
  MonitorBBuf2.java:22           : while (noe >= capacity) {
------------------------------------------------------ transition #12 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  MonitorBBuf2.java:22           : while (noe >= capacity) {
  MonitorBBuf2.java:25           : if (noe < capacity) {
------------------------------------------------------ transition #13 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  MonitorBBuf2.java:25           : if (noe < capacity) {
  MonitorBBuf2.java:26           : queue = queue.enq(e);
------------------------------------------------------ transition #14 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  MonitorBBuf2.java:26           : queue = queue.enq(e);
  EmpQueue.java:9                : return new NeQueue<E>(e, this);
  NeQueue.java:11                : public NeQueue(E e, Queue<E> q) {
      [1 insn w/o sources]
  NeQueue.java:12                : this.head = e;
  NeQueue.java:13                : this.tail = q;
  NeQueue.java:14                : }
  EmpQueue.java:9                : return new NeQueue<E>(e, this);
  MonitorBBuf2.java:26           : queue = queue.enq(e);
------------------------------------------------------ transition #15 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  MonitorBBuf2.java:26           : queue = queue.enq(e);
------------------------------------------------------ transition #16 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"EXPOSE" ,1/2,isCascaded:false}
  MonitorBBuf2.java:26           : queue = queue.enq(e);
  MonitorBBuf2.java:27           : log.add(e);
------------------------------------------------------ transition #17 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  MonitorBBuf2.java:27           : log.add(e);
      [3 insn w/o sources]
------------------------------------------------------ transition #18 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [7 insn w/o sources]
------------------------------------------------------ transition #19 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [5 insn w/o sources]
------------------------------------------------------ transition #20 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,1/2,isCascaded:false}
      [12 insn w/o sources]
------------------------------------------------------ transition #21 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [4 insn w/o sources]
------------------------------------------------------ transition #22 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [4 insn w/o sources]
------------------------------------------------------ transition #23 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [9 insn w/o sources]
------------------------------------------------------ transition #24 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [22 insn w/o sources]
------------------------------------------------------ transition #25 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [36 insn w/o sources]
------------------------------------------------------ transition #26 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [1 insn w/o sources]
------------------------------------------------------ transition #27 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"EXPOSE" ,1/2,isCascaded:false}
      [6 insn w/o sources]
------------------------------------------------------ transition #28 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [4 insn w/o sources]
------------------------------------------------------ transition #29 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [5 insn w/o sources]
------------------------------------------------------ transition #30 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [5 insn w/o sources]
  MonitorBBuf2.java:27           : log.add(e);
  MonitorBBuf2.java:28           : noe++;
------------------------------------------------------ transition #31 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  MonitorBBuf2.java:28           : noe++;
------------------------------------------------------ transition #32 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  MonitorBBuf2.java:28           : noe++;
  MonitorBBuf2.java:29           : this.notifyAll();
      [2 insn w/o sources]
  MonitorBBuf2.java:31           : }
  Sender2.java:24                : }
  Sender2.java:19                : for (int i = 0; i < msgs.size(); i++){
------------------------------------------------------ transition #33 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  Sender2.java:19                : for (int i = 0; i < msgs.size(); i++){
      [2 insn w/o sources]
------------------------------------------------------ transition #34 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [2 insn w/o sources]
  Sender2.java:19                : for (int i = 0; i < msgs.size(); i++){
  Sender2.java:21                : buf.put(msgs.get(i));
------------------------------------------------------ transition #35 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  Sender2.java:21                : buf.put(msgs.get(i));
------------------------------------------------------ transition #36 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  Sender2.java:21                : buf.put(msgs.get(i));
      [6 insn w/o sources]
------------------------------------------------------ transition #37 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [8 insn w/o sources]
------------------------------------------------------ transition #38 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [3 insn w/o sources]
------------------------------------------------------ transition #39 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_ARRAY" ,1/2,isCascaded:false}
      [3 insn w/o sources]
  Sender2.java:21                : buf.put(msgs.get(i));
------------------------------------------------------ transition #40 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"LOCK" ,1/2,isCascaded:false}
  Sender2.java:21                : buf.put(msgs.get(i));
  MonitorBBuf2.java:22           : while (noe >= capacity) {
------------------------------------------------------ transition #41 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  MonitorBBuf2.java:22           : while (noe >= capacity) {
  MonitorBBuf2.java:25           : if (noe < capacity) {
------------------------------------------------------ transition #42 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  MonitorBBuf2.java:25           : if (noe < capacity) {
  MonitorBBuf2.java:26           : queue = queue.enq(e);
------------------------------------------------------ transition #43 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  MonitorBBuf2.java:26           : queue = queue.enq(e);
  NeQueue.java:7                 : public class NeQueue<E> implements Queue<E> {
  NeQueue.java:17                : return new NeQueue<E>(head, tail.enq(e));
  EmpQueue.java:9                : return new NeQueue<E>(e, this);
  NeQueue.java:11                : public NeQueue(E e, Queue<E> q) {
      [1 insn w/o sources]
  NeQueue.java:12                : this.head = e;
  NeQueue.java:13                : this.tail = q;
  NeQueue.java:14                : }
  EmpQueue.java:9                : return new NeQueue<E>(e, this);
  NeQueue.java:17                : return new NeQueue<E>(head, tail.enq(e));
  NeQueue.java:11                : public NeQueue(E e, Queue<E> q) {
      [1 insn w/o sources]
  NeQueue.java:12                : this.head = e;
  NeQueue.java:13                : this.tail = q;
  NeQueue.java:14                : }
  NeQueue.java:17                : return new NeQueue<E>(head, tail.enq(e));
  NeQueue.java:7                 : public class NeQueue<E> implements Queue<E> {
  MonitorBBuf2.java:26           : queue = queue.enq(e);
------------------------------------------------------ transition #44 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  MonitorBBuf2.java:26           : queue = queue.enq(e);
------------------------------------------------------ transition #45 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"EXPOSE" ,1/2,isCascaded:false}
  MonitorBBuf2.java:26           : queue = queue.enq(e);
  MonitorBBuf2.java:27           : log.add(e);
------------------------------------------------------ transition #46 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  MonitorBBuf2.java:27           : log.add(e);
      [3 insn w/o sources]
------------------------------------------------------ transition #47 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [7 insn w/o sources]
------------------------------------------------------ transition #48 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [5 insn w/o sources]
------------------------------------------------------ transition #49 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,1/2,isCascaded:false}
      [8 insn w/o sources]
------------------------------------------------------ transition #50 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [4 insn w/o sources]
------------------------------------------------------ transition #51 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [4 insn w/o sources]
------------------------------------------------------ transition #52 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [8 insn w/o sources]
------------------------------------------------------ transition #53 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [4 insn w/o sources]
------------------------------------------------------ transition #54 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [5 insn w/o sources]
------------------------------------------------------ transition #55 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [5 insn w/o sources]
  MonitorBBuf2.java:27           : log.add(e);
  MonitorBBuf2.java:28           : noe++;
------------------------------------------------------ transition #56 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  MonitorBBuf2.java:28           : noe++;
------------------------------------------------------ transition #57 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  MonitorBBuf2.java:28           : noe++;
  MonitorBBuf2.java:29           : this.notifyAll();
      [2 insn w/o sources]
  MonitorBBuf2.java:31           : }
  Sender2.java:24                : }
  Sender2.java:19                : for (int i = 0; i < msgs.size(); i++){
------------------------------------------------------ transition #58 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  Sender2.java:19                : for (int i = 0; i < msgs.size(); i++){
      [2 insn w/o sources]
------------------------------------------------------ transition #59 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
      [2 insn w/o sources]
  Sender2.java:19                : for (int i = 0; i < msgs.size(); i++){
  Sender2.java:26                : }
  Sender2.java:4                 : Name: NGUYEN, Minh Tien
------------------------------------------------------ transition #60 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"TERMINATE" ,1/2,isCascaded:false}
      [2 insn w/o sources]
  BBProb2.java:27                : Receiver2.join();
      [1 insn w/o sources]
------------------------------------------------------ transition #61 thread: 2
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"JOIN" ,1/1,isCascaded:false}
      [1 insn w/o sources]
  Receiver2.java:1               : import java.util.List;
  Receiver2.java:21              : for (int i = 0; i < nom; i++) {
  Receiver2.java:23              : msgs.add(buf.get());
  MonitorBBuf2.java:34           : while (noe <= 0) {
  MonitorBBuf2.java:37           : if (noe > 0) {
  MonitorBBuf2.java:38           : E e = queue.top();
  NeQueue.java:25                : return head;
  MonitorBBuf2.java:38           : E e = queue.top();
  MonitorBBuf2.java:39           : queue = queue.deq();
  NeQueue.java:21                : return tail;
  MonitorBBuf2.java:39           : queue = queue.deq();
  MonitorBBuf2.java:40           : noe--;
  MonitorBBuf2.java:41           : this.notifyAll();
      [2 insn w/o sources]
  MonitorBBuf2.java:42           : return e;
  Receiver2.java:23              : msgs.add(buf.get());
      [110 insn w/o sources]
  Receiver2.java:23              : msgs.add(buf.get());
  Receiver2.java:26              : }
  Receiver2.java:21              : for (int i = 0; i < nom; i++) {
  Receiver2.java:23              : msgs.add(buf.get());
  MonitorBBuf2.java:34           : while (noe <= 0) {
  MonitorBBuf2.java:37           : if (noe > 0) {
  MonitorBBuf2.java:38           : E e = queue.top();
  NeQueue.java:25                : return head;
  MonitorBBuf2.java:38           : E e = queue.top();
  MonitorBBuf2.java:39           : queue = queue.deq();
  NeQueue.java:21                : return tail;
  MonitorBBuf2.java:39           : queue = queue.deq();
  MonitorBBuf2.java:40           : noe--;
  MonitorBBuf2.java:41           : this.notifyAll();
      [2 insn w/o sources]
  MonitorBBuf2.java:42           : return e;
  Receiver2.java:23              : msgs.add(buf.get());
      [44 insn w/o sources]
  Receiver2.java:23              : msgs.add(buf.get());
  Receiver2.java:26              : }
  Receiver2.java:21              : for (int i = 0; i < nom; i++) {
  Receiver2.java:23              : msgs.add(buf.get());
  MonitorBBuf2.java:34           : while (noe <= 0) {
  MonitorBBuf2.java:35           : this.wait();
      [1 insn w/o sources]

====================================================== snapshot #1
thread java.lang.Thread:{id:0,name:main,status:WAITING,priority:5,isDaemon:false,lockCount:0,suspendCount:0}
  waiting on: Receiver2@2a0
  call stack:
        at java.lang.Thread.join(Thread.java)
        at BBProb2.main(BBProb2.java:27)

thread Receiver2:{id:2,name:Thread-2,status:WAITING,priority:5,isDaemon:false,lockCount:1,suspendCount:0}
  waiting on: MonitorBBuf2@179
  call stack:
        at java.lang.Object.wait(Object.java)
        at MonitorBBuf2.get(MonitorBBuf2.java:35)
        at Receiver2.run(Receiver2.java:23)


====================================================== results
error #1: gov.nasa.jpf.vm.NotDeadlockedProperty "deadlock encountered:   thread java.lang.Thread:{i..."

====================================================== statistics
elapsed time:       00:00:00
states:             new=62,visited=0,backtracked=0,end=1
search:             maxDepth=62,constraints=0
choice generators:  thread=62 (signal=0,lock=3,sharedRef=52,threadApi=4,reschedule=3), data=0
heap:               new=686,released=11,maxLive=677,gcCycles=56
instructions:       4494
max memory:         245MB
loaded code:        classes=76,methods=1809

====================================================== search finished: 2/1/20 6:15 PM
```

In the seventh running, JPF finds a fail case.
