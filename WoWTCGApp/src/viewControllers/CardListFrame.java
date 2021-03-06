/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CardListFrame.java
 *
 * Created on Dec 14, 2011, 4:53:57 PM
 */
package viewControllers;

import viewControllers.menu.MainFrame;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import model.Model;

/**
 *
 * @author Warkst
 */
public class CardListFrame extends javax.swing.JFrame {

    private Model model;
    private MainFrame delegate;
    private String[] data;
    
    /** Creates new form CardListFrame */
    public CardListFrame(MainFrame delegate, String[] data, Model model, String title) {
	this.delegate = delegate;
	this.data = data;
	this.model = model;
	
	initComponents();
	
	this.setTitle(title);
	
	// override to delegate callback to allow logging in chat area
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	this.setLocationRelativeTo(null);
	
	this.cardList.setListData(data);	
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cardList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cardList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        cardList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        cardList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cardList);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 219, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cardListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cardListMouseClicked
	// select a card in the total database
	if (evt.getButton() == MouseEvent.BUTTON1) {
	    if (evt.getClickCount() % 2 == 0) {
		System.out.println("Double clicked on card: " + cardList.getSelectedValue());
	    }
	} else if (evt.getButton() == MouseEvent.BUTTON3) {
	    System.out.println("Right clicked on card: " +cardList.getSelectedValue());
	    cardList.setSelectedIndex(cardList.locationToIndex(evt.getPoint()));
	    
	    // SHOW POPUP MENU WITH OPTIONS: READ CARD / TO HAND, TO GY, RFTG
	    
//	    final Point clickedPoint = evt.getLocationOnScreen();
//	    
//	    SwingUtilities.invokeLater(new Runnable() {
//
//		@Override
//		public void run() {
//		    model.getCardByName((String) cardList.getSelectedValue()).showCard(clickedPoint);
//		}
//	    });
	}
    }//GEN-LAST:event_cardListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList cardList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
