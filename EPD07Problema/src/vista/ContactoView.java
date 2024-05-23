

package vista;

import controlador.ContactoController;
import modelo.ContactoModel;

/**
 *
 * MODIFICA LA INTERFAZ DE CONTACTOVIEW
 */
public interface ContactoView {

    ContactoController getController();
    void setController(ContactoController controller);

    ContactoModel getModel();
    void setModel(ContactoModel model);

    void dataModelChanged();
    void display();
}
