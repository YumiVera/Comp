import java.io.InputStream;
import java.io.OutputStream;


public class RLE {

    public static void compress(InputStream is, OutputStream os) throws Exception {
        int valor;
        int ultimo = -1;
        int contador = 0;
        System.out.println("NUEVO");
        while ((valor = is.read()) != -1) {

            if (ultimo == valor) {
                contador++;
                if (contador == 1) {
                    os.write(ultimo);
                    System.out.println(ultimo);

                } else if (contador >= 255) {
                    os.write(contador);
                    os.write(ultimo);
                    System.out.println(contador);
                    System.out.println(ultimo);
                    contador = -2;
                }

            } else {
                if (ultimo != -1 && contador >= 2) {
                    os.write(contador - 1);
                    System.out.println(contador - 1);

                } else if (contador == 1) {
                    os.write(0);
                    System.out.println(0);
                }
                ultimo = valor;
                System.out.println(ultimo);
                os.write(ultimo);
                contador = 0;
            }

        }

        if (contador != 0) {
            os.write(contador - 1);
            System.out.println(contador - 1);

        }

        System.out.println("cierra");
        os.close();
        is.close();


    }


    public static void decompress(InputStream is, OutputStream os) throws Exception {
        int valor;
        int ultimo = -1;
        int contador = 0;
        System.out.println("NUEVO");
        while ((valor = is.read()) != -1) {

                if (ultimo == valor) {
                    contador++;

                    if (contador == 1) {
                        os.write(ultimo);
                        System.out.println(ultimo);
                    }

                } else {
                    ultimo = valor;

                    if(valor!=0){
                        os.write(ultimo);
                        System.out.println(ultimo);
                    }



                }
            }

        System.out.println("cierra");
        os.close();
        is.close();


    }
}
