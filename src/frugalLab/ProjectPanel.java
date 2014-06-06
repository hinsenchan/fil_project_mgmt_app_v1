/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frugalLab;

/**
 *
 * @author Hinsen Chan
 */
public class ProjectPanel extends javax.swing.JPanel {
    private FrugalController frugalController;
    private static final String[] STATUS = {"Active", "Completed", "Suspended", "Aborted"};

    /**
     * Creates new form ProjectPanel
     */
    public ProjectPanel(FrugalController frugalController) {
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
        titleTextField = new javax.swing.JTextField();
        projectIDTextField = new javax.swing.JTextField();
        statusComboBox = new javax.swing.JComboBox();
        startDateTextField = new javax.swing.JTextField();
        endDateTextField = new javax.swing.JTextField();
        outcomeScrollPane = new javax.swing.JScrollPane();
        outcomeTextArea = new javax.swing.JTextArea();
        separatorPanel = new javax.swing.JPanel();
        separator = new javax.swing.JSeparator();
        rightPropPanel = new javax.swing.JPanel();
        studentsLabel = new javax.swing.JLabel();
        partnersLabel = new javax.swing.JLabel();
        advisorsLabel = new javax.swing.JLabel();
        categoriesLabel = new javax.swing.JLabel();
        tagsLabel = new javax.swing.JLabel();
        mediaLabel = new javax.swing.JLabel();
        otherDataLabel = new javax.swing.JLabel();
        categoriesScrollPane = new javax.swing.JScrollPane();
        categoriesList = new javax.swing.JList();
        tagScrollPane = new javax.swing.JScrollPane();
        tagsList = new javax.swing.JList();
        mediaButton = new javax.swing.JButton();
        otherDataButton = new javax.swing.JButton();
        studentsManageButton = new javax.swing.JButton();
        partnersManageButton = new javax.swing.JButton();
        advisorsManageButton = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        tableScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        buttonPanel = new javax.swing.JPanel();
        buttonLayoutPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(143, 19, 21));
        setPreferredSize(new java.awt.Dimension(1024, 768));

        propertyPanel.setBackground(new java.awt.Color(143, 19, 21));

        leftPropPanel.setBackground(new java.awt.Color(143, 19, 21));

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

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });

        outcomeTextArea.setColumns(20);
        outcomeTextArea.setRows(5);
        outcomeScrollPane.setViewportView(outcomeTextArea);

        javax.swing.GroupLayout leftPropPanelLayout = new javax.swing.GroupLayout(leftPropPanel);
        leftPropPanel.setLayout(leftPropPanelLayout);
        leftPropPanelLayout.setHorizontalGroup(
            leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPropPanelLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outcomeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(endDateLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startDateLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(projectIDLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(outcomeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(titleTextField)
                    .addComponent(projectIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(startDateTextField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftPropPanelLayout.setVerticalGroup(
            leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPropPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectIDLabel)
                    .addComponent(projectIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDateLabel))
                .addGap(18, 18, 18)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateLabel))
                .addGap(18, 18, 18)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outcomeLabel)
                    .addComponent(outcomeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        separatorPanel.setBackground(new java.awt.Color(143, 19, 21));

        separator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout separatorPanelLayout = new javax.swing.GroupLayout(separatorPanel);
        separatorPanel.setLayout(separatorPanelLayout);
        separatorPanelLayout.setHorizontalGroup(
            separatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
            .addGroup(separatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, separatorPanelLayout.createSequentialGroup()
                    .addContainerGap(43, Short.MAX_VALUE)
                    .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );
        separatorPanelLayout.setVerticalGroup(
            separatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(separatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(separatorPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        rightPropPanel.setBackground(new java.awt.Color(143, 19, 21));

        studentsLabel.setBackground(new java.awt.Color(143, 19, 21));
        studentsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        studentsLabel.setForeground(java.awt.Color.white);
        studentsLabel.setText("Students:");
        studentsLabel.setOpaque(true);

        partnersLabel.setBackground(new java.awt.Color(143, 19, 21));
        partnersLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        partnersLabel.setForeground(java.awt.Color.white);
        partnersLabel.setText("Partners:");
        partnersLabel.setOpaque(true);

        advisorsLabel.setBackground(new java.awt.Color(143, 19, 21));
        advisorsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        advisorsLabel.setForeground(java.awt.Color.white);
        advisorsLabel.setText("Advisors:");
        advisorsLabel.setOpaque(true);

        categoriesLabel.setBackground(new java.awt.Color(143, 19, 21));
        categoriesLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        categoriesLabel.setForeground(java.awt.Color.white);
        categoriesLabel.setText("Categories:");
        categoriesLabel.setOpaque(true);

        tagsLabel.setBackground(new java.awt.Color(143, 19, 21));
        tagsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        tagsLabel.setForeground(java.awt.Color.white);
        tagsLabel.setText("Tags:");
        tagsLabel.setOpaque(true);

        mediaLabel.setBackground(new java.awt.Color(143, 19, 21));
        mediaLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mediaLabel.setForeground(java.awt.Color.white);
        mediaLabel.setText("Media:");
        mediaLabel.setOpaque(true);

        otherDataLabel.setBackground(new java.awt.Color(143, 19, 21));
        otherDataLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        otherDataLabel.setForeground(java.awt.Color.white);
        otherDataLabel.setText("Other Data:");
        otherDataLabel.setOpaque(true);

        categoriesList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Select one...", "Add new category...", "Cat1", "Cat2", "Cat3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        categoriesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                categoriesListValueChanged(evt);
            }
        });
        categoriesScrollPane.setViewportView(categoriesList);

        tagsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Select one or more...", "Add new tag...", "Tag1", "Tag2", "Tag3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        tagsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                tagsListValueChanged(evt);
            }
        });
        tagScrollPane.setViewportView(tagsList);

        mediaButton.setText("Manage");
        mediaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediaButtonActionPerformed(evt);
            }
        });

        otherDataButton.setText("Manage");
        otherDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherDataButtonActionPerformed(evt);
            }
        });

        studentsManageButton.setText("Manage");
        studentsManageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsManageButtonActionPerformed(evt);
            }
        });

        partnersManageButton.setText("Manage");
        partnersManageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partnersManageButtonActionPerformed(evt);
            }
        });

        advisorsManageButton.setText("Manage");
        advisorsManageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advisorsManageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightPropPanelLayout = new javax.swing.GroupLayout(rightPropPanel);
        rightPropPanel.setLayout(rightPropPanelLayout);
        rightPropPanelLayout.setHorizontalGroup(
            rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPropPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentsLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(partnersLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(advisorsLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(categoriesLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tagsLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mediaLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(otherDataLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(otherDataButton)
                    .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(studentsManageButton)
                        .addComponent(partnersManageButton)
                        .addComponent(advisorsManageButton)
                        .addComponent(tagScrollPane)
                        .addComponent(mediaButton)
                        .addComponent(categoriesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        rightPropPanelLayout.setVerticalGroup(
            rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPropPanelLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentsManageButton)
                    .addComponent(studentsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(partnersLabel)
                    .addComponent(partnersManageButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(advisorsLabel)
                    .addComponent(advisorsManageButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoriesLabel)
                    .addGroup(rightPropPanelLayout.createSequentialGroup()
                        .addComponent(categoriesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tagsLabel)
                            .addComponent(tagScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mediaButton)
                            .addComponent(mediaLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(otherDataButton)
                            .addComponent(otherDataLabel))))
                .addContainerGap(29, Short.MAX_VALUE))
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
            .addComponent(separatorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(leftPropPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rightPropPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tablePanel.setBackground(new java.awt.Color(143, 19, 21));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "projectID", "Title", "Status", "Start Date", "End Date", "Students", "Partners", "Advisors", "Categories", "Tags", "Media", "Other Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableScrollPane.setViewportView(table);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 184, Short.MAX_VALUE)
            .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tablePanelLayout.createSequentialGroup()
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        buttonPanel.setBackground(new java.awt.Color(143, 19, 21));

        buttonLayoutPanel.setBackground(new java.awt.Color(143, 19, 21));
        buttonLayoutPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 25, 35));

        addButton.setText("Add");
        addButton.setPreferredSize(new java.awt.Dimension(90, 29));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        buttonLayoutPanel.add(addButton);

        updateButton.setText("Update");
        updateButton.setPreferredSize(new java.awt.Dimension(90, 29));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        buttonLayoutPanel.add(updateButton);

        deleteButton.setText("Delete");
        deleteButton.setPreferredSize(new java.awt.Dimension(90, 29));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        buttonLayoutPanel.add(deleteButton);

        clearButton.setText("Clear");
        clearButton.setPreferredSize(new java.awt.Dimension(90, 29));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        buttonLayoutPanel.add(clearButton);

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(buttonLayoutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
            .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(buttonLayoutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(propertyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(propertyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButtonActionPerformed

    private void studentsManageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsManageButtonActionPerformed
        frugalController.launchStudentsPanel();
    }//GEN-LAST:event_studentsManageButtonActionPerformed

    private void partnersManageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partnersManageButtonActionPerformed
        frugalController.launchPartnersPanel();
    }//GEN-LAST:event_partnersManageButtonActionPerformed

    private void advisorsManageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advisorsManageButtonActionPerformed
        frugalController.launchAdvisorsPanel();
    }//GEN-LAST:event_advisorsManageButtonActionPerformed

    private void mediaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediaButtonActionPerformed
        frugalController.launchMediaPanel();
    }//GEN-LAST:event_mediaButtonActionPerformed

    private void otherDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherDataButtonActionPerformed
        frugalController.launchOtherDataPanel();
    }//GEN-LAST:event_otherDataButtonActionPerformed

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void categoriesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_categoriesListValueChanged
        if (categoriesList.getSelectedIndex() == 1) {
            frugalController.launchCategoryPanel();
        }
    }//GEN-LAST:event_categoriesListValueChanged

    private void tagsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_tagsListValueChanged
        if (tagsList.getSelectedIndex() == 1) {
            frugalController.launchTagPanel();
        }
    }//GEN-LAST:event_tagsListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel advisorsLabel;
    private javax.swing.JButton advisorsManageButton;
    private javax.swing.JPanel buttonLayoutPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel categoriesLabel;
    private javax.swing.JList categoriesList;
    private javax.swing.JScrollPane categoriesScrollPane;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JTextField endDateTextField;
    private javax.swing.JPanel leftPropPanel;
    private javax.swing.JButton mediaButton;
    private javax.swing.JLabel mediaLabel;
    private javax.swing.JButton otherDataButton;
    private javax.swing.JLabel otherDataLabel;
    private javax.swing.JLabel outcomeLabel;
    private javax.swing.JScrollPane outcomeScrollPane;
    private javax.swing.JTextArea outcomeTextArea;
    private javax.swing.JLabel partnersLabel;
    private javax.swing.JButton partnersManageButton;
    private javax.swing.JLabel projectIDLabel;
    private javax.swing.JTextField projectIDTextField;
    private javax.swing.JPanel propertyPanel;
    private javax.swing.JPanel rightPropPanel;
    private javax.swing.JSeparator separator;
    private javax.swing.JPanel separatorPanel;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JTextField startDateTextField;
    private javax.swing.JComboBox statusComboBox;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel studentsLabel;
    private javax.swing.JButton studentsManageButton;
    private javax.swing.JTable table;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JScrollPane tagScrollPane;
    private javax.swing.JLabel tagsLabel;
    private javax.swing.JList tagsList;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
