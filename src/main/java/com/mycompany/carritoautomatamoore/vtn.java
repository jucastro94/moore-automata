/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.carritoautomatamoore;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JuanMiguelC
 */
public class vtn extends javax.swing.JFrame {

    public Proceso proceso = new Proceso();
    public boolean[] direcciones = new boolean[4];
    private String ruta = "";

    public vtn() {
        initComponents();
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                int keyCode = e.getKeyCode();
                if (e.getKeyChar() == 'w' || keyCode == KeyEvent.VK_UP) {
                    System.out.println("w");
                    direcciones[0] = true;
                    ruta = proceso.nuevaEntrada(1);
                    resaltar("w");
                    llenarTablaEstados();
                    llenarTablaCadena();
                    llenarTablaProceso();
                    mostrarImagenes(ruta);
                }
                if (e.getKeyChar() == 's' || keyCode == KeyEvent.VK_DOWN) {
                    System.out.println("s");
                    direcciones[1] = true;
                    ruta = proceso.nuevaEntrada(2);
                    resaltar("s");
                    llenarTablaEstados();
                    llenarTablaCadena();
                    llenarTablaProceso();
                    mostrarImagenes(ruta);
                }
                if (e.getKeyChar() == 'a' || keyCode == KeyEvent.VK_LEFT) {
                    System.out.println("a");
                    direcciones[2] = true;
                    ruta = proceso.nuevaEntrada(3);
                    resaltar("a");
                    llenarTablaEstados();
                    llenarTablaCadena();
                    llenarTablaProceso();
                    mostrarImagenes(ruta);
                }
                if (e.getKeyChar() == 'd' || keyCode == KeyEvent.VK_RIGHT) {
                    System.out.println("d");
                    direcciones[3] = true;
                    ruta = proceso.nuevaEntrada(4);
                    resaltar("d");
                    llenarTablaEstados();
                    llenarTablaCadena();
                    llenarTablaProceso();
                    mostrarImagenes(ruta);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (e.getKeyChar() == 'w' || keyCode == KeyEvent.VK_UP) {
                    direcciones[0] = false;
                }
                if (e.getKeyChar() == 's' || keyCode == KeyEvent.VK_DOWN) {
                    direcciones[1] = false;
                }
                if (e.getKeyChar() == 'a' || keyCode == KeyEvent.VK_LEFT) {
                    direcciones[2] = false;
                }
                if (e.getKeyChar() == 'd' || keyCode == KeyEvent.VK_RIGHT) {
                    direcciones[3] = false;
                }
                if (valDirecciones()) {
                    System.out.println("stop");
                    ruta = proceso.nuevaEntrada(0);
                    ocultar();
                     llenarTablaEstados();
                    llenarTablaCadena();
                    llenarTablaProceso();
                    mostrarImagenes(ruta);
                }
            }
        });

    }
    public Font fuente = new Font("Arial", Font.BOLD, 18);
    public Font fuente2 = new Font("Segoe UI", Font.PLAIN, 12);

    public void resaltar(String tecla) {

        switch (tecla) {
            case "w" -> {
                lblArriba.setForeground(Color.RED);
                lblAtras.setForeground(Color.BLACK);
                lblDerecha.setForeground(Color.BLACK);
                lblIzquierda.setForeground(Color.BLACK);

                lblArriba.setFont(fuente);
                lblAtras.setFont(fuente2);
                lblDerecha.setFont(fuente2);
                lblIzquierda.setFont(fuente2);

            }
            case "s" -> {
                lblArriba.setForeground(Color.BLACK);
                lblAtras.setForeground(Color.RED);
                lblDerecha.setForeground(Color.BLACK);
                lblIzquierda.setForeground(Color.BLACK);

                lblArriba.setFont(fuente2);
                lblAtras.setFont(fuente);
                lblDerecha.setFont(fuente2);
                lblIzquierda.setFont(fuente2);
            }
            case "a" -> {
                lblArriba.setForeground(Color.BLACK);
                lblAtras.setForeground(Color.BLACK);
                lblDerecha.setForeground(Color.BLACK);
                lblIzquierda.setForeground(Color.RED);

                lblArriba.setFont(fuente2);
                lblAtras.setFont(fuente2);
                lblDerecha.setFont(fuente2);
                lblIzquierda.setFont(fuente);
            }
            case "d" -> {
                lblArriba.setForeground(Color.BLACK);
                lblAtras.setForeground(Color.BLACK);
                lblDerecha.setForeground(Color.RED);
                lblIzquierda.setForeground(Color.BLACK);

                lblArriba.setFont(fuente2);
                lblAtras.setFont(fuente2);
                lblDerecha.setFont(fuente);
                lblIzquierda.setFont(fuente2);
            }
        }
    }

    public void ocultar() {
        lblArriba.setForeground(Color.BLACK);
        lblAtras.setForeground(Color.BLACK);
        lblDerecha.setForeground(Color.BLACK);
        lblIzquierda.setForeground(Color.BLACK);

        lblArriba.setFont(fuente2);
        lblAtras.setFont(fuente2);
        lblDerecha.setFont(fuente2);
        lblIzquierda.setFont(fuente2);
    }

    public boolean valDirecciones() {
        int val = 0;
        for (int i = 0; i < direcciones.length; i++) {
            if (direcciones[i] == false) {
                val++;
            }
        }
        if (val == 4) {
            return true;
        } else {
            return false;
        }
    }

    public void mostrarImagenes(String ruta) {
        Image image = null;
        try {
            image = ImageIO.read(new File("src\\main\\java\\com\\mycompany\\carritoautomatamoore\\resources\\" + ruta).getAbsoluteFile());
        } catch (IOException e) {
            System.out.println("error: " + e);
        }

        // Crear un ImageIcon a partir de la imagen
        ImageIcon icono = new ImageIcon(image);
        Image imagenEscalada = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        lblImage.setIcon(iconoEscalado);
        lblImage.setSize(150, 150);
    }

    public void llenarTablaEstados() {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnNames = {"estado", "salida", "usos", "recursividad"};
        modelo.setColumnIdentifiers(columnNames);
         Object[] fila = new Object[JTEstados.getColumnCount()];
         for (int i = 0; i < proceso.totalEstados.size(); i++) {
            //sout.println("aaaaaaa " + proceso.listaTotalidadEstados.get(i).nombre);
            fila[0]=proceso.totalEstados.get(i).nombre;
            fila[1]=proceso.totalEstados.get(i).salida;
            fila[2]=proceso.totalEstados.get(i).usos;
            fila[3]=proceso.totalEstados.get(i).recursividad;
            modelo.addRow(fila);
        }
         JTEstados.setModel(modelo);
    }

    public void llenarTablaCadena() {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnNames = {"Entrada", "Salida"};
        modelo.setColumnIdentifiers(columnNames);
         Object[] fila = new Object[jtCadena.getColumnCount()];
         for (int i = 0; i < proceso.cadenaEntrada.size(); i++) {
            //sout.println("aaaaaaa " + proceso.listaTotalidadEstados.get(i).nombre);
            fila[0]=proceso.cadenaEntrada.get(i);
            fila[1]=proceso.listaSalida.get(i);
            modelo.addRow(fila);
        }
         jtCadena.setModel(modelo);
    }
 public void llenarTablaProceso() {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnNames = {"Entrada"};
        modelo.setColumnIdentifiers(columnNames);
         Object[] fila = new Object[jtProceso.getColumnCount()];
         for (int i = 0; i < proceso.listaProceso.size(); i++) {
            fila[0]=proceso.listaProceso.get(i);
            modelo.addRow(fila);
        }
         jtProceso.setModel(modelo);
    }
    public void keyPressed(KeyEvent event) {
        System.out.println("Tecla presionada: " + event.getKeyChar());

    }

    public void keyReleased(KeyEvent event) {
        System.out.println("Tecla liberada: " + event.getKeyChar());
    }

    public void keyTyped(KeyEvent event) {
        System.out.println("Tecla escrita: " + event.getKeyChar());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lblArriba = new javax.swing.JLabel();
        lblIzquierda = new javax.swing.JLabel();
        lblAtras = new javax.swing.JLabel();
        lblDerecha = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCadena = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTEstados = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtProceso = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Estados");

        lblArriba.setText("Arriba");
        lblArriba.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblIzquierda.setText("Izquierda");

        lblAtras.setText("Atras");

        lblDerecha.setText("Derecha");

        lblImage.setText(".");
        lblImage.setName("lblImage"); // NOI18N

        jLabel1.setText("Cadena de entrada:");

        jtCadena.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "entrada", "salida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtCadena);

        JTEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "estado", "salida", "usos", "recursividades"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(JTEstados);

        jLabel3.setText("recorrido por estados");

        jtProceso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "entrada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtProceso);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 256, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAtras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblArriba, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(372, 372, 372))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(138, 138, 138))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(lblArriba)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIzquierda)
                    .addComponent(lblDerecha))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAtras)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vtn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTEstados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtCadena;
    private javax.swing.JTable jtProceso;
    private javax.swing.JLabel lblArriba;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblDerecha;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblIzquierda;
    // End of variables declaration//GEN-END:variables
}
