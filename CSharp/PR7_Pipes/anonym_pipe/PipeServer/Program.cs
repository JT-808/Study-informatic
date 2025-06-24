using System;
using System.Diagnostics;
using System.IO;
using System.IO.Pipes;

class Program
{
    static void Main(string[] args)
    {
        using var pipeServer = new AnonymousPipeServerStream(PipeDirection.Out, HandleInheritability.Inheritable);

        Console.WriteLine("Pipe Server gestartet.");
        Console.WriteLine($"Pipe Handle für Client: {pipeServer.GetClientHandleAsString()}");

        // Starte Clientprozess mit Handle als Argument
        var clientProcess = new Process();
        clientProcess.StartInfo.FileName = "../PipeClient/bin/Debug/net9.0/PipeClient"; // Pfad anpassen nach Build
        clientProcess.StartInfo.Arguments = pipeServer.GetClientHandleAsString();
        clientProcess.StartInfo.UseShellExecute = false;
        clientProcess.Start();

        pipeServer.DisposeLocalCopyOfClientHandle();

        using var sw = new StreamWriter(pipeServer);
        sw.AutoFlush = true;
        sw.WriteLine("Hallo vom Server!");

        clientProcess.WaitForExit();

        Console.WriteLine("Server beendet.");
    }
}
