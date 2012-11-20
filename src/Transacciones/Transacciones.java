/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transacciones;

/**
 *
 * @author aDRiaN
 */
public class Transacciones {
    
    NodoTransaccion cabeza; /* Nombre que referencia donde esta el objeto ej inicio*/

    Transacciones() {
        cabeza = null; /* cabeza queda apuntando a nulo  */
    }
    
    public void insertarPrimero(int NoCuenta, String fecha, String tipo_transacción, String tipo_de_cuenta, int monto) {
        NodoTransaccion nuevo = new NodoTransaccion();
        nuevo.NoCuenta = NoCuenta;
        nuevo.fecha = fecha;
        nuevo.tipo_transacción = tipo_transacción;
        nuevo.tipo_de_cuenta = tipo_de_cuenta;
        nuevo.monto = monto;
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }


    /*  4.	Ahora creamos una parte llamada insertar ultimo, para ello hay * que hacer 
     * forma de recorrer la lista o tener un apuntador que defina el ultimo nodo. */
    public void insertarFinal(int NoCuenta, String fecha, String tipo_transacción, String tipo_de_cuenta, int monto) {
        NodoTransaccion aux = cabeza;  /*
         * Creamos una variable de tipo nodo
         */
        /*
         * apunta a donde apunta cabeza
         */
        NodoTransaccion ant = cabeza;  /*
         * creamos anterior
         */
        NodoTransaccion nuevo = new NodoTransaccion();
        nuevo.NoCuenta = NoCuenta;
        nuevo.fecha = fecha;
        nuevo.tipo_transacción = tipo_transacción;
        nuevo.tipo_de_cuenta = tipo_de_cuenta;
        nuevo.monto = monto;
        /*
         * insertar nuevo dato
         */
        if (aux == null) { // se verifica si es el primer elemento, 
            nuevo.siguiente = null;
            cabeza = nuevo;
        } else {
            while (aux.siguiente != null) {  
                /*asignele a aux siguiente ciclo hasta que sea nulo*/
                aux = aux.siguiente;  /*le da a aux el siguiente*/
            }
            nuevo.siguiente = null;  /*
             * el nuevo elemento sera el siguiente
             */
            aux.siguiente = nuevo;  /*
             * auxiliar seria el nuevo objeto
             */
        }

    }

    /* 4.1	Creamos método que imprima lo que insertamos en la lista  */
    public String mostrarLista() {
        //  JTextArea pantalla=new JTextArea(6,40); /* Creamos un recuadro de 6 x 40  */

        String pantalla = "";
        pantalla += "   Listado de Transacciones\n\n"; /* Abre el listado  */
        NodoTransaccion aux; /*  nodo auxiliar */
        aux = cabeza; /*  auxiliar sera la cabeza */
        pantalla+="No Cuenta  -  Fecha  - tipo de transacción -  tipo_de_cuenta  -   monto\n";
        while (aux != null) /*  ciclo hasta que auxiliar sea nulo */ {
            pantalla += "   "+aux.NoCuenta + " - " + aux.fecha + " " + aux.tipo_transacción + " " + aux.tipo_de_cuenta +" " + aux.monto +"\n"; /*  pantalla tendra entonces */
            /*  los datos de auxiliar */
            aux = aux.siguiente;
        } 
           
    /* cuando termine el ciclo devolvera el mensaje con la pantalla de los datos  */
        return pantalla;
    }
    
    /* 5.	Creamos una parte de eliminar primero */
    public void eliminarPrimero() {

        cabeza = cabeza.siguiente;
        /* Decimos que la cabeza sea cabeza.siguiente  */
        /* Osea que el primer cabeza ya no existiria en los nodos  */
    }

    /* 6. Creamos una parte de eliminar ultimo */
    public void eliminarFinal() {
        NodoTransaccion ant = cabeza;   /* El nodo anterior es igual a cabeza  */
        NodoTransaccion aux = cabeza.siguiente;   /* el auxiliar ahora es uno mas adelante  */
        /* que la cabeza  */
        while (aux.siguiente != null) {   /* Ciclo  hasta siguiente ser null*/
            ant = ant.siguiente; /* el anterior es el anterior con el siguiente  */
            aux = aux.siguiente; /* Asi se mueve al siguiente nodo  */
        }
        ant.siguiente = null; /* se le pone que al terminar el ciclo  */
        /* osea al ser anterior el penultimo se le dice que el siguiente  */
        /*   */
    }
    /* 7. Creamos una parte de eliminar posicion dada*/

    public void eliminarPosicion(int x) { /* dise que insertaremos x  */
        /* ese x lo insertamos mas adelante en el main  */
        if (x == 1) { /* si x es igual a 1 entonces */
            eliminarPrimero(); /*  llame al metodo eliminar primero */
        } else {
            if (x == cantidadNodos()) { /* si es igual a 8 siendo 8 el numero de nodos */
                eliminarFinal();/* llama al metodo eliminar final  */
            } else { /* si no entonces haga lo siguiente  */
                NodoTransaccion ant = cabeza; /* decimos que anterior es igual a cabeza  */
                NodoTransaccion actual = cabeza.siguiente; /* actual es el que sigue de cabeza  */
                NodoTransaccion siguiente = actual.siguiente; /* y siguiente es despues de actual  */
                int can = 2; /* cantidad 2 osea empieza desde la posicion 2  */
                while (can != x) { /* ciclo hasta que cantidad sea diferente de x  */
                    can++; /* cantidad aumenta de 1 en uno  */
                    ant = ant.siguiente; /* cuando eso entonces se movera asi  */
                    /* anterior sera anterior siguiente  */
                    actual = actual.siguiente; /* actual sera el que sigue  */
                    siguiente = siguiente.siguiente; /* siguiente sera el que sigue  */
                }/*  cuando se termine anterior */
                ant.siguiente = siguiente; /* anterior.siguiente sera siguiente  */
                /*  osea se salta uno y lo borra y ese sera el numero que el damos */
            }
        }
    }
    /* 8. Creamos metodo para ver la cantidad de nodos  */

    public int cantidadNodos() {
        int can = 0; /* empezamos con cantidad igual a 0  */
        NodoTransaccion aux = cabeza; /* decimos que el auxiliar es igual a cabeza osea posicion1  */
        while (aux != null) { /* ciclo hasta que el auxiliar sea nulo  */
            can++; /* aumente la cantidad  */
            aux = aux.siguiente; /* y el auxiliar sea de siguiente en siguiente  */
        }/* cantidad lo que hace es contar el numero de veces que auxiliar se mueve  */
        System.out.println("cant " + can);
        return can; /*  retorna el valor de cantidad */

    }
    /* 9. Creamos metodo para buscar un nodo  */

    public NodoTransaccion buscarNodo(int NoCuenta) { /* le vamos a pasar en main el valor n  */
        NodoTransaccion aux = cabeza; /* Decimos que auxiliar esta desde la posicion 1  */

        while (aux != null) { /* Ciclo hasta que el dato de auxiliar sera diferente de n  */
            if (aux.NoCuenta == NoCuenta) {
                return aux;/* retorna el valor de cantidad osea donde esta el dato buscado  */
            }
            aux = aux.siguiente; /* Auxiliar sera siguiente en siguiente  */
        }
        return null; // retorna null cuando no lo encuentra
    }

//    public NodoTransaccion buscarNodoXNombre(String nombre) { /* le vamos a pasar en main el valor n  */
//        NodoTransaccion aux = cabeza; /* Decimos que auxiliar esta desde la posicion 1  */
//
//        while (aux != null) { /* Ciclo hasta que el dato de auxiliar sera diferente de n  */
//            System.out.println((aux.dato2+" "+aux.dato3+" "+aux.dato4) +" - "+nombre);
//            if ((aux.dato2+" "+aux.dato3+" "+aux.dato4).contains(nombre)) {//verifica si nombre aparece en la concatenacion de nombre y apellidos
//                System.out.println(aux.dato);
//                return aux;/* retorna el valor de cantidad osea donde esta el dato buscado  */
//            }
//            aux = aux.siguiente; /* Auxiliar sera siguiente en siguiente  */
//        }
//        return null; // retorna null cuando no lo encuentra
//    }

//    public void ordenarXApellido() {
//
//        NodoTransaccion aux1 = cabeza;
//        NodoTransaccion aux2 = null;
//        NodoTransaccion naux = new NodoTransaccion();
//
//        while (aux1 != null) {
//            aux2 = aux1;
//
//            while (aux2.siguiente != null) {
//                aux2 = aux2.siguiente;
//
//                if (aux1.dato3.compareTo(aux2.dato3)>0) {// esto es para intercambiar 2 nodos
//                    naux.dato = aux1.dato;
//                    naux.dato2 = aux1.dato2;
//                    naux.dato3 = aux1.dato3;
//                     naux.dato4 = aux1.dato4;
//                    aux1.dato = aux2.dato;
//                    aux1.dato2 = aux2.dato2;
//                    aux1.dato3 = aux2.dato3;
//                     aux1.dato4 = aux2.dato4;
//                    aux2.dato = naux.dato;
//                    aux2.dato2 = naux.dato2;
//                    aux2.dato3 = naux.dato3;
//                    aux2.dato4 = naux.dato4;
//                }
//            }
//            aux1 = aux1.siguiente;
//        }
//    }


//    public void ordenarXCodigo() {
//        NodoTransaccion aux1 = cabeza;
//        NodoTransaccion aux2 = null;
//        NodoTransaccion naux = new NodoTransaccion();
//
//        while (aux1 != null) {
//            aux2 = aux1;
//
//            while (aux2.siguiente != null) {
//                aux2 = aux2.siguiente;
//
//                if (aux1.dato > aux2.dato) {
//                    naux.dato = aux1.dato;
//                    naux.dato2 = aux1.dato2;
//                    naux.dato3 = aux1.dato3;
//                    naux.dato4 = aux1.dato4;
//                    aux1.dato = aux2.dato;
//                    aux1.dato2 = aux2.dato2;
//                    aux1.dato3 = aux2.dato3;
//                     aux1.dato4 = aux2.dato4;
//                    aux2.dato = naux.dato;
//                    aux2.dato2 = naux.dato2;
//                    aux2.dato3 = naux.dato3;
//                    aux2.dato4 = naux.dato4;
//                    
//                }
//            }
//            aux1 = aux1.siguiente;
//        }
//
//    }

    public NodoTransaccion obtenerNodoXPos(int pos) {
        if (pos < 1 || pos > cantidadNodos()) {
            return null;
        }
        if (pos == 1) {
            return cabeza;
        } else {
            NodoTransaccion ant = cabeza;
            NodoTransaccion actual = cabeza.siguiente;
            int can = 2;
            while (can != pos) {
                can++;
                ant = ant.siguiente;
                actual = actual.siguiente;
            }
            return actual;
        }
    }

    public int obtenerPosXcod(int NoCuenta) {
        int can = 1; /*  Iniciamos con la cantidad igual a 1 */
        NodoTransaccion aux = cabeza; /* Decimos que auxiliar esta desde la posicion 1  */

        while (aux != null) { /* Ciclo hasta que el dato de auxiliar sera diferente de n  */
            if (aux.NoCuenta == NoCuenta) {
                return can;/* retorna la capital de el departamento que esta buscando  */
            }
            can++;/* Cantidad se aumenta de 1 en 1 contando la posicion de auxiliar  */
            
            aux = aux.siguiente; /* Auxiliar sera siguiente en siguiente  */
        }
        return can; // retorna null cuando no lo encuentra

    }

//    public NodoTransaccion minimo(int pos) {
//
//        NodoTransaccion aux = obtenerNodoXPos(pos); /* Decimos que auxiliar esta desde la posicion 1  */
//
//        NodoTransaccion encontrado = aux;// retornamos la posicion
//
//        while (aux != null) { /* Ciclo hasta que el dato de auxiliar sera diferente de n  */
//            if (aux.dato < encontrado.dato) {
//                encontrado = aux;
//                System.out.println("min" + encontrado.dato);
//            }
//            aux = aux.siguiente; /* Auxiliar sera siguiente en siguiente  */
//        }
//        return encontrado; // retorna el nodo menor
//
//    }
//    public void ordenarXCodigo(Nodo nodo, int pos) {
//        if (pos < cantidadNodos()) {
//            Nodo min = nodo;
//            int aux = 0, posmin = pos;
//            while (min != null ) { /* Ciclo hasta que el dato de auxiliar sera diferente de n  */
//            pos++; /* Cantidad se aumenta de 1 en 1 contando la posicion de auxiliar  */
//            if (min.dato)) {
//                encontrado = aux.dato3;
//                return encontrado;/* retorna la capital de el departamento que esta buscando  */
//            }
//            aux = aux.siguiente; /* Auxiliar sera siguiente en siguiente  */
//        }
//            for (int i = pos; i < cantidadNodos(); i++) {
//                if (datos[i] < min) {
//                    posmin = i;
//                    min = datos[i];
//                }
//            }
//            aux = datos[pos];
//            datos[pos] = min;
//            datos[posmin] = aux;
//            ordenarXCodigo(datos, pos + 1);
//        }

    
}
