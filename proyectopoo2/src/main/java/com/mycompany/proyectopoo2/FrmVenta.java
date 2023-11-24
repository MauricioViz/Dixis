/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectopoo2;

/*
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
*/
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
import controller.ClienteController;
import controller.DetalleVentaController;
import controller.ProductoController;
import controller.VentaController;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.DetalleVenta;
import model.Producto;
import model.Venta;
import services.funciones;
/**
 *
 * @author CHRISTOPHER
 */
public class FrmVenta extends javax.swing.JFrame {
    private DefaultTableModel dtmCliente = new DefaultTableModel();
    private DefaultTableModel dtmVenta = new DefaultTableModel();
    private DefaultTableModel dtmLstVenta = new DefaultTableModel();
    private DefaultTableModel dtmDetalleVenta = new DefaultTableModel();
    private ClienteController cliController = new ClienteController();
    private ProductoController proController = new ProductoController();
    private VentaController venController = new VentaController();
    private DetalleVentaController detVenController = new DetalleVentaController();
    int item;
    double pagoTotal = 0.00;
    double subTotal = 0.00;
    /**
     * Creates new form FrmVenta
     */
    public FrmVenta() {
        initComponents();
        columnaCli();
        columnaVenta();
        columnaListadoVenta();
        columnaDetVenta();
        listarCli();
        listarVenta();
        listarDetVenta();
        this.setLocationRelativeTo(null);
    }
    
    public void columnaCli()
    {
        dtmCliente.addColumn("CODIGO");
        dtmCliente.addColumn("RAZON SOCIAL");
        dtmCliente.addColumn("RUC");
        dtmCliente.addColumn("TELEFONO");
        dtmCliente.addColumn("DIRECCION");
        this.GrillaCliente.setModel(dtmCliente);
    }
    
    public void columnaVenta()
    {
        dtmVenta.addColumn("CODIGO");
        dtmVenta.addColumn("DESCRIPCION");
        dtmVenta.addColumn("CANTIDAD");
        dtmVenta.addColumn("IGV");
        dtmVenta.addColumn("PRECIO UNITARIO");
        dtmVenta.addColumn("PRECIO SUBTOTAL");
        dtmVenta.addColumn("PRECIO TOTAL");
        this.GrillaVenta.setModel(dtmVenta);
    }
    
    public void columnaListadoVenta()
    {
        dtmLstVenta.addColumn("CODIGO");
        dtmLstVenta.addColumn("CLIENTE");
        dtmLstVenta.addColumn("EMPLEADO");
        dtmLstVenta.addColumn("SERIE");
        dtmLstVenta.addColumn("FECHA");
        dtmLstVenta.addColumn("SUBTOTAL");
        dtmLstVenta.addColumn("IGV");
        dtmLstVenta.addColumn("TOTAL");
        this.GrillaLstVenta.setModel(dtmLstVenta);
    }
        
    public void columnaDetVenta()
    {
        dtmDetalleVenta.addColumn("ID VENTA");
        dtmDetalleVenta.addColumn("PRODUCTO");
        dtmDetalleVenta.addColumn("CANTIDAD");
        dtmDetalleVenta.addColumn("PRECIO UNITARIO");
        dtmDetalleVenta.addColumn("PRECIO TOTAL");
        this.GrillaDetalleVenta.setModel(dtmDetalleVenta);
    }
    
    public void listarCli()
    {
        List<Cliente> lst = cliController.getAllClienteController();
        dtmCliente.setNumRows(0);
        for(Cliente x:lst)
        {
            Object[] vector = new Object[5];
            vector[0] = x.getIdCliente();
            vector[1] = x.getRazSocCli();
            vector[2] = x.getRucCli();
            vector[3] = x.getTlfCli();
            vector[4] = x.getDirCli();
            dtmCliente.addRow(vector);
        }
        GrillaCliente.setModel(dtmCliente);
    }  
    
    public void listarVenta()
    {
        List<Venta> lst = venController.GetAllVentaController();
        dtmLstVenta.setNumRows(0);
        for(Venta x:lst)
        {
            Object[] vector = new Object[8];
            vector[0] = x.getIdVen();
            vector[1] = x.getIdCliVen();
            vector[2] = x.getIdEmpVen();
            vector[3] = x.getSerieVenta();
            vector[4] = x.getFecha();
            vector[5] = x.getSubTotalVen();
            vector[6] = x.getIgv();
            vector[7] = x.getTotalVen();
            dtmLstVenta.addRow(vector);
        }
        GrillaLstVenta.setModel(dtmLstVenta);
    }  
        
    public void listarDetVenta()
    {
        List<DetalleVenta> lst = detVenController.getAllDetalleVentaController();
        this.dtmDetalleVenta.setNumRows(0);
        for(DetalleVenta x:lst)
        {
            Object[] vector = new Object[5];
            vector[0] = x.getIdVenDetalleVen();
            vector[1] = x.getIdProDetalleVen();
            vector[2] = x.getCantDetalleVen();
            vector[3] = x.getPreDetalleVen();
            vector[4] = x.getTotalDetalleVen();
            this.dtmDetalleVenta.addRow(vector);
        }
        this.GrillaDetalleVenta.setModel(dtmDetalleVenta);
    }
        
    public void limpiarCli()
    {
        this.txtCodCli.setText("");
        this.txtRazSocCli.setText("");
        this.txtRucCli.setText("");
        this.txtTlfCli.setText("");
        this.txtDirCli.setText("");
    }
    
    public void limpiarVentaTotal()
    {
        txtCodVenta.setText("");
        txtSerieVenta.setText("");
        txtFechaVenta.setText("");
        limpiarVenta();
        limpiarDetalle();
        limpiarTabla();
    }
        
    public void limpiarVenta()
    {
        txtCodCliVenta.setText("");
        txtRazSocCliVenta.setText("");
        txtIdUsuVenta.setText("");
        txtNomUsuVenta.setText("");
        limpiarDetalle();
        limpiarTabla();
    }
    
    public void limpiarDetalle()
    {
        txtCodProdVenta.setText("");
        txtDesProdVenta.setText("");
        txtPreProdVenta.setText("");
        txtStockProdVenta.setText("");
        this.txtCantVenta.setText("");
        this.txtIgvVenta.setText("");
    }
    
    public void limpiarTabla()
    {
        for(int i = 0; i < dtmVenta.getRowCount(); i++)
        {
            dtmVenta.removeRow(i);
            i = i - 1;
        }
    }
        
    public void totalPagar()
    {
        pagoTotal = 0;
        subTotal = 0;
        int numFila = GrillaVenta.getRowCount();
        double calcular;
        double sub;
        for(int i = 0; i < numFila; i++)
        {
            sub = Double.parseDouble(String.valueOf(GrillaVenta.getModel().getValueAt(i, 5)));
            calcular = Double.parseDouble(String.valueOf(GrillaVenta.getModel().getValueAt(i, 6)));
            pagoTotal = pagoTotal + calcular;
            subTotal = subTotal + sub;
        }
        this.lblPagoTotal.setText(String.format("%.2f", pagoTotal));
        this.lblSubTotal.setText(String.format("%.2f", subTotal));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDesProdVenta = new javax.swing.JTextField();
        txtCantVenta = new javax.swing.JTextField();
        txtPreProdVenta = new javax.swing.JTextField();
        txtStockProdVenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtRazSocCliVenta = new javax.swing.JTextField();
        btnImprimirFactura = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblPagoTotal = new javax.swing.JLabel();
        btnQuitarProdVenta = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSerieVenta = new javax.swing.JTextField();
        txtCodVenta = new javax.swing.JTextField();
        txtCodCliVenta = new javax.swing.JTextField();
        btnObtenerCli = new javax.swing.JButton();
        btnObtenerProducto = new javax.swing.JButton();
        txtCodProdVenta = new javax.swing.JTextField();
        btnNuevaVenta = new javax.swing.JButton();
        txtIgvVenta = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtIdUsuVenta = new javax.swing.JTextField();
        txtNomUsuVenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnVistaEmp = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        GrillaVenta = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtFechaVenta = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        lblMaximo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        GrillaLstVenta = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        GrillaDetalleVenta = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtRucCli = new javax.swing.JTextField();
        txtRazSocCli = new javax.swing.JTextField();
        txtTlfCli = new javax.swing.JTextField();
        txtDirCli = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        GrillaCliente = new javax.swing.JTable();
        btnGuardarCli = new javax.swing.JButton();
        btnEliminarCli = new javax.swing.JButton();
        btnModCli = new javax.swing.JButton();
        btnNuevoCli = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCodCli = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtBuscarCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("PROCESO DE VENTA");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(183, 183, 183))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel23)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 850, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\venta.png")); // NOI18N
        jButton1.setText("Nueva Venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\cliente.png")); // NOI18N
        jButton2.setText("Cliente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(102, 102, 102));
        jButton6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\nueva venta.png")); // NOI18N
        jButton6.setText("Detalle Venta");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(204, 0, 0));
        btnCerrar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\nueva venta.png")); // NOI18N
        jButton3.setText("Venta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jButton1)
                .addGap(53, 53, 53)
                .addComponent(jButton3)
                .addGap(49, 49, 49)
                .addComponent(jButton6)
                .addGap(58, 58, 58)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, 550));

        jLabel3.setText("Producto");

        jLabel5.setText("Cantidad");

        jLabel6.setText("Precio");

        jLabel7.setText("Stock");

        txtDesProdVenta.setEditable(false);

        txtCantVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantVentaKeyTyped(evt);
            }
        });

        txtPreProdVenta.setEditable(false);

        txtStockProdVenta.setEditable(false);

        jLabel2.setText("Cliente");

        jLabel8.setText("Razón Social");

        txtRazSocCliVenta.setEditable(false);

        btnImprimirFactura.setBackground(new java.awt.Color(204, 204, 204));
        btnImprimirFactura.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\imprimir.png")); // NOI18N
        btnImprimirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirFacturaActionPerformed(evt);
            }
        });

        jLabel12.setText("Total:");

        btnQuitarProdVenta.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnQuitarProdVenta.setForeground(new java.awt.Color(0, 0, 255));
        btnQuitarProdVenta.setText("Quitar");
        btnQuitarProdVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProdVentaActionPerformed(evt);
            }
        });

        jLabel11.setText("Código");

        jLabel13.setText("Serie");

        txtSerieVenta.setEditable(false);

        txtCodVenta.setEditable(false);

        txtCodCliVenta.setEditable(false);

        btnObtenerCli.setText("...");
        btnObtenerCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerCliActionPerformed(evt);
            }
        });

        btnObtenerProducto.setText("...");
        btnObtenerProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerProductoActionPerformed(evt);
            }
        });

        txtCodProdVenta.setEditable(false);

        btnNuevaVenta.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnNuevaVenta.setForeground(new java.awt.Color(0, 0, 255));
        btnNuevaVenta.setText("Nuevo");
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        txtIgvVenta.setEditable(false);
        txtIgvVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIgvVentaKeyTyped(evt);
            }
        });

        jLabel19.setText("IGV");

        txtIdUsuVenta.setEditable(false);

        txtNomUsuVenta.setEditable(false);

        jLabel4.setText("Empleado");

        btnVistaEmp.setText("...");
        btnVistaEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVistaEmpActionPerformed(evt);
            }
        });

        GrillaVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(GrillaVenta);

        jLabel18.setText("Sub total:");

        jLabel20.setText("Fecha:");

        jLabel22.setText("Máximo:");

        lblMaximo.setText("jLabel24");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txtCodVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txtSerieVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(259, 259, 259)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(216, 216, 216)
                                .addComponent(btnNuevaVenta))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtCodProdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDesProdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtCantVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIgvVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPreProdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(txtStockProdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnObtenerProducto)
                        .addGap(37, 37, 37)
                        .addComponent(btnQuitarProdVenta))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtCodCliVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtIdUsuVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(27, 27, 27)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtRazSocCliVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtNomUsuVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnObtenerCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnVistaEmp))
                                        .addGap(38, 38, 38))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(312, 312, 312)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblMaximo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblPagoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnImprimirFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))))
                .addGap(95, 95, 95))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSerieVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNuevaVenta)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel19)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodProdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDesProdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObtenerProducto)
                    .addComponent(btnQuitarProdVenta)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIgvVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPreProdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockProdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel22)
                        .addComponent(lblMaximo)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCodCliVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(txtIdUsuVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtRazSocCliVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtNomUsuVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnObtenerCli)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnVistaEmp))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPagoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnImprimirFactura))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nueva Venta", jPanel2);

        GrillaLstVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(GrillaLstVenta);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Venta", jPanel5);

        GrillaDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "DESCRIPCION", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ));
        jScrollPane2.setViewportView(GrillaDetalleVenta);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Detalle Venta", jPanel3);

        jLabel14.setText("Razon Social:");

        jLabel15.setText("RUC:");

        jLabel16.setText("Teléfono:");

        jLabel17.setText("Dirección:");

        txtRucCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucCliKeyTyped(evt);
            }
        });

        txtRazSocCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazSocCliKeyTyped(evt);
            }
        });

        txtTlfCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTlfCliKeyTyped(evt);
            }
        });

        GrillaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DNI/RUC", "NOMBRE", "TELEFONO", "DIRECCION"
            }
        ));
        GrillaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrillaClienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(GrillaCliente);

        btnGuardarCli.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardarCli.setForeground(new java.awt.Color(0, 0, 153));
        btnGuardarCli.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\guardar.png")); // NOI18N
        btnGuardarCli.setText("Guardar");
        btnGuardarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCliActionPerformed(evt);
            }
        });

        btnEliminarCli.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEliminarCli.setForeground(new java.awt.Color(0, 0, 153));
        btnEliminarCli.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\eliminar.png")); // NOI18N
        btnEliminarCli.setText("Eliminar");
        btnEliminarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCliActionPerformed(evt);
            }
        });

        btnModCli.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnModCli.setForeground(new java.awt.Color(0, 0, 153));
        btnModCli.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\modificar.png")); // NOI18N
        btnModCli.setText("Modificar");
        btnModCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModCliActionPerformed(evt);
            }
        });

        btnNuevoCli.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnNuevoCli.setForeground(new java.awt.Color(0, 0, 153));
        btnNuevoCli.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christopher\\Documents\\NetBeansProjects\\proyectopoo2\\src\\main\\java\\com\\mycompany\\proyectopoo2\\Img\\venta.png")); // NOI18N
        btnNuevoCli.setText("Nuevo");
        btnNuevoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCliActionPerformed(evt);
            }
        });

        jLabel9.setText("Código:");

        txtCodCli.setEditable(false);

        jLabel10.setText("RUC:");

        txtBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarClienteActionPerformed(evt);
            }
        });
        txtBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarClienteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTlfCli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txtDirCli)
                            .addComponent(txtRucCli, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRazSocCli, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodCli, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(btnNuevoCli))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnGuardarCli)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarCli))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(btnModCli)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarCliente)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtRazSocCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRucCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtTlfCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDirCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(41, 41, 41)
                        .addComponent(btnNuevoCli)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardarCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnModCli))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cliente", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 850, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtBuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClienteKeyReleased
        Cliente obj = new Cliente();
        obj.setRazSocCli(this.txtBuscarCliente.getText());
        List<Cliente> lst = cliController.getBuscarNombreClienteController(obj);
        dtmCliente.setNumRows(0);
        for(Cliente x:lst)
        {
            Object[] vector = new Object[5];
            vector[0] = x.getIdCliente();
            vector[1] = x.getRazSocCli();
            vector[2] = x.getRucCli();
            vector[3] = x.getTlfCli();
            vector[4] = x.getDirCli();
            dtmCliente.addRow(vector);
        }
        GrillaVenta.setModel(dtmCliente);
    }//GEN-LAST:event_txtBuscarClienteKeyReleased

    private void txtBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarClienteActionPerformed

    private void btnNuevoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCliActionPerformed
        this.txtCodCli.setText(cliController.correlativoClienteController());
        this.txtRazSocCli.setText("");
        this.txtRucCli.setText("");
        this.txtTlfCli.setText("");
        this.txtDirCli.setText("");
    }//GEN-LAST:event_btnNuevoCliActionPerformed

    private void btnModCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModCliActionPerformed
        if(!this.txtCodCli.getText().isEmpty() && !this.txtRazSocCli.getText().isEmpty() &&
            !this.txtRucCli.getText().isEmpty() && !this.txtTlfCli.getText().isEmpty() &&
            !this.txtDirCli.getText().isEmpty())
        {
            int msg = JOptionPane.showConfirmDialog(btnModCli,"Deseas Modificar el Registro!!!","Modificar",JOptionPane.YES_NO_OPTION);
            if (msg == JOptionPane.YES_OPTION)
            {
                Cliente cli = new Cliente();
                cli.setIdCliente(this.txtCodCli.getText());
                cli.setRazSocCli(this.txtRazSocCli.getText());
                cli.setRucCli(this.txtRucCli.getText());
                cli.setTlfCli(this.txtTlfCli.getText());
                cli.setDirCli(this.txtDirCli.getText());
                cliController.updateClienteController(cli);
                listarCli();//Actualizar la BD
                limpiarCli();
                JOptionPane.showMessageDialog(this,"Registro Modificado Satisfactoriamente");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        }
    }//GEN-LAST:event_btnModCliActionPerformed

    private void btnEliminarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCliActionPerformed
        if(!this.txtCodCli.getText().isEmpty() && !this.txtRazSocCli.getText().isEmpty() &&
            !this.txtRucCli.getText().isEmpty() && !this.txtTlfCli.getText().isEmpty() &&
            !this.txtDirCli.getText().isEmpty())
        {
            int msg = JOptionPane.showConfirmDialog(btnEliminarCli,"Deseas Eliminar el Registro!!!","Eliminar",JOptionPane.YES_NO_OPTION);
            if (msg == JOptionPane.YES_OPTION)
            {
                Cliente cli = new Cliente();
                cli.setIdCliente(this.txtCodCli.getText());
                cliController.removeClienteController(cli);
                listarCli();//Actualizar BD
                limpiarCli();
                JOptionPane.showMessageDialog(this,"Registro Eliminado Satisfactoriamente");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        }
    }//GEN-LAST:event_btnEliminarCliActionPerformed

    private void btnGuardarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCliActionPerformed
        if(!this.txtCodCli.getText().isEmpty() && !this.txtRazSocCli.getText().isEmpty() &&
            !this.txtRucCli.getText().isEmpty() && !this.txtTlfCli.getText().isEmpty() &&
            !this.txtDirCli.getText().isEmpty())
        {
            int msg = JOptionPane.showConfirmDialog(btnGuardarCli,"Deseas Guardar el Registro!!!","Guardar",JOptionPane.YES_NO_OPTION);
            if (msg == JOptionPane.YES_OPTION)
            {
                Cliente cli = new Cliente();
                cli.setIdCliente(this.txtCodCli.getText());
                cli.setRazSocCli(this.txtRazSocCli.getText());
                cli.setRucCli(this.txtRucCli.getText());
                cli.setTlfCli(this.txtTlfCli.getText());
                cli.setDirCli(this.txtDirCli.getText());
                cliController.addClienteController(cli);
                listarCli();//Actualizar la BD
                limpiarCli();
                JOptionPane.showMessageDialog(this,"Registro Guardado Satisfactoriamente");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }//GEN-LAST:event_btnGuardarCliActionPerformed

    private void GrillaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaClienteMouseClicked
        this.txtCodCli.setText(GrillaCliente.getValueAt(GrillaCliente.getSelectedRow(), 0).toString());
        this.txtRazSocCli.setText(GrillaCliente.getValueAt(GrillaCliente.getSelectedRow(), 1).toString());
        this.txtRucCli.setText(GrillaCliente.getValueAt(GrillaCliente.getSelectedRow(), 2).toString());
        this.txtTlfCli.setText(GrillaCliente.getValueAt(GrillaCliente.getSelectedRow(), 3).toString());
        this.txtDirCli.setText(GrillaCliente.getValueAt(GrillaCliente.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_GrillaClienteMouseClicked

    private void txtTlfCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTlfCliKeyTyped
        Character c = evt.getKeyChar();

        if(!Character.isDigit(c) || this.txtTlfCli.getText().length() >= 9)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtTlfCliKeyTyped

    private void txtRazSocCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazSocCliKeyTyped
        Character c = evt.getKeyChar();

        if(!Character.isLetter(c) && c != KeyEvent.VK_SPACE)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtRazSocCliKeyTyped

    private void txtRucCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucCliKeyTyped
        Character c = evt.getKeyChar();

        if(!Character.isDigit(c) || this.txtRucCli.getText().length() >= 11)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtRucCliKeyTyped

    private void btnVistaEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVistaEmpActionPerformed
        FrmVistaEmpleado frmEmp = new FrmVistaEmpleado();
        frmEmp.toFront();
        frmEmp.setVisible(true);
        frmEmp.opcion = 2;
    }//GEN-LAST:event_btnVistaEmpActionPerformed

    private void txtIgvVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIgvVentaKeyTyped
        Character c = evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtIgvVentaKeyTyped

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        this.txtCodVenta.setText(String.valueOf(venController.getCorrelativoVentaController()));
        this.txtSerieVenta.setText(venController.getCorrelativoSerieVentaController());
        this.txtFechaVenta.setText(funciones.getFechaActual());
        limpiarVenta();
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void btnObtenerProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerProductoActionPerformed
        FrmVistaProducto frmProd = new FrmVistaProducto();
        frmProd.toFront();
        frmProd.setVisible(true);
        frmProd.opcion = 2;
    }//GEN-LAST:event_btnObtenerProductoActionPerformed

    private void btnObtenerCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerCliActionPerformed
        FrmVistaCliente frmCli = new FrmVistaCliente();
        frmCli.toFront();
        frmCli.setVisible(true);
    }//GEN-LAST:event_btnObtenerCliActionPerformed

    private void btnQuitarProdVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProdVentaActionPerformed
        this.dtmVenta = (DefaultTableModel) GrillaVenta.getModel();
        this.dtmVenta.removeRow(GrillaVenta.getSelectedRow());
        totalPagar();
        txtCodProdVenta.requestFocus();
    }//GEN-LAST:event_btnQuitarProdVentaActionPerformed

    private void btnImprimirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirFacturaActionPerformed
        if(txtCodVenta.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Registre una nueva venta");
            return;
        }
        if(txtCodCliVenta.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Registre un cliente venta");
            return;
        }
        if(txtIdUsuVenta.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Registre al empleado encargado de la venta");
            return;
        }
        if(lblPagoTotal.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Registre los productos a vender");
            return;
        }
        GuardarVenta();
        GuardarDetalle();
        listarVenta();
        listarDetVenta();
        pdf();
        limpiarVentaTotal();
    }//GEN-LAST:event_btnImprimirFacturaActionPerformed

    private void txtCantVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantVentaKeyTyped
        Character c = evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantVentaKeyTyped

    private void txtCantVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantVentaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea agregar el producto?", "Agregar producto", JOptionPane.YES_NO_OPTION);
            if(opcion == JOptionPane.YES_OPTION)
            {
                if(!"".equals(this.txtCantVenta.getText()) && !this.txtIgvVenta.getText().isEmpty())
                {
                    String cod = this.txtCodProdVenta.getText();
                    String descripcion = this.txtDesProdVenta.getText();
                    double pre_ven = Double.parseDouble(this.txtPreProdVenta.getText());
                    int stock = Integer.parseInt(this.txtStockProdVenta.getText());
                    int cantidad = Integer.parseInt(this.txtCantVenta.getText());
                    double sub = pre_ven * cantidad;
                    double igv = Double.parseDouble(this.txtIgvVenta.getText());
                    double total = pre_ven * cantidad + (pre_ven * cantidad) * (igv/100);
                    if(stock >= cantidad)
                    {
                        item = item + 1;
                        for(int i = 0; i < GrillaVenta.getRowCount(); i++)
                        {
                            if(GrillaVenta.getValueAt(i, 1).equals(this.txtDesProdVenta.getText()))
                            {
                                JOptionPane.showMessageDialog(null, "El producto ya esta registrado");
                                limpiarDetalle();
                                return;
                            }
                        }
                        ArrayList lst = new ArrayList();
                        lst.add(item);
                        lst.add(cod);
                        lst.add(descripcion);
                        lst.add(cantidad);
                        lst.add(igv);
                        lst.add(pre_ven);
                        lst.add(sub);
                        lst.add(total);
                        Object vec[] = new Object[7];
                        vec[0] = lst.get(1);
                        vec[1] = lst.get(2);
                        vec[2] = lst.get(3);
                        vec[3] = lst.get(4);
                        vec[4] = lst.get(5);
                        vec[5] = lst.get(6);
                        vec[6] = lst.get(7);
                        dtmVenta.addRow(vec);
                        GrillaVenta.setModel(dtmVenta);
                        totalPagar();
                        limpiarDetalle();
                        RegistrarMaximo();
                        txtCodProdVenta.requestFocus();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "El stock es insuficiente");
                        this.txtCantVenta.setText("");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Ingrese la cantidad y el igv");
                }
            }
            else
            {
                limpiarDetalle();
            }
        }
    }//GEN-LAST:event_txtCantVentaKeyPressed

    void GuardarVenta()
    {
        int msg = JOptionPane.showConfirmDialog(btnGuardarCli,"Deseas Guardar el Registro!!!","Guardar",JOptionPane.YES_NO_OPTION);
        if (msg == JOptionPane.YES_OPTION)
        {
            Venta obj = new Venta();
            obj.setIdVen(Integer.parseInt(this.txtCodVenta.getText()));
            obj.setFecha(this.txtFechaVenta.getText());
            obj.setSubTotalVen(Double.parseDouble(this.lblSubTotal.getText()));
            obj.setTotalVen(Double.parseDouble(this.lblPagoTotal.getText()));
            obj.setIdEmpVen(txtIdUsuVenta.getText());
            obj.setIdCliVen(txtCodCliVenta.getText());
            obj.setSerieVenta(this.txtSerieVenta.getText());
            obj.setIgv(0.18);
            venController.addVentaController(obj);
            JOptionPane.showMessageDialog(this,"Registro Guardado Satisfactoriamente");
        }
    }
    
    void GuardarDetalle()
    {
        DetalleVenta obj = new DetalleVenta();
        
        for(int i = 0; i < GrillaVenta.getRowCount(); i++)
        {
            obj.setIdVenDetalleVen(Integer.parseInt(txtCodVenta.getText()));
            obj.setIdProDetalleVen(GrillaVenta.getValueAt(i, 0).toString());
            obj.setCantDetalleVen(Integer.parseInt(GrillaVenta.getValueAt(i, 2).toString()));
            obj.setPreDetalleVen(Double.parseDouble(GrillaVenta.getValueAt(i, 4).toString()));
            obj.setTotalDetalleVen(Double.parseDouble(GrillaVenta.getValueAt(i, 5).toString()));
            detVenController.addDetalleVentaController(obj);
            ActualizarStock();
        }
    }
    
    void ActualizarStock()
    {
        for(int i = 0; i < GrillaDetalleVenta.getRowCount(); i++)
        {
            Producto pro = new Producto();
            String cod = GrillaDetalleVenta.getValueAt(i, 1).toString();
            int cant = Integer.parseInt(GrillaDetalleVenta.getValueAt(i, 2).toString());
            pro = proController.getBuscarCodigoProductoController(cod);
            int stockActual = pro.getCantidad() - cant;
            proController.actualizarProductoController(cod, stockActual);
        }
    }

    void RegistrarMaximo()
    {
        double max = 0.0; 
        for(int i = 0; i < GrillaVenta.getRowCount(); i++)
        {
            double cant = Double.parseDouble(GrillaVenta.getValueAt(i, 4).toString());
            if(max < cant)
            {
                max = cant;
            }
        }
        lblMaximo.setText("" + max);
    }
    
    private void pdf()
    {
        try
        {
            
            FileOutputStream archivo;
            String destino = "src/main/java/pdf/venta.pdf";
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
            Phrase factura = new Phrase("FACTURA" + "\nRUC:" + ruc + "\n" + txtSerieVenta.getText(),letra1);
            PdfPCell cell1 = new PdfPCell(factura);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            Encabezado.addCell(direccion);
            Encabezado.addCell("");
            Encabezado.addCell(cell1);
            
            document.add(Encabezado);
            
            Phrase linea = new Phrase("----------------------------------------------------------------------------------------------------------------------------------");
            Phrase dato = new Phrase("\nDatos del cliente: " + "\n",letra3);
            document.add(linea);
            document.add(dato);
            
            PdfPTable tablaCli = new PdfPTable(3);
            tablaCli.setWidthPercentage(100);
            tablaCli.getDefaultCell().setBorder(0);
            float[] columnaTablaCli = new float[]{50f, 10f, 10f};
            tablaCli.setWidths(columnaTablaCli);
            tablaCli.setHorizontalAlignment(Element.ALIGN_LEFT);
            Cliente cliente = new Cliente();
            cliente = cliController.getPorCodigoClienteController(txtCodCliVenta.getText());
            Phrase cli = new Phrase("Fecha de emision                    : " + txtFechaVenta.getText() + 
                                    "\nRazon                                      : "  + cliente.getRazSocCli()  + 
                                    "\nRuc                                          : "  + cliente.getRucCli() +
                                    "\nDirecccion del cliente             : " + cliente.getDirCli() +
                                    "\nTelefono                                  : "  + cliente.getTlfCli() + 
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
            
            for(int i = 0; i < GrillaVenta.getRowCount(); i++)
            {
                String cant = GrillaVenta.getValueAt(i, 2).toString();
                String producto = GrillaVenta.getValueAt(i, 1).toString();
                String precio = GrillaVenta.getValueAt(i, 4).toString();
                String total = GrillaVenta.getValueAt(i, 6).toString();
                tablaPro.addCell(cant);
                tablaPro.addCell(producto);
                tablaPro.addCell(precio);
                tablaPro.addCell(total);
            }
            document.add(tablaPro);
                        
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.setFont(letra3);
            info.add("Subtotal   :        " + lblSubTotal.getText());
            info.add("\nImpuesto : 18%\n");
            info.add("Total   :         " + lblPagoTotal.getText());
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
            msj.add("Gracias por su compra");
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
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GrillaCliente;
    private javax.swing.JTable GrillaDetalleVenta;
    private javax.swing.JTable GrillaLstVenta;
    private javax.swing.JTable GrillaVenta;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminarCli;
    private javax.swing.JButton btnGuardarCli;
    private javax.swing.JButton btnImprimirFactura;
    private javax.swing.JButton btnModCli;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JButton btnNuevoCli;
    private javax.swing.JButton btnObtenerCli;
    private javax.swing.JButton btnObtenerProducto;
    private javax.swing.JButton btnQuitarProdVenta;
    private javax.swing.JButton btnVistaEmp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblMaximo;
    private javax.swing.JLabel lblPagoTotal;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JTextField txtCantVenta;
    private javax.swing.JTextField txtCodCli;
    public static javax.swing.JTextField txtCodCliVenta;
    public static javax.swing.JTextField txtCodProdVenta;
    private javax.swing.JTextField txtCodVenta;
    public static javax.swing.JTextField txtDesProdVenta;
    private javax.swing.JTextField txtDirCli;
    private javax.swing.JTextField txtFechaVenta;
    public static javax.swing.JTextField txtIdUsuVenta;
    public static javax.swing.JTextField txtIgvVenta;
    public static javax.swing.JTextField txtNomUsuVenta;
    public static javax.swing.JTextField txtPreProdVenta;
    private javax.swing.JTextField txtRazSocCli;
    public static javax.swing.JTextField txtRazSocCliVenta;
    private javax.swing.JTextField txtRucCli;
    private javax.swing.JTextField txtSerieVenta;
    public static javax.swing.JTextField txtStockProdVenta;
    private javax.swing.JTextField txtTlfCli;
    // End of variables declaration//GEN-END:variables
}
