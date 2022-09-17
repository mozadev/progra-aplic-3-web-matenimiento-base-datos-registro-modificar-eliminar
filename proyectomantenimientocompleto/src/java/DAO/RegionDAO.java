
package DAO;

import BEAN.RegionBean;
import UTIL.ConexionBD;
import java.util.*;
import java.sql.*;

public class RegionDAO {
    
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    ArrayList<RegionBean> lista=null;
    RegionBean objRegionBean=null;
    
    public ArrayList<RegionBean> ListarRegion(){
        try {
            cn=ConexionBD.getConexionBD();
            pt=cn.prepareStatement("select * from region;");
            rs=pt.executeQuery();
            lista=new ArrayList<RegionBean>();
            while(rs.next()){
                objRegionBean=new RegionBean();
                objRegionBean.setCODREGION(rs.getInt(1));
                objRegionBean.setNOMBREGION(rs.getString(2));
                lista.add(objRegionBean);
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int InsertarRegion(RegionBean objRegionBean){
        int estado=0;
        try {
            cn=ConexionBD.getConexionBD();
            pt=cn.prepareStatement("insert into region(CODREGION,NOMBREGION) VALUES(?,?);");
            pt.setInt(1, objRegionBean.getCODREGION());
            pt.setString(2, objRegionBean.getNOMBREGION());
            estado=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return estado;
    }
    
    public int ModificarRegion(RegionBean objRegionBean){
        int estado=0;
        try {
            cn=ConexionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE region set NOMBREGION=? WHERE CODREGION=?;");
            pt.setString(1, objRegionBean.getNOMBREGION());
            pt.setInt(2, objRegionBean.getCODREGION());
            estado=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return estado;
    }
    
    public int EliminarRegion(RegionBean objRegionBean){
        int estado=0;
        try {
            cn=ConexionBD.getConexionBD();
            pt=cn.prepareStatement("DELETE FROM region WHERE CODREGION=?;");
            pt.setInt(1, objRegionBean.getCODREGION());
            estado=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return estado;
    }
}
