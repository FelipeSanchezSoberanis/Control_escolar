/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.awt.Color;
import java.util.List;
import java.util.function.BooleanSupplier;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
class AltaDeAlumnosDocumentListener implements DocumentListener{
    JTextField jTxtFldMatricula;
    JTextField jTxtFldNombre;
    JTextField jTxtFldApellido;
    JButton jBtnDarDeAlta;

    AltaDeAlumnosDocumentListener(JTextField matricula, JTextField nombre, JTextField apellido, JButton jBtnDarDeAlta) {
        this.jTxtFldMatricula = matricula;
        this.jTxtFldNombre = nombre;
        this.jTxtFldApellido = apellido;
        this.jBtnDarDeAlta = jBtnDarDeAlta;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        checkValues();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        checkValues();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        checkValues();
    }

    void checkValues() {
        // #region Verificación de la matricula
        int matricula = -1;

        boolean success1 = true;
        try {
            matricula = Integer.parseInt(jTxtFldMatricula.getText());
        } catch (Exception e) {
            success1 = false;

            jTxtFldMatricula.setBorder(new LineBorder(Color.red));
        } if (success1) {
            if (matricula >= 0 && matricula <= 9999) {
                jTxtFldMatricula.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
            } else {
                jTxtFldMatricula.setBorder(new LineBorder(Color.red));
                success1 = false;
            }
        }
        // #endregion

        // #region Verificacion del nombre
        String nombre = "";

        boolean success2 = true;
        try {
            nombre = jTxtFldNombre.getText();
        } catch (Exception e) {
            success2 = false;

            jTxtFldNombre.setBorder(new LineBorder(Color.red));
        } if (success2) {
            if (!nombre.matches(".*[0-9]+.*") && nombre.length() > 0) {
                jTxtFldNombre.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
            } else {
                jTxtFldNombre.setBorder(new LineBorder(Color.red));
                success2 = false;
            }

        }
        // #endregion

        // #region Velificacion del apellido
        String apellido = "";

        boolean success3 = true;
        try {
            apellido = jTxtFldApellido.getText();
        } catch (Exception e) {
            success3 = false;

            jTxtFldApellido.setBorder(new LineBorder(Color.red));
        } if (success3) {
            if (!apellido.matches(".*[0-9]+.*") && apellido.length() > 0) {
                jTxtFldApellido.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
            } else {
                jTxtFldApellido.setBorder(new LineBorder(Color.red));
                success3 = false;
            }

        }
        // #endregion

        if (success1 && success2 && success3) {
            jBtnDarDeAlta.setEnabled(true);
        } else {
            jBtnDarDeAlta.setEnabled(false);
        }
    }
}

public class appWindow extends javax.swing.JFrame {

    /**
     * Creates new form appWindow
     */
    public appWindow() {
        initComponents();

        this.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Poner como primera vista la página principal
        this.jPnlHome.setVisible(true);
        this.jPnlMostrarAlumnos.setVisible(false);
        this.jPnlMostrarMaterias.setVisible(false);
        this.jPnlAltaDeAlumnos.setVisible(false);
        this.jPnlAsignarCalificaciones.setVisible(false);
        this.jPnlPromedioTotal.setVisible(false);
        this.jPnlPromedioParcial.setVisible(false);
        this.jPnlAlumnosReprobadas.setVisible(false);
        this.jPnlExtraordinarios.setVisible(false);

        this.jTxtFldAltaAlumnoMatricula.getDocument().addDocumentListener(new AltaDeAlumnosDocumentListener(jTxtFldAltaAlumnoMatricula, jTxtFldAltaAlumnoNombre, jTxtFldAltaAlumnoApellido, jBtnAltaAlumno));
        this.jTxtFldAltaAlumnoNombre.getDocument().addDocumentListener(new AltaDeAlumnosDocumentListener(jTxtFldAltaAlumnoMatricula, jTxtFldAltaAlumnoNombre, jTxtFldAltaAlumnoApellido, jBtnAltaAlumno));
        this.jTxtFldAltaAlumnoApellido.getDocument().addDocumentListener(new AltaDeAlumnosDocumentListener(jTxtFldAltaAlumnoMatricula, jTxtFldAltaAlumnoNombre, jTxtFldAltaAlumnoApellido, jBtnAltaAlumno));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlMostrarMaterias = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblMostrarMaterias = new javax.swing.JTable();
        jPnlMostrarAlumnos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblMostrarAlumnos = new javax.swing.JTable();
        jPnlAltaDeAlumnos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtFldAltaAlumnoMatricula = new javax.swing.JTextField();
        jTxtFldAltaAlumnoNombre = new javax.swing.JTextField();
        jTxtFldAltaAlumnoApellido = new javax.swing.JTextField();
        jBtnAltaAlumno = new javax.swing.JButton();
        jPnlAsignarCalificaciones = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPnlPromedioTotal = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTblPromediosTotales = new javax.swing.JTable();
        jPnlPromedioParcial = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTblPromediosParciales = new javax.swing.JTable();
        jPnlAlumnosReprobadas = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTblAlumnosReprobadas = new javax.swing.JTable();
        jPnlExtraordinarios = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTblExtraordinarios = new javax.swing.JTable();
        jPnlHome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemAlumnos = new javax.swing.JMenuItem();
        jMenuMaterias = new javax.swing.JMenuItem();
        jMenuAltaAlumnos = new javax.swing.JMenu();
        jMenuAsignarCalificaciones = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItemPromedioTotal = new javax.swing.JMenuItem();
        jMenuItemPromedioParcial = new javax.swing.JMenuItem();
        jMenuItemAlumnosReprobadas = new javax.swing.JMenuItem();
        jMenuItemExtraordinarios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de control escolar");
        setResizable(false);

        jTblMostrarMaterias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTblMostrarMaterias);

        javax.swing.GroupLayout jPnlMostrarMateriasLayout = new javax.swing.GroupLayout(jPnlMostrarMaterias);
        jPnlMostrarMaterias.setLayout(jPnlMostrarMateriasLayout);
        jPnlMostrarMateriasLayout.setHorizontalGroup(
            jPnlMostrarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlMostrarMateriasLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPnlMostrarMateriasLayout.setVerticalGroup(
            jPnlMostrarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlMostrarMateriasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTblMostrarAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTblMostrarAlumnos);

        javax.swing.GroupLayout jPnlMostrarAlumnosLayout = new javax.swing.GroupLayout(jPnlMostrarAlumnos);
        jPnlMostrarAlumnos.setLayout(jPnlMostrarAlumnosLayout);
        jPnlMostrarAlumnosLayout.setHorizontalGroup(
            jPnlMostrarAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlMostrarAlumnosLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPnlMostrarAlumnosLayout.setVerticalGroup(
            jPnlMostrarAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlMostrarAlumnosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel2.setText("Matricula");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellido");

        jBtnAltaAlumno.setText("Dar de alta");
        jBtnAltaAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltaAlumnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlAltaDeAlumnosLayout = new javax.swing.GroupLayout(jPnlAltaDeAlumnos);
        jPnlAltaDeAlumnos.setLayout(jPnlAltaDeAlumnosLayout);
        jPnlAltaDeAlumnosLayout.setHorizontalGroup(
            jPnlAltaDeAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlAltaDeAlumnosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPnlAltaDeAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(60, 60, 60)
                .addGroup(jPnlAltaDeAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTxtFldAltaAlumnoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(jTxtFldAltaAlumnoApellido)
                    .addComponent(jTxtFldAltaAlumnoMatricula))
                .addGap(185, 185, 185))
            .addGroup(jPnlAltaDeAlumnosLayout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(jBtnAltaAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(248, 248, 248))
        );
        jPnlAltaDeAlumnosLayout.setVerticalGroup(
            jPnlAltaDeAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlAltaDeAlumnosLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPnlAltaDeAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtFldAltaAlumnoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPnlAltaDeAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtFldAltaAlumnoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPnlAltaDeAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtFldAltaAlumnoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jBtnAltaAlumno)
                .addGap(32, 32, 32))
        );

        jPnlAsignarCalificaciones.setBackground(new java.awt.Color(255, 51, 102));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Asignar calificaciones");

        javax.swing.GroupLayout jPnlAsignarCalificacionesLayout = new javax.swing.GroupLayout(jPnlAsignarCalificaciones);
        jPnlAsignarCalificaciones.setLayout(jPnlAsignarCalificacionesLayout);
        jPnlAsignarCalificacionesLayout.setHorizontalGroup(
            jPnlAsignarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlAsignarCalificacionesLayout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel5)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPnlAsignarCalificacionesLayout.setVerticalGroup(
            jPnlAsignarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlAsignarCalificacionesLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel5)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jTblPromediosTotales.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTblPromediosTotales);

        javax.swing.GroupLayout jPnlPromedioTotalLayout = new javax.swing.GroupLayout(jPnlPromedioTotal);
        jPnlPromedioTotal.setLayout(jPnlPromedioTotalLayout);
        jPnlPromedioTotalLayout.setHorizontalGroup(
            jPnlPromedioTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlPromedioTotalLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPnlPromedioTotalLayout.setVerticalGroup(
            jPnlPromedioTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlPromedioTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTblPromediosParciales.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTblPromediosParciales);

        javax.swing.GroupLayout jPnlPromedioParcialLayout = new javax.swing.GroupLayout(jPnlPromedioParcial);
        jPnlPromedioParcial.setLayout(jPnlPromedioParcialLayout);
        jPnlPromedioParcialLayout.setHorizontalGroup(
            jPnlPromedioParcialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlPromedioParcialLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPnlPromedioParcialLayout.setVerticalGroup(
            jPnlPromedioParcialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlPromedioParcialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPnlAlumnosReprobadas.setPreferredSize(new java.awt.Dimension(640, 360));

        jTblAlumnosReprobadas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTblAlumnosReprobadas);

        javax.swing.GroupLayout jPnlAlumnosReprobadasLayout = new javax.swing.GroupLayout(jPnlAlumnosReprobadas);
        jPnlAlumnosReprobadas.setLayout(jPnlAlumnosReprobadasLayout);
        jPnlAlumnosReprobadasLayout.setHorizontalGroup(
            jPnlAlumnosReprobadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlAlumnosReprobadasLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPnlAlumnosReprobadasLayout.setVerticalGroup(
            jPnlAlumnosReprobadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlAlumnosReprobadasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTblExtraordinarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTblExtraordinarios);

        javax.swing.GroupLayout jPnlExtraordinariosLayout = new javax.swing.GroupLayout(jPnlExtraordinarios);
        jPnlExtraordinarios.setLayout(jPnlExtraordinariosLayout);
        jPnlExtraordinariosLayout.setHorizontalGroup(
            jPnlExtraordinariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlExtraordinariosLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPnlExtraordinariosLayout.setVerticalGroup(
            jPnlExtraordinariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlExtraordinariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Página principal");

        javax.swing.GroupLayout jPnlHomeLayout = new javax.swing.GroupLayout(jPnlHome);
        jPnlHome.setLayout(jPnlHomeLayout);
        jPnlHomeLayout.setHorizontalGroup(
            jPnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlHomeLayout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel1)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        jPnlHomeLayout.setVerticalGroup(
            jPnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlHomeLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel1)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jMenu3.setText("Mostrar");

        jMenuItemAlumnos.setText("Alumnos");
        jMenuItemAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAlumnosActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemAlumnos);

        jMenuMaterias.setText("Materias");
        jMenuMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMateriasActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuMaterias);

        jMenuBar1.add(jMenu3);

        jMenuAltaAlumnos.setText("Alta de alumnos");
        jMenuAltaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuAltaAlumnosMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuAltaAlumnos);

        jMenuAsignarCalificaciones.setText("Asignar calificaciones");
        jMenuAsignarCalificaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuAsignarCalificacionesMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuAsignarCalificaciones);

        jMenu6.setText("Reportes");

        jMenuItemPromedioTotal.setText("Promedio total de alumnos");
        jMenuItemPromedioTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPromedioTotalActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemPromedioTotal);

        jMenuItemPromedioParcial.setText("Promedio parcial de alumnos");
        jMenuItemPromedioParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPromedioParcialActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemPromedioParcial);

        jMenuItemAlumnosReprobadas.setText("Alumnos con materias reprobadas");
        jMenuItemAlumnosReprobadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAlumnosReprobadasActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemAlumnosReprobadas);

        jMenuItemExtraordinarios.setText("Extraordinarios");
        jMenuItemExtraordinarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExtraordinariosActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemExtraordinarios);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlMostrarAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlMostrarMaterias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlAltaDeAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlAsignarCalificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlPromedioTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlPromedioParcial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlAlumnosReprobadas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlExtraordinarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlMostrarAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlMostrarMaterias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlAltaDeAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlAsignarCalificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlPromedioTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlPromedioParcial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlAlumnosReprobadas, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlExtraordinarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPnlHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAlumnosActionPerformed
        // Hacer que el panel correcto sea visible
        this.jPnlHome.setVisible(false);
        this.jPnlMostrarAlumnos.setVisible(true);
        this.jPnlMostrarMaterias.setVisible(false);
        this.jPnlAltaDeAlumnos.setVisible(false);
        this.jPnlAsignarCalificaciones.setVisible(false);
        this.jPnlPromedioTotal.setVisible(false);
        this.jPnlPromedioParcial.setVisible(false);
        this.jPnlAlumnosReprobadas.setVisible(false);
        this.jPnlExtraordinarios.setVisible(false);

        // Poner los valores en la tabla
        List<Alumno> alumnos = ControlEscolar.getAlumnos();
        alumnos.sort((o1, o2) -> Integer.valueOf(o1.getMatricula()).compareTo(Integer.valueOf(o2.getMatricula())));

        String[] columnNames = {"Matricula", "Nombre", "Apellido"};

        DefaultTableModel defaultTableModel = new DefaultTableModel(columnNames,0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; };
        };

        for (Alumno alumno : alumnos) {
            defaultTableModel.addRow(new Object[] {alumno.getMatricula(), alumno.getNombre(), alumno.getApellido()});
        }

        jTblMostrarAlumnos.setModel(defaultTableModel);
    }//GEN-LAST:event_jMenuItemAlumnosActionPerformed

    private void jMenuAltaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuAltaAlumnosMouseClicked
        // Hacer que el panel correcto sea visible
        this.jPnlHome.setVisible(false);
        this.jPnlMostrarAlumnos.setVisible(false);
        this.jPnlMostrarMaterias.setVisible(false);
        this.jPnlAltaDeAlumnos.setVisible(true);
        this.jPnlAsignarCalificaciones.setVisible(false);
        this.jPnlPromedioTotal.setVisible(false);
        this.jPnlPromedioParcial.setVisible(false);
        this.jPnlAlumnosReprobadas.setVisible(false);
        this.jPnlExtraordinarios.setVisible(false);

        jBtnAltaAlumno.setEnabled(false);
    }//GEN-LAST:event_jMenuAltaAlumnosMouseClicked

    private void jMenuAsignarCalificacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuAsignarCalificacionesMouseClicked
        this.jPnlHome.setVisible(false);
        this.jPnlMostrarAlumnos.setVisible(false);
        this.jPnlMostrarMaterias.setVisible(false);
        this.jPnlAltaDeAlumnos.setVisible(false);
        this.jPnlAsignarCalificaciones.setVisible(true);
        this.jPnlPromedioTotal.setVisible(false);
        this.jPnlPromedioParcial.setVisible(false);
        this.jPnlAlumnosReprobadas.setVisible(false);
        this.jPnlExtraordinarios.setVisible(false);
    }//GEN-LAST:event_jMenuAsignarCalificacionesMouseClicked

    private void jBtnAltaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAltaAlumnoActionPerformed
        int matricula = Integer.parseInt(jTxtFldAltaAlumnoMatricula.getText());
        String nombre = jTxtFldAltaAlumnoNombre.getText();
        String apellido = jTxtFldAltaAlumnoApellido.getText();

        ControlEscolar.addAlumno(matricula, nombre, apellido);
    }//GEN-LAST:event_jBtnAltaAlumnoActionPerformed

    private void jMenuMateriasActionPerformed(java.awt.event.ActionEvent evt) {
        // Hacer que la pestaña sea visible
        this.jPnlHome.setVisible(false);
        this.jPnlMostrarAlumnos.setVisible(false);
        this.jPnlMostrarMaterias.setVisible(true);
        this.jPnlAltaDeAlumnos.setVisible(false);
        this.jPnlAsignarCalificaciones.setVisible(false);
        this.jPnlPromedioTotal.setVisible(false);
        this.jPnlPromedioParcial.setVisible(false);
        this.jPnlAlumnosReprobadas.setVisible(false);
        this.jPnlExtraordinarios.setVisible(false);

        // Poner la info en la tabla
        List<Materia> materias = ControlEscolar.getMaterias();
        materias.sort((o1, o2) -> Integer.valueOf(o1.getClave()).compareTo(Integer.valueOf(o2.getClave())));

        String[] columnNames = {"Clave", "Nombre", "Créditos"};

        DefaultTableModel defaultTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; };
        };

        for (Materia materia : materias) {
            defaultTableModel.addRow(new Object[] {materia.getClave(), materia.getNombre(), materia.getCreditos()});
        }

        jTblMostrarMaterias.setModel(defaultTableModel);
    }

    private void jMenuItemPromedioTotalActionPerformed(java.awt.event.ActionEvent evt) {
        // Hacer que la pestaña correcta sea la que se ve
        this.jPnlHome.setVisible(false);
        this.jPnlMostrarAlumnos.setVisible(false);
        this.jPnlMostrarMaterias.setVisible(false);
        this.jPnlAltaDeAlumnos.setVisible(false);
        this.jPnlAsignarCalificaciones.setVisible(false);
        this.jPnlPromedioTotal.setVisible(true);
        this.jPnlPromedioParcial.setVisible(false);
        this.jPnlAlumnosReprobadas.setVisible(false);
        this.jPnlExtraordinarios.setVisible(false);

        // Poner información en la tabla
        List<String[]> promedios = ControlEscolar.getPromedioTotalAlumnos();
        promedios.sort((o1, o2) -> o1[0].compareTo(o2[0]));

        String[] columnNames = {"Matricula", "Nombre", "Promedio"};

        DefaultTableModel defaultTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; };
        };

        for (String[] string : promedios) {
            String nombreCompleto = ControlEscolar.getNombreByMatricula(Integer.parseInt(string[0]));
            defaultTableModel.addRow(new Object[] {string[0], nombreCompleto, string[1]});
        }

        jTblPromediosTotales.setModel(defaultTableModel);
    }

    private void jMenuItemPromedioParcialActionPerformed(java.awt.event.ActionEvent evt) {
        this.jPnlHome.setVisible(false);
        this.jPnlMostrarAlumnos.setVisible(false);
        this.jPnlMostrarMaterias.setVisible(false);
        this.jPnlAltaDeAlumnos.setVisible(false);
        this.jPnlAsignarCalificaciones.setVisible(false);
        this.jPnlPromedioTotal.setVisible(false);
        this.jPnlPromedioParcial.setVisible(true);
        this.jPnlAlumnosReprobadas.setVisible(false);
        this.jPnlExtraordinarios.setVisible(false);

        // Poner información en la tabla
        List<String[]> promedios = ControlEscolar.getPromedioParcialAlumnos();
        promedios.sort((o1, o2) -> o1[0].compareTo(o2[0]));

        String[] columnNames = {"Matricula", "Nombre", "Promedio"};

        DefaultTableModel defaultTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; };
        };

        for (String[] string : promedios) {
            String nombreCompleto = ControlEscolar.getNombreByMatricula(Integer.parseInt(string[0]));
            defaultTableModel.addRow(new Object[] {string[0], nombreCompleto, string[1]});
        }

        jTblPromediosParciales.setModel(defaultTableModel);
    }

    private void jMenuItemAlumnosReprobadasActionPerformed(java.awt.event.ActionEvent evt) {
        // Hacer que la tab correcta se muestre
        this.jPnlHome.setVisible(false);
        this.jPnlMostrarAlumnos.setVisible(false);
        this.jPnlMostrarMaterias.setVisible(false);
        this.jPnlAltaDeAlumnos.setVisible(false);
        this.jPnlAsignarCalificaciones.setVisible(false);
        this.jPnlPromedioTotal.setVisible(false);
        this.jPnlPromedioParcial.setVisible(false);
        this.jPnlAlumnosReprobadas.setVisible(true);
        this.jPnlExtraordinarios.setVisible(false);

        // Poner información en la tabla
        List<String[]> alumnosConReprobadas = ControlEscolar.getAlumnosYReprobadas();
        alumnosConReprobadas.sort((o1, o2) -> o1[0].compareTo(o2[0]));

        String[] columnNames = {"Matricula", "Nombre", "Clave", "Materia"};

        DefaultTableModel defaultTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; };
        };

        for (String[] string : alumnosConReprobadas) {
            String nombreAlumno = ControlEscolar.getNombreByMatricula(Integer.parseInt(string[0]));
            String nombreMateria = ControlEscolar.getNombreByClave(Integer.parseInt(string[1]));
            defaultTableModel.addRow(new Object[] {string[0], nombreAlumno, string[1], nombreMateria});
        }

        jTblAlumnosReprobadas.setModel(defaultTableModel);
    }

    private void jMenuItemExtraordinariosActionPerformed(java.awt.event.ActionEvent evt) {
        // Hacer la tab correcta se muestre
        this.jPnlHome.setVisible(false);
        this.jPnlMostrarAlumnos.setVisible(false);
        this.jPnlMostrarMaterias.setVisible(false);
        this.jPnlAltaDeAlumnos.setVisible(false);
        this.jPnlAsignarCalificaciones.setVisible(false);
        this.jPnlPromedioTotal.setVisible(false);
        this.jPnlPromedioParcial.setVisible(false);
        this.jPnlAlumnosReprobadas.setVisible(false);
        this.jPnlExtraordinarios.setVisible(true);

        // Poner información en la tabla
        List<String[]> extraordinarios = ControlEscolar.getExtraordinarios();
        extraordinarios.sort((o1, o2) -> o1[0].compareTo(o1[0]));

        String[] columnNames = {"Clave", "Nombre", "Extraordinarios"};

        DefaultTableModel defaultTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; };
        };

        for (String[] string : extraordinarios) {
            String nombreMateria = ControlEscolar.getNombreByClave(Integer.parseInt(string[0]));
            defaultTableModel.addRow(new Object[] {string[0], nombreMateria, string[1]});
        }

        jTblExtraordinarios.setModel(defaultTableModel);
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
            java.util.logging.Logger.getLogger(appWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(appWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(appWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(appWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new appWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAltaAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenuAltaAlumnos;
    private javax.swing.JMenu jMenuAsignarCalificaciones;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAlumnos;
    private javax.swing.JMenuItem jMenuItemAlumnosReprobadas;
    private javax.swing.JMenuItem jMenuItemExtraordinarios;
    private javax.swing.JMenuItem jMenuItemPromedioParcial;
    private javax.swing.JMenuItem jMenuItemPromedioTotal;
    private javax.swing.JMenuItem jMenuMaterias;
    private javax.swing.JPanel jPnlAltaDeAlumnos;
    private javax.swing.JPanel jPnlAlumnosReprobadas;
    private javax.swing.JPanel jPnlAsignarCalificaciones;
    private javax.swing.JPanel jPnlExtraordinarios;
    private javax.swing.JPanel jPnlHome;
    private javax.swing.JPanel jPnlMostrarAlumnos;
    private javax.swing.JPanel jPnlMostrarMaterias;
    private javax.swing.JPanel jPnlPromedioParcial;
    private javax.swing.JPanel jPnlPromedioTotal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTblAlumnosReprobadas;
    private javax.swing.JTable jTblExtraordinarios;
    private javax.swing.JTable jTblMostrarAlumnos;
    private javax.swing.JTable jTblMostrarMaterias;
    private javax.swing.JTable jTblPromediosParciales;
    private javax.swing.JTable jTblPromediosTotales;
    private javax.swing.JTextField jTxtFldAltaAlumnoApellido;
    private javax.swing.JTextField jTxtFldAltaAlumnoMatricula;
    private javax.swing.JTextField jTxtFldAltaAlumnoNombre;
    // End of variables declaration//GEN-END:variables
}
