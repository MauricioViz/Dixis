/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectopoo2;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static com.mycompany.proyectopoo2.FrmVenta.txtCodCliVenta;
import static com.mycompany.proyectopoo2.FrmVenta.txtRazSocCliVenta;
import controller.CompraController;
import controller.DetalleCompraController;
import controller.ProductoController;
import controller.ProveedorController;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Compra;
import model.DetalleCompra;
import model.Producto;
import model.Proveedor;
import services.funciones;

/**
 *
 * @author CHRISTOPHER
 */
public class FrmCompra extends javax.swing.JFrame {
    private DefaultTableModel dtmProveedor = new DefaultTableModel();
    private DefaultTableModel dtmProducto = new DefaultTableModel();
    private DefaultTableModel dtmCompra = new DefaultTableModel();
    private DefaultTableModel dtmDetCompra = new DefaultTableModel();
    private ProveedorController proController = new ProveedorController();
    private ProductoController prodController = new ProductoController();
    private DetalleCompraController detComController = new DetalleCompraController();
    private CompraController comController = new CompraController();
    private DecimalFormat df = new DecimalFormat("0.00");
    /**
     * Creates new form FrmCompra
     */
    public FrmCompra() {
        initComponents();
        columnaProv();
        columnaProd();
        columnaCompra();
        columnaDetCompra();
        listarProv();
        listarProd();
        listarDetCompra();
        this.setLocationRelativeTo(null);
    }
    
    public void columnaProv()
    {
        dtmProveedor.addColumn("CODIGO");
        dtmProveedor.addColumn("RAZON SOCIAL");
        dtmProveedor.addColumn("RUC");
        dtmProveedor.addColumn("TELEFONO");
        dtmProveedor.addColumn("DIRECCION");
        this.GrillaProveedor.setModel(dtmProveedor);
    }
    
    public void columnaProd()
    {
        dtmProducto.addColumn("CODIGO");
        dtmProducto.addColumn("PROVEEDOR");
        dtmProducto.addColumn("NOMBRE");
        dtmProducto.addColumn("PRECIO COMPRA");
        dtmProducto.addColumn("PRECIO VENTA");
        dtmProducto.addColumn("CANTIDAD");
        this.GrillaProducto.setModel(dtmProducto);
    }
    
    public void columnaCompra()
    {
        dtmCompra.addColumn("PRODUCTO");
        dtmCompra.addColumn("DESCRIPCION");
        dtmCompra.addColumn("CANTIDAD");
        dtmCompra.addColumn("PRECIO");
        dtmCompra.addColumn("IGV");
        dtmCompra.addColumn("TOTAL");
        this.GrillaCompra.setModel(dtmCompra);
    }
    
    public void columnaDetCompra()
    {
        dtmDetCompra.addColumn("COMPRA");
        dtmDetCompra.addColumn("PRODUCTO");
        dtmDetCompra.addColumn("CANTIDAD");
        dtmDetCompra.addColumn("PRECIO UNITARIO");
        dtmDetCompra.addColumn("TOTAL");
        this.GrillaDetalleCompra.setModel(dtmDetCompra);
    }
    
    public void columnaDetCom()
    {
        dtmProducto.addColumn("CODIGO");
        dtmProducto.addColumn("PRODUCTO");
        dtmProducto.addColumn("CANTIDAD");
        dtmProducto.addColumn("PRECIO COMPRA");
        dtmProducto.addColumn("TOTAL");
        this.GrillaProducto.setModel(dtmProducto);
    }
        
    public void listarProv()
    {
        List<Proveedor> lst = proController.getAllProveedorController();
        dtmProveedor.setNumRows(0);
        for(Proveedor x:lst)
        {
            Object[] vector = new Object[5];
            vector[0] = x.getIdProv();
            vector[1] = x.getRazSocProv();
            vector[2] = x.getRucProv();
            vector[3] = x.getTlfProv();
            vector[4] = x.getDirProv();
            dtmProveedor.addRow(vector);
        }
        GrillaProveedor.setModel(dtmProveedor);
    }
    
    public void listarProd()
    {
        List<Producto> lst = prodController.getAllProductoController();
        dtmProducto.setNumRows(0);
        for(Producto x:lst)
        {
            Object[] vector = new Object[6];
            vector[0] = x.getIdProd();
            vector[1] = x.getIdProv();
            vector[2] = x.getNomProd();
            vector[3] = x.getPreComProd();
            vector[4] = x.getPreVenProd();
            vector[5] = x.getCantidad();
            dtmProducto.addRow(vector);
        }
        GrillaProducto.setModel(dtmProducto);
    }
    public void listarDetCompra()
    {
        List<DetalleCompra> lst = detComController.getAllDetalleCompra();
        dtmDetCompra.setNumRows(0);
        for(DetalleCompra x:lst)
        {
            Object[] vector = new Object[5];
            vector[0] = x.getIdCompDetalleComp();
            vector[1] = x.getIdProDetalleComp();
            vector[2] = x.getCantDetalleComp();
            vector[3] = x.getPreDetalleComp();
            vector[4] = x.getTotalDetalleComp();
            dtmDetCompra.addRow(vector);
        }
        this.GrillaDetalleCompra.setModel(dtmDetCompra);
    }  
    public void limpiarProv()
    {
        this.txtCodProv.setText("");
        this.txtRazSocProv.setText("");
        this.txtRucProv.setText("");
        this.txtTelefProv.setText("");
        this.txtDirProv.setText("");
    }
    
    public void limpiarProd()
    {
        this.txtCodPro.setText("");
        this.txtCodProvProd.setText("");
        this.txtDesPro.setText("");
        this.txtPreComPro.setText("");
        this.txtPreVenPro.setText("");
        this.txtCantPro.setText("");
    }

    public void limpiarDetalle()
    {
        txtCodProdCompra.setText("");
        txtPrecioCompra.setText("");
        txtDesCompra.setText("");
        txtCantCompra.setText("");
        txtIgv.setText("");
    }
    
    public void limpiarCompra()
    {
        txtCodProvCompra.setText("");
        txtRazSocialProvCompra.setText("");
        txtCodEmpCompra.setText("");
        txtNomEmpCompra.setText("");
        txtSubTotalCompra.setText("");
        txtIgvCompra.setText("");
        txtTotalCompra.setText("");
        limpiarDetalle();
        limpiarTabla();
    }
    
    public void limpiarCompraTotal()
    {
        txtCodCompra.setText("");
        txtFechaCompra.setText("");
        txtCodProvCompra.setText("");
        txtRazSocialProvCompra.setText("");
        txtCodEmpCompra.setText("");
        txtNomEmpCompra.setText("");
        txtSubTotalCompra.setText("");
        txtIgvCompra.setText("");
        txtTotalCompra.setText("");
        limpiarDetalle();
        limpiarTabla();
    }
    
    public void limpiarTabla()
    {
        for(int i = 0; i < dtmCompra.getRowCount(); i++)
        {
            dtmCompra.removeRow(i);
            i = i - 1;
        }
    }
    
    private void remover()
    {
        DefaultTableModel modelo = (DefaultTableModel) GrillaCompra.getModel();
        int item = GrillaCompra.getSelectedRow();
        if(item >= 0)
        {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea quitar el producto?","Quitar producto",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(opcion == JOptionPane.YES_OPTION)
            {
                modelo.removeRow(item);
                calcularTotal();
            }  
            else
            {
                
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione una fila","Compras",JOptionPane.WARNING_MESSAGE);
        }
    }
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDesCompra = new javax.swing.JTextField();
        txtCantCompra = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        GrillaCompra = new javax.swing.JTable();
        btnEliminarNuevaCompra = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtRazSocialProvCompra = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSubTotalCompra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIgvCompra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotalCompra = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtCodEmpCompra = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtNomEmpCompra = new javax.swing.JTextField();
        btnAgregarProdCompra = new javax.swing.JButton();
        btnEliminarProdCompra = new javax.swing.JButton();
        txtCodProdCompra = new javax.swing.JTextField();
        txtCodProvCompra = new javax.swing.JTextField();
        btnVistaProd = new javax.swing.JButton();
        btnVistaProv = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        txtIgv = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtCodCompra = new javax.swing.JTextField();
        btnNuevaCompra = new javax.swing.JButton();
        btnObtenerEmpleado = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtFechaCompra = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        GrillaDetalleCompra = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtRucProv = new javax.swing.JTextField();
        txtRazSocProv = new javax.swing.JTextField();
        txtTelefProv = new javax.swing.JTextField();
        txtDirProv = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        GrillaProveedor = new javax.swing.JTable();
        btnNuevoProv = new javax.swing.JButton();
        btnGuardarProv = new javax.swing.JButton();
        btnEliminarProv = new javax.swing.JButton();
        btnModProv = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarProv = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCodProv = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtCodPro = new javax.swing.JTextField();
        txtDesPro = new javax.swing.JTextField();
        txtCantPro = new javax.swing.JTextField();
        txtPreVenPro = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        GrillaProducto = new javax.swing.JTable();
        btnAgregarPro = new javax.swing.JButton();
        btnModificarPro = new javax.swing.JButton();
        btnEliminarPro = new javax.swing.JButton();
        btnNuevoPro = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        txtPreComPro = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtBuscarPro = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtCodProvProd = new javax.swing.JTextField();
        btnObtenerProveedor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("PROCESO DE COMPRA");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel23)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 800, -1));

        jPanel10.setBackground(new java.awt.Color(0, 51, 153));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Bodoni MT Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DIXIS");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(37, 37, 37))
        );

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\proveedor.png")); // NOI18N
        jButton3.setText("Proveedor");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\inventario.png")); // NOI18N
        jButton4.setText("Productos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(102, 102, 102));
        jButton5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\compra.png")); // NOI18N
        jButton5.setText(" Detalle Compra");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(102, 102, 102));
        jButton6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\nueva compra.png")); // NOI18N
        jButton6.setText("Nueva compra");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(102, 102, 102));
        btnCerrar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(204, 0, 0));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton5)
                .addGap(42, 42, 42)
                .addComponent(jButton3)
                .addGap(40, 40, 40)
                .addComponent(jButton4)
                .addGap(40, 40, 40)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, 510));

        jLabel9.setText("Codigo");

        jLabel10.setText("Descripción");

        jLabel11.setText("Cantidad");

        txtDesCompra.setEditable(false);

        txtCantCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantCompraActionPerformed(evt);
            }
        });
        txtCantCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantCompraKeyTyped(evt);
            }
        });

        GrillaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(GrillaCompra);

        btnEliminarNuevaCompra.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEliminarNuevaCompra.setForeground(new java.awt.Color(0, 0, 153));
        btnEliminarNuevaCompra.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\imprimir.png")); // NOI18N
        btnEliminarNuevaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarNuevaCompraActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel3.setText("PRODUCTO:");

        jLabel12.setText("Precio");

        txtPrecioCompra.setEditable(false);
        txtPrecioCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioCompraActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel4.setText("PROVEEDOR:");

        jLabel13.setText("Codigo");

        txtRazSocialProvCompra.setEditable(false);

        jLabel14.setText("Razón Social");

        jLabel6.setText("Sub total:");

        jLabel7.setText("IGV:");

        jLabel8.setText("Total:");

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel17.setText("EMPLEADO:");

        jLabel21.setText("Codigo");

        txtCodEmpCompra.setEditable(false);

        jLabel28.setText("Nombre");

        txtNomEmpCompra.setEditable(false);

        btnAgregarProdCompra.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAgregarProdCompra.setForeground(new java.awt.Color(0, 0, 255));
        btnAgregarProdCompra.setText("Agregar");
        btnAgregarProdCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProdCompraActionPerformed(evt);
            }
        });

        btnEliminarProdCompra.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEliminarProdCompra.setForeground(new java.awt.Color(0, 0, 255));
        btnEliminarProdCompra.setText("Eliminar");
        btnEliminarProdCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProdCompraActionPerformed(evt);
            }
        });

        txtCodProdCompra.setEditable(false);

        txtCodProvCompra.setEditable(false);

        btnVistaProd.setText("...");
        btnVistaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVistaProdActionPerformed(evt);
            }
        });

        btnVistaProv.setText("...");
        btnVistaProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVistaProvActionPerformed(evt);
            }
        });

        jLabel31.setText("IGV");

        txtIgv.setEditable(false);
        txtIgv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIgvKeyTyped(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel32.setText("Código:");

        txtCodCompra.setEditable(false);

        btnNuevaCompra.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnNuevaCompra.setForeground(new java.awt.Color(0, 0, 255));
        btnNuevaCompra.setText("Nuevo");
        btnNuevaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaCompraActionPerformed(evt);
            }
        });

        btnObtenerEmpleado.setText("...");
        btnObtenerEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerEmpleadoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel5.setText("Fecha:");

        txtFechaCompra.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIgvCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarNuevaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtCodProvCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRazSocialProvCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnVistaProv)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodEmpCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtNomEmpCompra)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnObtenerEmpleado))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(29, 29, 29))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(btnNuevaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtCodProdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDesCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCantCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(btnVistaProd)
                                        .addGap(30, 30, 30)
                                        .addComponent(btnEliminarProdCompra))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarProdCompra)))))
                .addGap(46, 46, 46))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtCodCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaCompra)
                    .addComponent(jLabel5)
                    .addComponent(txtFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDesCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodProdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAgregarProdCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarProdCompra)
                            .addComponent(btnVistaProd))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRazSocialProvCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodProvCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVistaProv)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodEmpCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomEmpCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnObtenerEmpleado))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnEliminarNuevaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIgvCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtSubTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nueva Compra", jPanel3);

        GrillaDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CODIGO", "DESCRIPCION", "CANTIDAD"
            }
        ));
        jScrollPane4.setViewportView(GrillaDetalleCompra);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Detalle Compra", jPanel5);

        jLabel18.setText("RUC:");

        jLabel19.setText("Razón social:");

        jLabel20.setText("Teléfono:");

        jLabel22.setText("Dirección:");

        txtRucProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucProvKeyTyped(evt);
            }
        });

        txtRazSocProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazSocProvKeyTyped(evt);
            }
        });

        txtTelefProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefProvKeyTyped(evt);
            }
        });

        GrillaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "RUC", "RAZON SOCIAL", "TELEFONO", "DIRECCION", "CORREO"
            }
        ));
        GrillaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrillaProveedorMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(GrillaProveedor);

        btnNuevoProv.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnNuevoProv.setForeground(new java.awt.Color(0, 0, 153));
        btnNuevoProv.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\nueva compra.png")); // NOI18N
        btnNuevoProv.setText("Nuevo");
        btnNuevoProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProvActionPerformed(evt);
            }
        });

        btnGuardarProv.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardarProv.setForeground(new java.awt.Color(0, 0, 153));
        btnGuardarProv.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\guardar.png")); // NOI18N
        btnGuardarProv.setText("Guardar");
        btnGuardarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProvActionPerformed(evt);
            }
        });

        btnEliminarProv.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEliminarProv.setForeground(new java.awt.Color(0, 0, 153));
        btnEliminarProv.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\eliminar.png")); // NOI18N
        btnEliminarProv.setText("Eliminar");
        btnEliminarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProvActionPerformed(evt);
            }
        });

        btnModProv.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnModProv.setForeground(new java.awt.Color(0, 0, 153));
        btnModProv.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\modificar.png")); // NOI18N
        btnModProv.setText("Modificar");
        btnModProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModProvActionPerformed(evt);
            }
        });

        jLabel2.setText("Razon Social:");

        txtBuscarProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProvKeyReleased(evt);
            }
        });

        jLabel15.setText("Codigo:");

        txtCodProv.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtRazSocProv))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTelefProv, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                        .addComponent(txtDirProv)
                                        .addComponent(txtCodProv)))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(txtRucProv, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(btnGuardarProv)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnEliminarProv))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addComponent(btnNuevoProv))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(btnModProv))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarProv)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtCodProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(txtRazSocProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtRucProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(txtTelefProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel22))
                            .addComponent(txtDirProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(btnNuevoProv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardarProv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarProv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModProv)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proveedor", jPanel7);

        jLabel24.setText("Código:");

        jLabel25.setText("Descripción:");

        jLabel26.setText("Cantidad:");

        jLabel27.setText("Precio de venta:");

        txtCodPro.setEditable(false);

        txtDesPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDesProKeyTyped(evt);
            }
        });

        txtCantPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantProKeyTyped(evt);
            }
        });

        txtPreVenPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPreVenProKeyTyped(evt);
            }
        });

        GrillaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        GrillaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrillaProductoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(GrillaProducto);

        btnAgregarPro.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAgregarPro.setForeground(new java.awt.Color(0, 0, 153));
        btnAgregarPro.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\agregar.png")); // NOI18N
        btnAgregarPro.setText("Agregar");
        btnAgregarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProActionPerformed(evt);
            }
        });

        btnModificarPro.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnModificarPro.setForeground(new java.awt.Color(0, 0, 153));
        btnModificarPro.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\modificar producto.png")); // NOI18N
        btnModificarPro.setText("Modificar");
        btnModificarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProActionPerformed(evt);
            }
        });

        btnEliminarPro.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEliminarPro.setForeground(new java.awt.Color(0, 0, 153));
        btnEliminarPro.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\eliminar producto.png")); // NOI18N
        btnEliminarPro.setText("Eliminar");
        btnEliminarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProActionPerformed(evt);
            }
        });

        btnNuevoPro.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnNuevoPro.setForeground(new java.awt.Color(0, 0, 153));
        btnNuevoPro.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\nuevo producto.png")); // NOI18N
        btnNuevoPro.setText("Nuevo");
        btnNuevoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProActionPerformed(evt);
            }
        });

        jLabel29.setText("Precio de compra:");

        jLabel30.setText("Descripción");

        txtBuscarPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProKeyReleased(evt);
            }
        });

        jLabel16.setText("Proveedor:");

        txtCodProvProd.setEditable(false);

        btnObtenerProveedor.setText("...");
        btnObtenerProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtBuscarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodProvProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnObtenerProveedor))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(txtDesPro, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(txtPreVenPro, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(txtPreComPro, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(txtCantPro, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addComponent(btnModificarPro))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(btnAgregarPro)
                                    .addGap(6, 6, 6)
                                    .addComponent(btnNuevoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGap(73, 73, 73)
                                    .addComponent(btnEliminarPro))))
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel24))
                    .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel30))
                    .addComponent(txtBuscarPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(txtCodProvProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnObtenerProveedor))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel25))
                            .addComponent(txtDesPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel27))
                            .addComponent(txtPreVenPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel29))
                            .addComponent(txtPreComPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel26))
                            .addComponent(txtCantPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarPro)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNuevoPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregarPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addComponent(btnEliminarPro))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Producto", jPanel6);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantCompraActionPerformed

    private void txtPrecioCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioCompraActionPerformed

    private void btnNuevoProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProvActionPerformed
        this.txtCodProv.setText(proController.getCorrelativoProveedor());
    }//GEN-LAST:event_btnNuevoProvActionPerformed

    private void btnGuardarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProvActionPerformed
        int msg = JOptionPane.showConfirmDialog(this.btnGuardarProv,"Deseas Guardar el Registro!!!","Guardar",JOptionPane.YES_NO_OPTION);
        if (msg == JOptionPane.YES_OPTION)
        {
            Proveedor pro = new Proveedor();
            pro.setIdProv(this.txtCodProv.getText());
            pro.setRazSocProv(this.txtRazSocProv.getText());
            pro.setRucProv(this.txtRucProv.getText());
            pro.setTlfProv(this.txtTelefProv.getText());
            pro.setDirProv(this.txtDirProv.getText());
            proController.addProveedorController(pro);
            listarProv();//Actualizar la BD
            limpiarProv();
            JOptionPane.showMessageDialog(this,"Registro Guardado Satisfactoriamente");
        }
    }//GEN-LAST:event_btnGuardarProvActionPerformed

    private void btnEliminarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProvActionPerformed
        int msg = JOptionPane.showConfirmDialog(null,"Deseas Eliminar el Registro!!!","Eliminar",JOptionPane.YES_NO_OPTION);
        if (msg == JOptionPane.YES_OPTION)
        {
            Proveedor pro = new Proveedor();
            pro.setIdProv(this.txtCodProv.getText());
            proController.removeProveedorController(pro);
            listarProv();//Actualizar la BD
            limpiarProv();
            JOptionPane.showMessageDialog(this,"Registro Eliminado Satisfactoriamente");
        }
    }//GEN-LAST:event_btnEliminarProvActionPerformed

    private void btnModProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModProvActionPerformed
        int msg = JOptionPane.showConfirmDialog(null,"Deseas Modificar el Registro!!!","Modificar",JOptionPane.YES_NO_OPTION);
        if (msg == JOptionPane.YES_OPTION)
        {
            Proveedor pro = new Proveedor();
            pro.setIdProv(this.txtCodProv.getText());
            pro.setRazSocProv(this.txtRazSocProv.getText());
            pro.setRucProv(this.txtRucProv.getText());
            pro.setTlfProv(this.txtTelefProv.getText());
            pro.setDirProv(this.txtDirProv.getText());
            proController.updateProveedorController(pro);
            listarProv();//Actualizar la BD
            limpiarProv();
            JOptionPane.showMessageDialog(this,"Registro Modificado Satisfactoriamente");
        }
    }//GEN-LAST:event_btnModProvActionPerformed

    private void GrillaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaProveedorMouseClicked
        this.txtCodProv.setText(GrillaProveedor.getValueAt(GrillaProveedor.getSelectedRow(), 0).toString());
        this.txtRazSocProv.setText(GrillaProveedor.getValueAt(GrillaProveedor.getSelectedRow(), 1).toString());
        this.txtRucProv.setText(GrillaProveedor.getValueAt(GrillaProveedor.getSelectedRow(), 2).toString());
        this.txtTelefProv.setText(GrillaProveedor.getValueAt(GrillaProveedor.getSelectedRow(), 3).toString());
        this.txtDirProv.setText(GrillaProveedor.getValueAt(GrillaProveedor.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_GrillaProveedorMouseClicked

    private void txtBuscarProvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProvKeyReleased
        Proveedor obj = new Proveedor();
        obj.setRazSocProv(this.txtBuscarProv.getText());
        List<Proveedor> lst = proController.getBuscarRazonSocialProveedorController(obj);
        dtmProveedor.setNumRows(0);
        for(Proveedor x:lst)
        {
            Object[] vector = new Object[5];
            vector[0] = x.getIdProv();
            vector[1] = x.getRazSocProv();
            vector[2] = x.getRucProv();
            vector[3] = x.getTlfProv();
            vector[4] = x.getDirProv();
            dtmProveedor.addRow(vector);
        }
        GrillaProveedor.setModel(dtmProveedor);
    }//GEN-LAST:event_txtBuscarProvKeyReleased

    private void btnAgregarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProActionPerformed
        int msg = JOptionPane.showConfirmDialog(null,"Deseas Agregar al Registro!!!","Agregar",JOptionPane.YES_NO_OPTION);
        if (msg == JOptionPane.YES_OPTION)
        {
            Producto prod = new Producto();
            prod.setIdProd(this.txtCodPro.getText());
            prod.setIdProv(this.txtCodProvProd.getText());
            prod.setNomProd(this.txtDesPro.getText());
            prod.setPreComProd(Double.parseDouble(this.txtPreComPro.getText()));
            prod.setPreVenProd(Double.parseDouble(this.txtPreVenPro.getText()));
            prod.setCantidad(Integer.parseInt(this.txtCantPro.getText()));
            prodController.addProductoController(prod);
            listarProd();//Actualizar la BD
            limpiarProd();
            JOptionPane.showMessageDialog(this,"Registro Agregado Satisfactoriamente");
        }
    }//GEN-LAST:event_btnAgregarProActionPerformed

    private void btnEliminarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProActionPerformed
        int msg = JOptionPane.showConfirmDialog(null,"Deseas Eliminar el Registro!!!","Eliminar",JOptionPane.YES_NO_OPTION);
        if (msg == JOptionPane.YES_OPTION)
        {
            Producto prod = new Producto();
            prod.setIdProd(this.txtCodPro.getText());
            prodController.removeProductoController(prod);
            listarProd();//Actualizar la BD
            limpiarProd();
            JOptionPane.showMessageDialog(this,"Registro Eliminado Satisfactoriamente");
        }
    }//GEN-LAST:event_btnEliminarProActionPerformed

    private void GrillaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaProductoMouseClicked
        this.txtCodPro.setText(GrillaProducto.getValueAt(GrillaProducto.getSelectedRow(), 0).toString());
        this.txtCodProvProd.setText(GrillaProducto.getValueAt(GrillaProducto.getSelectedRow(), 1).toString());
        this.txtDesPro.setText(GrillaProducto.getValueAt(GrillaProducto.getSelectedRow(), 2).toString());
        this.txtPreComPro.setText(GrillaProducto.getValueAt(GrillaProducto.getSelectedRow(), 3).toString());
        this.txtPreVenPro.setText(GrillaProducto.getValueAt(GrillaProducto.getSelectedRow(), 4).toString());
        this.txtCantPro.setText(this.GrillaProducto.getValueAt(GrillaProducto.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_GrillaProductoMouseClicked

    private void btnModificarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProActionPerformed
        int msg = JOptionPane.showConfirmDialog(null,"Deseas Modificar el Registro!!!","Modificar",JOptionPane.YES_NO_OPTION);
        if (msg == JOptionPane.YES_OPTION)
        {
            Producto prod = new Producto();
            prod.setIdProd(this.txtCodPro.getText());
            prod.setIdProv(this.txtCodProvProd.getText());
            prod.setNomProd(this.txtDesPro.getText());
            prod.setPreComProd(Double.parseDouble(this.txtPreComPro.getText()));
            prod.setPreVenProd(Double.parseDouble(this.txtPreVenPro.getText()));
            prod.setCantidad(Integer.parseInt(this.txtCantPro.getText()));
            prodController.updateProductoController(prod);
            listarProd();//Actualizar la BD
            limpiarProd();
            JOptionPane.showMessageDialog(this,"Registro Modificado Satisfactoriamente");
        }
    }//GEN-LAST:event_btnModificarProActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnNuevoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProActionPerformed
        this.txtCodPro.setText(prodController.getCorrelativoProducto());
    }//GEN-LAST:event_btnNuevoProActionPerformed

    private void txtRucProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucProvKeyTyped
        Character c = evt.getKeyChar();
        if(!Character.isDigit(c) || txtRucProv.getText().length() >= 11)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtRucProvKeyTyped

    private void txtTelefProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefProvKeyTyped
        Character c = evt.getKeyChar();
        if(!Character.isDigit(c) || txtRucProv.getText().length() >= 9)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefProvKeyTyped

    private void txtDesProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDesProKeyTyped
        Character c = evt.getKeyChar();
        if(!Character.isLetter(c) && c != KeyEvent.VK_SPACE)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtDesProKeyTyped

    private void txtRazSocProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazSocProvKeyTyped
        Character c = evt.getKeyChar();
        if(!Character.isLetter(c) && c != KeyEvent.VK_SPACE)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtRazSocProvKeyTyped

    private void txtPreVenProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPreVenProKeyTyped
        
    }//GEN-LAST:event_txtPreVenProKeyTyped

    private void txtCantProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantProKeyTyped
        Character c = evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantProKeyTyped

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtBuscarProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProKeyReleased
        Producto obj = new Producto();
        obj.setNomProd(this.txtBuscarPro.getText());
        List<Producto> lst = prodController.getBuscarDescripcionProductoController(obj);
        dtmProducto.setNumRows(0);
        for(Producto x:lst)
        {
            Object[] vector = new Object[6];
            vector[0] = x.getIdProd();
            vector[1] = x.getIdProv();
            vector[2] = x.getNomProd();
            vector[3] = x.getPreComProd();
            vector[4] = x.getPreVenProd();
            vector[5] = x.getCantidad();
            dtmProducto.addRow(vector);
        }
        GrillaProducto.setModel(dtmProducto);
    }//GEN-LAST:event_txtBuscarProKeyReleased

    private void btnVistaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVistaProdActionPerformed
        FrmVistaProducto frmProd = new FrmVistaProducto();
        frmProd.toFront();
        frmProd.setVisible(true);
        frmProd.opcion = 1;
    }//GEN-LAST:event_btnVistaProdActionPerformed

    private void btnVistaProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVistaProvActionPerformed
        FrmVistaProveedor frmProv = new FrmVistaProveedor();
        frmProv.toFront();
        frmProv.setVisible(true);
        frmProv.opcion = 1;
    }//GEN-LAST:event_btnVistaProvActionPerformed

    private void btnAgregarProdCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProdCompraActionPerformed
        if(txtCodProdCompra.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
            return;
        }
        if(txtCantCompra.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad");
            return;
        }
        if(txtIgv.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el igv");
            return;
        }
        AgregarProducto();
        limpiarDetalle();
    }//GEN-LAST:event_btnAgregarProdCompraActionPerformed

    private void btnEliminarProdCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProdCompraActionPerformed
        remover();
    }//GEN-LAST:event_btnEliminarProdCompraActionPerformed

    private void btnNuevaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaCompraActionPerformed
        txtCodCompra.setText(String.valueOf(comController.getCorrelativoCompraController()));
        txtFechaCompra.setText(funciones.getFechaActual());
        limpiarCompra();
    }//GEN-LAST:event_btnNuevaCompraActionPerformed

    private void btnObtenerProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerProveedorActionPerformed
        FrmVistaProveedor frmProv = new FrmVistaProveedor();
        frmProv.toFront();
        frmProv.setVisible(true);
        frmProv.opcion = 2;
    }//GEN-LAST:event_btnObtenerProveedorActionPerformed

    private void btnObtenerEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerEmpleadoActionPerformed
        FrmVistaEmpleado frmEmp = new FrmVistaEmpleado();
        frmEmp.toFront();
        frmEmp.setVisible(true);
        frmEmp.opcion = 3;
    }//GEN-LAST:event_btnObtenerEmpleadoActionPerformed

    private void txtCantCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantCompraKeyTyped
        Character c = evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantCompraKeyTyped

    private void txtIgvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIgvKeyTyped
        Character c = evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtIgvKeyTyped

    private void btnEliminarNuevaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarNuevaCompraActionPerformed
        if(txtCodProvCompra.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Seleccione un proveedor");
            return;
        }
        if(txtTotalCompra.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Agregue una compra");
            return;
        }
        if(txtCodEmpCompra.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Agregue al empleado que realizo la compra");
            return;
        }
        GuardarCompra();
        GuardarDetalle();
        listarDetCompra();
        pdf();
        limpiarCompraTotal();
    }//GEN-LAST:event_btnEliminarNuevaCompraActionPerformed

    void GuardarCompra()
    {
        int msg = JOptionPane.showConfirmDialog(null,"Deseas Agregar la compra","Compra",JOptionPane.YES_NO_OPTION);
        if (msg == JOptionPane.YES_OPTION)
        {
            Compra obj = new Compra();
            obj.setIdComp(Integer.parseInt(txtCodCompra.getText()));
            obj.setFechaComp(txtFechaCompra.getText());
            obj.setSubTotalComp(Double.parseDouble(txtSubTotalCompra.getText()));
            obj.setIgv(Double.parseDouble(txtIgvCompra.getText()));
            obj.setTotalComp(Double.parseDouble(txtTotalCompra.getText()));
            obj.setEstComp("RECIBIDO");
            obj.setIdEmpComp(txtCodEmpCompra.getText());
            obj.setIdProvComp(txtCodProvCompra.getText());
            comController.addCompraController(obj);
            JOptionPane.showMessageDialog(null, "La Compra se realizo con satisfactoriamente!");
            
            System.out.println(obj.getIdComp());
            System.out.println(obj.getFechaComp());
            System.out.println(obj.getSubTotalComp());
            System.out.println(obj.getIgv());
            System.out.println(obj.getTotalComp());
            System.out.println(obj.getEstComp());
            System.out.println(obj.getIdEmpComp());
            System.out.println(obj.getIdProvComp());
        }
    }
    
    void GuardarDetalle()
    {
        DetalleCompra obj = new DetalleCompra();
        
        for(int i = 0; i < GrillaCompra.getRowCount(); i++)
        {
            obj.setIdCompDetalleComp(Integer.parseInt(txtCodCompra.getText()));
            obj.setIdProDetalleComp(GrillaCompra.getValueAt(i, 0).toString());
            obj.setCantDetalleComp(Integer.parseInt(GrillaCompra.getValueAt(i, 2).toString()));
            obj.setPreDetalleComp(Double.parseDouble(GrillaCompra.getValueAt(i, 3).toString()));
            obj.setTotalDetalleComp(Double.parseDouble(GrillaCompra.getValueAt(i, 5).toString()));
            detComController.addDetalleCompra(obj);
            ActualizarStock();
        }
    }
    
    void AgregarProducto()
    {
        int msg = JOptionPane.showConfirmDialog(null,"¿Deseas agregar el producto?","Producto",JOptionPane.YES_NO_OPTION);
        if (msg == JOptionPane.YES_OPTION)
        {
            double subtotal, total, igv;
        
            int cant = Integer.parseInt(this.txtCantCompra.getText());
            double precio = Double.parseDouble(FrmCompra.txtPrecioCompra.getText());
            double impuesto = Double.parseDouble(this.txtIgv.getText());

            subtotal = cant * precio;
            igv = subtotal * (impuesto/100);
            total = subtotal;

            ArrayList lst = new ArrayList();
            lst.add(FrmCompra.txtCodProdCompra.getText());
            lst.add(FrmCompra.txtDesCompra.getText());
            lst.add(this.txtCantCompra.getText());
            lst.add(FrmCompra.txtPrecioCompra.getText());
            lst.add(igv);
            lst.add(total);

            Object[] obj = new Object[6];
            obj[0] = lst.get(0);
            obj[1] = lst.get(1);
            obj[2] = lst.get(2);
            obj[3] = lst.get(3);
            obj[4] = lst.get(4);
            obj[5] = lst.get(5);

            dtmCompra.addRow(obj);
            GrillaCompra.setModel(dtmCompra);
            calcularTotal();
        }
    }
    
    void calcularTotal()
    {
        double subtotal = 0;
        double impuesto = 0;
        double tpagar = 0;
        
        for(int i = 0; i < GrillaCompra.getRowCount(); i++)
        {
            int cantidad = Integer.parseInt(GrillaCompra.getValueAt(i, 2).toString());
            double precio = Double.parseDouble(GrillaCompra.getValueAt(i, 3).toString());
            double imp = Double.parseDouble(GrillaCompra.getValueAt(i, 4).toString());
            
            subtotal += (cantidad * precio);
            impuesto += imp;
            tpagar = subtotal + impuesto;
        }
        this.txtSubTotalCompra.setText("" + df.format(subtotal));
        this.txtIgvCompra.setText("" + df.format(impuesto));
        txtTotalCompra.setText("" + df.format(tpagar));
    }
    
     void ActualizarStock()
    {
        for(int i = 0; i < GrillaDetalleCompra.getRowCount(); i++)
        {
            Producto pro = new Producto();
            String cod = GrillaDetalleCompra.getValueAt(i, 1).toString();
            int cant = Integer.parseInt(GrillaDetalleCompra.getValueAt(i, 2).toString());
            pro = prodController.getBuscarCodigoProductoController(cod);
            int stockActual = pro.getCantidad() + cant;
            prodController.actualizarProductoController(cod, stockActual);
        }
    }
        private void pdf()
    {
        try
        {
            
            FileOutputStream archivo;
            String destino = "src/main/java/pdf/compra.pdf";
            File file = new File(destino);
            archivo = new FileOutputStream(file);
            Document document = new Document();
            PdfWriter.getInstance(document, archivo);
            document.open();
            
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            Font letra1 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            Font letra3 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
            
            PdfPTable Encabezado = new PdfPTable(3);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] columnaEncabezado = new float[]{50f, 10f, 20f};
            Encabezado.setWidths(columnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            String ruc = "20678943131";
            String ciudad = "ATE - LIMA - LIMA";
            String dir = "AV. AMERICA SUR 1194 URB. PALERMO";
            String raz = "DIXIS";
            Phrase direccion = new Phrase(raz + "\n" + dir + "\n" + ciudad,letra1);
            Phrase factura = new Phrase("FACTURA" + "\nRUC:" + ruc + "\nF0001-" + txtCodCompra.getText(),letra1);
            PdfPCell cell1 = new PdfPCell(factura);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            Encabezado.addCell(direccion);
            Encabezado.addCell("");
            Encabezado.addCell(cell1);
            
            document.add(Encabezado);
            
            Phrase linea = new Phrase("----------------------------------------------------------------------------------------------------------------------------------");
            Phrase dato = new Phrase("\nDatos del proveedor: " + "\n",letra3);
            document.add(linea);
            document.add(dato);
            
            PdfPTable tablaCli = new PdfPTable(3);
            tablaCli.setWidthPercentage(100);
            tablaCli.getDefaultCell().setBorder(0);
            float[] columnaTablaCli = new float[]{50f, 10f, 10f};
            tablaCli.setWidths(columnaTablaCli);
            tablaCli.setHorizontalAlignment(Element.ALIGN_LEFT);
            Proveedor pro = new Proveedor();
            pro = proController.getPorCodigoProveedorController(txtCodProvCompra.getText());
            Phrase cli = new Phrase("Fecha de emision                    : " + txtFechaCompra.getText() + 
                                    "\nRazon                                      : "  + pro.getRazSocProv()+ 
                                    "\nRuc                                          : "  + pro.getRucProv()+
                                    "\nDirecccion del cliente             : " + pro.getDirProv() +
                                    "\nTelefono                                  : "  + pro.getTlfProv() + 
                                    "\nTipo de moneda                      : Soles" ,letra3);
            tablaCli.addCell(cli);
            tablaCli.addCell("");  
            tablaCli.addCell("");
            document.add(tablaCli);
            document.add(linea);
            
            PdfPTable tablaPro = new PdfPTable(4);
            tablaPro.setWidthPercentage(100);
            tablaPro.getDefaultCell().setBorder(0);
            float[] columnaPro = new float[]{20, 50, 30, 40};
            tablaPro.setWidths(columnaPro);
            tablaPro.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell pr1 = new PdfPCell(new Phrase("Cantidad",negrita));
            PdfPCell pr2 = new PdfPCell(new Phrase("Descripcion",negrita));
            PdfPCell pr3 = new PdfPCell(new Phrase("Precio Unitario",negrita));
            PdfPCell pr4 = new PdfPCell(new Phrase("Precio Total",negrita));
            pr1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            pr2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            pr3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            pr4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tablaPro.addCell(pr1);
            tablaPro.addCell(pr2);
            tablaPro.addCell(pr3);
            tablaPro.addCell(pr4);
            
            for(int i = 0; i < GrillaCompra.getRowCount(); i++)
            {
                String cant = GrillaCompra.getValueAt(i, 2).toString();
                String producto = GrillaCompra.getValueAt(i, 1).toString();
                String precio = GrillaCompra.getValueAt(i, 3).toString();
                String total = GrillaCompra.getValueAt(i, 5).toString();
                tablaPro.addCell(cant);
                tablaPro.addCell(producto);
                tablaPro.addCell(precio);
                tablaPro.addCell(total);
            }
            document.add(tablaPro);
            
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.setFont(letra3);
            info.add("Subtotal   :        " + txtSubTotalCompra.getText());
            info.add("\nImpuesto : 18%\n");
            info.add("Total   :         " + txtTotalCompra.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            document.add(info);
            
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.setFont(letra3);
            firma.add("Firma\n\n\n");
            firma.add("---------------------------------------");
            firma.add("\nGerente General");
            firma.setAlignment(Element.ALIGN_CENTER);
            document.add(firma);
            
            Paragraph msj = new Paragraph();
            msj.add(Chunk.NEWLINE);
            msj.add("Autorizacion de compra");
            msj.setAlignment(Element.ALIGN_CENTER);
            document.add(msj);
            
            document.close();
            Desktop.getDesktop().open(file);
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCompra().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GrillaCompra;
    private javax.swing.JTable GrillaDetalleCompra;
    public static javax.swing.JTable GrillaProducto;
    private javax.swing.JTable GrillaProveedor;
    private javax.swing.JButton btnAgregarPro;
    private javax.swing.JButton btnAgregarProdCompra;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminarNuevaCompra;
    private javax.swing.JButton btnEliminarPro;
    private javax.swing.JButton btnEliminarProdCompra;
    private javax.swing.JButton btnEliminarProv;
    private javax.swing.JButton btnGuardarProv;
    private javax.swing.JButton btnModProv;
    private javax.swing.JButton btnModificarPro;
    private javax.swing.JButton btnNuevaCompra;
    private javax.swing.JButton btnNuevoPro;
    private javax.swing.JButton btnNuevoProv;
    private javax.swing.JButton btnObtenerEmpleado;
    private javax.swing.JButton btnObtenerProveedor;
    private javax.swing.JButton btnVistaProd;
    private javax.swing.JButton btnVistaProv;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtBuscarPro;
    private javax.swing.JTextField txtBuscarProv;
    private javax.swing.JTextField txtCantCompra;
    private javax.swing.JTextField txtCantPro;
    private javax.swing.JTextField txtCodCompra;
    public static javax.swing.JTextField txtCodEmpCompra;
    private javax.swing.JTextField txtCodPro;
    public static javax.swing.JTextField txtCodProdCompra;
    private javax.swing.JTextField txtCodProv;
    public static javax.swing.JTextField txtCodProvCompra;
    public static javax.swing.JTextField txtCodProvProd;
    public static javax.swing.JTextField txtDesCompra;
    private javax.swing.JTextField txtDesPro;
    private javax.swing.JTextField txtDirProv;
    private javax.swing.JTextField txtFechaCompra;
    public static javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtIgvCompra;
    public static javax.swing.JTextField txtNomEmpCompra;
    private javax.swing.JTextField txtPreComPro;
    private javax.swing.JTextField txtPreVenPro;
    public static javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtRazSocProv;
    public static javax.swing.JTextField txtRazSocialProvCompra;
    private javax.swing.JTextField txtRucProv;
    private javax.swing.JTextField txtSubTotalCompra;
    private javax.swing.JTextField txtTelefProv;
    private javax.swing.JTextField txtTotalCompra;
    // End of variables declaration//GEN-END:variables
}
