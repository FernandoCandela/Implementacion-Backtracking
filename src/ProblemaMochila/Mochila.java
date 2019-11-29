package ProblemaMochila;

public class Mochila {

    private int pesoMaximo;
    private Elemento[] elementos;

    //Se pone las variables peso y beneficios actuales
    private int peso;
    private int beneficio;

    public Mochila(int pesoMaximo, int numElementos) {
        this.pesoMaximo = pesoMaximo;
        this.elementos = new Elemento[numElementos];//Se pondra la cantidad de elemtos que se desea poner
        this.beneficio = 0;
        this.peso = 0;
    }

    public Elemento[] getElementos() {
        return elementos;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    /**
     * Añade un elemento a la mochila
     *
     * @param e
     */
    public void añadirElemento(Elemento e) {
//al momento de añadir un elemento tambien se la va a añadir su peso y beneficio
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] == null) {
                this.elementos[i] = e;
                this.beneficio += e.getBeneficio();
                this.peso += e.getPeso();
                break;
            }
        }

    }

    public void limpiar() {
//Aca se vaceara o se reseteara la mochila para probar otros valores         
        this.peso = 0;
        this.beneficio = 0;
        for (int i = 0; i < this.elementos.length; i++) {
            this.elementos[i] = null;
        }
    }

    public void eliminarElemento(Elemento e) {
//al momento de elimar un elemento se elimina el beneficio y el peso         
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i].equals(e)) {
                this.elementos[i] = null;
                this.peso -= e.getPeso();
                this.beneficio -= e.getBeneficio();
                break;
            }
        }
    }

    public boolean existeElemento(Elemento e) {
//Esto para evitar estar repitiendo los elementos
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] != null && this.elementos[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
//sirve para mostrar los elementos y sus beneficios        
        String cadena = "";
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] != null) {
                cadena += elementos[i] + "\n";
            }
        }
        cadena += "Peso: " + getPeso() + "\n";
        cadena += "Beneficio: " + getBeneficio() + "\n";
        return cadena;
    }

}
