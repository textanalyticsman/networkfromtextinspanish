/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import database.DAOCorpus;
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
import logic.CCluster;
import logic.CCorpus;
import logic.CEntityNormalized;
import logic.CEntityRaw;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author osboxes
 */
public class GeneratingNormalizedEntities extends javax.swing.JInternalFrame {

    /**
     * Creates new form EntitiesExtraction
     */
    public GeneratingNormalizedEntities() {
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
        jButtonExtractNormalizedEntities = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableConfigurationClusterAvailable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableClusters1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableCorpusEntitiesBelongCluster1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableNormalizedEntities = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableEntitiesBelongToNormalEntity = new javax.swing.JTable();
        jButtonSaveNormalizedEntities = new javax.swing.JButton();

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

        jButtonExtractNormalizedEntities.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButtonExtractNormalizedEntities.setText("Extract normalized entities");
        jButtonExtractNormalizedEntities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExtractNormalizedEntitiesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("List of clusters");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Entities that belong to the selected cluster");

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

        jTableClusters1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifier", "Label", "Sample of entities", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Long.class
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
        jTableClusters1.setToolTipText("");
        jTableClusters1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableClusters1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClusters1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableClusters1);
        TableRowSorter<TableModel> sorter02 = new TableRowSorter<TableModel>(jTableClusters1.getModel());
        jTableClusters1.setRowSorter(sorter02);
        //jTableCorpusEntities.convertRowIndexToView(0);

        List<RowSorter.SortKey> sortKeys02 = new ArrayList<>(25);
        sortKeys02.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sortKeys02.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
        sorter02.setSortKeys(sortKeys02);

        jTableCorpusEntitiesBelongCluster1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Entity Identifier", "Entity name", "Entity type", "Entity length", "Sentence Identifier", "Sentence"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
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
        jTableCorpusEntitiesBelongCluster1.setToolTipText("");
        jTableCorpusEntitiesBelongCluster1.setMinimumSize(new java.awt.Dimension(60, 0));
        jTableCorpusEntitiesBelongCluster1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCorpusEntitiesBelongCluster1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableCorpusEntitiesBelongCluster1);
        TableRowSorter<TableModel> sorter03 = new TableRowSorter<TableModel>(jTableCorpusEntitiesBelongCluster1.getModel());
        jTableCorpusEntitiesBelongCluster1.setRowSorter(sorter03);
        //jTableCorpusEntities.convertRowIndexToView(0);

        List<RowSorter.SortKey> sortKeys03 = new ArrayList<>(25);
        sortKeys03.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sortKeys03.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
        sorter03.setSortKeys(sortKeys03);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("List of normalized entities");

        jTableNormalizedEntities.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cluster Id", "Label", "Ent Id", "Entity", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jLabel6.setText("Entities represented by a normalized entity");

        jTableEntitiesBelongToNormalEntity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Entity Identifier", "Entity name", "Entity type", "Entity length", "Sentence Identifier", "Sentence"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
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
        jTableEntitiesBelongToNormalEntity.setToolTipText("");
        jTableEntitiesBelongToNormalEntity.setMinimumSize(new java.awt.Dimension(60, 0));
        jTableEntitiesBelongToNormalEntity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEntitiesBelongToNormalEntityMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTableEntitiesBelongToNormalEntity);
        TableRowSorter<TableModel> sorter05 = new TableRowSorter<TableModel>(jTableEntitiesBelongToNormalEntity.getModel());
        jTableEntitiesBelongToNormalEntity.setRowSorter(sorter05);
        //jTableCorpusEntities.convertRowIndexToView(0);

        List<RowSorter.SortKey> sortKeys05 = new ArrayList<>(25);
        sortKeys05.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sortKeys05.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
        sorter05.setSortKeys(sortKeys05);

        jButtonSaveNormalizedEntities.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButtonSaveNormalizedEntities.setText("Save normalized entities");
        jButtonSaveNormalizedEntities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveNormalizedEntitiesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSaveNormalizedEntities, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonLoadAvailableCorpora)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(463, 463, 463)
                                        .addComponent(jLabel4))
                                    .addComponent(jButtonExtractNormalizedEntities, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(32, 32, 32))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButtonExtractNormalizedEntities, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButtonSaveNormalizedEntities, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        
        model = (DefaultTableModel) jTableClusters1.getModel();
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
    private void jButtonExtractNormalizedEntitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExtractNormalizedEntitiesActionPerformed
                     
        int row=jTableAvailableCorpora.getSelectedRow();                
        int corpusId=(Integer)jTableAvailableCorpora.getValueAt(row, 0); 
        
        row=jTableConfigurationClusterAvailable.getSelectedRow();
        
        int minPts=(Integer)jTableConfigurationClusterAvailable.getValueAt(row, 0); 
        double epsilon=(Double)jTableConfigurationClusterAvailable.getValueAt(row, 1); 
        
        showNormalizedEntities(corpusId, minPts,  epsilon);        
        
    }//GEN-LAST:event_jButtonExtractNormalizedEntitiesActionPerformed

    private void refreshScreenAfterGeneratingNewCluster()
    { /*       
        int row=jTableAvailableCorpora.getSelectedRow();                
        int corpusId=(Integer)jTableAvailableCorpora.getValueAt(row, 0); 
        
        row=jTableConfigurationClusterAvailable.getSelectedRow();
        
        int minPts=(Integer)jTableConfigurationClusterAvailable.getValueAt(row, 0); 
        double epsilon=(Double)jTableConfigurationClusterAvailable.getValueAt(row, 1); 
        
        showClusters(corpusId, minPts,  epsilon);*/

        //showEntitiesAndSentencesByCluster(jTableCorpusEntitiesBelongCluster,jTableClusters);
        showEntitiesAndSentencesByCluster(jTableCorpusEntitiesBelongCluster1,jTableClusters1);
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
        
        long answer=entNorm.validateExistanceOfNormalizedEntities(corpusId,minPts, epsilon);
        
        if(answer==0)
        {
            DefaultTableModel model1 = (DefaultTableModel) jTableNormalizedEntities.getModel();
            model1.setRowCount(0);

            model1 = (DefaultTableModel) jTableEntitiesBelongToNormalEntity.getModel();
            model1.setRowCount(0);

            // TODO add your handling code here:


            List<Object[]> resultSet = entNorm.generateNormalizedEntities(corpusId, minPts, epsilon);

            for (Object[] result : resultSet) {

    //            DefaultTableModel model = (DefaultTableModel)jTableClusters.getModel();
                DefaultTableModel modelc1 = (DefaultTableModel)jTableNormalizedEntities.getModel();
                Integer clusterid=(Integer)result[0];
                Integer label=(Integer)result[1];
                Integer entityId=(Integer)result[2];
                String entity=(String)result[3];
                String type=(String)result[4];

                modelc1.insertRow(jTableNormalizedEntities.getRowCount(), new Object []{clusterid,label,entityId,entity,type});
            }            
        }
        else
        {
            JOptionPane.showMessageDialog(null,"The configuration cluster Eps MinPts selected for this corpus has normalized entities",title, JOptionPane.INFORMATION_MESSAGE);            
        }                                
    }    
    
    private void showClusters(int corpusId,int minPts, double epsilon)
    {
        //DefaultTableModel model1 = (DefaultTableModel) jTableClusters.getModel();
        //model1.setRowCount(0);
        
        DefaultTableModel model1 = (DefaultTableModel) jTableClusters1.getModel();
        model1.setRowCount(0);
        
        model1 = (DefaultTableModel) jTableCorpusEntitiesBelongCluster1.getModel();
        model1.setRowCount(0);
        
        // TODO add your handling code here:
        CCluster cluster = new CCluster();

        /*List<DAOCluster> resultSet = cluster.getAvailableClusters(corpusId, minPts, epsilon);

        for (DAOCluster c : resultSet) {

            DefaultTableModel model = (DefaultTableModel)jTableClusters.getModel();
            Integer clusterid=c.getClusterid();
            Integer label=c.getLabel();

            model.insertRow(jTableClusters.getRowCount(), new Object []{clusterid,label});

        }*/

        List<Object[]> resultSet = cluster.getAvailableClustersNative(corpusId, minPts, epsilon);

        for (Object[] result : resultSet) {

//            DefaultTableModel model = (DefaultTableModel)jTableClusters.getModel();
            DefaultTableModel modelc1 = (DefaultTableModel)jTableClusters1.getModel();
            Integer clusterid=(Integer)result[0];
            Integer label=(Integer)result[1];
            String clusterSample="";
            if(label==2147483647)
            {
                clusterSample="Noise";                
            }
            else
            {
                clusterSample=(String)result[2];                
            }
            Long quantity=(Long)result[3];
            //model.insertRow(jTableClusters.getRowCount(), new Object []{clusterid,label,clusterSample,quantity});
            modelc1.insertRow(jTableClusters1.getRowCount(), new Object []{clusterid,label,clusterSample,quantity});
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
        
        showClusters(corpusId, minPts,  epsilon);
    }//GEN-LAST:event_jTableConfigurationClusterAvailableMouseClicked

    private void jTableNormalizedEntitiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNormalizedEntitiesMouseClicked
        // TODO add your handling code here:
        //showEntitiesAndSentencesByCluster(jTableEntitiesBelongToNormalEntity,jTableNormalizedEntities);
        showEntitiesAndSentencesByClusterAndEntity(jTableEntitiesBelongToNormalEntity,jTableNormalizedEntities);
    }//GEN-LAST:event_jTableNormalizedEntitiesMouseClicked

    private void jTableEntitiesBelongToNormalEntityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEntitiesBelongToNormalEntityMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableEntitiesBelongToNormalEntityMouseClicked

    private void jTableCorpusEntitiesBelongCluster1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCorpusEntitiesBelongCluster1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2)
        {
            int row=jTableCorpusEntitiesBelongCluster1.getSelectedRow();

            System.out.println("Row: " + row);

            int trueIndex=jTableCorpusEntitiesBelongCluster1.convertRowIndexToModel(row);

            //System.out.println("Fila: " + trueIndex);

            String sentence= (String)jTableCorpusEntitiesBelongCluster1.getModel().getValueAt(trueIndex, 5);

            String message=WordUtils.wrap(sentence, 200, "\n", false);

            String title="Sentence detail";

            JOptionPane.showMessageDialog(null,message,title, JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jTableCorpusEntitiesBelongCluster1MouseClicked

    private void jTableClusters1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClusters1MouseClicked
        // TODO add your handling code here:
        showEntitiesAndSentencesByCluster(jTableCorpusEntitiesBelongCluster1,jTableClusters1);
    }//GEN-LAST:event_jTableClusters1MouseClicked

    private void jButtonSaveNormalizedEntitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveNormalizedEntitiesActionPerformed
        // TODO add your handling code here:
        String answer=saveNormalizedEntities();
        
        if(answer.compareTo("")==0)
        {
//            refreshScreenAfterGeneratingNewCluster();

            String message="The set of normalized entities was generated properly";
            String title="Generating normalized entities";                
            JOptionPane.showMessageDialog(null,message,title, JOptionPane.INFORMATION_MESSAGE);                               
        }
        else
        {
            String title="Generating normalized entities";                
            JOptionPane.showMessageDialog(null,answer,title, JOptionPane.ERROR_MESSAGE);                                           
        }           
    }//GEN-LAST:event_jButtonSaveNormalizedEntitiesActionPerformed
    
 private String saveNormalizedEntities()
 {
        String answer="";
                
        if(jTableNormalizedEntities.getRowCount()>0)
        {
            EntityManager em = Persistence.createEntityManagerFactory("SNAFromSpanishTextPU").createEntityManager(); 

            int selectCount=jTableNormalizedEntities.getRowCount();
            
            
            em.getTransaction().begin();
            
            for (int i=0;i<selectCount;i++)
            {
                //Boolean isSelected=(Boolean)jTableAvailableDocuments.getValueAt(i, 4);
                //System.out.println(isSelected.booleanValue());
                /*if(jTableAvailableDocuments.getValueAt(i, 4)!=null)
                {
                    if((Boolean)jTableAvailableDocuments.getValueAt(i, 4))
                    {
                        documentsSet.add(jTableAvailableDocuments.getValueAt(i, 0));
                    }

                }*/
                int clusterId= (Integer)jTableNormalizedEntities.getValueAt(i, 0);
                String entityName = (String)jTableNormalizedEntities.getValueAt(i, 3);
                String entityType = (String)jTableNormalizedEntities.getValueAt(i, 4);
                
                CEntityNormalized cEntNorm = new CEntityNormalized();
                
                cEntNorm.saveNormalizedEntity(em, entityName, entityType, clusterId);
            }

            try
            {
              em.getTransaction().commit();
            }
            catch (Exception e)
            {
              answer="It was impossible to save normalized entities";
              em.getTransaction().rollback();
              e.printStackTrace();
              throw e;
            }            
          
        }
        else
        {
            answer="In order to save normalized entities you need a list of normalized entities generated previously";
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
    private javax.swing.JButton jButtonExtractNormalizedEntities;
    private javax.swing.JButton jButtonLoadAvailableCorpora;
    private javax.swing.JButton jButtonSaveNormalizedEntities;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTableAvailableCorpora;
    private javax.swing.JTable jTableClusters1;
    private javax.swing.JTable jTableConfigurationClusterAvailable;
    private javax.swing.JTable jTableCorpusEntitiesBelongCluster1;
    private javax.swing.JTable jTableEntitiesBelongToNormalEntity;
    private javax.swing.JTable jTableNormalizedEntities;
    // End of variables declaration//GEN-END:variables
}