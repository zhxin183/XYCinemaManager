package com.xxy.ui.dialog;

import af.swing.LayoutBox;
import af.swing.layout.VLayout;
import com.xxy.bean.Arrange;
import com.xxy.bean.Cinema;
import com.xxy.bean.Film;
import com.xxy.bean.Room;
import com.xxy.constants.Constants;
import com.xxy.util.SwingUtil;
import com.xxy.util.TestDataUtil;
import com.xxy.util.UiUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.xxy.constants.Constants.UI_ROOT_PADDING;

/**
 * 添加和编辑影院时，使用的弹窗
 */
public class AdminArrangeDialog extends AdminBaseDialog {

    LayoutBox root;

    JLabel lbCinemaName = new JLabel();
    JComboBox<Room> cbRoom = new JComboBox<>();
    JComboBox<Film> cbFilm = new JComboBox<>();

    JSpinner spStartTime;
    JSpinner spEndTime;

    JSpinner spPrice;

    private int cinemaId;
    private int roomId;

    public AdminArrangeDialog(String title, int cinemaId) {
        super(new JFrame(), true, true);
        this.cinemaId = cinemaId;

        initView(title);
    }

    public AdminArrangeDialog(String title, Arrange arrange) {
        super(new JFrame(), true, false);
        this.cinemaId = arrange.getCinemaId();
        this.roomId = arrange.getRoomId();

        initView(title);
    }

    private void initView(String title) {
        setSize(360, 360);
        setResizable(false);
        SwingUtil.centerInScreen(this);

        setTitle(title);

        root = new LayoutBox().layout(new BorderLayout());
        this.setContentPane(root);

        root.add(initCenter(), BorderLayout.CENTER);
        root.add(initBottom(), BorderLayout.SOUTH);

        setCinemaComboBoxData(TestDataUtil.getCinemaList());
    }

    private JComponent initCenter() {
        LayoutBox dataPanel = new LayoutBox().layout(new VLayout());
        dataPanel.padding(UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING);
        dataPanel.bgColor(new Color(Constants.UI_COLOR_BG));

        dataPanel.add( UiUtil.initFormLine("电影院", lbCinemaName) );
        dataPanel.add( UiUtil.initFormLine("放映厅", cbRoom) );
        dataPanel.add( UiUtil.initFormLine("电影", cbFilm) );

        spStartTime = initDateTimeSpinner();
        dataPanel.add( UiUtil.initFormLine("开始时间", spStartTime) );

        spEndTime = initDateTimeSpinner();
        dataPanel.add( UiUtil.initFormLine("结束时间", spEndTime) );

        spPrice = initPriceSpinner();
        dataPanel.add( UiUtil.initFormLine("票价", spPrice) );

        return dataPanel;
    }

    private JSpinner initDateTimeSpinner() {
        // 获得时间日期模型
        SpinnerDateModel model = new SpinnerDateModel();
        // 获得JSpinner对象
        JSpinner spinner = new JSpinner(model);
        spinner.setValue(new Date());
        // 设置时间格式
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "yyyy-MM-dd HH:mm:ss");
        spinner.setEditor(editor);
        return spinner;
    }

    private JSpinner initPriceSpinner() {
        SpinnerNumberModel model = new SpinnerNumberModel(29.8, 0, 1000.0, 0.01);

        JSpinner spinner = new JSpinner(model);
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinner);
        spinner.setEditor(editor);
        return spinner;
    }

    private JComponent initBottom() {
        // 表格编辑按钮
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        LayoutBox actionPanel = new LayoutBox().layout(flowLayout);
        actionPanel.padding(UI_ROOT_PADDING, 0, UI_ROOT_PADDING, 0);
        actionPanel.add(btnCancel);
        btnCancel.addActionListener(onActionListener);
        actionPanel.add(btnSave);
        btnSave.addActionListener(onActionListener);
        actionPanel.bgColor(new Color(Constants.UI_COLOR_BG));
        return actionPanel;
    }

    /**
     * 刷新右边数据
     */
    public void refreshData() {

    }

    /**
     * 设置电影院下拉框数据
     * @param listCinema 电影院数据
     */
    public void setCinemaComboBoxData(ArrayList<Cinema> listCinema) {

    }

    /**
     * 底部按钮事件监听
     */
    private ActionListener onActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnCancel) {
                dispose();
            } else if (e.getSource() == btnSave) {
                System.out.println("保存数据");
            }
        }
    };
}
