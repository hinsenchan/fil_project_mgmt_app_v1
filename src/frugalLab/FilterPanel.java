/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frugalLab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.util.List;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Hinsen Chan
 */

public class FilterPanel extends javax.swing.JPanel {
    FrugalController frugalController;
    private static final String PERSISTENCE_UNIT_NAME = "coen275projectPU";  // Used in persistence.xml
    //private SearchResultTableModel searchResultTableModel;

    private static EntityManagerFactory factory;  

    private EntityManager manager;

    private String[] status, categories, tags, students, partners, advisors, media;
    
    private int[] tagsI, studentsI, partnersI, advisorsI, mediaI;
    
    private String[] statusFilter, categoryFilter, tagFilter, studentFilter, partnerFilter, advisorFilter, mediaFilter;
    /**
     * Creates new form FilterPanel3
     */
    public FilterPanel(FrugalController frugalController) {

        getData();
        myInitComponents();

        startDateTextField.setText("");
        endDateTextField.setText("");
        this.frugalController = frugalController;
        
        
    }
    
    public void updateFilters()
    {
        int y;
        Object[] obj;
 // statusFilter, categoryFilter, tagFilter, studentFilter, partnerFilter, advisorFilter, mediaFilter;

        obj = new Object[1];
        obj[0] = statusComboBox.getSelectedItem();
        statusFilter = new String[obj.length];
        y = 0;
        for (Object o : obj)
        {
            statusFilter[y] = o.toString();
            y++;
        }
       
        obj = new Object[1];
        obj[0] = categoryComboBox.getSelectedItem();
        categoryFilter = new String[obj.length];
        y = 0;
        for (Object o : obj)
        {
            categoryFilter[y] = o.toString();
            y++;
        }
        
        
        obj = tagList.getSelectedValues();
        tagFilter = new String[obj.length];
        y = 0;
        for (Object o : obj)
        {
            tagFilter[y] = o.toString();
            y++;
        }
        
        obj = studentsList.getSelectedValues();
        studentFilter = new String[obj.length];

        y = 0;
        for (Object o : obj)
        {
            studentFilter[y] = o.toString();
            y++;
        }
        
        obj = partnersList.getSelectedValues();
        partnerFilter = new String[obj.length];
        y = 0;
        for (Object o : obj)
        {
            partnerFilter[y] = o.toString();
            y++;
        }
        
        obj = advisorsList.getSelectedValues();
        advisorFilter = new String[obj.length];

        y = 0;
        for (Object o : obj)
        {
            advisorFilter[y] = o.toString();
            y++;
        }
        
        obj = mediaList.getSelectedValues();
        mediaFilter = new String[obj.length];
        y = 0;
        for (Object o : obj)
        {
            mediaFilter[y] = o.toString();
            y++;
        }
        
        frugalController.setFilters(statusFilter, categoryFilter, tagFilter, studentFilter, partnerFilter, advisorFilter, mediaFilter);
        
    }
    
    public void getData()
    {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();

        ProjectService p = new ProjectService(manager);
        CategoryService c = new CategoryService(manager);
        TagService t = new TagService(manager);
        StudentsService s = new StudentsService(manager, "");
        PartnersService pS = new PartnersService(manager, "");
        AdvisorsService a = new AdvisorsService(manager, "");
        MediaService m = new MediaService(manager, "");
        
        List<Project> P = p.read();
        List<Category> C = c.readAll();
        List<Tag> T = t.readAll();
        List<Students> S = s.read();
        List<Partners> PS = pS.read();
        List<Advisors> A = a.read();
        List<Media> M = m.read();
        
        status = new String[P.size()];
        int y = 0;
        for(Project x : P)
        {
            status[y]=x.getTitle();
            y++;
        }
        
        categories = new String[C.size()];
        y = 0;
        for(Category x : C)
        {
            categories[y]=x.getCategory();
            y++;
        }
        
        //    private int[] tagsI, studentsI, partnersI, advisorsI, mediaI;

        
        tags = new String[T.size()];
        y = 0;
        tagsI = new int[T.size()];
        for(Tag x : T)
        {
            tags[y]=x.getTag();
            tagsI[y]=y;
            y++;
        }

        students = new String[S.size()];
        y = 0;
        studentsI = new int[S.size()];
        for(Students x : S)
        {
            students[y]=x.getName();
            studentsI[y]=y;
            y++;
        }
        
        advisors = new String[A.size()];
        y = 0;
        advisorsI = new int[A.size()];
        for(Advisors x : A)
        {
            advisors[y]=x.getName();
            studentsI[y]=y;
            y++;
        }
        
        
        partners = new String[PS.size()];
        y = 0;
        partnersI = new int[PS.size()];
        for(Partners x : PS)
        {
            partners[y]=x.getName();
            partnersI[y]=y;
            y++;
        }
        
        media = new String[M.size()];
        y = 0;
        mediaI=new int[M.size()];
        for(Media x : M)
        {
            media[y]=x.getFileName();
            mediaI[y]=y;
            y++;
        }
        
        
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
        statusComboBox = new javax.swing.JComboBox();
        statusLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        tagsLabel = new javax.swing.JLabel();
        startDateTextField = new javax.swing.JTextField();
        endDateTextField = new javax.swing.JTextField();
        tagScrollPane = new javax.swing.JScrollPane();
        tagList = new javax.swing.JList();
        categoryComboBox = new javax.swing.JComboBox();
        separatorPanel = new javax.swing.JPanel();
        separator = new javax.swing.JSeparator();
        rightPropPanel = new javax.swing.JPanel();
        studentsLabel = new javax.swing.JLabel();
        partnersLabel = new javax.swing.JLabel();
        advisorsLabel = new javax.swing.JLabel();
        mediaLabel = new javax.swing.JLabel();
        parntersScrollPane = new javax.swing.JScrollPane();
        partnersList = new javax.swing.JList();
        advisorsScrollPane = new javax.swing.JScrollPane();
        advisorsList = new javax.swing.JList();
        studentsScrollPane = new javax.swing.JScrollPane();
        studentsList = new javax.swing.JList();
        mediaScrollPane = new javax.swing.JScrollPane();
        mediaList = new javax.swing.JList();
        buttonPanel = new javax.swing.JPanel();
        applyButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(143, 19, 21));
        setPreferredSize(new java.awt.Dimension(1024, 768));

        propertyPanel.setBackground(new java.awt.Color(143, 19, 21));
        propertyPanel.setPreferredSize(new java.awt.Dimension(1000, 618));
        propertyPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        leftPropPanel.setBackground(new java.awt.Color(143, 19, 21));
        leftPropPanel.setPreferredSize(new java.awt.Dimension(485, 618));

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        statusLabel.setForeground(java.awt.Color.white);
        statusLabel.setText("Status:");

        startDateLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        startDateLabel.setForeground(java.awt.Color.white);
        startDateLabel.setText("Start Date:");

        endDateLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        endDateLabel.setForeground(java.awt.Color.white);
        endDateLabel.setText("End Date:");

        categoryLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        categoryLabel.setForeground(java.awt.Color.white);
        categoryLabel.setText("Category:");

        tagsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        tagsLabel.setForeground(java.awt.Color.white);
        tagsLabel.setText("Tags:");

        startDateTextField.setText("jTextField1");

        endDateTextField.setText("jTextField1");

        tagList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        tagList.setVisibleRowCount(5);
        tagList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                tagListValueChanged(evt);
            }
        });
        tagScrollPane.setViewportView(tagList);

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftPropPanelLayout = new javax.swing.GroupLayout(leftPropPanel);
        leftPropPanel.setLayout(leftPropPanelLayout);
        leftPropPanelLayout.setHorizontalGroup(
            leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPropPanelLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statusLabel)
                    .addComponent(startDateLabel)
                    .addComponent(endDateLabel)
                    .addComponent(categoryLabel)
                    .addComponent(tagsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(statusComboBox, 0, 200, Short.MAX_VALUE)
                    .addComponent(endDateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(startDateTextField)
                    .addComponent(categoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tagScrollPane))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        leftPropPanelLayout.setVerticalGroup(
            leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPropPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateLabel)
                    .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endDateLabel)
                    .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryLabel)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tagsLabel)
                    .addComponent(tagScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        propertyPanel.add(leftPropPanel);

        separatorPanel.setBackground(new java.awt.Color(143, 19, 21));
        separatorPanel.setPreferredSize(new java.awt.Dimension(30, 618));

        separator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        separator.setPreferredSize(new java.awt.Dimension(30, 10));

        javax.swing.GroupLayout separatorPanelLayout = new javax.swing.GroupLayout(separatorPanel);
        separatorPanel.setLayout(separatorPanelLayout);
        separatorPanelLayout.setHorizontalGroup(
            separatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(separatorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, 6, Short.MAX_VALUE)
                .addContainerGap())
        );
        separatorPanelLayout.setVerticalGroup(
            separatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(separatorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );

        propertyPanel.add(separatorPanel);

        rightPropPanel.setBackground(new java.awt.Color(143, 19, 21));
        rightPropPanel.setPreferredSize(new java.awt.Dimension(485, 618));

        studentsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        studentsLabel.setForeground(java.awt.Color.white);
        studentsLabel.setText("Students:");

        partnersLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        partnersLabel.setForeground(java.awt.Color.white);
        partnersLabel.setText("Partners:");

        advisorsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        advisorsLabel.setForeground(java.awt.Color.white);
        advisorsLabel.setText("Advisors:");

        mediaLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mediaLabel.setForeground(java.awt.Color.white);
        mediaLabel.setText("Media:");

        partnersList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        partnersList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                partnersListValueChanged(evt);
            }
        });
        parntersScrollPane.setViewportView(partnersList);

        advisorsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        advisorsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                advisorsListValueChanged(evt);
            }
        });
        advisorsScrollPane.setViewportView(advisorsList);

        studentsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        studentsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                studentsListValueChanged(evt);
            }
        });
        studentsScrollPane.setViewportView(studentsList);

        mediaList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        mediaList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                mediaListValueChanged(evt);
            }
        });
        mediaScrollPane.setViewportView(mediaList);

        javax.swing.GroupLayout rightPropPanelLayout = new javax.swing.GroupLayout(rightPropPanel);
        rightPropPanel.setLayout(rightPropPanelLayout);
        rightPropPanelLayout.setHorizontalGroup(
            rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPropPanelLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mediaLabel)
                    .addComponent(advisorsLabel)
                    .addComponent(studentsLabel)
                    .addComponent(partnersLabel))
                .addGap(18, 18, 18)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parntersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advisorsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mediaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        rightPropPanelLayout.setVerticalGroup(
            rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPropPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentsLabel)
                    .addComponent(studentsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(partnersLabel)
                    .addComponent(parntersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(advisorsLabel)
                    .addComponent(advisorsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mediaLabel)
                    .addComponent(mediaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        propertyPanel.add(rightPropPanel);

        buttonPanel.setBackground(new java.awt.Color(143, 19, 21));
        buttonPanel.setPreferredSize(new java.awt.Dimension(1000, 120));
        buttonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 30));

        applyButton.setText("Apply");
        applyButton.setPreferredSize(new java.awt.Dimension(100, 29));
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(applyButton);

        cancelButton.setText("Cancel");
        cancelButton.setPreferredSize(new java.awt.Dimension(100, 29));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(cancelButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(propertyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(propertyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //My Method
        private void myInitComponents() {

        propertyPanel = new javax.swing.JPanel();
        leftPropPanel = new javax.swing.JPanel();
        statusComboBox = new javax.swing.JComboBox();
        statusLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        tagsLabel = new javax.swing.JLabel();
        startDateTextField = new javax.swing.JTextField();
        endDateTextField = new javax.swing.JTextField();
        tagScrollPane = new javax.swing.JScrollPane();
        tagList = new javax.swing.JList();
        categoryComboBox = new javax.swing.JComboBox();
        separatorPanel = new javax.swing.JPanel();
        separator = new javax.swing.JSeparator();
        rightPropPanel = new javax.swing.JPanel();
        studentsLabel = new javax.swing.JLabel();
        partnersLabel = new javax.swing.JLabel();
        advisorsLabel = new javax.swing.JLabel();
        mediaLabel = new javax.swing.JLabel();
        parntersScrollPane = new javax.swing.JScrollPane();
        partnersList = new javax.swing.JList();
        advisorsScrollPane = new javax.swing.JScrollPane();
        advisorsList = new javax.swing.JList();
        studentsScrollPane = new javax.swing.JScrollPane();
        studentsList = new javax.swing.JList();
        mediaScrollPane = new javax.swing.JScrollPane();
        mediaList = new javax.swing.JList();
        buttonPanel = new javax.swing.JPanel();
        applyButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(143, 19, 21));
        setPreferredSize(new java.awt.Dimension(1024, 768));

        propertyPanel.setBackground(new java.awt.Color(143, 19, 21));
        propertyPanel.setPreferredSize(new java.awt.Dimension(1000, 618));
        propertyPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        leftPropPanel.setBackground(new java.awt.Color(143, 19, 21));
        leftPropPanel.setPreferredSize(new java.awt.Dimension(485, 618));

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel(status));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        statusLabel.setForeground(java.awt.Color.white);
        statusLabel.setText("Status:");

        startDateLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        startDateLabel.setForeground(java.awt.Color.white);
        startDateLabel.setText("Start Date:");

        endDateLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        endDateLabel.setForeground(java.awt.Color.white);
        endDateLabel.setText("End Date:");

        categoryLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        categoryLabel.setForeground(java.awt.Color.white);
        categoryLabel.setText("Category:");

        tagsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        tagsLabel.setForeground(java.awt.Color.white);
        tagsLabel.setText("Tags:");

        startDateTextField.setText("jTextField1");

        endDateTextField.setText("jTextField1");

        tagList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = tags;
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        tagList.setVisibleRowCount(5);
        tagList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tagList.setSelectedIndices(tagsI);
        tagList.clearSelection();
        
        tagList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                tagListValueChanged(evt);
            }
        });
        tagScrollPane.setViewportView(tagList);

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel(categories));
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftPropPanelLayout = new javax.swing.GroupLayout(leftPropPanel);
        leftPropPanel.setLayout(leftPropPanelLayout);
        leftPropPanelLayout.setHorizontalGroup(
            leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPropPanelLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statusLabel)
                    .addComponent(startDateLabel)
                    .addComponent(endDateLabel)
                    .addComponent(categoryLabel)
                    .addComponent(tagsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(statusComboBox, 0, 200, Short.MAX_VALUE)
                    .addComponent(endDateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(startDateTextField)
                    .addComponent(categoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tagScrollPane))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        leftPropPanelLayout.setVerticalGroup(
            leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPropPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateLabel)
                    .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endDateLabel)
                    .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryLabel)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(leftPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tagsLabel)
                    .addComponent(tagScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        propertyPanel.add(leftPropPanel);

        separatorPanel.setBackground(new java.awt.Color(143, 19, 21));
        separatorPanel.setPreferredSize(new java.awt.Dimension(30, 618));

        separator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        separator.setPreferredSize(new java.awt.Dimension(30, 10));

        javax.swing.GroupLayout separatorPanelLayout = new javax.swing.GroupLayout(separatorPanel);
        separatorPanel.setLayout(separatorPanelLayout);
        separatorPanelLayout.setHorizontalGroup(
            separatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(separatorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, 6, Short.MAX_VALUE)
                .addContainerGap())
        );
        separatorPanelLayout.setVerticalGroup(
            separatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(separatorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );

        propertyPanel.add(separatorPanel);

        rightPropPanel.setBackground(new java.awt.Color(143, 19, 21));
        rightPropPanel.setPreferredSize(new java.awt.Dimension(485, 618));

        studentsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        studentsLabel.setForeground(java.awt.Color.white);
        studentsLabel.setText("Students:");

        partnersLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        partnersLabel.setForeground(java.awt.Color.white);
        partnersLabel.setText("Partners:");

        advisorsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        advisorsLabel.setForeground(java.awt.Color.white);
        advisorsLabel.setText("Advisors:");

        mediaLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mediaLabel.setForeground(java.awt.Color.white);
        mediaLabel.setText("Media:");

        partnersList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = partners;
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        partnersList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        partnersList.setSelectedIndices(partnersI);
        partnersList.clearSelection();
        partnersList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                partnersListValueChanged(evt);
            }
        });
        parntersScrollPane.setViewportView(partnersList);

        advisorsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = advisors;
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        advisorsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        advisorsList.setSelectedIndices(advisorsI);
        advisorsList.clearSelection();
        advisorsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                advisorsListValueChanged(evt);
            }
        });
        advisorsScrollPane.setViewportView(advisorsList);

        studentsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = students;
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        studentsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        studentsList.setSelectedIndices(studentsI);
        studentsList.clearSelection();
        studentsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                studentsListValueChanged(evt);
            }
        });
        studentsScrollPane.setViewportView(studentsList);

        mediaList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = media;
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        mediaList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        mediaList.setSelectedIndices(mediaI);
        mediaList.clearSelection();
        mediaList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                mediaListValueChanged(evt);
            }
        });
        mediaScrollPane.setViewportView(mediaList);

        javax.swing.GroupLayout rightPropPanelLayout = new javax.swing.GroupLayout(rightPropPanel);
        rightPropPanel.setLayout(rightPropPanelLayout);
        rightPropPanelLayout.setHorizontalGroup(
            rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPropPanelLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mediaLabel)
                    .addComponent(advisorsLabel)
                    .addComponent(studentsLabel)
                    .addComponent(partnersLabel))
                .addGap(18, 18, 18)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parntersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advisorsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mediaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        rightPropPanelLayout.setVerticalGroup(
            rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPropPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentsLabel)
                    .addComponent(studentsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(partnersLabel)
                    .addComponent(parntersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(advisorsLabel)
                    .addComponent(advisorsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(rightPropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mediaLabel)
                    .addComponent(mediaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        propertyPanel.add(rightPropPanel);

        buttonPanel.setBackground(new java.awt.Color(143, 19, 21));
        buttonPanel.setPreferredSize(new java.awt.Dimension(1000, 120));
        buttonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 30));

        applyButton.setText("Apply");
        applyButton.setPreferredSize(new java.awt.Dimension(100, 29));
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateFilters();
                applyButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(applyButton);

        cancelButton.setText("Cancel");
        cancelButton.setPreferredSize(new java.awt.Dimension(100, 29));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(cancelButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(propertyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(propertyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
    
    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        frugalController.launchSearchPanel();
    }//GEN-LAST:event_applyButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        frugalController.launchSearchPanel();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void tagListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_tagListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tagListValueChanged

    private void studentsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_studentsListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_studentsListValueChanged

    private void partnersListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_partnersListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_partnersListValueChanged

    private void advisorsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_advisorsListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_advisorsListValueChanged

    private void mediaListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_mediaListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_mediaListValueChanged

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel advisorsLabel;
    private javax.swing.JList advisorsList;
    private javax.swing.JScrollPane advisorsScrollPane;
    private javax.swing.JButton applyButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JTextField endDateTextField;
    private javax.swing.JPanel leftPropPanel;
    private javax.swing.JLabel mediaLabel;
    private javax.swing.JList mediaList;
    private javax.swing.JScrollPane mediaScrollPane;
    private javax.swing.JScrollPane parntersScrollPane;
    private javax.swing.JLabel partnersLabel;
    private javax.swing.JList partnersList;
    private javax.swing.JPanel propertyPanel;
    private javax.swing.JPanel rightPropPanel;
    private javax.swing.JSeparator separator;
    private javax.swing.JPanel separatorPanel;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JTextField startDateTextField;
    private javax.swing.JComboBox statusComboBox;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel studentsLabel;
    private javax.swing.JList studentsList;
    private javax.swing.JScrollPane studentsScrollPane;
    private javax.swing.JList tagList;
    private javax.swing.JScrollPane tagScrollPane;
    private javax.swing.JLabel tagsLabel;
    // End of variables declaration//GEN-END:variables

    public JList getAdvisorsList() {
        return advisorsList;
    }

    public void setAdvisorsList(String[] data) {
        this.advisorsList = new JList(data);
    }

    public JComboBox getCategoryComboBox() {
        return categoryComboBox;
    }

    public void setCategoryComboBox(String[] data) {
        this.categoryComboBox = new JComboBox(data);
    }

    public JTextField getEndDateTextField() {
        return endDateTextField;
    }

    public void setEndDateTextField(String s) {
        this.endDateTextField.setText(s);
    }

    public JList getMediaList() {
        return mediaList;
    }

    public void setMediaList(String[] data) {
        this.mediaList = new JList(data);;
    }

    public JList getPartnersList() {
        return partnersList;
    }

    public void setPartnersList(String[] data) {
        this.partnersList = new JList(data);
    }

    public JTextField getStartDateTextField() {
        return startDateTextField;
    }

    public void setStartDateTextField(String s) {
        this.startDateTextField.setText(s);
    }

    public JComboBox getStatusComboBox() {
        return statusComboBox;
    }

    public void setStatusComboBox(String[] data) {
        this.statusComboBox = new JComboBox(data);
    }

    public JList getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(String[] data) {
        this.studentsList = new JList(data);
    }

    public JList getTagList() {
        return tagList;
    }

    public void setTagList(String[] data) {
        this.tagList = new JList(data);
    }
}
