
using System.ComponentModel;
using System.Threading;

Console.WriteLine("BackgroundWorker");

// Erstelle und konfiguriere den BackgroundWorker
BackgroundWorker bgw = new BackgroundWorker();

// Konfiguration des BackgroundWorkers
bgw.WorkerReportsProgress = true;
bgw.WorkerSupportsCancellation = true;

// Zeitnehmer
var Start = DateTime.Now;

// Event-Handler zuweisen
bgw.DoWork += new DoWorkEventHandler(testDoWork);
bgw.RunWorkerCompleted += (s, e) =>
{
    var Ende = DateTime.Now;
    var elapsed = Ende - Start;
    Console.WriteLine("Fertig in " + elapsed);
};

// Starte den Worker
bgw.RunWorkerAsync();

// Verhindert, dass das Skript sofort endet
Console.ReadLine();

// DoWork-Methode mit korrekter Signatur
void testDoWork(object sender, DoWorkEventArgs e)
{
    for (int i = 0; i < 1000000; i++)
    {
        Console.WriteLine(i);
        // Thread.Sleep(100); // optional zur Simulation von Zeitaufwand
    }
}

