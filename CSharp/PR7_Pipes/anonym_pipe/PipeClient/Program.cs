using System;
using System.IO;
using System.IO.Pipes;

class Program
{
    static void Main(string[] args)
    {
        if (args.Length < 1)
        {
            Console.WriteLine("Kein Pipe-Handle als Argument übergeben.");
            return;
        }

        string pipeHandle = args[0];

        using var pipeClient = new AnonymousPipeClientStream(PipeDirection.In, pipeHandle);
        using var sr = new StreamReader(pipeClient);

        Console.WriteLine("Client gestartet. Warte auf Nachricht...");

        string message = sr.ReadLine();

        Console.WriteLine($"Nachricht vom Server: {message}");

        Console.WriteLine("Client beendet.");
    }
}
