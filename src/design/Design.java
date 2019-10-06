package design;

import listeners.*;
import managerGroup.ManagerGroup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Design {
   private final ManagerGroup managerGroup;
    public Design(ManagerGroup managerGroup){
        this.managerGroup=managerGroup;
    }
    // Объявления графических компонентов
    private JFrame Music;
    private DefaultTableModel model;
    private JButton save;
    private JButton saveXML;
    private JButton download;
    private JButton downloadXML;
    private JButton add;
    private JButton delete;

    private JToolBar toolBar;
    public JScrollPane scroll;
    public static JTable group;
    public static JTable group1;
    public static JTable group2;
    public static JTable hit;
    private JComboBox searchParametr;
    public static JComboBox groups;
    public static JComboBox groups2;
    private JTextField text;
    private JButton filter;
    private JButton filter2;
    private JButton hitRefresh;
    public void show() {
        // Создание окна
        Music = new JFrame("Music");
        Music.setSize(500, 300);
        Music.setLocation(100, 100);
        Music.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Создание кнопок и прикрепление иконок
        save = new JButton(new ImageIcon("./img/save.png"));
        save.setBorderPainted(false);
        save.setFocusPainted(false);
        save.setContentAreaFilled(false);

        saveXML = new JButton(new ImageIcon("./img/save.png"));
        saveXML.setBorderPainted(false);
        saveXML.setFocusPainted(false);
        saveXML.setContentAreaFilled(false);

        download = new JButton(new ImageIcon("./img/download.png"));
        download.setBorderPainted(false);
        download.setFocusPainted(false);
        download.setContentAreaFilled(false);

        downloadXML = new JButton(new ImageIcon("./img/download.png"));
        downloadXML.setBorderPainted(false);
        downloadXML.setFocusPainted(false);
        downloadXML.setContentAreaFilled(false);

        add = new JButton(new ImageIcon("./img/add.png"));
        add.setBorderPainted(false);
        add.setFocusPainted(false);
        add.setContentAreaFilled(false);

        delete = new JButton(new ImageIcon("./img/delete.png"));
        delete.setBorderPainted(false);
        delete.setFocusPainted(false);
        delete.setContentAreaFilled(false);


        // Настройка подсказок для кнопок
        save.setToolTipText("Save");
        saveXML.setToolTipText("Save XML");
        download.setToolTipText("Download");
        downloadXML.setToolTipText("Download XML");
        add.setToolTipText("Add entry");
        delete.setToolTipText("Delete entry");


        // Добавление кнопок на панель инструментов
        toolBar = new JToolBar("Tool bar");
        toolBar.add(save);
        toolBar.add(download);
        toolBar.add(add);
        toolBar.add(delete);
        toolBar.add(saveXML);
        toolBar.add(downloadXML);


        // Размещение панели инструментов
        Music.setLayout(new BorderLayout());
        Music.add(toolBar, BorderLayout.NORTH);



       // toolBar.add(tabbedPane);
       // Music.add(tabbedPane, BorderLayout.NORTH);
        // Создание таблицы с данными
        String [] columns = {"Name of group", "Tour schedule", "Year of foundation"};
        model=  new DefaultTableModel(null, columns);
        group = new JTable(model);
        group.getTableHeader().setReorderingAllowed(false);
        scroll = new JScrollPane(group);




        // Подготовка компонентов поиска
        groups = new JComboBox();
        filter = new JButton(new ImageIcon("./img/search.png"));
        filter.setBorderPainted(false);
        filter.setFocusPainted(false);
        filter.setContentAreaFilled(false);
        // Добавление компонентов на панель
        JPanel filterPanel = new JPanel();
        filterPanel.add(groups);
        JButton  add1 = new JButton(new ImageIcon("./img/add24.png"));
        add1.setBorderPainted(false);
        add1.setFocusPainted(false);
        add1.setContentAreaFilled(false);

        JButton delete1 = new JButton(new ImageIcon("./img/delete24.png"));
        delete1.setBorderPainted(false);
        delete1.setFocusPainted(false);
        delete1.setContentAreaFilled(false);
        filterPanel.add(add1);
        filterPanel.add(delete1);
        filterPanel.add(filter);



        groups2 = new JComboBox();
        filter2 = new JButton(new ImageIcon("./img/search.png"));
        filter2.setBorderPainted(false);
        filter2.setFocusPainted(false);
        filter2.setContentAreaFilled(false);
        JPanel filterPanel2 = new JPanel();
        filterPanel2.add(groups2);
        JButton  add2 = new JButton(new ImageIcon("./img/add24.png"));
        add2.setBorderPainted(false);
        add2.setFocusPainted(false);
        add2.setContentAreaFilled(false);

        JButton delete2 = new JButton(new ImageIcon("./img/delete24.png"));
        delete2.setBorderPainted(false);
        delete2.setFocusPainted(false);
        delete2.setContentAreaFilled(false);
        filterPanel2.add(add2);
        filterPanel2.add(delete2);
        filterPanel2.add(filter2);
        // Размещение  панели поиска внизу окна
      //  Music.add(filterPanel, BorderLayout.SOUTH);

        String [] col1 = {"Structure"};
        DefaultTableModel model1=  new DefaultTableModel(null, col1);
         group1 = new JTable(model1);
        group1.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroll1 = new JScrollPane(group1);

        JPanel Structure = new JPanel();
        Structure.setLayout(new BorderLayout());
        Structure.add(filterPanel,BorderLayout.NORTH);
        Structure.add(scroll1,BorderLayout.CENTER);

        String [] col2 = {"Repertoire"};
        DefaultTableModel model2=  new DefaultTableModel(null, col2);
         group2 = new JTable(model2);
        group2.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroll2 = new JScrollPane(group2);

        JPanel Repertoire = new JPanel();
        Repertoire.setLayout(new BorderLayout());
        Repertoire.add(filterPanel2,BorderLayout.NORTH);
        Repertoire.add(scroll2,BorderLayout.CENTER);


        hitRefresh = new JButton(new ImageIcon("./img/hit.png"));
        hitRefresh.setBorderPainted(false);
        hitRefresh.setFocusPainted(false);
        hitRefresh.setContentAreaFilled(false);
        String [] col5 = {"Hit parade"};
        DefaultTableModel model5=  new DefaultTableModel(null, col1);
        hit = new JTable(model5);
        hit.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroll5 = new JScrollPane(hit);
        JPanel hitPanel = new JPanel();
        hitPanel.setLayout(new BorderLayout());
        hitPanel.add(hitRefresh,BorderLayout.NORTH);
        hitPanel.add(scroll5,BorderLayout.CENTER);


        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = new ImageIcon("./img/tab.png");

        JComponent panel1 = new JTextField("Panel #1");
        tabbedPane.addTab("Main", icon, scroll,
                "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent panel2 = new JTextField("Panel #2");
        tabbedPane.addTab("Structure", icon, Structure,
                "See structure");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JComponent panel3 = new JTextField("Panel #3");
        tabbedPane.addTab("Repertoire", icon, Repertoire,
                "See repertoire");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        JComponent panel4 = new JTextField("Panel #4");
        tabbedPane.addTab("Hit parade", icon, hitPanel,
                "See hit parade");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        // Размещение таблицы с данными
        Music.add(tabbedPane, BorderLayout.CENTER);

        // Визуализация экранной формы
        Music.setVisible(true);
        Music.addWindowListener(new WindowLis());
        add.addActionListener(new AddListenerToolbar(managerGroup));
        delete.addActionListener(new DeleteListenerToolbar(managerGroup));
        save.addActionListener(new SaveListenerToolbar(managerGroup));
        saveXML.addActionListener(new SaveXML(managerGroup));
        download.addActionListener(new LoadListenerToolbar(managerGroup));
        downloadXML.addActionListener(new LoadXML(managerGroup));
        add1.addActionListener(new AddStructureListener(managerGroup));
        delete1.addActionListener(new DeleteStructureListener(managerGroup));
        add2.addActionListener(new AddRepertoireListener(managerGroup));
        delete2.addActionListener(new DeleteRepertoireListener(managerGroup));
        filter.addActionListener(new SearchStructureListener(managerGroup));
        filter2.addActionListener(new SearchRepertoireListener(managerGroup));
        hitRefresh.addActionListener(new ReloadHitListener(managerGroup));
    }
}
