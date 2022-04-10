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
public class Controlador2 {

    Conexion conexion = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(conexion.Conectar());
    ModelAndView mv = new ModelAndView();
    List datos;
    int id;

    @RequestMapping(value = "menu2.htm", method = RequestMethod.GET)
    public ModelAndView getMenú() {
        String sql = "select id,marca,modelo,precio from producto2";
        datos = this.jdbcTemplate.queryForList(sql);
        mv.addObject("lista", datos);
        mv.setViewName("menu2");
        return mv;
    }

    @RequestMapping(value = "oferta2.htm", method = RequestMethod.GET)
    public ModelAndView getOferta(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select id,modelo,color,precio,cuota from producto2 where id = " + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mv.addObject("lista", datos);
        mv.setViewName("oferta2");
        return mv;
    }

    @RequestMapping(value = "contacto2.htm", method = RequestMethod.GET)
    public ModelAndView getContacto() {
        mv.setViewName("contacto2");
        return mv;
    }

    @RequestMapping(value = "venta2.htm", method = RequestMethod.GET)
    public ModelAndView getVenta() {
        String sql = "select id_producto,modelo,color,precio, sum(cantidad_venta) as vendidos "
                + "from venta2 "
                + "group by id_producto,modelo,color,precio"
                + " having sum(cantidad_venta) >= 40"
                + " order by vendidos desc";
        try {
            datos = this.jdbcTemplate.queryForList(sql);
            mv.addObject("lista", datos);
            mv.setViewName("venta2");
        } catch (DataAccessException e) {
            e.getMessage();
        }
        return mv;
    }

}
