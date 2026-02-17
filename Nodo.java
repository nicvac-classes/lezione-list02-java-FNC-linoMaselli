public Class Nodo <T>{

    private T dato;
    private Nodo next;

    public Nodo <T> (T dato) {
        this.dato = dato;
        next = null;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getNext() {
        return next;
    }

}