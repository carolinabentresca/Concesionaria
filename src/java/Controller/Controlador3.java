package Controller;

import Config.Conexion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador3 {

    Conexion conexion = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(conexion.Conectar());
    ModelAndView mv = new ModelAndView();
    List datos;
    int id;

    @RequestMapping(value = "menu3.htm", method = RequestMethod.GET)
    public ModelAndView getMenú() {
        String sql = "select id,marca,modelo,precio from producto3";
        datos = this.jdbcTemplate.queryForList(sql);
        mv.addObject("lista", datos);
        mv.setViewName("menu3");
        return mv;
    }

    @RequestMapping(value = "oferta3.htm", method = RequestMethod.GET)
    public ModelAndView getOferta(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select id,modelo,color,precio,cuota from producto3 where id = " + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mv.addObject("lista", datos);
        mv.setViewName("oferta3");
        return mv;
    }

    @RequestMapping(value = "contacto3.htm", method = RequestMethod.GET)
    public ModelAndView getContacto() {
        mv.setViewName("contacto3");
        return mv;
    }

    @RequestMapping(value = "venta3.htm", method = RequestMethod.GET)
    public ModelAndView getVenta() {
        String sql = "select id_producto,modelo,color,precio, sum(cantidad_venta) as vendidos "
                + "from venta3 "
                + "group by id_producto,modelo,color,precio"
                + " having sum(cantidad_venta) >= 40"
                + " order by vendidos desc";
        try {
            datos = this.jdbcTemplate.queryForList(sql);
            mv.addObject("lista", datos);
            mv.setViewName("venta3");
        } catch (DataAccessException e) {
            e.getMessage();
        }
        return mv;
    }
}
