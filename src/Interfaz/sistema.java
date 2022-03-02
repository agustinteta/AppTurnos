package Interfaz;

import Clases.Turno;
import Clases.ConexionSQL;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class sistema extends javax.swing.JFrame {
    
    //ATRIBUTO
    int idUsuario;
    
    //CONSTRUCTOR
    public sistema(int idUsuario) {
        initComponents();
        //Centrar ventana y titulo
        setLocationRelativeTo(null); //Centrar ventana
        setTitle("Sistema - Gestor de Turnos"); //Titulo
        this.idUsuario = idUsuario;
        jTableTurnos.setAutoCreateRowSorter(true);
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        scrollTable = new javax.swing.JScrollPane();
        jTableTurnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ftxtFecha = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        jComboHora = new javax.swing.JComboBox<>();
        btnMostrarTodo = new javax.swing.JButton();
        btnMostrarDia = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setText("INSERTAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jTableTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "DNI", "Dia", "Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTurnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTurnosMouseClicked(evt);
            }
        });
        scrollTable.setViewportView(jTableTurnos);
        if (jTableTurnos.getColumnModel().getColumnCount() > 0) {
            jTableTurnos.getColumnModel().getColumn(0).setResizable(false);
            jTableTurnos.getColumnModel().getColumn(1).setResizable(false);
            jTableTurnos.getColumnModel().getColumn(2).setResizable(false);
            jTableTurnos.getColumnModel().getColumn(3).setResizable(false);
            jTableTurnos.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setText("Nombre");

        jLabel2.setText("DNI");

        try {
            ftxtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtFechaActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha de Turno (yyyy-MM-dd)");

        jLabel4.setText("Hora de Turno");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        jComboHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30" }));
        jComboHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboHoraActionPerformed(evt);
            }
        });

        btnMostrarTodo.setText("TODOS LOS TURNOS");
        btnMostrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodoActionPerformed(evt);
            }
        });

        btnMostrarDia.setText("TURNOS DEL DIA");
        btnMostrarDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDiaActionPerformed(evt);
            }
        });

        jLabel5.setText("Email");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(71, 71, 71)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(76, 76, 76))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(194, 194, 194)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(ftxtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jComboHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail))
                        .addGap(17, 17, 17)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(btnMostrarDia, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnMostrarTodo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ftxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarTodo)
                    .addComponent(btnMostrarDia))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //METODO PARA VACIAR LOS CAMPOS DE TEXTO DEL FORMULARIO
    private void limpiarCampos() {
        txtNombre.setText("");
        txtEmail.setText("");
        txtDni.setText("");
        ftxtFecha.setText("");
    }

    //METODO UTILIZADO PARA LA CARGA DE LA TABLA EN LA VISUALIZACION DE TURNOS
    //RECIBE COMO PARAMETRO EL IDUSUARIO
    //CARGA LA TABLA CON TODOS LOS TURNOS EN LA BASE DE DATOS
    private void cargarTabla(int idUsuario) {

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jTableTurnos.setModel(modelo);

            ConexionSQL cc = new ConexionSQL();
            java.sql.Connection con = (Connection) cc.conexion();

            String SQL = "SELECT idturnos, nombre, email, dni, dia_turno, hora_turno FROM turnos WHERE idusuario =" + idUsuario;

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Email");
            modelo.addColumn("DNI");
            modelo.addColumn("Dia");
            modelo.addColumn("Hora");

            while (rs.next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //METODO UTILIZADO PARA LA CARGA DE LA TABLA EN LA VISUALIZACION DE TURNOS
    //RECIBE COMO PARAMETRO EL IDUSUARIO
    //Y SOLO CARGA LOS TURNOS QUE COINCIDAN CON EL DIA ACTUAL(FECHA DE LA PC)
    private void cargarTablaTurnosDelDia(int idUsuario, String fecha) {

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jTableTurnos.setModel(modelo);

            ConexionSQL cc = new ConexionSQL();
            java.sql.Connection con = (Connection) cc.conexion();

            String SQL = "SELECT idturnos, nombre, email, dni, dia_turno, hora_turno FROM turnos WHERE idusuario ='" + idUsuario + "' and dia_turno='" + fecha + "'";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Email");
            modelo.addColumn("DNI");
            modelo.addColumn("Dia");
            modelo.addColumn("Hora");

            while (rs.next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //METODO UTILIZADO PARA LLENAR LOS CAMPOS DEL FORMULARIO DE SISTEMA
    //DE FORMA AUTOMATICA.
    private void getDatos() {

        try {
            ConexionSQL cc = new ConexionSQL();
            java.sql.Connection con = (Connection) cc.conexion();

            int fila = jTableTurnos.getSelectedRow();
            String idTurno = jTableTurnos.getValueAt(fila, 0).toString();

            String SQL = "SELECT idturnos, nombre, email, dni, dia_turno, hora_turno FROM turnos WHERE idturnos=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, idTurno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                txtNombre.setText(rs.getString("nombre"));
                txtEmail.setText(rs.getString("email"));
                txtDni.setText(rs.getString("dni"));
                ftxtFecha.setText(rs.getString("dia_turno"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int fila = jTableTurnos.getSelectedRow();
        int opcion = jComboHora.getSelectedIndex();
        Turno turno = new Turno(idUsuario, Integer.parseInt(jTableTurnos.getValueAt(fila, 0).toString()), txtNombre.getText(), txtEmail.getText(),
                Integer.parseInt(txtDni.getText()), jComboHora.getItemAt(opcion).toString(), ftxtFecha.getText());

        if (turno.eliminarTurno(turno.getIdTurno())) {
            limpiarCampos();
            cargarTabla(turno.getIdUsuario());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        int opcion = jComboHora.getSelectedIndex();
        Turno turno = new Turno(idUsuario, txtNombre.getText(), txtEmail.getText(), Integer.parseInt(txtDni.getText()), jComboHora.getItemAt(opcion).toString(), ftxtFecha.getText());
        if (turno.validarDisponibilidadTurno()) {
            turno.agregarTurno();
            limpiarCampos();
            cargarTabla(turno.getIdUsuario());
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        int fila = jTableTurnos.getSelectedRow();
        int opcion = jComboHora.getSelectedIndex();
        Turno turno = new Turno(idUsuario, Integer.parseInt(jTableTurnos.getValueAt(fila, 0).toString()), txtNombre.getText(), txtEmail.getText(),
                Integer.parseInt(txtDni.getText()), jComboHora.getItemAt(opcion).toString(), ftxtFecha.getText());

        if (turno.validarDisponibilidadTurno()) {
            turno.modificarTurno(turno.getIdTurno());
            limpiarCampos();
            cargarTabla(turno.getIdUsuario());
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void ftxtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtFechaActionPerformed

    }//GEN-LAST:event_ftxtFechaActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed

    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed

    }//GEN-LAST:event_txtDniActionPerformed

    private void jTableTurnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTurnosMouseClicked
        getDatos();
    }//GEN-LAST:event_jTableTurnosMouseClicked

    private void jComboHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboHoraActionPerformed

    }//GEN-LAST:event_jComboHoraActionPerformed

    private void btnMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoActionPerformed
        cargarTabla(idUsuario);
    }//GEN-LAST:event_btnMostrarTodoActionPerformed

    private void btnMostrarDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDiaActionPerformed
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formatter.format(date);
        cargarTablaTurnosDelDia(this.idUsuario, fecha);
    }//GEN-LAST:event_btnMostrarDiaActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrarDia;
    private javax.swing.JButton btnMostrarTodo;
    private javax.swing.JFormattedTextField ftxtFecha;
    private javax.swing.JComboBox<String> jComboHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTable jTableTurnos;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private ConexionSQL conexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
