/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frugalLab;

/**
 *
 * @author fattymcphatfat
 */
public class SearchResultPanel extends javax.swing.JPanel {
    FrugalController frugalController;

    /**
     * Creates new form SearchResultPanel
     */
    public SearchResultPanel(FrugalController frugalController) {
        initComponents();
        this.frugalController = frugalController;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        propertyPanel = new javax.swing.JPanel();
        leftPropPanel = new javax.swing.JPanel();
        projectIDLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        outcomeLabel = new javax.swing.JLabel();
        projectIDTextField = new javax.swing.JTextField();
        titleTextField = new javax.swing.JTextField();
        statusTextField = new javax.swing.JTextField();
        startDateTextField = new javax.swing.JTextField();
        endDateTextField = new javax.swing.JTextField();
        outcomeScrollPane = new javax.swing.JScrollPane();
        outcomeTextArea = new javax.swing.JTextArea();
        separatorPanel = new javax.swing.JPanel();
        separator = new javax.swing.JSeparator();
        rightPropPanel = new javax.swing.JPanel();
        studentsPanel = new javax.swing.JLabel();
        partnersPanel = new javax.swing.JLabel();
        advisorsPanel = new javax.swing.JLabel();
        categoriesPanel = new javax.swing.JLabel();
        tagsPanel = new javax.swing.JLabel();
        mediaPanel = new javax.swing.JLabel();
        otherDataPanel = new javax.swing.JLabel();
        studentsScrollPane = new javax.swing.JScrollPane();
        studentsTextArea = new javax.swing.JTextArea();
        partnersScrollPane = new javax.swing.JScrollPane();
        partnersTextArea = new javax.swing.JTextArea();
        categoriesScrollPane = new javax.swing.JScrollPane();
        categoriesTextArea = new javax.swing.JTextArea();
        advisorsScrollPane = new javax.swing.JScrollPane();
        advisorsTextArea = new javax.swing.JTextArea();
        tagsScrollPane = new javax.swing.JScrollPane();
        tagsTextArea = new javax.swing.JTextArea();
        mediaViewButton = new javax.swing.JButton();
        otherDataViewButton = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        tablePanelScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBackground(new java.awt.Color(143, 19, 21));
        setPreferredSize(new java.awt.Dimension(1024, 768));

        propertyPanel.setBackground(new java.awt.Color(143, 19, 21));

        leftPropPanel.setBackground(new java.awt.Color(143, 19, 21));
        leftPropPanel.setPreferredSize(new java.awt.Dimension(447, 401));

        projectIDLabel.setBackground(new java.awt.Color(143, 19, 21));
        projectIDLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        projectIDLabel.setForeground(java.awt.Color.white);
        projectIDLabel.setText("projectID:");
        projectIDLabel.setOpaque(true);

        titleLabel.setBackground(new java.awt.Color(143, 19, 21));
        titleLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        titleLabel.setForeground(java.awt.Color.white);
        titleLabel.setText("Title:");
        titleLabel.setOpaque(true);

        statusLabel.setBackground(new java.awt.Color(143, 19, 21));
        statusLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        statusLabel.setForeground(java.awt.Color.white);
        statusLabel.setText("Status:");
        statusLabel.setOpaque(true);

        startDateLabel.setBackground(new java.awt.Color(143, 19, 21));
        startDateLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        startDateLabel.setForeground(java.awt.Color.white);
        startDateLabel.setText("Start Date:");
        startDateLabel.setOpaque(true);

        endDateLabel.setBackground(new java.awt.Color(143, 19, 21));
        endDateLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        endDateLabel.setForeground(java.awt.Color.white);
        endDateLabel.setText("End Date:");
        endDateLabel.setOpaque(true);

        outcomeLabel.setBackground(new java.awt.Color(143, 19, 21));
        outcomeLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        outcomeLabel.setForeground(java.awt.Color.white);
        outcomeLabel.setText("Outcome:");
        outcomeLabel.setOpaque(true);

        projectIDTextField.setEditable(false);

        titleTextField.setEditable(false);

        statusTextField.setEditable(false);

        startDateTextField.setEditable(false);
        startDateTextField.setText("mm/dd/yyyy");

        endDateTextField.setEditable(false);
        endDateTextField.setText("mm/dd/yyyy");

        outcomeTextArea.setEditable(false);
        outcomeTextArea.setColumns(20);
        outcomeTextArea.setRows(5);
        outcomeScrollPane.setViewportView(outcomeTextArea);

        javax.swing.GroupLayout leftPropPanelLayout = new javax.swing.GroupLayout(leftPropPanel);
        leftPropPanel.setLayout(leftPropPanelLayout);
        leftPropPanelLayout.setHorizontalGroup(
            leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPropPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projectIDLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startDateLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(endDateLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(outcomeLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(outcomeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleTextField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftPropPanelLayout.setVerticalGroup(
            leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPropPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectIDLabel)
                    .addComponent(projectIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateLabel)
                    .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endDateLabel)
                    .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPropPanelLayout.createSequentialGroup()
                        .addComponent(outcomeLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(outcomeScrollPane))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        separatorPanel.setBackground(new java.awt.Color(143, 19, 21));
        separatorPanel.setPreferredSize(new java.awt.Dimension(92, 28));

        separator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout separatorPanelLayout = new javax.swing.GroupLayout(separatorPanel);
        separatorPanel.setLayout(separatorPanelLayout);
        separatorPanelLayout.setHorizontalGroup(
            separatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(separatorPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        separatorPanelLayout.setVerticalGroup(
            separatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(separatorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separator)
                .addContainerGap())
        );

        rightPropPanel.setBackground(new java.awt.Color(143, 19, 21));
        rightPropPanel.setPreferredSize(new java.awt.Dimension(449, 426));

        studentsPanel.setBackground(new java.awt.Color(143, 19, 21));
        studentsPanel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        studentsPanel.setForeground(java.awt.Color.white);
        studentsPanel.setText("Students:");
        studentsPanel.setOpaque(true);

        partnersPanel.setBackground(new java.awt.Color(143, 19, 21));
        partnersPanel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        partnersPanel.setForeground(java.awt.Color.white);
        partnersPanel.setText("Partners:");
        partnersPanel.setOpaque(true);

        advisorsPanel.setBackground(new java.awt.Color(143, 19, 21));
        advisorsPanel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        advisorsPanel.setForeground(java.awt.Color.white);
        advisorsPanel.setText("Advisors:");
        advisorsPanel.setOpaque(true);

        categoriesPanel.setBackground(new java.awt.Color(143, 19, 21));
        categoriesPanel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        categoriesPanel.setForeground(java.awt.Color.white);
        categoriesPanel.setText("Categories:");
        categoriesPanel.setOpaque(true);

        tagsPanel.setBackground(new java.awt.Color(143, 19, 21));
        tagsPanel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        tagsPanel.setForeground(java.awt.Color.white);
        tagsPanel.setText("Tags:");
        tagsPanel.setOpaque(true);

        mediaPanel.setBackground(new java.awt.Color(143, 19, 21));
        mediaPanel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mediaPanel.setForeground(java.awt.Color.white);
        mediaPanel.setText("Media:");
        mediaPanel.setOpaque(true);

        otherDataPanel.setBackground(new java.awt.Color(143, 19, 21));
        otherDataPanel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        otherDataPanel.setForeground(java.awt.Color.white);
        otherDataPanel.setText("Other Data:");
        otherDataPanel.setOpaque(true);

        studentsTextArea.setColumns(20);
        studentsTextArea.setRows(2);
        studentsScrollPane.setViewportView(studentsTextArea);

        partnersTextArea.setColumns(20);
        partnersTextArea.setRows(2);
        partnersScrollPane.setViewportView(partnersTextArea);

        categoriesTextArea.setColumns(20);
        categoriesTextArea.setRows(2);
        categoriesScrollPane.setViewportView(categoriesTextArea);

        advisorsTextArea.setColumns(20);
        advisorsTextArea.setRows(2);
        advisorsScrollPane.setViewportView(advisorsTextArea);

        tagsTextArea.setColumns(20);
        tagsTextArea.setRows(2);
        tagsScrollPane.setViewportView(tagsTextArea);

        mediaViewButton.setText("View");
        mediaViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediaViewButtonActionPerformed(evt);
            }
        });

        otherDataViewButton.setText("View");
        otherDataViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherDataViewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightPropPanelLayout = new javax.swing.GroupLayout(rightPropPanel);
        rightPropPanel.setLayout(rightPropPanelLayout);
        rightPropPanelLayout.setHorizontalGroup(
            rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPropPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentsPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(partnersPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(advisorsPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(categoriesPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tagsPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mediaPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(otherDataPanel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(11, 11, 11)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(otherDataViewButton)
                    .addComponent(mediaViewButton)
                    .addComponent(tagsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoriesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advisorsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(partnersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rightPropPanelLayout.setVerticalGroup(
            rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPropPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentsPanel)
                    .addComponent(studentsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(partnersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(partnersPanel))
                .addGap(24, 24, 24)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(advisorsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advisorsPanel))
                .addGap(24, 24, 24)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoriesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoriesPanel))
                .addGap(24, 24, 24)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tagsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tagsPanel))
                .addGap(18, 24, Short.MAX_VALUE)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mediaPanel)
                    .addComponent(mediaViewButton))
                .addGap(18, 18, 18)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(otherDataViewButton)
                    .addComponent(otherDataPanel))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout propertyPanelLayout = new javax.swing.GroupLayout(propertyPanel);
        propertyPanel.setLayout(propertyPanelLayout);
        propertyPanelLayout.setHorizontalGroup(
            propertyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(propertyPanelLayout.createSequentialGroup()
                .addComponent(leftPropPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separatorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightPropPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        propertyPanelLayout.setVerticalGroup(
            propertyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(propertyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(propertyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leftPropPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addComponent(separatorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addComponent(rightPropPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tablePanel.setBackground(new java.awt.Color(143, 19, 21));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "projectID", "Title", "Status", "Start Date", "End Date", "Students", "Partners", "Advisors", "Categories", "Tags"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePanelScrollPane.setViewportView(table);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tablePanelScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablePanelScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(propertyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(propertyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mediaViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediaViewButtonActionPerformed
        frugalController.launchMediaViewPanel();
    }//GEN-LAST:event_mediaViewButtonActionPerformed

    private void otherDataViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherDataViewButtonActionPerformed
        frugalController.launchOtherDataViewPanel();
    }//GEN-LAST:event_otherDataViewButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel advisorsPanel;
    private javax.swing.JScrollPane advisorsScrollPane;
    private javax.swing.JTextArea advisorsTextArea;
    private javax.swing.JLabel categoriesPanel;
    private javax.swing.JScrollPane categoriesScrollPane;
    private javax.swing.JTextArea categoriesTextArea;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JTextField endDateTextField;
    private javax.swing.JPanel leftPropPanel;
    private javax.swing.JLabel mediaPanel;
    private javax.swing.JButton mediaViewButton;
    private javax.swing.JLabel otherDataPanel;
    private javax.swing.JButton otherDataViewButton;
    private javax.swing.JLabel outcomeLabel;
    private javax.swing.JScrollPane outcomeScrollPane;
    private javax.swing.JTextArea outcomeTextArea;
    private javax.swing.JLabel partnersPanel;
    private javax.swing.JScrollPane partnersScrollPane;
    private javax.swing.JTextArea partnersTextArea;
    private javax.swing.JLabel projectIDLabel;
    private javax.swing.JTextField projectIDTextField;
    private javax.swing.JPanel propertyPanel;
    private javax.swing.JPanel rightPropPanel;
    private javax.swing.JSeparator separator;
    private javax.swing.JPanel separatorPanel;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JTextField startDateTextField;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField statusTextField;
    private javax.swing.JLabel studentsPanel;
    private javax.swing.JScrollPane studentsScrollPane;
    private javax.swing.JTextArea studentsTextArea;
    private javax.swing.JTable table;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JScrollPane tablePanelScrollPane;
    private javax.swing.JLabel tagsPanel;
    private javax.swing.JScrollPane tagsScrollPane;
    private javax.swing.JTextArea tagsTextArea;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTextField;
    // End of variables declaration//GEN-END:variables
}
