/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HandController.java
 *
 * Created on 21-aug-2012, 11:57:28
 */
package viewControllers;

import model.Hand;

/**
 *
 * @author Robin jr
 */
public class HandController extends javax.swing.JPanel {

    private final Hand hand;
    private final SessionController sessionController;
    
    /** Creates new form HandController */
    public HandController(SessionController parent) {
	initComponents();
	
	this.sessionController = parent;
	
	this.hand = new Hand(this);
    }
    
    public void addCard(CardController toAdd){
	hand.addCard(toAdd.addHandMouseListener(this));
    }
    
    public void playResource(CardController toPlay){
	removeCard(toPlay);
	sessionController.addCardToResources(toPlay);
    }
    
    public void playResourceFlipped(CardController toPlay){
	toPlay.setFlipped(true);
	playResource(toPlay);
    }
    
    public void playCard(CardController toPlay){
	removeCard(toPlay);
	sessionController.addCardToTable(toPlay);
    }
    
    public void resolveCard(CardController toResolve){
	removeCard(toResolve);
	sessionController.resolve(toResolve);
    }
    
    public void removeCard(CardController toRemove){
	hand.removeCard(toRemove);
	toRemove.removeHandMouseListener();
	
	update();
    }
    
    public void prepareAttachingOfCard(CardController toAttach){
	sessionController.prepareAttachingOfCard(toAttach);
    }
    
    public void update(){
	System.out.println("HandController::Received hand model update");
	
	this.handOutlet.removeAll();
	for (CardController cardController : hand.cards()) {
	    this.handOutlet.add(cardController);
	}
	
	this.handOutlet.repaint();
	this.handOutlet.validate();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        handOutlet = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        handOutlet.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hand", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        add(handOutlet, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel handOutlet;
    // End of variables declaration//GEN-END:variables
}
