package com.utc.sistema_tevcol.repository;

import com.utc.sistema_tevcol.entity.Catalogo;
import java.sql.*;
import java.util.*;

public class CatalogoRepository {

    private Connection con;

    public CatalogoRepository(Connection con) {
        this.con = con;
    }

    public void guardar(Catalogo c) throws SQLException {
        String sql = "INSERT INTO catalogo (tipo_cat, descripcion_cat, estado_cat) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, c.getTipoCat());
        ps.setString(2, c.getDescripcionCat());
        ps.setString(3, c.getEstadoCat());
        ps.executeUpdate();
    }

    public List<Catalogo> listar() throws SQLException {
        List<Catalogo> lista = new ArrayList<>();
        String sql = "SELECT * FROM catalogo";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            Catalogo c = new Catalogo(
                rs.getLong("codigo_cat"),
                rs.getString("tipo_cat"),
                rs.getString("descripcion_cat"),
                rs.getString("estado_cat")
            );
            lista.add(c);
        }
        return lista;
    }

    public void actualizar(Catalogo c) throws SQLException {
        String sql = "UPDATE catalogo SET tipo_cat=?, descripcion_cat=?, estado_cat=? WHERE codigo_cat=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, c.getTipoCat());
        ps.setString(2, c.getDescripcionCat());
        ps.setString(3, c.getEstadoCat());
        ps.setLong(4, c.getCodigoCat());
        ps.executeUpdate();
    }

    public void eliminar(Long id) throws SQLException {
        String sql = "DELETE FROM catalogo WHERE codigo_cat=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        ps.executeUpdate();
    }
}