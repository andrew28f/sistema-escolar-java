package view;

import java.awt.CardLayout;

public class MenuPrincipalForm extends javax.swing.JFrame {

    public MenuPrincipalForm() {
        initComponents();
        this.setTitle("Menu Principal");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        painelPrincipal.add(new AlunoForm(), "AlunoForm");
        painelPrincipal.add(new ProfessorForm(), "ProfessorForm");
        painelPrincipal.add(new TurmaForm(), "TurmaForm");
        painelPrincipal.add(new CursoForm(), "CursoForm");
        painelPrincipal.add(new NivelForm(), "NivelForm");
        painelPrincipal.add(new SobreForm(), "SobreForm");
        
        // Lógica para trocar os cards
        CardLayout cl = (CardLayout) painelPrincipal.getLayout();
        cl.show(painelPrincipal, "AlunoForm");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraNavegacao = new javax.swing.JPanel();
        btnAluno = new javax.swing.JButton();
        btnProfessor = new javax.swing.JButton();
        btnTurma = new javax.swing.JButton();
        btnCurso = new javax.swing.JButton();
        btnNivel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        painelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        barraNavegacao.setBackground(new java.awt.Color(0, 0, 51));

        btnAluno.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnAluno.setForeground(new java.awt.Color(255, 255, 255));
        btnAluno.setText("Aluno");
        btnAluno.setContentAreaFilled(false);
        btnAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlunoActionPerformed(evt);
            }
        });
        barraNavegacao.add(btnAluno);

        btnProfessor.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnProfessor.setForeground(new java.awt.Color(255, 255, 255));
        btnProfessor.setText("Professor");
        btnProfessor.setContentAreaFilled(false);
        btnProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfessorActionPerformed(evt);
            }
        });
        barraNavegacao.add(btnProfessor);

        btnTurma.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnTurma.setForeground(new java.awt.Color(255, 255, 255));
        btnTurma.setText("Turma");
        btnTurma.setContentAreaFilled(false);
        btnTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurmaActionPerformed(evt);
            }
        });
        barraNavegacao.add(btnTurma);

        btnCurso.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnCurso.setForeground(new java.awt.Color(255, 255, 255));
        btnCurso.setText("Curso");
        btnCurso.setContentAreaFilled(false);
        btnCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursoActionPerformed(evt);
            }
        });
        barraNavegacao.add(btnCurso);

        btnNivel.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnNivel.setForeground(new java.awt.Color(255, 255, 255));
        btnNivel.setText("Nível");
        btnNivel.setContentAreaFilled(false);
        btnNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNivelActionPerformed(evt);
            }
        });
        barraNavegacao.add(btnNivel);

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sobre");
        jButton1.setActionCommand("Usuarios");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        barraNavegacao.add(jButton1);

        btnUsuario.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnUsuario.setForeground(new java.awt.Color(255, 102, 102));
        btnUsuario.setText("Sair");
        btnUsuario.setContentAreaFilled(false);
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        barraNavegacao.add(btnUsuario);

        getContentPane().add(barraNavegacao, java.awt.BorderLayout.PAGE_START);

        painelPrincipal.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );

        painelPrincipal.add(jPanel1, "card2");

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlunoActionPerformed
        CardLayout cl = (CardLayout) painelPrincipal.getLayout();
        cl.show(painelPrincipal, "AlunoForm");
    }//GEN-LAST:event_btnAlunoActionPerformed

    private void btnTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurmaActionPerformed
        CardLayout cl = (CardLayout) painelPrincipal.getLayout();
        cl.show(painelPrincipal, "TurmaForm");
    }//GEN-LAST:event_btnTurmaActionPerformed

    private void btnProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfessorActionPerformed
        CardLayout cl = (CardLayout) painelPrincipal.getLayout();
        cl.show(painelPrincipal, "ProfessorForm");
    }//GEN-LAST:event_btnProfessorActionPerformed

    private void btnCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursoActionPerformed
        CardLayout cl = (CardLayout) painelPrincipal.getLayout();
        cl.show(painelPrincipal, "CursoForm");
    }//GEN-LAST:event_btnCursoActionPerformed

    private void btnNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNivelActionPerformed
        CardLayout cl = (CardLayout) painelPrincipal.getLayout();
        cl.show(painelPrincipal, "NivelForm");
    }//GEN-LAST:event_btnNivelActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CardLayout cl = (CardLayout) painelPrincipal.getLayout();
        cl.show(painelPrincipal, "SobreForm");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraNavegacao;
    private javax.swing.JButton btnAluno;
    private javax.swing.JButton btnCurso;
    private javax.swing.JButton btnNivel;
    private javax.swing.JButton btnProfessor;
    private javax.swing.JButton btnTurma;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painelPrincipal;
    // End of variables declaration//GEN-END:variables
}
