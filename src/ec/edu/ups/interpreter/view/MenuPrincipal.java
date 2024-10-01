package ec.edu.ups.interpreter.view;

import ec.edu.ups.interpreter.model.Contexto;
import ec.edu.ups.interpreter.model.IExpression;
import ec.edu.ups.interpreter.model.NumeroExpresion;
import ec.edu.ups.interpreter.model.OperadorExpresion;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 3
 */
public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        txt_expresion = new javax.swing.JTextField();
        btn_procesar = new javax.swing.JButton();
        lblExpresion = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_procesar.setText("Proceasar");
        btn_procesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_procesarActionPerformed(evt);
            }
        });

        lblExpresion.setText("Expresion");

        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblExpresion)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btn_procesar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_salir)
                        .addGap(160, 160, 160))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_expresion, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_expresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExpresion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_procesar)
                    .addComponent(btn_salir))
                .addContainerGap(209, Short.MAX_VALUE))
        );

        pack();
    }

    private void btn_procesarActionPerformed(java.awt.event.ActionEvent evt) {
        
        ArrayList<IExpression> expresiones = new ArrayList<>();
        String dato[];
        String val = txt_expresion.getText();
        dato = val.split(" ");
        Contexto contexto = new Contexto();

        // Añadimos los tokens pasados como argumentos
        for (String token : dato) {
            if (contexto.getValor(token) >= 0) {
                expresiones.add(new NumeroExpresion(token));
            } else {
                expresiones.add(new OperadorExpresion(token));
            }
        }

        // Interpretamos cada expresión
        for (IExpression e : expresiones) {
            e.interpret(contexto);
        }
        JOptionPane.showMessageDialog(null, "El resultado de la interpretacion es: " + contexto.getResultado());
        txt_expresion.setText(null);
        txt_expresion.requestFocus();
    }

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btn_procesar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel lblExpresion;
    private javax.swing.JTextField txt_expresion;
}
