package pe.edu.upeu.syscenterfile.servicio;

import java.util.List;
import java.util.Properties;
import pe.edu.upeu.syscenterfile.modelo.MenuMenuItenTO;

public interface MenuMenuItemDaoI {

    public List<MenuMenuItenTO> listaAccesos(String perfil, Properties idioma);
}

