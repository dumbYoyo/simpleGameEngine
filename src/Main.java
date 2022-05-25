import zuimamamba.Window;

import java.util.ArrayList;

// 7-5-22, 440 lines of code just for a textured square! dem
// NOTE - RTX 3090 texture is the default texture
// 8-5-22, 807 lines of code (has ability to create multiple objects with a bit higher level abstraction)
// 12-5-22, 1910 lines of code (now I have ability to create materials and gameObject class is also a bit improved, lighting - diffuse, specular)

// TODO: make a nice input manager! (does not need to professional, anything will work)

public class Main {
    public static void main(String[] args) {
        new Window();
        char s = '*';
        char b = ' ';

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0) {
                    System.out.print(s);
                }

                if (i != 0) {
                    if (i == 1) {
                        if (j == 2) {
                            System.out.print(b);
                        } else {
                            System.out.print(s);
                        }
                    }

                    if (i == 2) {
                        if (j == 1 || j == 3) {
                            System.out.print(b);
                        } else {
                            System.out.print(s);
                        }
                    }

                    if (i == 3) {
                        if (j == 2) {
                            System.out.print(b);
                        } else {
                            System.out.print(s);
                        }
                    }

                    if (i == 4) {
                        System.out.print(s);
                    }
                }
            }
            System.out.println();
        }
    }
}
