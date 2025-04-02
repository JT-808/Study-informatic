#include <stdio.h>
#include <stdlib.h>

struct test {
  char c;
  int x;
  float z;
};

union union_test {
  struct test t;
  unsigned char bytes[sizeof(struct test)];
};

int main() {

  /*            Ohne union
   struct test t = {'z', 0x000F4240, 1000000.0f};
   */

  union union_test u;
  u.t.c = 'z';
  u.t.x = 0x000F4240;
  u.t.z = 1000000.0f;

  printf("Struktur test:");
  printf("\nAdresse von c: %p", &u.t.c); // gibt Speicheradresse aus
  printf("\nAdresse von x: %p", &u.t.x);
  printf("\nAdresse von z: %p", &u.t.z);
  printf("\nGröße der Struktur: %lu Bytes\n", sizeof(u.t));

  printf("\nSpeicherinhalt der Union in Hexadezimal:\n");
  for (size_t i = 0; i < sizeof(u.bytes); i++) {
    printf("Byte %2d: 0x%02X hex, %d dez\n", (int)i, u.bytes[i],
           u.bytes[i]); // Cast von size_t zu int
  }
  /* %02X: Gibt den Wert des i-ten Bytes in Hexadezimalform aus
  (mit mindestens 2 Stellen und führender Null, falls notwendig).*/

  return EXIT_SUCCESS; /* EXIT_SUCCESS (0) alles ok */
}