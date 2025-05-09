
using System;

// Speichern des heutigen Datums
var heute = DateTime.Today;
// Speichern der aktuellen Uhrzeit
var uhrzeit = DateTime.Now.TimeOfDay;


Console.WriteLine("heute: " + heute.ToString("dd-MM-yyyy"));
Console.WriteLine("heute: " + uhrzeit.ToString("hh\\:mm\\:ss"));

heute = heute.AddDays(-345);

Console.WriteLine("-345 Tage : " + heute.ToString("dd-MM-yyyy"));
