import java.util.NoSuchElementException;

public class Lista<T> {

    Nodo<T> head;
    
    public Lista<T>(Nodo<T> head) {
        head = null;
    }

    public boolean vuota() {
        if (head.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void aggiungiInTesta(T dato) {
        Nodo<T> nuovoNodo = new Nodo(dato);
        nuovoNodo.next = head;
        head = nuovoNodo;
    }

    public void aggiungiInCoda(T dato) {
        Nodo <T> nuovoNodo = new Nodo(dato);

        if (head == null) {
            head = nuovoNodo;
        }

        Nodo<T> curr = head;
        while (curr != null) {
            curr = curr.next;
        }
        curr.next = nuovoNodo;
    }

    public void aggiungiInPosizione(T dato, int posizione) {
        if (posizione==0) {
            this.aggiungiInTesta(dato);
        } else {
            Nodo<T> curr = head;
            currI = 0;
            while (currI<posizione-1 && curr!=null) {
                curr = curr.next;
                ++currI;
            }
            if (curr.next!=null) {
                Nodo <T> nuovoNodo = new Nodo<>(dato);
                nuovoNodo.next = curr.next;
                curr.next = nuovoNodo;
            } else {
                throw new IndexOutOfBoundsException("Posizione oltre la Lista");
            }
            
        }
        
    }

    public T leggiTesta() {
        if (head == null) {
            throw new NoSuchElementException("Lista vuota");
        }
        return head.dato;
    }
    
    public T leggiCoda() {
        if (head == null) {
            throw new NoSuchElementException("Lista vuota");
        }
        Nodo<T> current = head;
        while (current!=null) {
            current = current.next;
        }
        return current.dato;
    }

    public T leggiinPosizione() {
        if (head==null) {
            throw new NoSuchElementException("Lista vuota");
        }
        if (posizione<0) {
            throw new IndexOutOfBoundsException("Posizione negativa");
        } 
        Nodo <T> curr = head;
        int currI = 0;
        while (currI<posizione-1 && curr!=null) {
            curr = curr.next;
            currI++;
        }
        if (curr!=null) {
            return curr.dato;   
        }
    }

    public int size() {
        Nodo <T> curr = head;
        int cont = 0;
        while (curr!=null) {
            curr = curr.next;
            ++cont;
        }
        return cont;
    }

    public boolean contains(T elem) {
        Nodo<T> curr = head;
        while (curr!=null) {
            T dato = curr.dato;
            if (dato instanceof String && elem instanceof String) {
                if (((String) dato).equalsIgnoreCase((String)elem)) {
                    return true;
                }
            }
            if (dato.equals(elem)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public int indexOf(T elem) {
        Nodo<T> curr = head;
        int idx = 0;
        while (curr!=null) {
            T dato = curr.dato;
            if (dato instanceof String && elem instanceof String) {
                if (((String) dato).equalsIgnoreCase((String)elem)) {
                    return idx;
                }
            }
            if (dato.equals(elem)) {
                return idx;
            }
            curr = curr.next;
            ++idx;
        }
        return -1;
    }

    public boolean cancella(T dato) {
        if (head == null) {
            return false;
        }
        
        if (head.dato.equals(dato)) {
            head = head.next;
            return true;
        }
        
        Nodo<T> precedente = head;
        Nodo<T> corrente = head.next;
        
        while (corrente != null) {
            if (corrente.dato.equals(dato)) {
                precedente.next = corrente.next;
                return true;
            }
            precedente = corrente;
            corrente = corrente.next;
        }
        
        return false;
    }

    public T cancellaInPosizione(int pos) {
        if (head==null || pos<0) {
            throw new IndexOutOfBoundsException("Lista vuota o posizione negativa.");
        }
        if (pos==0) {
            T dato = head.dato;
            head = head.next;
            return dato;
        }
        Nodo <T> prec = head;
        Nodo <T> curr = head.next;
        int cont = 1;
        while (curr!=null) {
            if (cont==pos) {
                T dato = curr.dato;
                prec.next = curr.next;
                return dato;
            }
            prec = curr;
            curr = curr.next;
            ++cont;
        }
        throw new IndexOutOfBoundsException("Posizione troppo grande");
    }

}