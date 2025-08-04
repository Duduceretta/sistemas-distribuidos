using System;
using System.Threading;

class Program {
    static void MinhaThread() {
        Console.WriteLine("Thread executando!");
    }

    static void Main() {
        Thread t = new Thread(new ThreadStart(MinhaThread));
        t.Start();
        t.Join();
    }
}