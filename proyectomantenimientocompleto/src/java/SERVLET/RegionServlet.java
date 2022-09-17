
package SERVLET;

import BEAN.RegionBean;
import DAO.RegionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opcad=request.getParameter("op");
        int op = Integer.parseInt(opcad);
        switch(op){
            case 1:{
                RegionDAO objRegionDAO = new RegionDAO();
                ArrayList listaregion=objRegionDAO.ListarRegion();
                request.setAttribute("listaregion",listaregion);
                getServletContext().getRequestDispatcher("/FrmRegionMant.jsp").forward(request, response);
                break;
            }
            case 2:{
                getServletContext().getRequestDispatcher("/FrmMenuMant.jsp").forward(request, response);
                break;
            }
            case 3:{
                getServletContext().getRequestDispatcher("/FrmRegionRegistrarMant.jsp").forward(request, response);
                break;
            }
            case 4:{
                String mensaje="";
                String codcad=request.getParameter("txtcodigo");
                int codigo=Integer.parseInt(codcad);
                String nombre = request.getParameter("txtnombre");
                RegionBean objRegionBean = new RegionBean();
                objRegionBean.setCODREGION(codigo);
                objRegionBean.setNOMBREGION(nombre);
                RegionDAO objRegionDAO = new RegionDAO();
                int estado = objRegionDAO.InsertarRegion(objRegionBean);
                if(estado==1){
                    mensaje="Registro Insertado !!";
                }else{
                    mensaje="Registro no insertado";
                }
                request.setAttribute("mensaje",mensaje);
                getServletContext().getRequestDispatcher("/FrmRegionRegistrarMant.jsp").forward(request, response);
                break;
            }
            case 5:{
                RegionDAO objRegionDAO = new RegionDAO();
                ArrayList listaregion=objRegionDAO.ListarRegion();
                request.setAttribute("listaregion",listaregion);
                getServletContext().getRequestDispatcher("/FrmRegionMant.jsp").forward(request, response);
                break;
            }
            case 6:{
                String codcad=request.getParameter("COD");
                int codigo = Integer.parseInt(codcad);
                String nombre=request.getParameter("NOM");
                RegionBean objRegionBean = new RegionBean();
                objRegionBean.setCODREGION(codigo);
                objRegionBean.setNOMBREGION(nombre);
                request.setAttribute("datos", objRegionBean);
                getServletContext().getRequestDispatcher("/FrmRegionModificarMant.jsp").forward(request, response);
                break;
            }
            case 7:{
                String mensaje="";
                String codcad=request.getParameter("CODIGO");
                int codigo=Integer.parseInt(codcad);
                String nombre = request.getParameter("txtnombre");
                RegionBean objRegionBean = new RegionBean();
                objRegionBean.setCODREGION(codigo);
                objRegionBean.setNOMBREGION(nombre);
                RegionDAO objRegionDAO = new RegionDAO();
                int estado = objRegionDAO.ModificarRegion(objRegionBean);
                if(estado==1){
                    mensaje="Registro Modificado";
                }else{
                    mensaje="Registro no Modificado";
                }
                request.setAttribute("mensaje",mensaje);
                request.setAttribute("datos",objRegionBean);
                getServletContext().getRequestDispatcher("/FrmRegionModificarMant.jsp").forward(request, response);
                break;
            }
            case 8:{
                String codcad=request.getParameter("COD");
                int codigo = Integer.parseInt(codcad);

                RegionBean objRegionBean = new RegionBean();
                objRegionBean.setCODREGION(codigo);
                
                RegionDAO objRegionDAO = new RegionDAO();
                objRegionDAO.EliminarRegion(objRegionBean);
                
                ArrayList listaregion=objRegionDAO.ListarRegion();
                request.setAttribute("listaregion",listaregion);
                getServletContext().getRequestDispatcher("/FrmRegionMant.jsp").forward(request, response);
                break;
            }
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
