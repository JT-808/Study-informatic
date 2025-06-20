using System;
using System.Threading;

Console.WriteLine("Threadzaehler");

Thread t = new Thread(threadFunktion);
var Start = DateTime.Now;
t.Start();

// Warten, bis der Thread fertig ist
t.Join();
var Ende = DateTime.Now;
var elapsed = Ende - Start;

Console.WriteLine("Fertig in " + elapsed);

void threadFunktion()
{
    for (int i = 0; i < 1000000; i++)
    {
        Console.WriteLine(i);
        // Thread.Sleep(100);
    }
}

