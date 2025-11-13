package day0908.work;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;

public class MemoInfoEvt extends WindowAdapter implements ActionListener,ItemListener{
	
	private JavaMemo jm;
	private MemoFont mf;
	private MemoInfo mi;
	private JPanel jplButton;
	public MemoInfoEvt(MemoFont mf) {
		this.mf = mf;
	}//MemoInfo
	public MemoInfoEvt(MemoInfo mi) {
		this.mi = mi;
	}//MemoInfo
	
	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosing(e);
	}//windowClosing
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}//itemStateChanged

	@Override
	public void actionPerformed(ActionEvent e) {
			mi.dispose();
	}//actionPerformed

}//MemoInfoEvt
