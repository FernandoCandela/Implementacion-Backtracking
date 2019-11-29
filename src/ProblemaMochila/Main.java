package ProblemaMochila;

public class Main {

    public static void llenarMochila(Mochila mochilaBas, Elemento[] elementos, boolean llena, Mochila mochilaOpt) {
//si esta llenaSe comprobara si la mochila que se tiene actualmente es mejor que la mochila optima
        if (llena) {

            if (mochilaBas.getBeneficio() > mochilaOpt.getBeneficio()) {
//si el beneficio de la base es mayor al de la optima, la que tengo actualmente sera mi nueva mochila optima
                Elemento[] elementosMochBase = mochilaBas.getElementos();
                mochilaOpt.limpiar();
//se mete los elementos a la nueva mochila optima
                for (Elemento e : elementosMochBase) {
                    if (e != null) {
                        mochilaOpt.añadirElemento(e);
                    }
                }
            }

        } else {
            //Se recorrera los elementos 
            for (int i = 0; i < elementos.length; i++) {
                //en el caso de que ya existe un elemento se mete otro elemento diferente
                if (!mochilaBas.existeElemento(elementos[i])) {
                    //Si el peso de la mochila llegara a ser superior, se indicara que ya esta llena
                    if (mochilaBas.getPesoMaximo() > mochilaBas.getPeso() + elementos[i].getPeso()) {
                        mochilaBas.añadirElemento(elementos[i]);
                        //se llama ala recursividad
                        llenarMochila(mochilaBas, elementos, false, mochilaOpt);
                        //quitamos el elemento para asi poder hacer mas combinaciones
                        mochilaBas.eliminarElemento(elementos[i]);
                    } else {
                        llenarMochila(mochilaBas, elementos, true, mochilaOpt);
                    }

                }

            }

        }

    }

    public static void main(String[] args) {

        Elemento[] elementos = {
            new Elemento(1, 1),
            new Elemento(2, 2),
            new Elemento(4, 10),
            new Elemento(1, 2),
            new Elemento(12, 15)
        };
//Se crea la mochila base que servira como borrador para probar el más optimo
        Mochila m_base = new Mochila(15, elementos.length);
//Aqui se pondra las mejores optimizaciones las cuales den mejores beneficios        
        Mochila m_opt = new Mochila(15, elementos.length);

        llenarMochila(m_base, elementos, false, m_opt);

        System.out.println(m_opt);
    }

}
