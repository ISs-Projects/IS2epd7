/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ContactoController;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Norberto Díaz-Díaz
 */
public class ContactoModelImpl implements ContactoModel {

    private ContactoController controller;
    private List<Contacto> contactos;

    public ContactoModelImpl() {
        contactos = new ArrayList<Contacto>();
    }

    public ContactoController getController() {
        return controller;
    }

    public void setController(ContactoController controller) {
        this.controller = controller;
    }

    public void nuevoContacto(Contacto contacto) {
        contactos.add(contacto);
        this.controller.fireDataModelChanged();
    }

    public void eliminarContacto(Contacto contacto) {
        contactos.remove(obtenerContacto(contacto.getNombre()));
        this.controller.fireDataModelChanged();
    }

    public Contacto obtenerContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    public void actualizarContacto(Contacto contacto) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equals(contacto.getNombre())) {
                contactos.set(i, contacto);
                break;
            }
        }
        this.controller.fireDataModelChanged();
    }

    public List<Contacto> obtenerContactos() {
        return contactos;
    }
}
