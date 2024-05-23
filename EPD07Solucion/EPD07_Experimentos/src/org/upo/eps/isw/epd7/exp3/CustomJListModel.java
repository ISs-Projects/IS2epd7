
package org.upo.eps.isw.epd7.exp3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class CustomJListModel implements ListModel {

    private List<String> colores = null;
    private List<ListDataListener> listeners = null;

    public CustomJListModel() {
        super();
        this.colores = new ArrayList<String>();
        this.listeners = new ArrayList<ListDataListener>();
        
        this.colores.add("Rojo");
        this.colores.add("Verde");
        this.colores.add("Azul");
    }
    
    public void addColor(String color) {
        this.colores.add(color);
        notificarObservadores();
    }

    /**
     * PAra no tener que llamar directamente al modelo
     */
    public void notificarObservadores(){
        ListDataEvent e =new ListDataEvent(this,ListDataEvent.CONTENTS_CHANGED,0,colores.size());
        for(ListDataListener l:listeners){
            l.contentsChanged(e);
        }
    }
    
    @Override
    public int getSize() {
        return this.colores.size();
    }

    @Override
    public String getElementAt(int index) {
        return this.colores.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        listeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        listeners.remove(l);
    }
}
