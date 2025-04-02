struct meine_struktur {
    int a;
    int b;
    char c;
};

struct a {
    char a;
    char b;
    char c; // 3 Byte
    // 1 Byte padding
    short d; // 2 Byte
    // 2 Byte padding
    char e; // 1 Byte
    // 3 Byte padding
};


union meine_union {
    
    int a;
    double b;
};

struct typeinfo {
    int type; // 0 = int, 1 = char, 2 = double
    union {
        int int_wert;
        char char_wert;
        double double_wert;
    } bla;
};

typedef struct meine_struktur meine_struktur;
typedef union meine_union meine_union;

void add_a(meine_struktur* s) {
    s->a++;
}

int main() {
    meine_struktur x;
    x.a = 3;

    struct typeinfo type;
    type.bla.char_wert = 'X';

    add_a(&x);

    meine_struktur bla = {3, 4, 'x'};

    meine_struktur bla2 = { .b = 10 };

}
