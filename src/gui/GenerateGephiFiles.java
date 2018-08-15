/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import database.DAOCorpus;
import filemanager.CFileManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import logic.CAnalyzer;
import logic.CCluster;
import logic.CCorpus;
import logic.CEdge;
import logic.CEntityNormalized;
import logic.CEntityRaw;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author osboxes
 */
public class GenerateGephiFiles extends javax.swing.JInternalFrame {

    /**
     * Creates new form EntitiesExtraction
     */
    public GenerateGephiFiles() {
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
        jButtonLoadSocialNetwork = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableConfigurationClusterAvailable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableNormalizedEntities = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableSocialNetwork = new javax.swing.JTable();
        jButtonGenerateFilesForGephi = new javax.swing.JButton();

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

        jButtonLoadSocialNetwork.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButtonLoadSocialNetwork.setText("Load the social network");
        jButtonLoadSocialNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadSocialNetworkActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setText("Available configured clusters");

        jTableConfigurationClusterAvailable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MinPts", "Epsilon"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConfigurationClusterAvailable.setToolTipText("");
        jTableConfigurationClusterAvailable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableConfigurationClusterAvailable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConfigurationClusterAvailableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableConfigurationClusterAvailable);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("List of normalized entities");

        jTableNormalizedEntities.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Label", "Class", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableNormalizedEntities.setToolTipText("");
        jTableNormalizedEntities.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableNormalizedEntities.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNormalizedEntitiesMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTableNormalizedEntities);
        TableRowSorter<TableModel> sorter04 = new TableRowSorter<TableModel>(jTableNormalizedEntities.getModel());
        jTableNormalizedEntities.setRowSorter(sorter04);
        //jTableCorpusEntities.convertRowIndexToView(0);

        List<RowSorter.SortKey> sortKeys04 = new ArrayList<>(25);
        sortKeys04.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sortKeys04.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
        sorter04.setSortKeys(sortKeys04);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("Social network generated");

        jTableSocialNetwork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Source", "Target", "Source Description", "Target Description", "Type", "Weight"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSocialNetwork.setToolTipText("");
        jTableSocialNetwork.setMinimumSize(new java.awt.Dimension(60, 0));
        jTableSocialNetwork.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSocialNetworkMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTableSocialNetwork);
        TableRowSorter<TableModel> sorter05 = new TableRowSorter<TableModel>(jTableSocialNetwork.getModel());
        jTableSocialNetwork.setRowSorter(sorter05);
        //jTableCorpusEntities.convertRowIndexToView(0);

        List<RowSorter.SortKey> sortKeys05 = new ArrayList<>(25);
        sortKeys05.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sortKeys05.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
        sorter05.setSortKeys(sortKeys05);

        jButtonGenerateFilesForGephi.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButtonGenerateFilesForGephi.setText("Generate files for Gephi");
        jButtonGenerateFilesForGephi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateFilesForGephiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jButtonLoadAvailableCorpora)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane7)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonLoadSocialNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1230, Short.MAX_VALUE)
                                .addComponent(jButtonGenerateFilesForGephi, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLoadAvailableCorpora)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonLoadSocialNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonGenerateFilesForGephi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoadAvailableCorporaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadAvailableCorporaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model1 = (DefaultTableModel) jTableAvailableCorpora.getModel();
        model1.setRowCount(0);
        
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
        showConfiguredClusterByCorpus();
    }//GEN-LAST:event_jTableAvailableCorporaMouseClicked

    private void showConfiguredClusterByCorpus()
    {
        DefaultTableModel model = (DefaultTableModel) jTableConfigurationClusterAvailable.getModel();
        model.setRowCount(0);
        
        model = (DefaultTableModel) jTableNormalizedEntities.getModel();
        model.setRowCount(0);
        
        int row=jTableAvailableCorpora.getSelectedRow();                
        int corpusId=(Integer)jTableAvailableCorpora.getValueAt(row, 0);   
        
        CCluster cluster = new CCluster();

        List <Object[]>results=cluster.getAvailableClusterConfigurationsByCorpusId(corpusId);

        for (Object[] result : results) {
            // Iterating through array object
            model = (DefaultTableModel)jTableConfigurationClusterAvailable.getModel();
            int minPts=(Integer)result[0];
            double epsilon=(Double)result[1];
            Object [] newRow = new Object []{minPts, epsilon};
            model.insertRow(jTableConfigurationClusterAvailable.getRowCount(), newRow);
        }        
        
    }
    private void jButtonLoadSocialNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadSocialNetworkActionPerformed
                     
        int row=jTableAvailableCorpora.getSelectedRow();                
        int corpusId=(Integer)jTableAvailableCorpora.getValueAt(row, 0); 
        
        row=jTableConfigurationClusterAvailable.getSelectedRow();
        
        int minPts=(Integer)jTableConfigurationClusterAvailable.getValueAt(row, 0); 
        double epsilon=(Double)jTableConfigurationClusterAvailable.getValueAt(row, 1); 
        
        showSocialNetwork(corpusId, minPts,  epsilon);                
    }//GEN-LAST:event_jButtonLoadSocialNetworkActionPerformed

    private void showSocialNetwork(int corpusId,int minPts, double epsilon)
    {
       //DefaultTableModel model1 = (DefaultTableModel) jTableClusters.getModel();
        //model1.setRowCount(0);
        CAnalyzer analizer = new CAnalyzer();
        
//        long answer=entNorm.validateExistanceOfSentenceNormalizedEntities(corpusId, minPts, epsilon);
  //      if(answer==0)
    //    {
               DefaultTableModel model1 = (DefaultTableModel) jTableSocialNetwork.getModel();
               model1.setRowCount(0);

               List<Object[]> resultSet = analizer.getSocialNetworkFomDatabase(corpusId, minPts, epsilon);

               for (Object[] result : resultSet) {
                   
                   DefaultTableModel modelc1 = (DefaultTableModel)jTableSocialNetwork.getModel();

                   Integer sourceID=(Integer)result[0];
                   String sourceDescription=(String)result[1];
                   Integer targetID=(Integer)result[2];
                   String targetDescription=(String)result[3];
                   //String sentence=(String)result[4];
                   String type="Undirected";
                   Integer weightEdge=(Integer)result[5];
                   modelc1.insertRow(jTableSocialNetwork.getRowCount(), new Object []{sourceID,targetID,sourceDescription,targetDescription,type,weightEdge});                         
               }                              
    //    }
      //  else
       // {
         //   JOptionPane.showMessageDialog(null,"The set of normalized entities has relationships with sentences",title, JOptionPane.INFORMATION_MESSAGE);            
      //  }         
              
    }    
    
    private void showNormalizedEntitiesAndSentences(int corpusId,int minPts, double epsilon)
    {
       //DefaultTableModel model1 = (DefaultTableModel) jTableClusters.getModel();
        //model1.setRowCount(0);
        CEntityNormalized entNorm = new CEntityNormalized();
        
        long answer=entNorm.validateExistanceOfSentenceNormalizedEntities(corpusId, minPts, epsilon);
        if(answer==0)
        {
               DefaultTableModel model1 = (DefaultTableModel) jTableSocialNetwork.getModel();
               model1.setRowCount(0);

               List<Object[]> resultSet = entNorm.getNormalizedEntitiesAndSentences(corpusId, minPts, epsilon);

               for (Object[] result : resultSet) {
       
                   DefaultTableModel modelc1 = (DefaultTableModel)jTableSocialNetwork.getModel();

                   Integer entNormId=(Integer)result[0];
                   String entNormName=(String)result[1];
                   String entNormType=(String)result[2];
                   Integer sentId=(Integer)result[3];
                   String sentence=(String)result[4];

                   modelc1.insertRow(jTableSocialNetwork.getRowCount(), new Object []{entNormId,entNormName,entNormType,sentId,sentence});
               }                 
        }
        else
        {
            JOptionPane.showMessageDialog(null,"The set of normalized entities has relationships with sentences",title, JOptionPane.INFORMATION_MESSAGE);            
        }         
              
    }
    
    private void refreshScreenAfterGeneratingNewCluster()
    { /*       
        int row=jTableAvailableCorpora.getSelectedRow();                
        int corpusId=(Integer)jTableAvailableCorpora.getValueAt(row, 0); 
        
        row=jTableConfigurationClusterAvailable.getSelectedRow();
        
        int minPts=(Integer)jTableConfigurationClusterAvailable.getValueAt(row, 0); 
        double epsilon=(Double)jTableConfigurationClusterAvailable.getValueAt(row, 1); 
        
        showClusters(corpusId, minPts,  epsilon);*/

        //showEntitiesAndSentencesByCluster(jTableCorpusEntitiesBelongCluster,jTableClusters);
        //showEntitiesAndSentencesByCluster(jTableCorpusEntitiesBelongCluster1,jTableClusters1);
    }
    
    private String moveEntitiesIntoOtherCluster()
    { 
        String answer="";
                
       
        
        return answer;
    }
    
    private void showNormalizedEntities(int corpusId,int minPts, double epsilon)
    {
        //DefaultTableModel model1 = (DefaultTableModel) jTableClusters.getModel();
        //model1.setRowCount(0);
        CEntityNormalized entNorm = new CEntityNormalized();
        
        DefaultTableModel model1 = (DefaultTableModel) jTableNormalizedEntities.getModel();
        model1.setRowCount(0);

//        model1 = (DefaultTableModel) jTableEntitiesBelongToNormalEntity.getModel();
  //      model1.setRowCount(0);

        // TODO add your handling code here:
        List<Object[]> resultSet = entNorm.getNormalizedEntitiesByCorpusEpsMinpts(corpusId, minPts, epsilon);
        
        
        System.out.println( "The number of normalized entities is: " + resultSet.size());

        for (Object[] result : resultSet) {

//            DefaultTableModel model = (DefaultTableModel)jTableClusters.getModel();
            DefaultTableModel modelc1 = (DefaultTableModel)jTableNormalizedEntities.getModel();
            Integer clusterid=(Integer)result[0];
            Integer label=(Integer)result[1];
            Integer entityId=(Integer)result[2];
            String entity=(String)result[3];
            String type=(String)result[4];
            String role=(String)result[5];

            modelc1.insertRow(jTableNormalizedEntities.getRowCount(), new Object []{entityId,entity,type,role});
        }            
                                       
    }       
    
    
    private void showEntitiesAndSentencesByCluster(javax.swing.JTable entityTable, javax.swing.JTable clusterTable)
    {
        DefaultTableModel model = (DefaultTableModel) entityTable.getModel();
        model.setRowCount(0);
        
        int row=clusterTable.getSelectedRow();                
        int clusterId=(Integer)clusterTable.getValueAt(row, 0);   
        
        CEntityRaw centityRaw = new CEntityRaw();
        
        List <Object[]>results=centityRaw.getEntitiesAndSentencesByCluster(clusterId);
        
        for (Object[] result : results) {
            // Iterating through array object
            model = (DefaultTableModel)entityTable.getModel();
            String temp=(String)result[1];
            int length=temp.length();
            Object [] newRow = new Object []{result[0],result[1],result[2],length,result[3],result[4]};
            model.insertRow(entityTable.getRowCount(), newRow);
        }         
        
    }
    
    private void showEntitiesAndSentencesByClusterAndEntity(javax.swing.JTable entityTable, javax.swing.JTable clusterTable)
    {
        DefaultTableModel model = (DefaultTableModel) entityTable.getModel();
        model.setRowCount(0);
        
        int row=clusterTable.getSelectedRow();                
        int clusterId=(Integer)clusterTable.getValueAt(row, 0);   
        
        row=clusterTable.getSelectedRow();                
        int label=(Integer)clusterTable.getValueAt(row, 1);  
        
        if(label!=2147483647) //Para los que no son ruido
        {
            CEntityRaw centityRaw = new CEntityRaw();

            List <Object[]>results=centityRaw.getEntitiesAndSentencesByCluster(clusterId);

            for (Object[] result : results) {
                // Iterating through array object
                model = (DefaultTableModel)entityTable.getModel();
                String temp=(String)result[1];
                int length=temp.length();
                Object [] newRow = new Object []{result[0],result[1],result[2],length,result[3],result[4]};
                model.insertRow(entityTable.getRowCount(), newRow);
            }               
        }
        else //Para los que son ruido
        {
            CEntityRaw centityRaw = new CEntityRaw();
            
            row=clusterTable.getSelectedRow();                
            int entityId=(Integer)clusterTable.getValueAt(row, 2); 

            Object[] result=centityRaw.getEntitiesAndSentencesByClusterAndEntity(clusterId,entityId); 
            
            model = (DefaultTableModel)entityTable.getModel();
            String temp=(String)result[1];
            int length=temp.length();
            Object [] newRow = new Object []{result[0],result[1],result[2],length,result[3],result[4]};
            model.insertRow(entityTable.getRowCount(), newRow);            
            
        }             
        
    }
    
    private void jTableConfigurationClusterAvailableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConfigurationClusterAvailableMouseClicked
        // TODO add your handling code here:                        
        int row=jTableAvailableCorpora.getSelectedRow();                
        int corpusId=(Integer)jTableAvailableCorpora.getValueAt(row, 0); 
        
        row=jTableConfigurationClusterAvailable.getSelectedRow();
        
        int minPts=(Integer)jTableConfigurationClusterAvailable.getValueAt(row, 0); 
        double epsilon=(Double)jTableConfigurationClusterAvailable.getValueAt(row, 1); 
        
        showNormalizedEntities(corpusId, minPts,  epsilon);
    }//GEN-LAST:event_jTableConfigurationClusterAvailableMouseClicked

    private void jTableNormalizedEntitiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNormalizedEntitiesMouseClicked
        // TODO add your handling code here:
        //showEntitiesAndSentencesByCluster(jTableEntitiesBelongToNormalEntity,jTableNormalizedEntities);
        //showEntitiesAndSentencesByClusterAndEntity(jTableEntitiesBelongToNormalEntity,jTableNormalizedEntities);
    }//GEN-LAST:event_jTableNormalizedEntitiesMouseClicked

    private void jButtonGenerateFilesForGephiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateFilesForGephiActionPerformed
        // TODO add your handling code here:
        CFileManager cfile=new CFileManager();
        try
        {
            cfile.writeCSVfile(jTableNormalizedEntities, "Nodes");
            cfile.writeCSVfile(jTableSocialNetwork, "Edges");
            JOptionPane.showMessageDialog(null,"Gephi files were generated","Gephi files generation", JOptionPane.INFORMATION_MESSAGE); 
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Problem: Gephi files were not generated","Gephi files generation", JOptionPane.ERROR_MESSAGE); 
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButtonGenerateFilesForGephiActionPerformed

    private void jTableSocialNetworkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSocialNetworkMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2)
        {
            int row=jTableSocialNetwork.getSelectedRow();
            
            System.out.println("Row: " + row);
            
            int trueIndex=jTableSocialNetwork.convertRowIndexToModel(row);
            
            System.out.println("Fila: " + trueIndex);
       
            String sentence= (String)jTableSocialNetwork.getModel().getValueAt(trueIndex, 4);
       
            String message=WordUtils.wrap(sentence, 200, "\n", false);
            
            String title="Sentence detail";
            
            JOptionPane.showMessageDialog(null,message,title, JOptionPane.INFORMATION_MESSAGE);                                
        }
              
    }//GEN-LAST:event_jTableSocialNetworkMouseClicked
    
 private String saveSocialNetwork()
 {
        String answer="";
                
        if(jTableSocialNetwork.getRowCount()>0)
        {
            EntityManager em = Persistence.createEntityManagerFactory("SNAFromSpanishTextPU").createEntityManager(); 

            int selectCount=jTableSocialNetwork.getRowCount();
            
            int row=jTableAvailableCorpora.getSelectedRow();                
            int corpusId=(Integer)jTableAvailableCorpora.getValueAt(row, 0);            
            
            em.getTransaction().begin();
            
            for (int i=0;i<selectCount;i++)
            {
                int sourceId=(Integer)jTableSocialNetwork.getValueAt(i, 0); 
                String sourceDescription=(String)jTableSocialNetwork.getValueAt(i, 1); 
                int targetId=(Integer)jTableSocialNetwork.getValueAt(i, 2);  
                String targetDescription=(String)jTableSocialNetwork.getValueAt(i, 3);  
                String sentences=(String)jTableSocialNetwork.getValueAt(i, 4);  
                int weight=(Integer)jTableSocialNetwork.getValueAt(i, 5);                  
                
                CAnalyzer analyzer = new CAnalyzer();
                
                analyzer.saveSocialNetwork(em, sourceId, sourceDescription, targetId, targetDescription, corpusId, weight, sentences);
            }

            try
            {
              em.getTransaction().commit();
            }
            catch (Exception e)
            {
              answer="It was impossible to save the social network";
              em.getTransaction().rollback();
              e.printStackTrace();
              throw e;
            }            
          
        }
        else
        {
            answer="You should generate the social network before saving it";
        }
        
        return answer;     
 }
 private void addEntityIntoHashMap(boolean newValue, int entityId) 
    {
        if(newValue)//reviso si la entidad ya existe en el Hash Map
        {
            /*Si la entidad ya existe en el Hash Map simplemente modifico su NewType*/
            entitiesToMove.add(entityId);
        }
        else
        {
            /*Si la entidad no existe en el Hash Map, la añado*/
            entitiesToMove.remove(entityId);
        }
        
        
    }    
    
    private HashSet<Integer> entitiesToMove = new HashSet<Integer>() ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGenerateFilesForGephi;
    private javax.swing.JButton jButtonLoadAvailableCorpora;
    private javax.swing.JButton jButtonLoadSocialNetwork;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTableAvailableCorpora;
    private javax.swing.JTable jTableConfigurationClusterAvailable;
    private javax.swing.JTable jTableNormalizedEntities;
    private javax.swing.JTable jTableSocialNetwork;
    // End of variables declaration//GEN-END:variables
}
