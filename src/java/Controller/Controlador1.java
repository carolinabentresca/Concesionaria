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
public class Controlador1 {

    Conexion conexion = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(conexion.Conectar());
    ModelAndView mv = new ModelAndView();
    List datos;
    int id;

    @RequestMapping(value = "index.htm", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "menu1.htm", method = RequestMethod.GET)
    public ModelAndView getMenú() {
        String sql = "select id,marca,modelo,precio from producto1";
        datos = this.jdbcTemplate.queryForList(sql);
        mv.addObject("lista", datos);
        mv.setViewName("menu1");
        return mv;
    }

    @RequestMapping(value = "oferta1.htm", method = RequestMethod.GET)
    public ModelAndView getOferta(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select id,modelo,color,precio,cuota from producto1 where id = " + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mv.addObject("lista", datos);
        mv.setViewName("oferta1");
        return mv;
    }

    @RequestMapping(value = "contacto1.htm", method = RequestMethod.GET)
    public ModelAndView getContacto() {
        mv.setViewName("contacto1");
        return mv;
    }

    @RequestMapping(value = "venta1.htm", method = RequestMethod.GET)
    public ModelAndView getVenta() {
        String sql = "select id_producto,modelo,color,precio, sum(cantidad_venta) as vendidos "
                + "from venta1 "
                + "group by id_producto,modelo,color,precio"
                + " having sum(cantidad_venta) >= 40"
                + " order by vendidos desc";
        try {
            datos = this.jdbcTemplate.queryForList(sql);
            mv.addObject("lista", datos);
            mv.setViewName("venta1");
        } catch (DataAccessException e) {
            e.getMessage();
        }
        return mv;
    }

}
