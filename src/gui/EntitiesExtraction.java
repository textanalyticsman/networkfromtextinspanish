/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import database.DAOCorpus;
import database.DAODocument;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logic.CAnalyzer;
import logic.CCorpus;
import logic.CDocument;

/**
 *
 * @author osboxes
 */
public class EntitiesExtraction extends javax.swing.JInternalFrame {

    /**
     * Creates new form EntitiesExtraction
     */
    public EntitiesExtraction() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLoadAvailableCorpora = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAvailableCorpora = new javax.swing.JTable();
        jButtonExtractEntitiesFromCorpus = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableRawEntities = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jButtonLoadAvailableCorpora.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButtonLoadAvailableCorpora.setText("Load available corpora");
        jButtonLoadAvailableCorpora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadAvailableCorporaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Available corpora within the database");

        jTableAvailableCorpora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifier", "Corpus description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAvailableCorpora.setToolTipText("");
        jTableAvailableCorpora.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableAvailableCorpora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAvailableCorporaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableAvailableCorpora);

        jButtonExtractEntitiesFromCorpus.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButtonExtractEntitiesFromCorpus.setText("Extract entities from selected corpus");
        jButtonExtractEntitiesFromCorpus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExtractEntitiesFromCorpusActionPerformed(evt);
            }
        });

        jTableRawEntities.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifier", "Entity name", "Entity type", "Document identifier ", "Document title", "Sentences identifier", "Sentence"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRawEntities.setToolTipText("");
        jTableRawEntities.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableRawEntities.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRawEntitiesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableRawEntities);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonExtractEntitiesFromCorpus)
                            .addComponent(jLabel2)
                            .addComponent(jButtonLoadAvailableCorpora)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 461, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLoadAvailableCorpora)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonExtractEntitiesFromCorpus)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoadAvailableCorporaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadAvailableCorporaActionPerformed
        // TODO add your handling code here:
        CCorpus corpus = new CCorpus();

        List<DAOCorpus> resultList = corpus.getAvailableCorpora();

        for (DAOCorpus c : resultList) {
            //jTextArea1.append(c.getName() + " (" + c.getCity() + ")" + "\n");
            //System.out.println(c.getName() + " (" + c.getCity() + ")" + "\n");

            DefaultTableModel model = (DefaultTableModel)jTableAvailableCorpora.getModel();
            Integer identifier=(Integer)c.getCorpid();
            String description=c.getCorpdesc();

            model.insertRow(jTableAvailableCorpora.getRowCount(), new Object []{identifier,description});

        }

    }//GEN-LAST:event_jButtonLoadAvailableCorporaActionPerformed

    private void jTableAvailableCorporaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAvailableCorporaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTableAvailableCorporaMouseClicked

    private void jButtonExtractEntitiesFromCorpusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExtractEntitiesFromCorpusActionPerformed
        // TODO add your handling code here:
        int row=jTableAvailableCorpora.getSelectedRow();        
        
        int id=(Integer)jTableAvailableCorpora.getValueAt(row, 0);
                
        
        CCorpus corpus=new CCorpus();
        
        //En caso aún no se hayan obtenido entidades de este corpus, procedo con la
        //extracción. En otro caso muestro un mensaje indicando que ya se han extraído 
        //entidades de este corpus
        if (!corpus.validateEntitiesExistanceForCorpus(id)) 
        {
            DAOCorpus corpusId = corpus.getCorpusById(id);

            CDocument document=new CDocument();

            List<DAODocument> documentsList=document.getDocumentsBelongCorpus(corpusId);

            CAnalyzer analyzer= new CAnalyzer();

            //This variable is used to know whether the extraction of entities was executed
            //with success or not
            boolean answer=false;
            try 
            {
               answer=analyzer.extractEntitiesFromDocuments(documentsList); 
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


            if(answer)
            {           
                //In this case the entities extraction process was executed with succes
                //so I have to run a query to show entities and their documents using a 
                //table
                List <Object[]>results=corpus.getEntitiesBelongToCorpus(id);
                                
                
                Iterator it = results.iterator( );  

                while (it.hasNext( )) {  

                  Object[] result = (Object[])it.next(); // Iterating through array object   

                  /*System.out.println(result[0]+ "*******"+result[1]+"*******"+result[2]+"*******"+result[3]+
                                    "*******"+result[4]+"*******"+result[5]+"*******"+result[6]); */                                                      
                  
                  
                 DefaultTableModel model = (DefaultTableModel)jTableRawEntities.getModel();
                 
                 Object [] newRow = new Object []{result[0],result[1],result[2],result[3],result[4],result[5],result[6]};

                 model.insertRow(jTableRawEntities.getRowCount(), newRow);

                }  

            }

        }
        else
        {
            String message="You cannot extract entities because this corpus has been processed before";
            String title="Entities extraction";                
            JOptionPane.showMessageDialog(null,message,title, JOptionPane.INFORMATION_MESSAGE);             
        }
        

    }//GEN-LAST:event_jButtonExtractEntitiesFromCorpusActionPerformed

    private void jTableRawEntitiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRawEntitiesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableRawEntitiesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExtractEntitiesFromCorpus;
    private javax.swing.JButton jButtonLoadAvailableCorpora;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAvailableCorpora;
    private javax.swing.JTable jTableRawEntities;
    // End of variables declaration//GEN-END:variables
}
